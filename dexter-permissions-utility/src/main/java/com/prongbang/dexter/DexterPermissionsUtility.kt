package com.prongbang.dexter

import android.Manifest
import com.karumi.dexter.DexterBuilder
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class DexterPermissionsUtility(
		private val permissionsManager: com.prongbang.dexter.PermissionsManager,
		private val dexter: DexterBuilder.Permission
) : PermissionsUtility {

	override fun checkSmsGranted(onGranted: () -> Unit) {
		dexter.withPermissions(
				Manifest.permission.RECEIVE_SMS,
				Manifest.permission.READ_SMS,
				Manifest.permission.SEND_SMS)
				.withListener(onPermissionsListener {
					onGranted.invoke()
				})
				.check()
	}

	override fun checkCameraGranted(onGranted: () -> Unit) {
		dexter.withPermissions(Manifest.permission.CAMERA)
				.withListener(onPermissionsListener {
					onGranted.invoke()
				})
				.check()
	}

	override fun checkExternalStorageGranted(onGranted: () -> Unit) {
		dexter.withPermissions(
				Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.WRITE_EXTERNAL_STORAGE)
				.withListener(onPermissionsListener {
					onGranted.invoke()
				})
				.check()
	}

	override fun checkLocationGranted(onGranted: () -> Unit) {
		dexter.withPermissions(
				Manifest.permission.ACCESS_FINE_LOCATION,
				Manifest.permission.ACCESS_COARSE_LOCATION,
				Manifest.permission.ACCESS_BACKGROUND_LOCATION)
				.withListener(onPermissionsListener {
					onGranted.invoke()
				})
				.check()
	}

	override fun isCameraGranted(onGranted: () -> Unit, onNotGranted: () -> Unit, onNeverAskAgain: () -> Unit) {
		processCheckPermissionGranted(Manifest.permission.CAMERA, onGranted, onNotGranted, onNeverAskAgain)
	}

	private fun processCheckPermissionGranted(permission: String, onGranted: () -> Unit,
	                                          onNotGranted: () -> Unit,
	                                          onNeverAskAgain: () -> Unit) {
		if (permissionsManager.isPermissionGranted(permission)) {
			onGranted.invoke()
		} else {
			if (!permissionsManager.isPermissionRationale(permission)) {
				onNeverAskAgain.invoke()
			} else {
				onNotGranted.invoke()
			}
		}
	}

	private fun onPermissionsListener(onGranted: () -> Unit): MultiplePermissionsListener {
		return object : MultiplePermissionsListener {
			override fun onPermissionsChecked(report: MultiplePermissionsReport) {
				onGranted.invoke()
			}

			override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest>, token: PermissionToken?) {
				token?.continuePermissionRequest()
			}
		}
	}
}