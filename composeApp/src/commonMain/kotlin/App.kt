import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory

@Composable
fun App() {
    MaterialTheme {
        val viewModel: BirdViewModel = getViewModel(Unit, viewModelFactory { BirdViewModel() })
        val state: BirdUiState by viewModel.uiState.collectAsState()

        LaunchedEffect(viewModel) {
            viewModel.fetchBirds()
        }

        Text(state.birds.toString(), Modifier.verticalScroll(rememberScrollState()))
    }
}