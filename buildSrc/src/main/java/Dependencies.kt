object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { ("androidx.compose:compose-bom:${Versions.composeBom}") }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }

    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }




    val junit by lazy { "junit:junit:${Versions.junit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
    val uiTestJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
}

object Modules {

    const val utilities = ":utilities"
}