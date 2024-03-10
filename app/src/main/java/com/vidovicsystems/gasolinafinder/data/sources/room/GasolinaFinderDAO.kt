package com.vidovicsystems.gasolinafinder.data.sources.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GasolinaFinderDAO {
    @Query ("SELECT * FROM GasolinaFinder")
    fun getAllGasStations(): Flow<List<GasolinaFinderEntity>>


    @Insert
    fun insertGasStation(vararg gasStation: GasolinaFinderEntity)
}