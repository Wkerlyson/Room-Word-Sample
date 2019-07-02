package com.projetos.roomwordsample.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.projetos.roomwordsample.dao.WordDao
import com.projetos.roomwordsample.model.Word

class WordRepository(private val wordDao: WordDao){

    val allWords: LiveData<List<Word>> = wordDao.getAllWords()

    @WorkerThread
    suspend fun inser(word: Word) {
        wordDao.insert(word)
    }
}