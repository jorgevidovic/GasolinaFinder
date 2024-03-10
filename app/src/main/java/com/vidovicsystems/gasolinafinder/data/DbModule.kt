package com.vidovicsystems.gasolinafinder.data

import android.content.Context
import androidx.room.Room
import com.vidovicsystems.gasolinafinder.data.sources.room.GasolinaFinderDB
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
object DbModule {

    @Provides
    fun providesGasolinaFinderRoomDb(@ApplicationContext context: Context): GasolinaFinderDB =
        Room.databaseBuilder(
            context,
            GasolinaFinderDB::class.java, "GasolinaFinder_room"
        ).build()
}
