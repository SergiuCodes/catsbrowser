package com.example.catsbrowser.domain.database

import androidx.room.*
import com.example.catsbrowser.domain.model.Breed

@Dao
interface BreedsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(breed: Breed)

    @Query("DELETE FROM breeds")
    fun clearAllBreeds()

    @Delete
    fun deleteBreed(breed: Breed)

    @Query("SELECT * FROM breeds WHERE favorite = 1")
    fun selectFavoriteBreeds() : List<Breed>

    @Query("SELECT * FROM breeds")
    fun selectAllBreeds() : List<Breed>

}