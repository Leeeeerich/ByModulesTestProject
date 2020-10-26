package com.sosov.fileexhibitsloader

import android.content.Context
import android.util.Log
import com.google.gson.GsonBuilder
import com.sosov.model.Exhibit
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class FileExhibitsLoaderImpl(private val context: Context) : FileExhibitsLoader {

    override fun getExhibitList(): List<Exhibit> {
        return getFromAssets(context)?.let { jsonToExhibit(it) } ?: listOf()
    }

    private fun getFromAssets(context: Context): String? {
        var streamReader: InputStreamReader? = null
        return try {
            streamReader = InputStreamReader(context.assets.open("phone_list.json"), "UTF-8")
            streamReader.buffered().use(BufferedReader::readText)
        } catch (e: IOException) {
            Log.e(javaClass.name, "${e.message}")
            null
        } finally {
            if (streamReader != null) {
                try {
                    streamReader.close()
                } catch (e: IOException) {
                    Log.e(javaClass.name, "${e.message}")
                }
            }
        }
    }

    private fun jsonToExhibit(jsonText: String): List<Exhibit> {
        return GsonBuilder().create().fromJson(jsonText, BaseExhibitObj::class.java).list
    }
}

data class BaseExhibitObj(val list: List<Exhibit>)