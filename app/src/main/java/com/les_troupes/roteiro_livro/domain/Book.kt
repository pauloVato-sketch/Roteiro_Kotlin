package com.les_troupes.roteiro_livro.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.les_troupes.roteiro_livro.core.Constants.Companion.BOOK_TABLE

@Entity(tableName = BOOK_TABLE)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val author: String,
    val image_res: String
)