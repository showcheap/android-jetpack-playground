package net.sucipto.kotlinplayground.data

import androidx.lifecycle.LiveData
import androidx.room.*
import net.sucipto.kotlinplayground.entity.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM persons ORDER BY id DESC")
    fun all(): LiveData<List<Person>>

    @Query("DELETE FROM persons")
    fun clear()

    @Delete
    fun delete(person: Person)

    @Insert
    fun add(person: Person)

    @Query("SELECT * FROM persons WHERE id = :id")
    fun find(id: Int): LiveData<Person>

    @Update
    fun update(person: Person): Int
}