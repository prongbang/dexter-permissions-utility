package com.prongbang.dexter

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker

interface PermissionsCheckerListener {
	fun listener(permissions: Collection<String>, permissionsChecker: PermissionsChecker)
}

open class PermissionsCheckerListenerImpl(
		private val context: Context
) : PermissionsCheckerListener {

	override fun listener(permissions: Collection<String>, permissionsChecker: PermissionsChecker) {
		var granted = 0
		permissions.forEach { permission ->
			if (ContextCompat.checkSelfPermission(context,
							permission) == PermissionChecker.PERMISSION_GRANTED) {
				granted++
			}
		}

		if (permissions.size == granted) {
			permissionsChecker.onGranted()
		} else {
			permissionsChecker.onNotGranted()
		}
	}
}