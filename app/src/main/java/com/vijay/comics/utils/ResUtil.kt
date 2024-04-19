package com.vijay.comics.utils

import android.content.Context
import com.squareup.moshi.Moshi
import java.io.BufferedReader
import java.io.InputStreamReader

object ResUtil {
    fun <T : Any> fromRawJson(clazz: Class<T>, context: Context, id: Int): T? {
        context.resources.openRawResource(id).let {
            val moshi = Moshi.Builder().build()
            val jsonData = BufferedReader(InputStreamReader(it)).use { br ->
                br.readText()
            }
            return moshi.adapter(clazz).fromJson(jsonData)
        }
    }
}
