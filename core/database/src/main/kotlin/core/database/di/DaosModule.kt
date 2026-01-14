package core.database.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import core.database.TemplateDatabase
import core.database.dao.TemplateDao

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {
    @Provides
    fun providesImageDao(
        database: TemplateDatabase
    ): TemplateDao = database.templateDao()
}