package com.example.catsbrowser.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.catsbrowser.domain.model.Breed

@Database(entities = [Breed::class], version = 1)
abstract class BreedsDatabase : RoomDatabase() {

    val dbName = "breeds_db"

    companion object {
        private var INSTANCE: BreedsDatabase? = null

        fun getInstance(context: Context): BreedsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BreedsDatabase::class.java,
                        "breeds_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}