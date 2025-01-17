// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.callautomation;

import com.azure.communication.callautomation.models.AnswerCallOptions;
import com.azure.communication.callautomation.models.AnswerCallResult;
import com.azure.communication.callautomation.models.CreateCallResult;
import com.azure.communication.callautomation.models.CreateGroupCallOptions;
import com.azure.communication.callautomation.models.DtmfTone;
import com.azure.communication.callautomation.models.FileSource;
import com.azure.communication.callautomation.models.events.CallConnected;
import com.azure.communication.callautomation.models.events.ContinuousDtmfRecognitionStopped;
import com.azure.communication.callautomation.models.events.PlayCompleted;
import com.azure.communication.callautomation.models.events.SendDtmfCompleted;
import com.azure.communication.common.CommunicationIdentifier;
import com.azure.communication.common.CommunicationUserIdentifier;
import com.azure.communication.identity.CommunicationIdentityAsyncClient;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.Response;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class CallMediaAsyncAutomatedLiveTests extends CallAutomationAutomatedLiveTestBase {
    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    @DisabledIfEnvironmentVariable(
        named = "SKIP_LIVE_TEST",
        matches = "(?i)(true)",
        disabledReason = "Requires environment to be set up")
    public void playMediaInACallAutomatedTest(HttpClient httpClient) {
        /* Test case: ACS to ACS call
         * 1. create a CallAutomationClient.
         * 2. create a call from source to one ACS target.
         * 3. get updated call properties and check for the connected state.
         * 4. play a media to all participants
         * 5. hang up the call.
         */

        CommunicationIdentityAsyncClient identityAsyncClient = getCommunicationIdentityClientUsingConnectionString(httpClient)
            .addPolicy((context, next) -> logHeaders("playMediaInACallAutomatedTest", next))
            .buildAsyncClient();

        List<CallConnectionAsync> callDestructors = new ArrayList<>();

        try {
            // create caller and receiver
            CommunicationUserIdentifier caller = identityAsyncClient.createUser().block();
            CommunicationIdentifier receiver = identityAsyncClient.createUser().block();

            CallAutomationAsyncClient callerAsyncClient = getCallAutomationClientUsingConnectionString(httpClient)
                .addPolicy((context, next) -> logHeaders("playMediaInACallAutomatedTest", next))
                .sourceIdentity(caller)
                .buildAsyncClient();

            // Create call automation client for receivers.
            CallAutomationAsyncClient receiverAsyncClient = getCallAutomationClientUsingConnectionString(httpClient)
                .addPolicy((context, next) -> logHeaders("playMediaInACallAutomatedTest", next))
                .buildAsyncClient();

            String uniqueId = serviceBusWithNewCall(caller, receiver);

            // create a call
            List<CommunicationIdentifier> targets = Collections.singletonList(receiver);
            CreateGroupCallOptions createCallOptions = new CreateGroupCallOptions(targets,
                DISPATCHER_CALLBACK + String.format("?q=%s", uniqueId));
            Response<CreateCallResult> createCallResultResponse = callerAsyncClient.createGroupCallWithResponse(createCallOptions).block();
            assertNotNull(createCallResultResponse);
            CreateCallResult createCallResult = createCallResultResponse.getValue();
            assertNotNull(createCallResult);
            assertNotNull(createCallResult.getCallConnectionProperties());
            String callerConnectionId = createCallResult.getCallConnectionProperties().getCallConnectionId();
            assertNotNull(callerConnectionId);

            // wait for the incomingCallContext
            String incomingCallContext = waitForIncomingCallContext(uniqueId, Duration.ofSeconds(10));
            assertNotNull(incomingCallContext);

            // answer the call
            AnswerCallOptions answerCallOptions = new AnswerCallOptions(incomingCallContext,
                DISPATCHER_CALLBACK + String.format("?q=%s", uniqueId));
            AnswerCallResult answerCallResult = Objects.requireNonNull(receiverAsyncClient.answerCallWithResponse(answerCallOptions).block()).getValue();
            assertNotNull(answerCallResult);
            assertNotNull(answerCallResult.getCallConnectionAsync());
            assertNotNull(answerCallResult.getCallConnectionProperties());
            callDestructors.add(answerCallResult.getCallConnectionAsync());

            // wait for callConnected
            CallConnected callConnected = waitForEvent(CallConnected.class, callerConnectionId, Duration.ofSeconds(10));
            assertNotNull(callConnected);

            // play media to all participants
            CallMediaAsync callMediaAsync = createCallResult.getCallConnectionAsync().getCallMediaAsync();
            callMediaAsync.playToAll(new FileSource().setUrl(MEDIA_SOURCE)).block();
            PlayCompleted playCompleted = waitForEvent(PlayCompleted.class, callerConnectionId, Duration.ofSeconds(20));
            assertNotNull(playCompleted);
        } catch (Exception ex) {
            fail("Unexpected exception received", ex);
        } finally {
            if (!callDestructors.isEmpty()) {
                try {
                    callDestructors.forEach(callConnection -> callConnection.hangUpWithResponse(true).block());
                } catch (Exception ignored) {
                    // Some call might have been terminated during the test, and it will cause exceptions here.
                    // Do nothing and iterate to next call connection.
                }
            }
        }
    }

    @ParameterizedTest
    @MethodSource("com.azure.core.test.TestBase#getHttpClients")
    @DisabledIfEnvironmentVariable(
        named = "SKIP_LIVE_TEST",
        matches = "(?i)(true)",
        disabledReason = "Requires environment to be set up")
    public void continuousRecognitionAndSendDtmfInACallAutomatedTest(HttpClient httpClient) {
        /* Test case: ACS to ACS call
         * 1. Create a CallAutomationClient.
         * 2. Create a call from source to one ACS target.
         * 3. Get updated call properties and check for the connected state.
         * 4. Start continuous recognition on source, expect no failure(exception)
         * 5. Send Dtmf tones to target, expect SendDtmfCompleted event and no failure(exception)
         * 6. Stop continuous Dtmf recognition on source, expect ContinuousDtmfRecognitionStopped event and no failure(exception)
         * 7. Hang up the call.
         */

        CommunicationIdentityAsyncClient identityAsyncClient = getCommunicationIdentityClientUsingConnectionString(httpClient)
            .addPolicy((context, next) -> logHeaders("continuousRecognitionAndSendDtmfInACallAutomatedTest", next))
            .buildAsyncClient();

        List<CallConnectionAsync> callDestructors = new ArrayList<>();

        try {
            // create caller and receiver
            CommunicationUserIdentifier caller = identityAsyncClient.createUser().block();
            CommunicationIdentifier receiver = identityAsyncClient.createUser().block();

            CallAutomationAsyncClient callerAsyncClient = getCallAutomationClientUsingConnectionString(httpClient)
                .addPolicy((context, next) -> logHeaders("continuousRecognitionAndSendDtmfInACallAutomatedTest", next))
                .sourceIdentity(caller)
                .buildAsyncClient();

            // Create call automation client for receivers.
            CallAutomationAsyncClient receiverAsyncClient = getCallAutomationClientUsingConnectionString(httpClient)
                .addPolicy((context, next) -> logHeaders("continuousRecognitionAndSendDtmfInACallAutomatedTest", next))
                .buildAsyncClient();

            String uniqueId = serviceBusWithNewCall(caller, receiver);

            // create a call
            List<CommunicationIdentifier> targets = Collections.singletonList(receiver);
            CreateGroupCallOptions createCallOptions = new CreateGroupCallOptions(targets,
                DISPATCHER_CALLBACK + String.format("?q=%s", uniqueId));
            Response<CreateCallResult> createCallResultResponse = callerAsyncClient.createGroupCallWithResponse(createCallOptions).block();
            assertNotNull(createCallResultResponse);
            CreateCallResult createCallResult = createCallResultResponse.getValue();
            assertNotNull(createCallResult);
            assertNotNull(createCallResult.getCallConnectionProperties());
            String callerConnectionId = createCallResult.getCallConnectionProperties().getCallConnectionId();
            assertNotNull(callerConnectionId);

            // wait for the incomingCallContext
            String incomingCallContext = waitForIncomingCallContext(uniqueId, Duration.ofSeconds(10));
            assertNotNull(incomingCallContext);

            // answer the call
            AnswerCallOptions answerCallOptions = new AnswerCallOptions(incomingCallContext,
                DISPATCHER_CALLBACK + String.format("?q=%s", uniqueId));
            AnswerCallResult answerCallResult = Objects.requireNonNull(receiverAsyncClient.answerCallWithResponse(answerCallOptions).block()).getValue();
            assertNotNull(answerCallResult);
            assertNotNull(answerCallResult.getCallConnectionAsync());
            assertNotNull(answerCallResult.getCallConnectionProperties());
            callDestructors.add(answerCallResult.getCallConnectionAsync());

            // wait for callConnected
            CallConnected callConnected = waitForEvent(CallConnected.class, callerConnectionId, Duration.ofSeconds(10));
            assertNotNull(callConnected);

            CallMediaAsync callMediaAsync = createCallResult.getCallConnectionAsync().getCallMediaAsync();

            // start continuous dtmf
            callMediaAsync.startContinuousDtmfRecognition(caller).block();
            callMediaAsync.sendDtmf(Stream.of(DtmfTone.A, DtmfTone.A, DtmfTone.A).collect(Collectors.toList()), receiver).block();

            // send dtmf
            SendDtmfCompleted sendDtmfCompleted = waitForEvent(SendDtmfCompleted.class, callerConnectionId, Duration.ofSeconds(20));
            assertNotNull(sendDtmfCompleted);

            // stop continuous dtmf
            callMediaAsync.stopContinuousDtmfRecognition(caller).block();
            ContinuousDtmfRecognitionStopped continuousDtmfRecognitionStopped = waitForEvent(
                ContinuousDtmfRecognitionStopped.class, callerConnectionId, Duration.ofSeconds(10)
            );
            assertNotNull(continuousDtmfRecognitionStopped);
        } catch (Exception ex) {
            fail("Unexpected exception received", ex);
        } finally {
            if (!callDestructors.isEmpty()) {
                try {
                    callDestructors.forEach(callConnection -> callConnection.hangUpWithResponse(true).block());
                } catch (Exception ignored) {
                    // Some call might have been terminated during the test, and it will cause exceptions here.
                    // Do nothing and iterate to next call connection.
                }
            }
        }
    }
}
