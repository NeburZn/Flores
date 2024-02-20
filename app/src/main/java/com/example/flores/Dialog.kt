package com.example.flores

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.flores.model.Flor
import com.example.flores.ui.theme.FloresTheme

@Composable
fun DialogText(
    flor: Flor,
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = {
                Text(
                    text = stringResource(flor.cientifico),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            confirmButton = {
                Button(onClick = { dismissDialog() }) {
                    Text(
                        text = "Aceptar",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            },
            text = {
                Text(
                    text = stringResource(flor.descripcion),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(R.dimen.ocho),
                            end = dimensionResource(R.dimen.ocho)
                        )
                )
            },
            shape = RoundedCornerShape(
                topEndPercent = 40,
                bottomStartPercent = 40,
                topStartPercent = 5,
                bottomEndPercent = 5
            )
        )
    }

}

@Composable
fun DialogImage(
    flor: Flor,
    showDialog: Boolean,
    dismissDialog: () -> Unit
) {
    var scale by remember {
        mutableStateOf(1f)
    }
    val offset by remember {
        mutableStateOf(Offset.Zero)
    }

    if (showDialog) {
        BoxWithConstraints(
            modifier = Modifier
        ) {
            Dialog(onDismissRequest = { dismissDialog() }) {
                val state = rememberTransformableState { zoomChange, _, _ ->
                    scale = (scale * zoomChange).coerceIn(1f, 3f)

                }
                Image(
                    painter = painterResource(flor.imagen),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.dieciseis)))
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            translationX = offset.x
                            translationY = offset.y
                        }
                        .transformable(state)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewText() {
    val flor = Flor(
        nombre = R.string.nombre1,
        imagen = R.drawable.lycoris_radiata,
        cientifico = R.string.cientifico1,
        descripcion = R.string.desc1
    )
    FloresTheme {
        DialogText(flor = flor, showDialog = true) {

        }
    }
}

@Preview
@Composable
fun PreviewImage() {
    val flor = Flor(
        nombre = R.string.nombre1,
        imagen = R.drawable.lycoris_radiata,
        cientifico = R.string.cientifico1,
        descripcion = R.string.desc1
    )
    FloresTheme {
        DialogImage(flor = flor, showDialog = true) {

        }
    }
}