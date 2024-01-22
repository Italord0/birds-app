package ui.birdDetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.Bird

data class BirdDetailsScreen(
    val bird: Bird = Bird()
) : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.padding(start = 8.dp).clickable { navigator.pop() },
                text = "Back",
                style = TextStyle(fontSize = 24.sp, color = Color.Blue)
            )
            Column(
                modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                KamelImage(
                    resource = asyncPainterResource("https://sebastianaigner.github.io/demo-image-api/${bird.path}"),
                    contentDescription = "${bird.category} by ${bird.author}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                )

                Text(
                    text = "Author: ${bird.author}",
                    style = TextStyle(fontSize = 18.sp)
                )
                Text(
                    text = "Category: ${bird.category}",
                    style = TextStyle(fontSize = 18.sp)
                )
            }
        }


    }
}