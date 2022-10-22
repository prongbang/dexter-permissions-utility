package com.prongbang.dexter

interface PermissionsUtility {
	fun isAccessGalleryGranted(permissionsChecker: PermissionsChecker)
	fun isReadExternalGranted(permissionsChecker: PermissionsChecker)
	fun isWriteExternalGranted(permissionsChecker: PermissionsChecker)
	fun isCameraGranted(permissionsChecker: PermissionsChecker)
	fun isNotificationGranted(permissionsChecker: PermissionsChecker)
	fun checkPhoneStateGranted(permissionsGranted: PermissionsGranted)
	fun checkReadExternalGranted(permissionsGranted: PermissionsGranted)
	fun checkWriteExternalGranted(permissionsGranted: PermissionsGranted)
	fun checkReadWriteExternalGranted(permissionsGranted: MultiplePermissionsGranted)
	fun checkCameraGranted(permissionsGranted: PermissionsGranted)
	fun checkNotificationGranted(permissionsGranted: PermissionsGranted)
	fun singleCheck(permission: String, permissionsGranted: PermissionsGranted)
	fun multipleCheck(permissions: Collection<String>, permissionsGranted: MultiplePermissionsGranted)
}