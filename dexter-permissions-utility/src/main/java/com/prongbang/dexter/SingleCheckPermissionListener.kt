package com.prongbang.dexter

import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

interface SingleCheckPermissionListener : PermissionListener {
	fun listener(permissionsGranted: PermissionsGranted): SingleCheckPermissionListener
}

open class SingleCheckPermissionListenerImpl : SingleCheckPermissionListener {
	private var permissionsGranted: PermissionsGranted? = null

	override fun listener(permissionsGranted: PermissionsGranted): SingleCheckPermissionListener {
		this.permissionsGranted = permissionsGranted
		return this
	}

	override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
		permissionsGranted?.onGranted()
	}

	override fun onPermissionRationaleShouldBeShown(p0: PermissionRequest?, p1: PermissionToken?) {
		p1?.continuePermissionRequest()
	}

	override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
		if (p0?.isPermanentlyDenied == true) {
			permissionsGranted?.onNotShowAgain()
		} else {
			permissionsGranted?.onDenied()
		}
	}
}