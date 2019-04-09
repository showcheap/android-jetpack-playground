package net.sucipto.kotlinplayground.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class Person(@PrimaryKey(autoGenerate = true) var id: Int?, var name: String)