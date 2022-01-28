// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.securityinsights.models.AutomationRuleAction;
import com.azure.resourcemanager.securityinsights.models.AutomationRuleTriggeringLogic;
import com.azure.resourcemanager.securityinsights.models.ClientInfo;
import com.azure.resourcemanager.securityinsights.models.ResourceWithEtag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.List;

/** Represents an automation rule. */
@Fluent
public final class AutomationRuleInner extends ResourceWithEtag {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(AutomationRuleInner.class);

    /*
     * Automation rule properties
     */
    @JsonProperty(value = "properties")
    private AutomationRuleProperties innerProperties;

    /**
     * Get the innerProperties property: Automation rule properties.
     *
     * @return the innerProperties value.
     */
    private AutomationRuleProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public AutomationRuleInner withEtag(String etag) {
        super.withEtag(etag);
        return this;
    }

    /**
     * Get the displayName property: The display name of the automation rule.
     *
     * @return the displayName value.
     */
    public String displayName() {
        return this.innerProperties() == null ? null : this.innerProperties().displayName();
    }

    /**
     * Set the displayName property: The display name of the automation rule.
     *
     * @param displayName the displayName value to set.
     * @return the AutomationRuleInner object itself.
     */
    public AutomationRuleInner withDisplayName(String displayName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationRuleProperties();
        }
        this.innerProperties().withDisplayName(displayName);
        return this;
    }

    /**
     * Get the order property: The order of execution of the automation rule.
     *
     * @return the order value.
     */
    public Integer order() {
        return this.innerProperties() == null ? null : this.innerProperties().order();
    }

    /**
     * Set the order property: The order of execution of the automation rule.
     *
     * @param order the order value to set.
     * @return the AutomationRuleInner object itself.
     */
    public AutomationRuleInner withOrder(Integer order) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationRuleProperties();
        }
        this.innerProperties().withOrder(order);
        return this;
    }

    /**
     * Get the triggeringLogic property: The triggering logic of the automation rule.
     *
     * @return the triggeringLogic value.
     */
    public AutomationRuleTriggeringLogic triggeringLogic() {
        return this.innerProperties() == null ? null : this.innerProperties().triggeringLogic();
    }

    /**
     * Set the triggeringLogic property: The triggering logic of the automation rule.
     *
     * @param triggeringLogic the triggeringLogic value to set.
     * @return the AutomationRuleInner object itself.
     */
    public AutomationRuleInner withTriggeringLogic(AutomationRuleTriggeringLogic triggeringLogic) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationRuleProperties();
        }
        this.innerProperties().withTriggeringLogic(triggeringLogic);
        return this;
    }

    /**
     * Get the actions property: The actions to execute when the automation rule is triggered.
     *
     * @return the actions value.
     */
    public List<AutomationRuleAction> actions() {
        return this.innerProperties() == null ? null : this.innerProperties().actions();
    }

    /**
     * Set the actions property: The actions to execute when the automation rule is triggered.
     *
     * @param actions the actions value to set.
     * @return the AutomationRuleInner object itself.
     */
    public AutomationRuleInner withActions(List<AutomationRuleAction> actions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new AutomationRuleProperties();
        }
        this.innerProperties().withActions(actions);
        return this;
    }

    /**
     * Get the createdTimeUtc property: The time the automation rule was created.
     *
     * @return the createdTimeUtc value.
     */
    public OffsetDateTime createdTimeUtc() {
        return this.innerProperties() == null ? null : this.innerProperties().createdTimeUtc();
    }

    /**
     * Get the lastModifiedTimeUtc property: The last time the automation rule was updated.
     *
     * @return the lastModifiedTimeUtc value.
     */
    public OffsetDateTime lastModifiedTimeUtc() {
        return this.innerProperties() == null ? null : this.innerProperties().lastModifiedTimeUtc();
    }

    /**
     * Get the createdBy property: Describes the client that created the automation rule.
     *
     * @return the createdBy value.
     */
    public ClientInfo createdBy() {
        return this.innerProperties() == null ? null : this.innerProperties().createdBy();
    }

    /**
     * Get the lastModifiedBy property: Describes the client that last updated the automation rule.
     *
     * @return the lastModifiedBy value.
     */
    public ClientInfo lastModifiedBy() {
        return this.innerProperties() == null ? null : this.innerProperties().lastModifiedBy();
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}