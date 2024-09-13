package com.example.unfollowersinstagram.presentation.viewmodel

import androidx.lifecycle.*
import com.example.unfollowersinstagram.domain.usecase.GetUsersDontFollowMeUseCase
import kotlinx.coroutines.launch

/**
 * @author Axel Sanchez
 */
class DontFollowMeViewModel(private val getUsersDontFollowMeUseCase: GetUsersDontFollowMeUseCase): ViewModel() {

    private val listData: MutableLiveData<DataProducts> =
        MutableLiveData<DataProducts>()


    fun setListData(result: DataProducts) {
        listData.postValue(result)
    }

    fun getUsers(userName: String) {
        viewModelScope.launch {
            setListData(getUsersDontFollowMeUseCase.call(userName))
        }
    }

    fun getProductLiveData(): LiveData<DataProducts> {
        return listData
    }

    class DontFollowMeViewModelFactory(private val getUsersDontFollowMeUseCase: GetUsersDontFollowMeUseCase) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(GetUsersDontFollowMeUseCase::class.java).newInstance(getUsersDontFollowMeUseCase)
        }
    }
}