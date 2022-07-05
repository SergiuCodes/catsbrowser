package com.example.catsbrowser.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.catsbrowser.domain.model.Breed

@Database(entities = [Breed::class], version = 9)
abstract class BreedsDatabase : RoomDatabase() {

    abstract fun breedsDao(): BreedsDao

    companion object {
        val dbName = "breeds_db"

        private var INSTANCE: BreedsDatabase? = null

        fun getInstance(context: Context): BreedsDatabase {
            synchronized(this) {

                val MIGRATION_8_9 = object : Migration(8, 9) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        // do nothing because you are not altering any table
                    }
                }
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BreedsDatabase::class.java,
                        dbName
                    )
                        .addMigrations(MIGRATION_8_9)
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}