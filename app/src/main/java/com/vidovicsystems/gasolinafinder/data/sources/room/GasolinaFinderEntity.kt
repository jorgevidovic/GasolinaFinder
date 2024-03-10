package com.vidovicsystems.gasolinafinder.data.sources.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GasolinaFinder")
data class GasolinaFinderEntity(
    @PrimaryKey(autoGenerate = true) val idGasStation: Int? = null,
    val name: String
)