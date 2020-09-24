package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.*

//Dao Data Access Object

@Dao
interface WordDao {

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete()
    fun deleteWord(word: Word)
}