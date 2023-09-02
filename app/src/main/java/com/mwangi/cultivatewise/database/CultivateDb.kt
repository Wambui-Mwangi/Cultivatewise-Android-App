package com.mwangi.cultivatewise.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class CultivateDb:RoomDatabase() {
    abstract fun cultivateDao():CultivateDao

    companion object{
        var database:CultivateDb?=null

        fun getDb(context: Context):CultivateDb{
            if (database==null){
                database = Room.databaseBuilder(context, CultivateDb::class.java, "CultivateDb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as CultivateDb
        }
    }
}