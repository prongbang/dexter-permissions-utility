package com.prongbang.permissions

import com.prongbang.dexter.PermissionsChecker
import com.prongbang.dexter.PermissionsGranted
import com.prongbang.dexter.PermissionsUtility

class Example {

	private lateinit var permissionUtility: PermissionsUtility

	fun example() {
		permissionUtility.isCameraGranted(object : PermissionsChecker {
			override fun onGranted() {

			}
			override fun onNotGranted() {

			}
		})

		permissionUtility.checkCameraGranted(object : PermissionsGranted() {
			override fun onGranted() {

			}

			override fun onDenied() {

			}

			override fun onNotShowAgain() {

			}
		})
	}
}