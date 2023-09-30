package de.rogallab.mobile.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.rogallab.mobile.utilities.logInfo

open class BaseActivity(
   private val _tag: String
) : AppCompatActivity() {

   // Start of full lifetime
   // Activity is first created
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      if (savedInstanceState == null)
         logInfo(_tag, "onCreate() Bundle == null")
      else
         logInfo(_tag, "onCreate() Bundle != null")
   }

   // Activity is restarted
   override fun onRestart() {
      super.onRestart()
      logInfo(_tag, "onRestart()")
   }

   // Start of visible lifetime
   // Activity is visible
   override fun onStart() {
      super.onStart()
      logInfo(_tag, "onStart()")
   }

   // Start of the active lifetime
   // Activity interacts with the user
   override fun onResume() {
      super.onResume()
      logInfo(_tag, "onResume()")
   }

   // End of active lifetime
   // User is leaving activity
   override fun onPause() {
      logInfo(_tag, "onPause()")
      super.onPause()
   }

   // End of visible lifetime
   // Activity is no longer visible
   override fun onStop() {
      logInfo(_tag, "onStop()")
      super.onStop()
   }

   // End of full lifetime
   // Called before the activity is destroyed.
   override fun onDestroy() {
      logInfo(_tag, "onDestroy()")
      super.onDestroy()
   }

   // override save/restore state methods -------------------------------------
   // Save instance state: invoked when the activity may be temporarily destroyed,
   override fun onSaveInstanceState(savedStateBundle: Bundle) {
      super.onSaveInstanceState(savedStateBundle)
      logInfo(_tag, "onSaveInstanceState()")
   }

   override fun onRestoreInstanceState(savedInstanceState: Bundle) {
      super.onRestoreInstanceState(savedInstanceState)
      logInfo(_tag, "onRestoreInstanceState()")
   }

   override fun onWindowFocusChanged(hasFocus: Boolean) {
      logInfo(_tag, "onWindowFocusChanged() $hasFocus")
      super.onWindowFocusChanged(hasFocus)
   }
}