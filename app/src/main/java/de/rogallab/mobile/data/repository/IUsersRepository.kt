package de.rogallab.mobile.data.repository

import de.rogallab.mobile.data.model.User
import kotlinx.coroutines.flow.Flow
import java.util.*

interface IUsersRepository {

   fun readAll(): Flow<MutableList<User>>
   suspend fun findById(id: UUID): User?

   suspend fun add(user: User)
   suspend fun update(user: User)
   suspend fun remove(user: User)
}