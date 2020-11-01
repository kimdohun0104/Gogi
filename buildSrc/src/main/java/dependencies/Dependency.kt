package dependencies

object Dependency {

    const val material = "com.google.android.material:material:1.2.1"

    object Kotlin {

        const val version = "1.4.10"
    }

    object AndroidX {

        const val appCompat = "androidx.appcompat:appcompat:1.2.0"

        object Compose {
            const val version = "1.0.0-alpha05"

            const val ui = "androidx.compose.ui:ui:$version"
            const val tooling = "androidx.ui:ui-tooling:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
        }


    }

    object Kinda {
        const val version = "1.3.0-beta3"

        const val core = "com.github.kimdohun0104.kinda:kinda-core:$version"
        const val dsl = "com.github.kimdohun0104.kinda:kinda-dsl:$version"
        const val android = "com.github.kimdohun0104.kinda:kinda-android:$version"
        const val compose = "com.github.kimdohun0104.kinda:kinda-compose:$version"
    }

    object Test {
        const val kinda = "com.github.kimdohun0104.kinda:kinda-android-test:${Kinda.version}"
    }
}