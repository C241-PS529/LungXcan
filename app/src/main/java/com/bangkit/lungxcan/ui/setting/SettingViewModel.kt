package com.bangkit.lungxcan.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.bangkit.lungxcan.ui.setting.SettingPreferences
import kotlinx.coroutines.launch
class SettingViewModel (private val pref: SettingPreferences) : ViewModel() {


        fun getThemeSettings() : LiveData<Boolean> {
            return pref.getThemeSetting().asLiveData()

        }

        fun saveThemeSetting(isDarkModeActive: Boolean) {
            viewModelScope.launch {
                pref.saveThemeSetting(isDarkModeActive)
            }
        }

    }

