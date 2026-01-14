package core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import core.database.entity.TemplateEntity

@Dao
interface TemplateDao {
    @Query("SELECT * FROM template_entities")
    suspend fun getAll(): List<TemplateEntity>

    @Query("SELECT * FROM template_entities WHERE id LIKE :id")
    suspend fun get(id: String): TemplateEntity?

    @Insert
    suspend fun insert(templateEntities: List<TemplateEntity>)

    @Query("DELETE FROM template_entities")
    suspend fun deleteAll()
}