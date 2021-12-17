// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automanage.implementation;

import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.automanage.fluent.BestPracticesClient;
import com.azure.resourcemanager.automanage.fluent.models.BestPracticeInner;
import com.azure.resourcemanager.automanage.models.BestPracticeList;
import reactor.core.publisher.Mono;

/** An instance of this class provides access to all the operations defined in BestPracticesClient. */
public final class BestPracticesClientImpl implements BestPracticesClient {
    private final ClientLogger logger = new ClientLogger(BestPracticesClientImpl.class);

    /** The proxy service used to perform REST calls. */
    private final BestPracticesService service;

    /** The service client containing this operation class. */
    private final AutomanageClientImpl client;

    /**
     * Initializes an instance of BestPracticesClientImpl.
     *
     * @param client the instance of the service client containing this operation class.
     */
    BestPracticesClientImpl(AutomanageClientImpl client) {
        this.service =
            RestProxy.create(BestPracticesService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for AutomanageClientBestPractices to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "AutomanageClientBest")
    private interface BestPracticesService {
        @Headers({"Content-Type: application/json"})
        @Get("/providers/Microsoft.Automanage/bestPractices/{bestPracticeName}")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<BestPracticeInner>> get(
            @HostParam("$host") String endpoint,
            @PathParam("bestPracticeName") String bestPracticeName,
            @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept,
            Context context);

        @Headers({"Content-Type: application/json"})
        @Get("/providers/Microsoft.Automanage/bestPractices")
        @ExpectedResponses({200})
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<BestPracticeList>> listByTenant(
            @HostParam("$host") String endpoint,
            @QueryParam("api-version") String apiVersion,
            @HeaderParam("Accept") String accept,
            Context context);
    }

    /**
     * Get information about a Automanage best practice.
     *
     * @param bestPracticeName The Automanage best practice name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a Automanage best practice.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BestPracticeInner>> getWithResponseAsync(String bestPracticeName) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (bestPracticeName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter bestPracticeName is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service
                        .get(this.client.getEndpoint(), bestPracticeName, this.client.getApiVersion(), accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Get information about a Automanage best practice.
     *
     * @param bestPracticeName The Automanage best practice name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a Automanage best practice.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<BestPracticeInner>> getWithResponseAsync(String bestPracticeName, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (bestPracticeName == null) {
            return Mono
                .error(new IllegalArgumentException("Parameter bestPracticeName is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.get(this.client.getEndpoint(), bestPracticeName, this.client.getApiVersion(), accept, context);
    }

    /**
     * Get information about a Automanage best practice.
     *
     * @param bestPracticeName The Automanage best practice name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a Automanage best practice.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<BestPracticeInner> getAsync(String bestPracticeName) {
        return getWithResponseAsync(bestPracticeName)
            .flatMap(
                (Response<BestPracticeInner> res) -> {
                    if (res.getValue() != null) {
                        return Mono.just(res.getValue());
                    } else {
                        return Mono.empty();
                    }
                });
    }

    /**
     * Get information about a Automanage best practice.
     *
     * @param bestPracticeName The Automanage best practice name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a Automanage best practice.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public BestPracticeInner get(String bestPracticeName) {
        return getAsync(bestPracticeName).block();
    }

    /**
     * Get information about a Automanage best practice.
     *
     * @param bestPracticeName The Automanage best practice name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return information about a Automanage best practice.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<BestPracticeInner> getWithResponse(String bestPracticeName, Context context) {
        return getWithResponseAsync(bestPracticeName, context).block();
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<BestPracticeInner>> listByTenantSinglePageAsync() {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(
                context ->
                    service.listByTenant(this.client.getEndpoint(), this.client.getApiVersion(), accept, context))
            .<PagedResponse<BestPracticeInner>>map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<PagedResponse<BestPracticeInner>> listByTenantSinglePageAsync(Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono
                .error(
                    new IllegalArgumentException(
                        "Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service
            .listByTenant(this.client.getEndpoint(), this.client.getApiVersion(), accept, context)
            .map(
                res ->
                    new PagedResponseBase<>(
                        res.getRequest(), res.getStatusCode(), res.getHeaders(), res.getValue().value(), null, null));
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<BestPracticeInner> listByTenantAsync() {
        return new PagedFlux<>(() -> listByTenantSinglePageAsync());
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    private PagedFlux<BestPracticeInner> listByTenantAsync(Context context) {
        return new PagedFlux<>(() -> listByTenantSinglePageAsync(context));
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BestPracticeInner> listByTenant() {
        return new PagedIterable<>(listByTenantAsync());
    }

    /**
     * Retrieve a list of Automanage best practices.
     *
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of the list best practice operation.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<BestPracticeInner> listByTenant(Context context) {
        return new PagedIterable<>(listByTenantAsync(context));
    }
}