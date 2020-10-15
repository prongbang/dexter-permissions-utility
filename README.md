# Dexter Permissions Utility

Easy use dexter permission for android

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
    implementation 'com.github.prongbang:dexter-permissions-utility:1.1.0'
}
```

## Usage

- Check permission allowed

```kotlin
permissionUtility.isCameraGranted(object : PermissionsChecker {
    override fun onGranted() {

    }

    override fun onNotGranted() {

    }
}))
```

- Require example permission

```kotlin
permissionUtility.checkCameraGranted(object : PermissionsGranted() {
    override fun onGranted() {

    }

    override fun onDenied() {

    }

    override fun onNotShowAgain() {

    }
})
```