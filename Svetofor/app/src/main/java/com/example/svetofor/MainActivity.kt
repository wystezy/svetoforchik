import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.trafficlight.databinding.ActivityMainBinding
import androidx.activity.viewModels
import com.example.svetofor.TrafficLightViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: TrafficLightViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateLights(viewModel.getCurrentState())

        binding.nextButton.setOnClickListener {
            val nextState = viewModel.nextState()
            updateLights(nextState)
        }
    }

    private fun updateLights(state: String) {
        binding.redLight.setBackgroundResource(if (state == "RED") R.drawable.circle_red else R.drawable.circle_grey)
        binding.yellowLight.setBackgroundResource(
            if (state == "YELLOW1" || state == "YELLOW2") R.drawable.circle_yellow else R.drawable.circle_grey
        )
        binding.greenLight.setBackgroundResource(if (state == "GREEN") R.drawable.circle_green else R.drawable.circle_grey)
    }
}
