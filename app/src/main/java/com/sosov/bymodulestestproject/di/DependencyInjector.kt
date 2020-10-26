package com.sosov.bymodulestestproject.di

import com.sosov.bymodulestestproject.model.repository.Repository
import com.sosov.bymodulestestproject.ui.base.exhibithion.ExhibitionModel
import com.sosov.fileexhibitsloader.FileExhibitsLoader
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object DependencyInjector {

    val appModule = module {
        single<FileExhibitsLoader> { Modules.getExhibitionLoader(get()) }
        single<Repository> { Modules.getRepository(get()) }
        viewModel { ExhibitionModel(get()) }
    }
}