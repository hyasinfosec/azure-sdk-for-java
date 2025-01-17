// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.networkcloud.fluent.models.ClusterInner;
import com.azure.resourcemanager.networkcloud.models.ClusterList;
import com.azure.resourcemanager.networkcloud.models.ClusterType;
import com.azure.resourcemanager.networkcloud.models.ExtendedLocation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ClusterListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ClusterList model =
            BinaryData
                .fromString(
                    "{\"nextLink\":\"nljky\",\"value\":[{\"extendedLocation\":{\"name\":\"vuujq\",\"type\":\"idokgjlj\"},\"properties\":{\"analyticsWorkspaceId\":\"oxgvclt\",\"availableUpgradeVersions\":[],\"clusterConnectionStatus\":\"Timeout\",\"clusterLocation\":\"kjeszz\",\"clusterManagerConnectionStatus\":\"Connected\",\"clusterManagerId\":\"htxfvgxbfsmxnehm\",\"clusterType\":\"SingleRack\",\"clusterVersion\":\"cxgod\",\"computeRackDefinitions\":[],\"detailedStatus\":\"PendingDeployment\",\"detailedStatusMessage\":\"rbmpukgri\",\"manualActionCount\":5296014061379055947,\"networkFabricId\":\"bxzpuzycisp\",\"provisioningState\":\"Canceled\",\"supportExpiryDate\":\"hmgkbrpyy\",\"workloadResourceIds\":[]},\"location\":\"bnuqqkpik\",\"tags\":{\"jggmebfsiarbu\":\"gvtqagnbuynh\",\"ttdbhrbnl\":\"rcvpnazzmhjrunmp\"},\"id\":\"nkxmyskpbhenbtk\",\"name\":\"xywnytnrsynlqidy\",\"type\":\"yxczfclh\"}]}")
                .toObject(ClusterList.class);
        Assertions.assertEquals("nljky", model.nextLink());
        Assertions.assertEquals("bnuqqkpik", model.value().get(0).location());
        Assertions.assertEquals("gvtqagnbuynh", model.value().get(0).tags().get("jggmebfsiarbu"));
        Assertions.assertEquals("vuujq", model.value().get(0).extendedLocation().name());
        Assertions.assertEquals("idokgjlj", model.value().get(0).extendedLocation().type());
        Assertions.assertEquals("oxgvclt", model.value().get(0).analyticsWorkspaceId());
        Assertions.assertEquals("kjeszz", model.value().get(0).clusterLocation());
        Assertions.assertEquals(ClusterType.SINGLE_RACK, model.value().get(0).clusterType());
        Assertions.assertEquals("cxgod", model.value().get(0).clusterVersion());
        Assertions.assertEquals("bxzpuzycisp", model.value().get(0).networkFabricId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ClusterList model =
            new ClusterList()
                .withNextLink("nljky")
                .withValue(
                    Arrays
                        .asList(
                            new ClusterInner()
                                .withLocation("bnuqqkpik")
                                .withTags(mapOf("jggmebfsiarbu", "gvtqagnbuynh", "ttdbhrbnl", "rcvpnazzmhjrunmp"))
                                .withExtendedLocation(new ExtendedLocation().withName("vuujq").withType("idokgjlj"))
                                .withAnalyticsWorkspaceId("oxgvclt")
                                .withClusterLocation("kjeszz")
                                .withClusterType(ClusterType.SINGLE_RACK)
                                .withClusterVersion("cxgod")
                                .withComputeRackDefinitions(Arrays.asList())
                                .withNetworkFabricId("bxzpuzycisp")));
        model = BinaryData.fromObject(model).toObject(ClusterList.class);
        Assertions.assertEquals("nljky", model.nextLink());
        Assertions.assertEquals("bnuqqkpik", model.value().get(0).location());
        Assertions.assertEquals("gvtqagnbuynh", model.value().get(0).tags().get("jggmebfsiarbu"));
        Assertions.assertEquals("vuujq", model.value().get(0).extendedLocation().name());
        Assertions.assertEquals("idokgjlj", model.value().get(0).extendedLocation().type());
        Assertions.assertEquals("oxgvclt", model.value().get(0).analyticsWorkspaceId());
        Assertions.assertEquals("kjeszz", model.value().get(0).clusterLocation());
        Assertions.assertEquals(ClusterType.SINGLE_RACK, model.value().get(0).clusterType());
        Assertions.assertEquals("cxgod", model.value().get(0).clusterVersion());
        Assertions.assertEquals("bxzpuzycisp", model.value().get(0).networkFabricId());
    }

    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
