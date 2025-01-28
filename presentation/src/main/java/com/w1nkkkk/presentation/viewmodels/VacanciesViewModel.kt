package com.w1nkkkk.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w1nkkkk.domain.Offer
import com.w1nkkkk.domain.RemoteVacanciesRepository
import com.w1nkkkk.domain.Vacancy
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VacanciesViewModel(
    private val repository: RemoteVacanciesRepository
) : ViewModel() {

    private val _state : MutableLiveData<State> = MutableLiveData()
    val state : LiveData<State> = _state

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, error ->
        _state.value = State.Error(error)
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO + coroutineExceptionHandler)

    fun getVacancies() {
        coroutineScope.launch {
            val data = repository.getData()
            _state.postValue(State.Success(data.first, data.second))
        }
    }

    sealed class State {
        data class Success(val offers: List<Offer>, val vacancies: List<Vacancy>) : State()
        data class Error(val error: Throwable) : State()
    }
}