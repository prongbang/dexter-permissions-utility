package com.prongbang.dexter

import android.Manifest
import com.karumi.dexter.DexterBuilder

open class DexterPermissionsUtility(
		private val dexter: DexterBuilder.Permission,
		private val singleCheckPermissionListener: SingleCheckPermissionListener,
		private val multipleCheckPermissionsListener: MultipleCheckPermissionsListener,
		private val permissionsCheckerListener: PermissionsCheckerListener
) : PermissionsUtility {

	override fun isAccessGalleryGranted(permissionsChecker: PermissionsChecker) {
		permissionsCheckerListener.listener(listOf(Manifest.permission.READ_EXTERNAL_STORAGE,
				Manifest.permission.WRITE_EXTERNAL_STORAGE), permissionsChecker)
	}

	override fun isReadExternalGranted(permissionsChecker: PermissionsChecker) {
		permissionsCheckerListener.listener(listOf(Manifest.permission.READ_EXTERNAL_STORAGE),
				permissionsChecker)
	}

	override fun isWriteExternalGranted(permissionsChecker: PermissionsChecker) {
		permissionsCheckerListener.listener(listOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
				permissionsChecker)
	}

	override fun isCameraGranted(permissionsChecker: PermissionsChecker) {
		permissionsCheckerListener.listener(listOf(Manifest.permission.CAMERA), permissionsChecker)
	}

	override fun checkPhoneStateGranted(permissionsGranted: PermissionsGranted) {
		singleCheck(Manifest.permission.READ_PHONE_STATE, permissionsGranted)
	}

	override fun checkReadExternalGranted(permissionsGranted: PermissionsGranted) {
		singleCheck(Manifest.permission.READ_EXTERNAL_STORAGE, permissionsGranted)
	}

	override fun checkWriteExternalGranted(permissionsGranted: PermissionsGranted) {
		singleCheck(Manifest.permission.WRITE_EXTERNAL_STORAGE, permissionsGranted)
	}

	override fun checkReadWriteExternalGranted(permissionsGranted: MultiplePermissionsGranted) {
		multipleCheck(listOf(
				Manifest.permission.WRITE_EXTERNAL_STORAGE,
				Manifest.permission.READ_EXTERNAL_STORAGE
		), permissionsGranted)
	}

	override fun checkCameraGranted(permissionsGranted: PermissionsGranted) {
		singleCheck(Manifest.permission.CAMERA, permissionsGranted)
	}

	override fun singleCheck(permission: String, permissionsGranted: PermissionsGranted) {
		dexter.withPermission(permission)
				.withListener(singleCheckPermissionListener.listener(permissionsGranted))
				.check()
	}

	override fun multipleCheck(permissions: Collection<String>,
	                           permissionsGranted: MultiplePermissionsGranted) {
		dexter.withPermissions(permissions)
				.withListener(multipleCheckPermissionsListener.listener(permissionsGranted))
				.check()
	}
}