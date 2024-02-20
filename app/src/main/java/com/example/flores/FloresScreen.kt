package com.example.flores

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.flores.model.Flor
import com.example.flores.ui.theme.FloresTheme

@Composable
fun ListaFlores(
    flores: List<Flor>,
    contentPadding: PaddingValues = PaddingValues(dimensionResource(R.dimen.ocho)),
) {
    LazyColumn(
        contentPadding = contentPadding,
    ) {
        items(flores) { flor ->
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.ocho)))
            Item(flor = flor)
        }
    }
}

@Composable
fun Item(
    flor: Flor,
) {
    var expanded by remember { mutableStateOf(false) }
    val rotate by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        animationSpec = tween(500), label = ""
    )
    if (expanded) {
        InfoAdicional(
            flor = flor,
            cambio = {
                expanded = !expanded;
            },
            modifier = Modifier
                .graphicsLayer {
                    rotationX = rotate
                    cameraDistance = 8 * density
                },
            rotate
        )
    } else {
        Tarjeta(
            flor = flor,
            cambio = {
                expanded = !expanded;
            },
            modifier = Modifier
                .graphicsLayer {
                    rotationX = rotate
                    cameraDistance = 8 * density
                },
            rotate
        )
    }

}

@Preview(showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewTarjeta() {
    val flor = Flor(
        nombre = R.string.nombre1,
        imagen = R.drawable.lycoris_radiata,
        cientifico = R.string.cientifico1,
        descripcion = R.string.desc1
    )
    FloresTheme {
        Tarjeta(flor, cambio = {}, rotar = 0f)
    }
}

@Preview(showBackground = true)
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewInfo() {
    val flor = Flor(
        nombre = R.string.nombre1,
        imagen = R.drawable.lycoris_radiata,
        cientifico = R.string.cientifico1,
        descripcion = R.string.desc1
    )
    FloresTheme {
        InfoAdicional(flor = flor, cambio = {}, rotar = 0f)
    }

}
