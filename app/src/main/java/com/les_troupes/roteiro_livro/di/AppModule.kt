package com.les_troupes.roteiro_livro.di

import android.content.Context
import androidx.room.Room
import com.les_troupes.roteiro_livro.core.Constants.Companion.BOOK_TABLE
import com.les_troupes.roteiro_livro.data.BookDao
import com.les_troupes.roteiro_livro.data.BookDb
import com.les_troupes.roteiro_livro.data.BookRepositoryImpl
import com.les_troupes.roteiro_livro.domain.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        BOOK_TABLE
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )
}