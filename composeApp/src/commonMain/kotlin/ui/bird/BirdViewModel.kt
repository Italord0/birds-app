package ui.bird

import model.Bird
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BirdViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<BirdUiState> = MutableStateFlow(BirdUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    override fun onCleared() {
        httpClient.close()
    }

    fun fetchBirds() {
        viewModelScope.launch {
            val birdsFromApi = getBirds()
            _uiState.update { uiState ->
                uiState.copy(birds = birdsFromApi)
            }
        }
    }

    private val httpClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    private suspend fun getBirds(): List<Bird> {
        return httpClient.get("https://sebi.io/demo-image-api/pictures.json")
            .body<List<Bird>>()
    }
}