package core.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.map
import mg.template.datastore.TemplatePreferences
import mg.template.datastore.copy
import javax.inject.Inject

class PreferencesDataSource @Inject constructor(
    private val templatePreferences: DataStore<TemplatePreferences>
) {
    val template = templatePreferences.data.map { "template" }

    suspend fun setTemplate(value: String) {
        templatePreferences.updateData {
            it.copy {
                integerValue = 0
                stringValue = ""
                booleanValue = false
            }
        }
    }
}