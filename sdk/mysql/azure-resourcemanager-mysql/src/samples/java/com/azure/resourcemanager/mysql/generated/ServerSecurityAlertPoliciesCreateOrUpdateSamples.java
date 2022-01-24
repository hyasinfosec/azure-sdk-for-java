// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.generated;

import com.azure.core.util.Context;
import com.azure.resourcemanager.mysql.models.SecurityAlertPolicyName;
import com.azure.resourcemanager.mysql.models.ServerSecurityAlertPolicy;
import com.azure.resourcemanager.mysql.models.ServerSecurityAlertPolicyState;
import java.util.Arrays;

/** Samples for ServerSecurityAlertPolicies CreateOrUpdate. */
public final class ServerSecurityAlertPoliciesCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/mysql/resource-manager/Microsoft.DBforMySQL/stable/2017-12-01/examples/ServerSecurityAlertsCreateMin.json
     */
    /**
     * Sample code: Update a server's threat detection policy with minimal parameters.
     *
     * @param manager Entry point to MySqlManager.
     */
    public static void updateAServerSThreatDetectionPolicyWithMinimalParameters(
        com.azure.resourcemanager.mysql.MySqlManager manager) {
        ServerSecurityAlertPolicy resource =
            manager
                .serverSecurityAlertPolicies()
                .getWithResponse(
                    "securityalert-4799", "securityalert-6440", SecurityAlertPolicyName.DEFAULT, Context.NONE)
                .getValue();
        resource.update().withState(ServerSecurityAlertPolicyState.DISABLED).withEmailAccountAdmins(true).apply();
    }

    /*
     * x-ms-original-file: specification/mysql/resource-manager/Microsoft.DBforMySQL/stable/2017-12-01/examples/ServerSecurityAlertsCreateMax.json
     */
    /**
     * Sample code: Update a server's threat detection policy with all parameters.
     *
     * @param manager Entry point to MySqlManager.
     */
    public static void updateAServerSThreatDetectionPolicyWithAllParameters(
        com.azure.resourcemanager.mysql.MySqlManager manager) {
        ServerSecurityAlertPolicy resource =
            manager
                .serverSecurityAlertPolicies()
                .getWithResponse(
                    "securityalert-4799", "securityalert-6440", SecurityAlertPolicyName.DEFAULT, Context.NONE)
                .getValue();
        resource
            .update()
            .withState(ServerSecurityAlertPolicyState.ENABLED)
            .withDisabledAlerts(Arrays.asList("Access_Anomaly", "Usage_Anomaly"))
            .withEmailAddresses(Arrays.asList("testSecurityAlert@microsoft.com"))
            .withEmailAccountAdmins(true)
            .withStorageEndpoint("https://mystorage.blob.core.windows.net")
            .withStorageAccountAccessKey(
                "sdlfkjabc+sdlfkjsdlkfsjdfLDKFTERLKFDFKLjsdfksjdflsdkfD2342309432849328476458/3RSD==")
            .withRetentionDays(5)
            .apply();
    }
}