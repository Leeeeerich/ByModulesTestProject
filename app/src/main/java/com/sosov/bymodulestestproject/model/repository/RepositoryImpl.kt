package com.sosov.bymodulestestproject.model.repository

import com.sosov.fileexhibitsloader.FileExhibitsLoader
import com.sosov.model.Exhibit

class RepositoryImpl(private val fileExhibitsLoader: FileExhibitsLoader) : Repository {

    override suspend fun loadExhibits(): List<Exhibit> {
        return fileExhibitsLoader.getExhibitList()
    }
}