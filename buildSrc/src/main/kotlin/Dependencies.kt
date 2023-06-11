object Versions {
  const val DateTime = "0.4.0"
  const val LifeCycle = "1.6.0"
  const val Navigation = "2.5.0"
  const val SqlDelight = "1.5.3"
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