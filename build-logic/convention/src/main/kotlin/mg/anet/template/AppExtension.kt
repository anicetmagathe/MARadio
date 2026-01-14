package mg.anet.template

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import javax.inject.Inject

open class AppVersionExtension @Inject constructor(objects: ObjectFactory) {
    val name: Property<String> =
        objects.property(String::class.java).convention("app")

    val version: Property<VersionInfo> =
        objects.property(VersionInfo::class.java).convention(VersionInfo(0, 0, 1))
}