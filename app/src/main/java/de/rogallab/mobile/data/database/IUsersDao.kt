package de.rogallab.mobile.data.database

import androidx.room.*
import de.rogallab.mobile.data.model.User
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface IUsersDao {
   // QUERIES ---------------------------------------------
   @Query("SELECT * FROM users")
   fun selectAll(): Flow<MutableList<User>>         // Observable Read

   @Query("SELECT * FROM users WHERE id = :id")      // One-Shot Read
   suspend fun findById(id: UUID): User?

   // COMMANDS --------------------------------------------
   @Insert(onConflict = OnConflictStrategy.REPLACE)  // One-Shot Write
   suspend fun insert(user: User)

   @Update
   suspend fun update(user: User)                  // One-Shot Write

   @Delete
   suspend fun delete(user: User)                 // One-Shot Write

}