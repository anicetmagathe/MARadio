import com.google.devtools.ksp.gradle.KspExtension
import mg.anet.template.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidKoinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            extensions.configure<KspExtension> {
                arg("KOIN_CONFIG_CHECK", "true")
            }

            dependencies {
                "implementation"(libs.findLibrary("koin.androidx.compose").get())
                "implementation"(libs.findLibrary("koin.android").get())
                "implementation"(libs.findLibrary("koin.annotations").get())
                "ksp"(libs.findLibrary("koin.ksp.compiler").get())
            }

        }
    }

}
