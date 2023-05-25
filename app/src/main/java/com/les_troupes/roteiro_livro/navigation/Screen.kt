package com.les_troupes.roteiro_livro.navigation

import com.les_troupes.roteiro_livro.core.Constants.Companion.BOOKS_SCREEN
import com.les_troupes.roteiro_livro.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}