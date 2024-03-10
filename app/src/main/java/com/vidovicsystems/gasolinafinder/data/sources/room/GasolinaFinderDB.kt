package com.vidovicsystems.gasolinafinder.data.sources.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GasolinaFinderEntity::class], version = 1)
abstract class GasolinaFinderDB: RoomDatabase(){
    abstract fun GasolinaFinderDAO(): GasolinaFinderDAO
}