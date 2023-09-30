package de.rogallab.mobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import de.rogallab.mobile.utilities.logInfo
import javax.inject.Inject

@HiltAndroidApp
class AppStart : Application() {
   override fun onCreate() {
      super.onCreate()
      logInfo(tag,"DI -> CompositionRoot")

   }
   companion object {
      //                       12345678901234567890123
      private const val tag = "ok>AppStart           ."
      const val database_name:    String = "A2_03_Layered.db"
      const val database_version: Int    = 1
   }
}