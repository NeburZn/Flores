package com.example.flores.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.flores.R

val Dancing = FontFamily(
    Font(R.font.dancing_regular)
)
val Caveat = FontFamily(
    Font(R.font.caveat_regular)
)
val Indie = FontFamily(
    Font(R.font.indie_regular)
)
val Pacifico = FontFamily(
    Font(R.font.pacifico_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(

    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),

    displayLarge = TextStyle(
        fontFamily = Dancing,
        fontSize = 40.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = Indie,
        fontSize = 20.sp,
        textAlign = TextAlign.Justify

    ),

    labelSmall = TextStyle(
        fontFamily = Caveat,
        color = Color.Gray,
        textDecoration = TextDecoration.Underline,
    ),

    labelMedium = TextStyle(
        fontFamily = Dancing,
        fontSize = 35.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline
    ),
    displayMedium = TextStyle(
        fontFamily = Pacifico,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold
    ),
    bodySmall = TextStyle(
        fontFamily = Caveat,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
    )
)