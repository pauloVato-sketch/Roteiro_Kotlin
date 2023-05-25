package com.les_troupes.roteiro_livro.presentation.update_book

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.les_troupes.roteiro_livro.presentation.books.BooksViewModel
import com.les_troupes.roteiro_livro.presentation.update_book.components.UpdateBookContent
import com.les_troupes.roteiro_livro.presentation.update_book.components.UpdateBookTopBar


@Composable
fun UpdateBookScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    bookId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getBook(bookId)
    }
    Scaffold(
        topBar = {
            UpdateBookTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateBookContent(
                padding = padding,
                book = viewModel.book,
                updateTitle = { title ->
                    viewModel.updateTitle(title)
                },
                updateAuthor = { author ->
                    viewModel.updateAuthor(author)
                },
                updateBook = { book ->
                    viewModel.updateBook(book)
                },
                navigateBack = navigateBack
            )
        }
    )
}