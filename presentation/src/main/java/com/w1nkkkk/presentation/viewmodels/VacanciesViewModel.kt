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
import kotlin.math.truncate

class VacanciesViewModel(
    private val repository: RemoteVacanciesRepository
) : ViewModel() {

    init {
        getVacancies()
    }

    private val _state : MutableLiveData<State> = MutableLiveData()
    val state : LiveData<State> = _state

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, error ->
        _state.postValue(State.Error(error))
    } // coroutineExceptionHandler + Dispatchers.IO - не работает в проекте не смог исправить

    fun getVacancies() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = repository.getData()
                _state.postValue(State.Success(data.second, data.first))
            } catch (e : Throwable) {
                _state.postValue(State.Error(e))
            }
        }
    }

    sealed class State(open val vacancies: List<Vacancy>) {
        class Success(vacancies: List<Vacancy>, val offers: List<Offer>, ) : State(vacancies)
        data class Error(val error: Throwable) : State(emptyList())
    }
}