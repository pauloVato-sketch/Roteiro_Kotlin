package com.les_troupes.roteiro_livro.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.les_troupes.roteiro_livro.domain.Book
import com.les_troupes.roteiro_livro.domain.Books
import androidx.compose.foundation.lazy.items


@Composable
@ExperimentalMaterialApi
fun BooksContent(
    padding: PaddingValues,
    books: Books,
    deleteBook: (book: Book) -> Unit,
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = books
        ) { book ->
            BookCard(
                book = book,
                deleteBook = {
                    deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
        }
    }
}