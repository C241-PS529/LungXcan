package com.bangkit.lungxcan.data.di

import android.content.Context
import com.bangkit.lungxcan.data.api.AuthApiConfig
import com.bangkit.lungxcan.data.api.MapApiConfig
import com.bangkit.lungxcan.data.pref.UserPreference
import com.bangkit.lungxcan.data.pref.dataStore
import com.bangkit.lungxcan.data.repository.ArticleRepository
import com.bangkit.lungxcan.data.repository.LoginRepository
import com.bangkit.lungxcan.data.repository.MapRepository
import com.bangkit.lungxcan.data.repository.RegisterRepository

object Injection {
    fun provideArticleRepository(): ArticleRepository {
        return ArticleRepository.getInstance()
    }

    fun provideMapRepository(): MapRepository {
        val mapApiService = MapApiConfig.getMapApi()
        return MapRepository.getInstance(mapApiService)
    }

    fun provideLoginRepository(context: Context): LoginRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = AuthApiConfig.getAuthApiService()
        return LoginRepository.getInstance(apiService, pref)
    }

    fun provideRegisterRepository(context: Context): RegisterRepository {
        val apiService = AuthApiConfig.getAuthApiService()
        return RegisterRepository.getInstance(apiService)
    }
}