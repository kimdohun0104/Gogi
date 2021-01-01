pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
}
rootProject.name = "Gogi"


include(":androidApp")
include(":androidApp:feature:splash")

include(":bridge")

include(":data:local")
include(":data:preference")
include(":androidApp:core")
include(":androidApp:feature:inputName")
include(":androidApp:feature:home")
include(":androidApp:feature:notification")
include(":androidApp:feature:expenditure")
include(":androidApp:feature:expenditureDetail")
include(":androidApp:feature:expenditureAddition")
include(":androidApp:feature:expenditureCategorySelection")
