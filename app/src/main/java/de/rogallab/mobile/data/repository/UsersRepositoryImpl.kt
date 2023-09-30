package de.rogallab.mobile.data.repository

import de.rogallab.mobile.data.database.IUsersDao
import de.rogallab.mobile.data.model.User
import de.rogallab.mobile.utilities.logDebug
import de.rogallab.mobile.utilities.logInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
   private val _userDao: IUsersDao
) : IUsersRepository {

   init { logInfo(tag, "init()") }

   override fun readAll(): Flow<MutableList<User>> =
      _userDao.selectAll()

   override suspend fun findById(id: UUID): User? =
      _userDao.findById(id)

   override suspend fun add(user: User) =
      _userDao.insert(user)

   override suspend fun update(user: User) =
      _userDao.update(user)

   override suspend fun remove(user: User) =
      _userDao.delete(user)

   companion object {
                                    // 12345678901234567890123
      private const val tag: String = "ok>UserRepository     ."
   }
}