package com.tatvasoft.demo.data.roomdatabase.userdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tatvasoft.demo.data.roomdatabase.userdata.UserDataItem

@Dao
interface UserDataDao {

    @Query("SELECT * FROM user_data")
    suspend fun getAllSavedUserDetail(): List<UserDataItem>

    @Insert()
    suspend fun insertUserDetail(userDataItem: UserDataItem)

    @Query("SELECT * FROM  user_data where user_name = (:userName)")
    suspend fun isUserNameExist(userName :String) : UserDataItem?
}