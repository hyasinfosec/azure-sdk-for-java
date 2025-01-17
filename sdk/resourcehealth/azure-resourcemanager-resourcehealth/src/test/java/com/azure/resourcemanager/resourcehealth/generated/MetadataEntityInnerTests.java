// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcehealth.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.resourcehealth.fluent.models.MetadataEntityInner;
import com.azure.resourcemanager.resourcehealth.models.MetadataSupportedValueDetail;
import com.azure.resourcemanager.resourcehealth.models.Scenario;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MetadataEntityInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MetadataEntityInner model =
            BinaryData
                .fromString(
                    "{\"properties\":{\"displayName\":\"hjq\",\"dependsOn\":[\"yeicxmqciwqvhk\",\"ixuigdtopbobj\"],\"applicableScenarios\":[\"Alerts\"],\"supportedValues\":[{\"id\":\"a\",\"displayName\":\"uhrzayvvt\",\"resourceTypes\":[]}]},\"id\":\"dfgiot\",\"name\":\"ftutqxlngxlefgu\",\"type\":\"nxkrx\"}")
                .toObject(MetadataEntityInner.class);
        Assertions.assertEquals("hjq", model.displayName());
        Assertions.assertEquals("yeicxmqciwqvhk", model.dependsOn().get(0));
        Assertions.assertEquals(Scenario.ALERTS, model.applicableScenarios().get(0));
        Assertions.assertEquals("a", model.supportedValues().get(0).id());
        Assertions.assertEquals("uhrzayvvt", model.supportedValues().get(0).displayName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MetadataEntityInner model =
            new MetadataEntityInner()
                .withDisplayName("hjq")
                .withDependsOn(Arrays.asList("yeicxmqciwqvhk", "ixuigdtopbobj"))
                .withApplicableScenarios(Arrays.asList(Scenario.ALERTS))
                .withSupportedValues(
                    Arrays
                        .asList(
                            new MetadataSupportedValueDetail()
                                .withId("a")
                                .withDisplayName("uhrzayvvt")
                                .withResourceTypes(Arrays.asList())));
        model = BinaryData.fromObject(model).toObject(MetadataEntityInner.class);
        Assertions.assertEquals("hjq", model.displayName());
        Assertions.assertEquals("yeicxmqciwqvhk", model.dependsOn().get(0));
        Assertions.assertEquals(Scenario.ALERTS, model.applicableScenarios().get(0));
        Assertions.assertEquals("a", model.supportedValues().get(0).id());
        Assertions.assertEquals("uhrzayvvt", model.supportedValues().get(0).displayName());
    }
}
