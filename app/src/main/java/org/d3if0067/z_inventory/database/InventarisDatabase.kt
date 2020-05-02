package org.d3if0067.z_inventory.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0067.z_inventory.model.DB_NAME

@Suppress("SpellCheckingInspection")
@Database(entities = [InventarisDatabaseModel::class], version = 1, exportSchema = false)
abstract class InventarisDatabase : RoomDatabase() {

    abstract val inventarisDao: InventarisDao

    companion object {
        @Volatile
        private var INSTANCE: InventarisDatabase? = null

        fun getInstance(context: Context): InventarisDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        InventarisDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}