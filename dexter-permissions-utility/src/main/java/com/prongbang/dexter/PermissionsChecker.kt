package com.prongbang.dexter

interface PermissionsChecker {
	fun onGranted()
	fun onNotGranted()
}
