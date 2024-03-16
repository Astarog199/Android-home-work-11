package com.example.hw11

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity


private const val KEY = "KEY_STRING"
private const val REPOSITORY_NAME = "rep_name"

class Repository(context: Context) {
    private var value: String? = null
    private var prefs: SharedPreferences? = null

    init {
        prefs = context.getSharedPreferences(REPOSITORY_NAME, AppCompatActivity.MODE_PRIVATE)
    }

    /**
     * будет доставать значение из SharedPreference;
     */
    private fun getDataFromSharedPreference(): String? {
        return prefs?.getString(KEY, null)
    }

    /**
     * Метод достаёт значение, и возвращает значение локальной переменной;
     */
    private fun getDataFromLocalVariable(): String? {
        return value
    }

    /**
     * Метод записывает значения и в SharedPreference, и в локальную переменную.
     */
    fun saveText(text: String) {
        prefs?.edit()?.putString(KEY, text)?.apply()
        value = text
    }

    /**
     * Метод очищает значение в SharedPreference, и в локальной переменной.
     */
    fun clearText() {
        prefs?.edit()?.remove(KEY)?.apply()
        value = null
    }

    /**
     * будет доставать значение из источников: сначала попытается взять значение локальной переменной;
     * если оно null, то попытаемся взять значение из SharedPreference.
     */
    fun getText(): String {
        val localVariable = getDataFromLocalVariable()
        val valueSP = getDataFromSharedPreference().toString()
        return localVariable ?: valueSP

    }
}