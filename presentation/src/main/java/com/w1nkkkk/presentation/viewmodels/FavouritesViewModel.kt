package com.w1nkkkk.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.w1nkkkk.domain.LocalVacanciesRepository
import com.w1nkkkk.domain.Vacancy
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import kotlin.coroutines.CoroutineContext

class FavouritesViewModel(
    private val repository: LocalVacanciesRepository
) : ViewModel() {

    val favourites : MutableStateFlow<List<Vacancy>> = MutableStateFlow(emptyList())

    val itemsCount : MutableLiveData<Int> = MutableLiveData(0)

    init {
        getFavourites()
    }

    fun getFavourites() {
        CoroutineScope(Dispatchers.IO).launch {
            val list = repository.getFavourites()
            favourites.emit(list)
            itemsCount.postValue(list.size)
        }
    }

    fun insertFavourites(item: Vacancy) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insertVacancy(item)
            getFavourites()
        }
    }

    fun deleteFavourites(item: Vacancy) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteVacancy(item)
            getFavourites()
        }
    }
}