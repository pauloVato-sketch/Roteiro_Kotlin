package com.les_troupes.roteiro_livro.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.les_troupes.roteiro_livro.core.Constants.Companion.BOOK_ID
import com.les_troupes.roteiro_livro.presentation.books.BooksScreen
import com.les_troupes.roteiro_livro.presentation.update_book.UpdateBookScreen

@Composable
@ExperimentalMaterialApi
fun NavGraph (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.BooksScreen.route
    ) {
        composable(
            route = Screen.BooksScreen.route
        ) {
            BooksScreen(
                navigateToUpdateBookScreen = { bookId:Int ->
                    navController.navigate(
                        route = "${Screen.UpdateBookScreen.route}/${bookId}"
                    )
                }
            )
        }
        composable(
            route = "${Screen.UpdateBookScreen.route}/{$BOOK_ID}",
            arguments = listOf(
                navArgument(BOOK_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getInt(BOOK_ID) ?: 0
            UpdateBookScreen(
                bookId = bookId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}