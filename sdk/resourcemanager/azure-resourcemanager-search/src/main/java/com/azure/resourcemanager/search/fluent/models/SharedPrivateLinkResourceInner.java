// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.search.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.resourcemanager.search.models.SharedPrivateLinkResourceProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Describes a Shared Private Link Resource managed by the Azure Cognitive Search service. */
@Fluent
public final class SharedPrivateLinkResourceInner extends ProxyResource {
    /*
     * Describes the properties of a Shared Private Link Resource managed by
     * the Azure Cognitive Search service.
     */
    @JsonProperty(value = "properties")
    private SharedPrivateLinkResourceProperties properties;

    /**
     * Get the properties property: Describes the properties of a Shared Private Link Resource managed by the Azure
     * Cognitive Search service.
     *
     * @return the properties value.
     */
    public SharedPrivateLinkResourceProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Describes the properties of a Shared Private Link Resource managed by the Azure
     * Cognitive Search service.
     *
     * @param properties the properties value to set.
     * @return the SharedPrivateLinkResourceInner object itself.
     */
    public SharedPrivateLinkResourceInner withProperties(SharedPrivateLinkResourceProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }
}
