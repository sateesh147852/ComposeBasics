package com.composebasics.examples.quotes

import android.content.Context
import com.composebasics.examples.quotes.model.Quotes
import com.google.gson.Gson

object DataManager {

    fun getQuotes(context: Context): Array<Quotes> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return Gson().fromJson(json,Array<Quotes>::class.java)
    }
}