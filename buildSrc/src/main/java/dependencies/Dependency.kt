package dependencies

object Dependency {

    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val material = "com.google.android.material:material:1.2.1"

    object Kotlin {

        const val version = "1.4.10"
    }

    object AndroidX {

        const val startup = "androidx.startup:startup-runtime:1.0.0"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"

        object Compose {
            const val version = "1.0.0-alpha07"

            const val ui = "androidx.compose.ui:ui:$version"
            const val tooling = "androidx.ui:ui-tooling:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val material = "androidx.compose.material:material:$version"
            const val liveData = "androidx.compose.runtime:runtime-livedata:$version"
        }

        object Navigation {
            const val compose = "androidx.navigation:navigation-compose:1.0.0-alpha02"
        }
    }

    object Kinda {
        const val version = "1.3.0-beta7"

        const val core = "com.github.kimdohun0104.kinda:kinda-core:$version"
        const val dsl = "com.github.kimdohun0104.kinda:kinda-dsl:$version"
        const val android = "com.github.kimdohun0104.kinda:kinda-android:$version"
    }

    object Koin {
        const val version = "2.2.1"
        const val compose = "org.koin:koin-androidx-compose:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13.1"
        const val mockito = "org.mockito:mockito-core:3.6.28"
        const val mockitoInline = "org.mockito:mockito-inline:3.6.28"
        const val kinda = "com.github.kimdohun0104.kinda:kinda-android-test:${Kinda.version}"
    }
}