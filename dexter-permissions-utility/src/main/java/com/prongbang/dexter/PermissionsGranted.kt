package com.prongbang.dexter

abstract class PermissionsGranted {
	abstract fun onGranted()
	open fun onDenied() {}
	open fun onNotShowAgain() {}
}

abstract class MultiplePermissionsGranted {
	abstract fun onGranted()
	open fun onDenied() {}
}