package de.rogallab.mobile.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.rogallab.mobile.AppStart
import de.rogallab.mobile.data.model.User

@Database(
   entities = [
      User::class,
   ],
   version = AppStart.database_version,
   exportSchema = false
)
//@TypeConverters(ZonedDateTimeConverters::class)

abstract class AppDatabase : RoomDatabase() {
   abstract fun createUserDao(): IUsersDao
}