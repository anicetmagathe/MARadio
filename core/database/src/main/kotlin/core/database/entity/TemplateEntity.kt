package core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "template_entities")
data class TemplateEntity(@PrimaryKey val id: Int, val name: String)