package com.ptr.android
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences =
        application.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

    // Функции для сохранения и получения данных из SharedPreferences
    fun saveData(key: String, value: String) {
        viewModelScope.launch {
            sharedPreferences.edit().putString(key, value).apply()
        }
    }

    fun loadData(key: String): String? {
        return sharedPreferences.getString(key, null)
    }
}