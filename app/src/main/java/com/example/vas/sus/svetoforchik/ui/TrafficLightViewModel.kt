package com.example.vas.sus.svetoforchik.ui

import androidx.lifecycle.ViewModel

class TrafficLightViewModel : ViewModel() {
    private val states = listOf("RED", "YELLOW1", "GREEN", "YELLOW2")
    private var index = 0

    fun getCurrentState(): String = states[index]

    fun nextState(): String {
        index = (index + 1) % states.size
        return getCurrentState()
    }
}
