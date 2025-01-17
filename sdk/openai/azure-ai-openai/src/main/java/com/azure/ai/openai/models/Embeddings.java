// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.openai.models;

import com.azure.core.annotation.Immutable;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Representation of the response data from an embeddings request. Embeddings measure the relatedness of text strings
 * and are commonly used for search, clustering, recommendations, and other similar scenarios.
 */
@Immutable
public final class Embeddings {
    /*
     * Embedding values for the prompts submitted in the request.
     */
    @JsonProperty(value = "data", required = true)
    private List<EmbeddingItem> data;

    /*
     * Usage counts for tokens input using the embeddings API.
     */
    @JsonProperty(value = "usage", required = true)
    private EmbeddingsUsage usage;

    /**
     * Creates an instance of Embeddings class.
     *
     * @param data the data value to set.
     * @param usage the usage value to set.
     */
    @JsonCreator
    private Embeddings(
            @JsonProperty(value = "data", required = true) List<EmbeddingItem> data,
            @JsonProperty(value = "usage", required = true) EmbeddingsUsage usage) {
        this.data = data;
        this.usage = usage;
    }

    /**
     * Get the data property: Embedding values for the prompts submitted in the request.
     *
     * @return the data value.
     */
    public List<EmbeddingItem> getData() {
        return this.data;
    }

    /**
     * Get the usage property: Usage counts for tokens input using the embeddings API.
     *
     * @return the usage value.
     */
    public EmbeddingsUsage getUsage() {
        return this.usage;
    }
}
