package com.prongbang.dexter

interface PermissionsUtility {
	fun checkSmsGranted(onGranted: () -> Unit)
	fun checkCameraGranted(onGranted: () -> Unit)
	fun checkExternalStorageGranted(onGranted: () -> Unit)
	fun isCameraGranted(onGranted: () -> Unit, onNotGranted: () -> Unit, onNeverAskAgain: () -> Unit)
	fun checkLocationGranted(onGranted: () -> Unit)
}