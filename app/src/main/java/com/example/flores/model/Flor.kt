package com.example.flores.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Flor(
    @StringRes val nombre: Int,
    @DrawableRes val imagen: Int,
    @StringRes val cientifico: Int,
    @StringRes val descripcion: Int,
)
