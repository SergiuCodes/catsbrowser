//package com.example.catsbrowser.di
//
//import com.example.catsbrowser.data.network.client.HttpRequestInterceptor
//import com.example.catsbrowser.data.network.service.BreedService
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//
//
//class NetworkModule {
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient {
//        return OkHttpClient.Builder()
//            .addInterceptor(HttpRequestInterceptor())
//            .build()
//    }
//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .client(okHttpClient)
//            .baseUrl("https://api.thecatapi.com/v1/")
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()
//    }
//    @Provides
//    @Singleton
//    fun createBreedService(retrofit: Retrofit){
//        retrofit.create(BreedService::class.java)
//    }
//}