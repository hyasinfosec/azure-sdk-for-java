// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.authorization.models.DenyAssignmentPermission;
import com.azure.resourcemanager.authorization.models.Principal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Deny Assignment. */
@Fluent
public final class DenyAssignmentInner {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(DenyAssignmentInner.class);

    /*
     * The deny assignment ID.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /*
     * The deny assignment name.
     */
    @JsonProperty(value = "name", access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /*
     * The deny assignment type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /*
     * Deny assignment properties.
     */
    @JsonProperty(value = "properties")
    private DenyAssignmentProperties innerProperties;

    /**
     * Get the id property: The deny assignment ID.
     *
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the name property: The deny assignment name.
     *
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the type property: The deny assignment type.
     *
     * @return the type value.
     */
    public String type() {
        return this.type;
    }

    /**
     * Get the innerProperties property: Deny assignment properties.
     *
     * @return the innerProperties value.
     */
    private DenyAssignmentProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the denyAssignmentName property: The display name of the deny assignment.
     *
     * @return the denyAssignmentName value.
     */
    public String denyAssignmentName() {
        return this.innerProperties() == null ? null : this.innerProperties().denyAssignmentName();
    }

    /**
     * Set the denyAssignmentName property: The display name of the deny assignment.
     *
     * @param denyAssignmentName the denyAssignmentName value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withDenyAssignmentName(String denyAssignmentName) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withDenyAssignmentName(denyAssignmentName);
        return this;
    }

    /**
     * Get the description property: The description of the deny assignment.
     *
     * @return the description value.
     */
    public String description() {
        return this.innerProperties() == null ? null : this.innerProperties().description();
    }

    /**
     * Set the description property: The description of the deny assignment.
     *
     * @param description the description value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withDescription(String description) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withDescription(description);
        return this;
    }

    /**
     * Get the permissions property: An array of permissions that are denied by the deny assignment.
     *
     * @return the permissions value.
     */
    public List<DenyAssignmentPermission> permissions() {
        return this.innerProperties() == null ? null : this.innerProperties().permissions();
    }

    /**
     * Set the permissions property: An array of permissions that are denied by the deny assignment.
     *
     * @param permissions the permissions value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withPermissions(List<DenyAssignmentPermission> permissions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withPermissions(permissions);
        return this;
    }

    /**
     * Get the scope property: The deny assignment scope.
     *
     * @return the scope value.
     */
    public String scope() {
        return this.innerProperties() == null ? null : this.innerProperties().scope();
    }

    /**
     * Set the scope property: The deny assignment scope.
     *
     * @param scope the scope value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withScope(String scope) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withScope(scope);
        return this;
    }

    /**
     * Get the doNotApplyToChildScopes property: Determines if the deny assignment applies to child scopes. Default
     * value is false.
     *
     * @return the doNotApplyToChildScopes value.
     */
    public Boolean doNotApplyToChildScopes() {
        return this.innerProperties() == null ? null : this.innerProperties().doNotApplyToChildScopes();
    }

    /**
     * Set the doNotApplyToChildScopes property: Determines if the deny assignment applies to child scopes. Default
     * value is false.
     *
     * @param doNotApplyToChildScopes the doNotApplyToChildScopes value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withDoNotApplyToChildScopes(Boolean doNotApplyToChildScopes) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withDoNotApplyToChildScopes(doNotApplyToChildScopes);
        return this;
    }

    /**
     * Get the principals property: Array of principals to which the deny assignment applies.
     *
     * @return the principals value.
     */
    public List<Principal> principals() {
        return this.innerProperties() == null ? null : this.innerProperties().principals();
    }

    /**
     * Set the principals property: Array of principals to which the deny assignment applies.
     *
     * @param principals the principals value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withPrincipals(List<Principal> principals) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withPrincipals(principals);
        return this;
    }

    /**
     * Get the excludePrincipals property: Array of principals to which the deny assignment does not apply.
     *
     * @return the excludePrincipals value.
     */
    public List<Principal> excludePrincipals() {
        return this.innerProperties() == null ? null : this.innerProperties().excludePrincipals();
    }

    /**
     * Set the excludePrincipals property: Array of principals to which the deny assignment does not apply.
     *
     * @param excludePrincipals the excludePrincipals value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withExcludePrincipals(List<Principal> excludePrincipals) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withExcludePrincipals(excludePrincipals);
        return this;
    }

    /**
     * Get the isSystemProtected property: Specifies whether this deny assignment was created by Azure and cannot be
     * edited or deleted.
     *
     * @return the isSystemProtected value.
     */
    public Boolean isSystemProtected() {
        return this.innerProperties() == null ? null : this.innerProperties().isSystemProtected();
    }

    /**
     * Set the isSystemProtected property: Specifies whether this deny assignment was created by Azure and cannot be
     * edited or deleted.
     *
     * @param isSystemProtected the isSystemProtected value to set.
     * @return the DenyAssignmentInner object itself.
     */
    public DenyAssignmentInner withIsSystemProtected(Boolean isSystemProtected) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DenyAssignmentProperties();
        }
        this.innerProperties().withIsSystemProtected(isSystemProtected);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}