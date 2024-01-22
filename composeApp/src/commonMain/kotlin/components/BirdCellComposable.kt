package components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.Bird

@Composable
fun BirdCellComposable(
    bird: Bird,
    onBirdClicked: (bird : Bird) -> Unit = { }
) {
    KamelImage(
        resource = asyncPainterResource("https://sebastianaigner.github.io/demo-image-api/${bird.path}"),
        contentDescription = "${bird.category} by ${bird.author}",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize(fraction = 0.8f)
            .fillMaxWidth()
            .aspectRatio(1.0f)
            .clickable { onBirdClicked(bird) },
    )
}
