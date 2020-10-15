package com.prongbang.dexter

import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

interface MultipleCheckPermissionsListener : MultiplePermissionsListener {
	fun listener(permissionsGranted: MultiplePermissionsGranted): MultiplePermissionsListener
}

open class MultipleCheckPermissionsListenerImpl : MultipleCheckPermissionsListener {
	private var permissionsGranted: MultiplePermissionsGranted? = null

	override fun listener(permissionsGranted: MultiplePermissionsGranted): MultipleCheckPermissionsListener {
		this.permissionsGranted = permissionsGranted
		return this
	}

	override fun onPermissionsChecked(report: MultiplePermissionsReport) {
		if (report.deniedPermissionResponses.isNotEmpty()) {
			permissionsGranted?.onDenied()
		} else {
			permissionsGranted?.onGranted()
		}
	}

	override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest>,
	                                                token: PermissionToken) {
		token.continuePermissionRequest()
	}

}