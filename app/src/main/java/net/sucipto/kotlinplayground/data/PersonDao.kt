package net.sucipto.kotlinplayground.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import net.sucipto.kotlinplayground.entity.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM persons ORDER BY id DESC")
    fun all() : LiveData<List<Person>>

    @Query("DELETE FROM persons")
    fun clear()

    @Delete
    fun delete(person: Person)

    @Insert
    fun add(person: Person)
}