package dependencies

object Version {

    const val compileSdkVersion = 30
    const val minSdkVersion = 21
    const val targetSdkVersion = 30

    const val majorVersion = 1
    const val minorVersion = 0
    const val patchVersion = 0

    const val versionCode = 100 * majorVersion + 10 * minorVersion + patchVersion
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
}