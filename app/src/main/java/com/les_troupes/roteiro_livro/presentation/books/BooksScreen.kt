package com.les_troupes.roteiro_livro.presentation.books

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.les_troupes.roteiro_livro.presentation.books.components.AddBookAlertDialog
import com.les_troupes.roteiro_livro.presentation.books.components.AddBookFloatingActionButton
import com.les_troupes.roteiro_livro.presentation.books.components.BooksContent
import com.les_troupes.roteiro_livro.presentation.books.components.BooksTopBar


@Composable
@ExperimentalMaterialApi
fun BooksScreen(
    viewModel: BooksViewModel = hiltViewModel(),
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    val books by viewModel.books.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            BooksTopBar()
        },
        content = { padding ->
            BooksContent(
                padding = padding,
                books = books,
                deleteBook = { book ->
                    viewModel.deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
            AddBookAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addBook(book)
                }
            )
        },
        floatingActionButton = {
            AddBookFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}