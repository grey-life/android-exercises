package com.example.todoapp

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }

    suspend fun delete(word: Word) {
        wordDao.deleteWord(word)
    }

    suspend fun deleteAll() {
        wordDao.deleteAll()
    }
}