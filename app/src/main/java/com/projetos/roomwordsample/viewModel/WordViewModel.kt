package com.projetos.roomwordsample.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.projetos.roomwordsample.database.WordRoomDatabase
import com.projetos.roomwordsample.model.Word
import com.projetos.roomwordsample.repository.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application ) : AndroidViewModel(application) {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.inser(word)
    }
}