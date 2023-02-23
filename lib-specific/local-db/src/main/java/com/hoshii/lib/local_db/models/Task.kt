package com.hoshii.lib.local_db.models

interface Task {
    val timeOfStart: Int?
    val timeOfFinish: Int?
    val dateTodo: Long
    val monetaryCost: Float
    val physicalEnergyCost: Energy
    val mentalEnergyCost: Energy
}

enum class Energy {
    NONE, LOW, MEDIUM, HIGH
}