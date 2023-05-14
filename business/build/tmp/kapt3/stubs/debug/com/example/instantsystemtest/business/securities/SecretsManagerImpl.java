package com.example.instantsystemtest.business.securities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0082 J\t\u0010\u0015\u001a\u00020\u0014H\u0082 J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/example/instantsystemtest/business/securities/SecretsManagerImpl;", "Lcom/example/instantsystemtest/business/securities/SecretsManager;", "()V", "apiKeyJsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/example/instantsystemtest/business/securities/models/ApiKey;", "getApiKeyJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "apiKeyJsonAdapter$delegate", "Lkotlin/Lazy;", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "urlJsonAdapter", "Lcom/example/instantsystemtest/business/securities/models/Url;", "getUrlJsonAdapter", "urlJsonAdapter$delegate", "getServiceApiKey", "", "getServiceUrl", "serviceApiKey", "serviceUrl", "business_debug"})
public final class SecretsManagerImpl implements com.example.instantsystemtest.business.securities.SecretsManager {
    private final kotlin.Lazy moshi$delegate = null;
    private final kotlin.Lazy urlJsonAdapter$delegate = null;
    private final kotlin.Lazy apiKeyJsonAdapter$delegate = null;
    
    public SecretsManagerImpl() {
        super();
    }
    
    private final com.squareup.moshi.Moshi getMoshi() {
        return null;
    }
    
    private final com.squareup.moshi.JsonAdapter<com.example.instantsystemtest.business.securities.models.Url> getUrlJsonAdapter() {
        return null;
    }
    
    private final com.squareup.moshi.JsonAdapter<com.example.instantsystemtest.business.securities.models.ApiKey> getApiKeyJsonAdapter() {
        return null;
    }
    
    private final native java.lang.String getServiceUrl() {
        return null;
    }
    
    private final native java.lang.String getServiceApiKey() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String serviceUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String serviceApiKey() {
        return null;
    }
}