package com.tatvasoft.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tatvasoft.demo.base.BaseViewModel
import com.tatvasoft.demo.base.Result
import com.tatvasoft.demo.model.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataViewModel : BaseViewModel() {
    var mData = MutableLiveData<Result<DataModel>>()


    fun getData(page: Int = 1) {
        viewModelScope.launch {
            try {
                val response = getRemote().getData(page)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.body()?.let {
                            mData.value = Result.Success(it)
                        } ?: kotlin.run {
                            mData.value = Result.Error(IllegalStateException())
                        }
                    } else {
                        mData.value = Result.Error(IllegalStateException())
                    }
                }
            } catch (e: Exception) {
                mData.value = Result.Error(e)
            }
        }
    }

}