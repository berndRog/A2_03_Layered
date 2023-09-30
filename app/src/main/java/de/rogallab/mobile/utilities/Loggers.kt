package de.rogallab.mobile.utilities

import android.util.Log
import de.rogallab.mobile.ui.MainActivity.Companion.isDebug

fun logError(tag: String, message: String) {
   val msg = formatMessage(message)
   Log.e(tag, msg)
}
fun logWarning(tag: String, message: String) {
   val msg = formatMessage(message)
   Log.w(tag, msg)
}
fun logInfo(tag: String, message: String) {
   val msg = formatMessage(message)
   Log.i(tag, msg)
}

fun logDebug(tag: String, message: String) {
   if (isDebug) {
      val msg = formatMessage(message)
      Log.d(tag, msg)
   }
}

private fun formatMessage(message: String) =
   String.format("%-70s %s", message, Thread.currentThread().toString())