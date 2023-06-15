package com.net.core.network.retrofit

import com.net.core.BuildConfig
import com.net.core.network.ParisSportifNetwork
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.net.core.network.model.League
import com.net.core.network.model.Teams
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParisSportifRetrofitNetwork @Inject constructor(
    networkJson: Json
) : ParisSportifNetwork {
    override suspend fun getLeagues(): League {
        return networkApi.getALLLeagues()
    }

    override suspend fun getTeams(league: String): Teams {
        return networkApi.getLeagueTeams(league)
    }


    @Suppress("EXPERIMENTAL_IS_NOT_ENABLED")
    @OptIn(ExperimentalSerializationApi::class)
    private val networkApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(ParisSportifRetrofitApi::class.java)
}
