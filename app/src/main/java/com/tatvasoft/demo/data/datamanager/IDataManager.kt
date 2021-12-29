package com.tatvasoft.demo.data.datamanager

import com.tatvasoft.demo.data.preferences.IPreference
import com.tatvasoft.demo.data.remote.ApiService
import com.tatvasoft.demo.data.roomdatabase.AppDatabase

interface IDataManager {
    fun getPreference(): IPreference
    fun getDatabase(): AppDatabase
    fun getRemote(): ApiService
}