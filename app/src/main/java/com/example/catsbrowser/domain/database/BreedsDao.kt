package com.example.catsbrowser.domain.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.catsbrowser.domain.model.Breed

@Dao
interface BreedsDao {

    @Insert
    fun insert(breed: Breed)

    @Query("DELETE FROM breeds")
    fun clearAllBreeds()

    @Delete
    fun deleteBreed(breed: Breed)

}