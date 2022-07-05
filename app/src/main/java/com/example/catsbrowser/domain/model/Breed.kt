package com.example.catsbrowser.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "breeds")
data class Breed(
    @PrimaryKey
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String? = "",
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String? = "",
    @ColumnInfo(name = "description")
    var description: String? = "",
    @ColumnInfo(name = "favorite")
    var isFavorite: Boolean = false
)