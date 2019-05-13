package dev.randallgreene.basketballstats.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PlayerEntry::class], version = 1 )
abstract class AppDatabase : RoomDatabase() {

    abstract fun playersDao(): PlayersDao

    // Singleton instantiation
    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "nba_database"
            ).build()
            INSTANCE = instance

            return instance
        }
    }
}