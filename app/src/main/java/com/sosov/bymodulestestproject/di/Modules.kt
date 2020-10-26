package com.sosov.bymodulestestproject.di

import android.content.Context
import com.sosov.bymodulestestproject.model.repository.RepositoryImpl
import com.sosov.fileexhibitsloader.FileExhibitsLoader
import com.sosov.fileexhibitsloader.FileExhibitsLoaderImpl

object Modules {

    fun getRepository(fileExhibitsLoader: FileExhibitsLoader): RepositoryImpl {
        return RepositoryImpl(fileExhibitsLoader)
    }

    fun getExhibitionLoader(context: Context): FileExhibitsLoaderImpl {
        return FileExhibitsLoaderImpl(context)
    }
}