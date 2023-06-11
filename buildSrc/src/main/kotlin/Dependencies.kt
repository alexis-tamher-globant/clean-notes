object Versions {
  const val DateTime = "0.4.0"
  const val LifeCycle = "1.6.0"
  const val Navigation = "2.5.0"
  const val SqlDelight = "1.5.3"
  const val koin = "3.2.0"
}

object Navigation {
  const val Compose = "androidx.navigation:navigation-compose:${Versions.Navigation}"
}
object LifeCycle {
  const val ViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LifeCycle}"
}
object Kotlin {
  const val DateTime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.DateTime}"
}

object SqlDelight {
  const val RuntTime = "com.squareup.sqldelight:runtime:${Versions.SqlDelight}"
  const val AndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.SqlDelight}"
  const val NativeDriver = "com.squareup.sqldelight:native-driver:${Versions.SqlDelight}"
  const val GradlePlugin = "com.squareup.sqldelight"
}

object Koin {
  const val Core = "io.insert-koin:koin-core:${Versions.koin}"
  const val Android = "io.insert-koin:koin-android:${Versions.koin}"
  const val AndroidCompose = "io.insert-koin:koin-androidx-compose:${Versions.koin}"
}