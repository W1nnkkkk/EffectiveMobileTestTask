package com.w1nkkkk.effectivemobile

import com.w1nkkkk.data.datasource.local.FavouritesLocalDatasource
import com.w1nkkkk.data.datasource.local.FavouritesLocalDatasourceImpl
import com.w1nkkkk.data.datasource.remote.RemoteDatasource
import com.w1nkkkk.data.datasource.remote.RemoteDatasourceImpl
import com.w1nkkkk.data.repository.LocalVacanciesRepositoryImpl
import com.w1nkkkk.data.repository.RemoteVacanciesRepositoryImpl
import com.w1nkkkk.domain.LocalVacanciesRepository
import com.w1nkkkk.domain.RemoteVacanciesRepository
import com.w1nkkkk.presentation.viewmodels.FavouritesViewModel
import com.w1nkkkk.presentation.viewmodels.VacanciesViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single<FavouritesViewModel> {
        FavouritesViewModel(repository = get())
    }

    single<VacanciesViewModel> {
        VacanciesViewModel(repository = get())
    }
}

val favouritesModule = module {
    single<FavouritesLocalDatasource> { FavouritesLocalDatasourceImpl(context = get()) }
    single<LocalVacanciesRepository> { LocalVacanciesRepositoryImpl(datasource = get()) }
}

val vacanciesModule = module {
    single<RemoteDatasource> { RemoteDatasourceImpl() }
    single<RemoteVacanciesRepository> { RemoteVacanciesRepositoryImpl(remoteDatasource = get()) }
}