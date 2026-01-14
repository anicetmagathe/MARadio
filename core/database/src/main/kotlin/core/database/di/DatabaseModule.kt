package core.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import core.database.TemplateDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesTemplateDatabase(
        @ApplicationContext context: Context,
    ): TemplateDatabase = Room.databaseBuilder(
        context,
        TemplateDatabase::class.java,
        "template-database",
    ).build()
}