package com.example.flores

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.flores.model.Flor


@Composable
fun Tarjeta(
    flor: Flor,
    cambio: () -> Unit,
    modifier: Modifier = Modifier,
    rotar: Float
) {
    Card(
        modifier = Modifier
            .clickable {
                cambio()
            }
            .graphicsLayer {
                rotationX = rotar
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .padding(
                    start = dimensionResource(R.dimen.seis),
                    top = dimensionResource(R.dimen.seis),
                    end = dimensionResource(R.dimen.seis)
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.seis))
            ) {
                Text(
                    text = stringResource(flor.nombre),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(dimensionResource(R.dimen.seis))

                    )
                Spacer(modifier = Modifier.padding(6.dp))
                Image(
                    painter = painterResource(flor.imagen),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(dimensionResource(R.dimen.ocho)))
                        .size(dimensionResource(R.dimen.grande))
                        .border(
                            BorderStroke(
                                dimensionResource(R.dimen.minimo),
                                MaterialTheme.colorScheme.tertiary
                            ),
                            RoundedCornerShape(dimensionResource(R.dimen.ocho))
                        )
                )
            }
            ExpandirInfo(flor = flor)
        }
    }
}


@Composable
fun InfoAdicional(
    flor: Flor,
    cambio: () -> Unit,
    modifier: Modifier = Modifier,
    rotar: Float
) {
    var openImagen by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .clickable {
                cambio()
            }
            .graphicsLayer {
                rotationX = rotar
            },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(
                    top = dimensionResource(R.dimen.seis),
                    end = dimensionResource(R.dimen.seis),
                    start = dimensionResource(R.dimen.seis)
                )
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(flor.imagen),
                contentDescription = null,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.enorme))
                    .clip(CircleShape)
                    .border(
                        BorderStroke(
                            dimensionResource(R.dimen.minimo),
                            if (isSystemInDarkTheme()) Color.White else Color.Black
                        ),
                        CircleShape
                    )
                    .clickable {
                        openImagen = true
                    }
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.tres)))
            Text(
                text = stringResource(flor.cientifico),
                style = MaterialTheme.typography.displayLarge
            )
            ExpandirInfo(flor = flor)
            DialogImage(
                flor = flor,
                showDialog = openImagen,
                dismissDialog = { openImagen = false })
        }
    }

}

@Composable
fun ExpandirInfo(flor: Flor) {
    var openDialog by remember { mutableStateOf(false) }

    TextButton(
        onClick = {
            openDialog = true
        }
    ) {
        Text(
            text = "Mas informacion",
            style = MaterialTheme.typography.labelSmall
        )
    }
    DialogText(
        showDialog = openDialog,
        dismissDialog = { openDialog = false },
        flor = flor
    )
}