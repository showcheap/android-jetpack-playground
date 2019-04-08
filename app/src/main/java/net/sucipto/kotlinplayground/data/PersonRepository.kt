package net.sucipto.kotlinplayground.data

import androidx.lifecycle.LiveData
import net.sucipto.kotlinplayground.entity.Person

class PersonRepository(private val dao: PersonDao) {
    val persons : LiveData<List<Person>> = dao.all()

    fun add(person: Person) {
        dao.add(person)
    }

    fun clear() {
        dao.clear()
    }

    fun delete(person: Person) {
        dao.delete(person)
    }

    fun find(id: Int) = dao.find(id)
}