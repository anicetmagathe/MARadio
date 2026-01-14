import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.BuildConfigField
import com.android.build.api.variant.VariantOutput
import com.android.build.gradle.BaseExtension
import mg.anet.template.AppVersionExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getByType

class ApplicationVersionConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val ext = project.extensions.create<AppVersionExtension>(
            "appVersionExtension", project.objects
        )

        project.plugins.withId("com.android.application") {
            project.extensions
                .configure<BaseExtension>("android") {
                    buildFeatures.buildConfig = true
                }

            val androidComponents =
                project.extensions.getByType<ApplicationAndroidComponentsExtension>()

            androidComponents.onVariants { variant ->
                val versionInfo = ext.version.get()
                val appName = ext.name.get()

                variant.outputs.forEach { output: VariantOutput ->
                    output.versionCode.set(versionInfo.code())
                    output.versionName.set(versionInfo.versionString())
                }
                variant.buildConfigFields?.run {
                    put(
                        "APP_VERSION_NAME",
                        BuildConfigField("String", "\"${versionInfo.versionString()}\"", null)
                    )
                    put(
                        "APP_LONG_VERSION_NAME",
                        BuildConfigField("String", "\"${versionInfo.longVersionString()}\"", null)
                    )
                    put(
                        "APP_VERSION_CODE",
                        BuildConfigField("int", "${versionInfo.code()}", null)
                    )
                    put(
                        "APP_NAME",
                        BuildConfigField("String", "\"$appName\"", null)
                    )
                }


            }
        }
    }
}