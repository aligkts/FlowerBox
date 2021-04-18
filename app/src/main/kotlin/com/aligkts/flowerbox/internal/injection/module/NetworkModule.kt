package com.aligkts.flowerbox.internal.injection.module

import android.content.Context
import com.aligkts.flowerbox.BuildConfig
import com.aligkts.flowerbox.data.remote.api.ProductService
import com.aligkts.flowerbox.internal.util.NetworkHandler
import com.aligkts.flowerbox.internal.util.api.ErrorHandlingInterceptor
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.moczul.ok2curl.CurlInterceptor
import com.squareup.moshi.Moshi
import dagger.Lazy
import dagger.Module
import dagger.Provides
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
internal class NetworkModule {

    companion object {
        private const val CLIENT_TIME_OUT = 120L
        private const val CLIENT_CACHE_SIZE = 10 * 1024 * 1024L
        private const val CLIENT_CACHE_DIRECTORY = "http"
    }

    /**
     * Create Cache object for OkHttp instance
     */
    @Provides
    @Singleton
    internal fun providesCache(context: Context): Cache = Cache(
        File(
            context.cacheDir,
            CLIENT_CACHE_DIRECTORY
        ),
        CLIENT_CACHE_SIZE
    )

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }

    @Provides
    @Singleton
    internal fun provideCurlInterceptor(): CurlInterceptor {
        return CurlInterceptor { message -> if (BuildConfig.DEBUG) println(message) }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        context: Context,
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor,
        curlInterceptor: CurlInterceptor,
        moshi: Moshi
    ): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
            .connectTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(CLIENT_TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context))
            .addInterceptor(loggingInterceptor)
            .addInterceptor(curlInterceptor)
            .addInterceptor(ErrorHandlingInterceptor(NetworkHandler(context), moshi))
            .cache(cache)

        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: Lazy<OkHttpClient>, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .callFactory { client.get().newCall(it) }
            .build()
    }

    @Provides
    @Singleton
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }
}
