package com.example.instantsystemtest.business.datasources;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/example/instantsystemtest/business/datasources/NewsDataSourceImpl;", "Lcom/example/instantsystemtest/business/datasources/NewsDataSource;", "newsMapper", "Lcom/example/instantsystemtest/business/datasources/mappers/NewsRemoteMapper;", "service", "Lcom/example/instantsystemtest/business/datasources/NewsService;", "(Lcom/example/instantsystemtest/business/datasources/mappers/NewsRemoteMapper;Lcom/example/instantsystemtest/business/datasources/NewsService;)V", "getNews", "", "Lcom/example/instantsystemtest/business/models/News;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "business_debug"})
public final class NewsDataSourceImpl implements com.example.instantsystemtest.business.datasources.NewsDataSource {
    private final com.example.instantsystemtest.business.datasources.mappers.NewsRemoteMapper newsMapper = null;
    private final com.example.instantsystemtest.business.datasources.NewsService service = null;
    
    public NewsDataSourceImpl(@org.jetbrains.annotations.NotNull
    com.example.instantsystemtest.business.datasources.mappers.NewsRemoteMapper newsMapper, @org.jetbrains.annotations.NotNull
    com.example.instantsystemtest.business.datasources.NewsService service) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getNews(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.instantsystemtest.business.models.News>> continuation) {
        return null;
    }
}