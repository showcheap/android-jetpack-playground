package net.sucipto.kotlinplayground.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(@PrimaryKey(autoGenerate = true) val id: Int?, val name: String)