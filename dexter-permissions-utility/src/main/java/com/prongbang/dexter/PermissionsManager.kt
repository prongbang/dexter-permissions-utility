package com.prongbang.dexter

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

interface PermissionsManager {
	fun isPermissionGranted(permission: String): Boolean
	fun isPermissionRationale(permission: String): Boolean
}

class SelfPermissionsManager(
		private val activity: Activity
) : PermissionsManager {

	override fun isPermissionGranted(permission: String): Boolean {
		return ContextCompat.checkSelfPermission(activity,
				permission) == PackageManager.PERMISSION_GRANTED
	}

	override fun isPermissionRationale(permission: String): Boolean {
		return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)
	}
}