# Dexter Permissions Utility

Easy use dexter permission for android

[![](https://jitpack.io/v/prongbang/dexter-permissions-utility.svg)](https://jitpack.io/#prongbang/dexter-permissions-utility)

## Installation

- Add the following repositories to your project/build.gradle file.

```groovy
repositories {
   maven { url 'https://jitpack.io' }
}
```

- Add the following dependency to your project/app/build.gradle file.

```groovy
dependencies {
    implementation 'com.karumi:dexter:6.2.3'
    implementation 'com.github.prongbang:dexter-permissions-utility:1.1.7'
}
```

## Usage

- Check permission allowed

```kotlin
private val permissionsUtility: PermissionsUtility by lazy {
    DexterPermissionsUtility(
            Dexter.withContext(this),
            SingleCheckPermissionListenerImpl(),
            MultipleCheckPermissionsListenerImpl(),
            PermissionsCheckerListenerImpl(this)
    )
}

permissionsUtility.isCameraGranted(object : PermissionsChecker {
    override fun onGranted() {

    }

    override fun onNotGranted() {

    }
})
```

- Require example permission

```kotlin
permissionsUtility.checkCameraGranted(object : PermissionsGranted() {
    override fun onGranted() {

    }

    override fun onDenied() {

    }

    override fun onNotShowAgain() {

    }
})
```
