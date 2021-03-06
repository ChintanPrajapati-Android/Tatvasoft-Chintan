package com.tatvasoft.demo.data.datamanager

import com.tatvasoft.demo.data.preferences.PreferenceManager
import com.tatvasoft.demo.data.remote.ApiClient
import com.tatvasoft.demo.data.remote.ApiService
import com.tatvasoft.demo.data.roomdatabase.AppDatabase

class DataManager : IDataManager {

    companion object {

        private var SINGLETON_INSTANCE: IDataManager? = null

        fun getInstance(): IDataManager {
            if (SINGLETON_INSTANCE == null) {
                SINGLETON_INSTANCE = DataManager()
            }
            return SINGLETON_INSTANCE!!
        }
    }

    override fun getPreference() = PreferenceManager.getInstance()

    override fun getDatabase(): AppDatabase {
        return AppDatabase.getDatabase()
    }

    override fun getRemote(): ApiService {
        return ApiClient.getInstance("https://reqres.in/").create(ApiService::class.java)
    }
}