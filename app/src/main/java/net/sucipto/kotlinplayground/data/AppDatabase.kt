package net.sucipto.kotlinplayground.data

import androidx.room.Database
import androidx.room.RoomDatabase
import net.sucipto.kotlinplayground.entity.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao() : PersonDao
}