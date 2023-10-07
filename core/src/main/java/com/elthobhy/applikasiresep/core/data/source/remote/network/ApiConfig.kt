package com.elthobhy.applikasiresep.core.data.source.remote.network

import com.elthobhy.applikasiresep.BuildConfig
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object {
        fun getApiService(): ApiService {
            val hostname = BuildConfig.HOSTNAME
            val certificatePinner = CertificatePinner.Builder()
                .add(hostname, BuildConfig.CERTIFICATE_PINNER)
                .build()
            val client = OkHttpClient.Builder()
                .certificatePinner(certificatePinner)

            if (BuildConfig.DEBUG) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.NONE)
                logging.redactHeader("Authorization")
                logging.redactHeader("Cookie")
                client.addInterceptor(logging)
            }

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}