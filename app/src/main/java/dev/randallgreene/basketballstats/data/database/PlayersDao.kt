package dev.randallgreene.basketballstats.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayersDao {

    @Query("SELECT * FROM players_table")
    fun getAllPlayers(): LiveData<List<PlayerEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerEntry: PlayerEntry)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(playerEntries: List<PlayerEntry>)

}