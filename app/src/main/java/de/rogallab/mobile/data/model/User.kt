package de.rogallab.mobile.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "users")
data class User(
   @PrimaryKey
   var id:UUID = UUID.randomUUID(),
   var name: String? = "",
   var email: String? = "",
)
