package core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import core.database.dao.TemplateDao
import core.database.entity.TemplateEntity

@Database(
    entities = [
        TemplateEntity::class
    ],
    version = 1
)
internal abstract class TemplateDatabase : RoomDatabase() {
    abstract fun templateDao(): TemplateDao
}