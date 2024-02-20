package com.example.flores

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flores.model.FlorRepository
import com.example.flores.ui.theme.FloresTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FloresTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FloresApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraFlores() {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    painterResource(R.drawable.flor_icon),
                    contentDescription = null,
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    text = stringResource(R.string.barra),
                    style = MaterialTheme.typography.displayMedium,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
                Icon(
                    painterResource(R.drawable.flor_icon),
                    contentDescription = null,
                    tint = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    modifier = Modifier
                        .size(40.dp)
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FloresApp() {
    val flores = FlorRepository.flowers
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            BarraFlores()
        }
    ) {
        ListaFlores(flores = flores, contentPadding = it)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    FloresTheme {
        BarraFlores()
    }
}