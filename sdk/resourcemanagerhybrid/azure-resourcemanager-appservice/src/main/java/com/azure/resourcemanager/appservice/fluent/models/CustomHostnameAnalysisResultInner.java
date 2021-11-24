// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.appservice.models.DnsVerificationTestResult;
import com.azure.resourcemanager.appservice.models.ErrorEntity;
import com.azure.resourcemanager.appservice.models.ProxyOnlyResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Custom domain analysis. */
@Fluent
public final class CustomHostnameAnalysisResultInner extends ProxyOnlyResource {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(CustomHostnameAnalysisResultInner.class);

    /*
     * CustomHostnameAnalysisResult resource specific properties
     */
    @JsonProperty(value = "properties")
    private CustomHostnameAnalysisResultProperties innerProperties;

    /**
     * Get the innerProperties property: CustomHostnameAnalysisResult resource specific properties.
     *
     * @return the innerProperties value.
     */
    private CustomHostnameAnalysisResultProperties innerProperties() {
        return this.innerProperties;
    }

    /** {@inheritDoc} */
    @Override
    public CustomHostnameAnalysisResultInner withKind(String kind) {
        super.withKind(kind);
        return this;
    }

    /**
     * Get the isHostnameAlreadyVerified property: &lt;code&gt;true&lt;/code&gt; if hostname is already verified;
     * otherwise, &lt;code&gt;false&lt;/code&gt;.
     *
     * @return the isHostnameAlreadyVerified value.
     */
    public Boolean isHostnameAlreadyVerified() {
        return this.innerProperties() == null ? null : this.innerProperties().isHostnameAlreadyVerified();
    }

    /**
     * Get the customDomainVerificationTest property: DNS verification test result.
     *
     * @return the customDomainVerificationTest value.
     */
    public DnsVerificationTestResult customDomainVerificationTest() {
        return this.innerProperties() == null ? null : this.innerProperties().customDomainVerificationTest();
    }

    /**
     * Get the customDomainVerificationFailureInfo property: Raw failure information if DNS verification fails.
     *
     * @return the customDomainVerificationFailureInfo value.
     */
    public ErrorEntity customDomainVerificationFailureInfo() {
        return this.innerProperties() == null ? null : this.innerProperties().customDomainVerificationFailureInfo();
    }

    /**
     * Get the hasConflictOnScaleUnit property: &lt;code&gt;true&lt;/code&gt; if there is a conflict on a scale unit;
     * otherwise, &lt;code&gt;false&lt;/code&gt;.
     *
     * @return the hasConflictOnScaleUnit value.
     */
    public Boolean hasConflictOnScaleUnit() {
        return this.innerProperties() == null ? null : this.innerProperties().hasConflictOnScaleUnit();
    }

    /**
     * Get the hasConflictAcrossSubscription property: &lt;code&gt;true&lt;/code&gt; if there is a conflict across
     * subscriptions; otherwise, &lt;code&gt;false&lt;/code&gt;.
     *
     * @return the hasConflictAcrossSubscription value.
     */
    public Boolean hasConflictAcrossSubscription() {
        return this.innerProperties() == null ? null : this.innerProperties().hasConflictAcrossSubscription();
    }

    /**
     * Get the conflictingAppResourceId property: Name of the conflicting app on scale unit if it's within the same
     * subscription.
     *
     * @return the conflictingAppResourceId value.
     */
    public String conflictingAppResourceId() {
        return this.innerProperties() == null ? null : this.innerProperties().conflictingAppResourceId();
    }

    /**
     * Get the cNameRecords property: CName records controller can see for this hostname.
     *
     * @return the cNameRecords value.
     */
    public List<String> cNameRecords() {
        return this.innerProperties() == null ? null : this.innerProperties().cNameRecords();
    }

    /**
     * Set the cNameRecords property: CName records controller can see for this hostname.
     *
     * @param cNameRecords the cNameRecords value to set.
     * @return the CustomHostnameAnalysisResultInner object itself.
     */
    public CustomHostnameAnalysisResultInner withCNameRecords(List<String> cNameRecords) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CustomHostnameAnalysisResultProperties();
        }
        this.innerProperties().withCNameRecords(cNameRecords);
        return this;
    }

    /**
     * Get the txtRecords property: TXT records controller can see for this hostname.
     *
     * @return the txtRecords value.
     */
    public List<String> txtRecords() {
        return this.innerProperties() == null ? null : this.innerProperties().txtRecords();
    }

    /**
     * Set the txtRecords property: TXT records controller can see for this hostname.
     *
     * @param txtRecords the txtRecords value to set.
     * @return the CustomHostnameAnalysisResultInner object itself.
     */
    public CustomHostnameAnalysisResultInner withTxtRecords(List<String> txtRecords) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CustomHostnameAnalysisResultProperties();
        }
        this.innerProperties().withTxtRecords(txtRecords);
        return this;
    }

    /**
     * Get the aRecords property: A records controller can see for this hostname.
     *
     * @return the aRecords value.
     */
    public List<String> aRecords() {
        return this.innerProperties() == null ? null : this.innerProperties().aRecords();
    }

    /**
     * Set the aRecords property: A records controller can see for this hostname.
     *
     * @param aRecords the aRecords value to set.
     * @return the CustomHostnameAnalysisResultInner object itself.
     */
    public CustomHostnameAnalysisResultInner withARecords(List<String> aRecords) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CustomHostnameAnalysisResultProperties();
        }
        this.innerProperties().withARecords(aRecords);
        return this;
    }

    /**
     * Get the alternateCNameRecords property: Alternate CName records controller can see for this hostname.
     *
     * @return the alternateCNameRecords value.
     */
    public List<String> alternateCNameRecords() {
        return this.innerProperties() == null ? null : this.innerProperties().alternateCNameRecords();
    }

    /**
     * Set the alternateCNameRecords property: Alternate CName records controller can see for this hostname.
     *
     * @param alternateCNameRecords the alternateCNameRecords value to set.
     * @return the CustomHostnameAnalysisResultInner object itself.
     */
    public CustomHostnameAnalysisResultInner withAlternateCNameRecords(List<String> alternateCNameRecords) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CustomHostnameAnalysisResultProperties();
        }
        this.innerProperties().withAlternateCNameRecords(alternateCNameRecords);
        return this;
    }

    /**
     * Get the alternateTxtRecords property: Alternate TXT records controller can see for this hostname.
     *
     * @return the alternateTxtRecords value.
     */
    public List<String> alternateTxtRecords() {
        return this.innerProperties() == null ? null : this.innerProperties().alternateTxtRecords();
    }

    /**
     * Set the alternateTxtRecords property: Alternate TXT records controller can see for this hostname.
     *
     * @param alternateTxtRecords the alternateTxtRecords value to set.
     * @return the CustomHostnameAnalysisResultInner object itself.
     */
    public CustomHostnameAnalysisResultInner withAlternateTxtRecords(List<String> alternateTxtRecords) {
        if (this.innerProperties() == null) {
            this.innerProperties = new CustomHostnameAnalysisResultProperties();
        }
        this.innerProperties().withAlternateTxtRecords(alternateTxtRecords);
        return this;
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