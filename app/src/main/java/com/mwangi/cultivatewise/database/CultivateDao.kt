package com.mwangi.cultivatewise.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mwangi.cultivatewise.model.User

@Dao
interface CultivateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUserbyEmail(email:String): User

}