import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import ui.bird.BirdScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(screens = listOf(BirdScreen())) { navigator ->
            SlideTransition(navigator)
        }
    }
}