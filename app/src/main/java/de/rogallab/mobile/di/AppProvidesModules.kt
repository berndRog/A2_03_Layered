package de.rogallab.mobile.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.rogallab.mobile.AppStart
import de.rogallab.mobile.data.database.IUsersDao
import de.rogallab.mobile.data.database.AppDatabase
import de.rogallab.mobile.data.repository.IUsersRepository
import de.rogallab.mobile.data.repository.UsersRepositoryImpl
import de.rogallab.mobile.utilities.logInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

// @Provides: Adds a binding for a type that cannot be constructor injected
// Factory methods provides a type, given as return type


@Module
@InstallIn(SingletonComponent::class)
object AppProvidesModules {
                          //12345678901234567890123
   private const val tag = "ok>AppProvidesModules ."

   @Singleton
   @Provides
   fun provideCoroutineDispatcher(): CoroutineDispatcher {
      logInfo(tag, "providesCoroutineDispatcher()")
      return Dispatchers.IO
   }

   @Provides
   @Singleton
   fun provideAppDatabase(
      application: Application // provided by Hilt
   ): AppDatabase {
      logInfo(tag, "providesAppDatabase()")
      return Room.databaseBuilder(
         context = application.applicationContext,
         klass = AppDatabase::class.java,
         name = AppStart.database_name
      ).fallbackToDestructiveMigration()
         .build()
   }
   @Provides
   @Singleton
   fun provideUserDao(
      database: AppDatabase
   ): IUsersDao {
      logInfo(tag, "providesIUserDao()")
      return database.createUserDao()
   }
   @Provides
   @Singleton
   fun provideUserRepository(
      userDao: IUsersDao
   ): IUsersRepository {
      logInfo(tag, "providesIUserRepository()")
      return UsersRepositoryImpl(userDao)
   }
}