package com.tatvasoft.demo.base

import androidx.lifecycle.ViewModel
import com.tatvasoft.demo.data.datamanager.DataManager
import com.tatvasoft.demo.data.preferences.IPreference
import com.tatvasoft.demo.data.remote.ApiService
import com.tatvasoft.demo.data.roomdatabase.AppDatabase

open class BaseViewModel : ViewModel() {

    fun getPreference(): IPreference {
        return DataManager.getInstance().getPreference()
    }

    fun getDatabase(): AppDatabase {
        return DataManager.getInstance().getDatabase()
    }

    fun getRemote(): ApiService {
        return DataManager.getInstance().getRemote()
    }
}