/**
 * Class will be used as container to be stored into the apps database.
 */
package dev.randallgreene.basketballstats.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class PlayerEntry(@PrimaryKey val playerLink: String,
                       val name: String,
                       val startYear: Int,
                       val endYear: Int
)