// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Query results for table insights query. */
@Fluent
public final class InsightsTableResult {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(InsightsTableResult.class);

    /*
     * Columns Metadata of the table
     */
    @JsonProperty(value = "columns")
    private List<InsightsTableResultColumnsItem> columns;

    /*
     * Rows data of the table
     */
    @JsonProperty(value = "rows")
    private List<List<String>> rows;

    /**
     * Get the columns property: Columns Metadata of the table.
     *
     * @return the columns value.
     */
    public List<InsightsTableResultColumnsItem> columns() {
        return this.columns;
    }

    /**
     * Set the columns property: Columns Metadata of the table.
     *
     * @param columns the columns value to set.
     * @return the InsightsTableResult object itself.
     */
    public InsightsTableResult withColumns(List<InsightsTableResultColumnsItem> columns) {
        this.columns = columns;
        return this;
    }

    /**
     * Get the rows property: Rows data of the table.
     *
     * @return the rows value.
     */
    public List<List<String>> rows() {
        return this.rows;
    }

    /**
     * Set the rows property: Rows data of the table.
     *
     * @param rows the rows value to set.
     * @return the InsightsTableResult object itself.
     */
    public InsightsTableResult withRows(List<List<String>> rows) {
        this.rows = rows;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (columns() != null) {
            columns().forEach(e -> e.validate());
        }
    }
}