/**
 * Class will be used as a POJO to be inserted into the apps database.
 */
package dev.randallgreene.basketballstats.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players_table")
data class PlayerEntry(@PrimaryKey val playerID: String,
                       val name: String,
                       val yearsPlayed: String
)