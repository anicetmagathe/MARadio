import com.android.build.gradle.LibraryExtension
import mg.anet.template.configureFlavors
import mg.anet.template.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationFlavorsConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                val extension = extensions.getByType<LibraryExtension>()
//                configureAndroidCompose(extension)
                configureFlavors(this)
            }
        }
    }
}