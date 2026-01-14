package core.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import mg.template.datastore.TemplatePreferences
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class TemplatePreferencesSerializer @Inject constructor() : Serializer<TemplatePreferences> {
    override val defaultValue: TemplatePreferences = TemplatePreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): TemplatePreferences =
        try {
            TemplatePreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: TemplatePreferences, output: OutputStream) {
        t.writeTo(output)
    }
}