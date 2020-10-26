package com.sosov.bymodulestestproject.model.repository

import com.sosov.model.Exhibit

interface Repository {
    fun loadExhibits(): List<Exhibit>
}