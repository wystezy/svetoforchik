import androidx.lifecycle.ViewModel

class TrafficLightViewModel : ViewModel() {
    private val states = listOf("RED", "YELLOW1", "GREEN", "YELLOW2")
    private var currentIndex = 0

    fun getCurrentState(): String = states[currentIndex]

    fun nextState(): String {
        currentIndex = (currentIndex + 1) % states.size
        return getCurrentState()
    }
}
