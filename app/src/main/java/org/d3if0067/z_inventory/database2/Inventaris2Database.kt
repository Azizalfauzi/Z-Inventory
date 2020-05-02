package org.d3if0067.z_inventory.database2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0067.z_inventory.model2.DB_NAME2


@Suppress("SpellCheckingInspection")
@Database(entities = [InventarisDatabaseModel2::class], version = 1, exportSchema = false)
abstract class Inventaris2Database : RoomDatabase() {
    abstract val inventaris2Dao: Inventaris2Dao

    companion object {
        @Volatile
        private var INSTANCE: Inventaris2Database? = null

        fun getInstance2(context: Context): Inventaris2Database {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Inventaris2Database::class.java,
                        DB_NAME2
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}