package com.iverse.android.di.use_case

import com.iverse.core.domain.usecase.firebase.UpdateDocument
import com.iverse.core.domain.usecase.firebase.UpdateDocumentImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {


    @Binds
    @Singleton
    abstract fun bindUpdateDocumentUseCase(
        updateDocumentImpl: UpdateDocumentImpl
    ): UpdateDocument
}