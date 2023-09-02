package com.mwangi.cultivatewise.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    var id: Int,
    var userName: String,
    @PrimaryKey(autoGenerate = true) var email: String,
    var password: String
)
