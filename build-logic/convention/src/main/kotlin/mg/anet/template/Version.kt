package mg.anet.template

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class VersionInfo(val major: Int, val minor: Int, val patch: Int) {
    fun versionString(): String = "$major.$minor.$patch"
    fun code(): Int = major * 10000 + minor * 100 + patch

    fun baseName(): String = "CarApp"

    fun longVersionString(): String = "${versionString()}.${
        SimpleDateFormat("ddMMyyHHmmss", Locale.FRANCE).format(
            Calendar.getInstance().time
        )
    }"
}