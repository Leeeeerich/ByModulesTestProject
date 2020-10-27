package com.sosov.bymodulestestproject.model.repository

import com.sosov.model.Exhibit

interface Repository {
    suspend fun loadExhibits(): List<Exhibit>
}