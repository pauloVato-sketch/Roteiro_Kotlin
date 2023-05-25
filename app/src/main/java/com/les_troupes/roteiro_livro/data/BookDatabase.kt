package com.les_troupes.roteiro_livro.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.les_troupes.roteiro_livro.domain.Book

@Database(
    entities = [Book::class],
    version = 1,
    exportSchema = false
)
abstract class BookDb : RoomDatabase() {
    abstract val bookDao: BookDao
}