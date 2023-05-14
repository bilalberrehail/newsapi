package com.example.instantsystemtest.business.di

import com.example.instantsystemtest.business.datasources.NewsDataSource
import com.example.instantsystemtest.business.datasources.NewsDataSourceImpl
import com.example.instantsystemtest.business.datasources.NewsService
import com.example.instantsystemtest.business.datasources.mappers.NewsRemoteMapper
import com.example.instantsystemtest.business.repositories.NewsRepository
import com.example.instantsystemtest.business.repositories.NewsRepositoryImpl
import com.example.instantsystemtest.business.securities.SecretsManager
import com.example.instantsystemtest.business.securities.SecretsManagerImpl
import com.squareup.moshi.Moshi
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val QUERY_PARAMETER_API_KEY = "apiKey"

val API_MODULE = module {

    single<SecretsManager> {
        SecretsManagerImpl()
    }

    single<OkHttpClient> {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original: Request = chain.request()
            val originalHttpUrl: HttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(QUERY_PARAMETER_API_KEY, get<SecretsManager>().serviceApiKey())
                .build()

            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)

            val request: Request = requestBuilder.build()
            chain.proceed(request)
        }
        httpClient.build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(get<SecretsManager>().serviceUrl())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(get())
            .build()
    }

    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }

    single<NewsDataSource> {
        NewsDataSourceImpl(
            newsMapper = NewsRemoteMapper(),
            service = get<Retrofit>().create(NewsService::class.java)
        )
    }
}