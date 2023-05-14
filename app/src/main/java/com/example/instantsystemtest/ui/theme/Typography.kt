package com.example.instantsystemtest.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class Typography(
    val title: TextStyle,
    val description: TextStyle,
    val normal: TextStyle,
)

val typography = Typography(
    title = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        lineHeight = 24.sp
    ),
    description = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 18.sp
    ),
    normal = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        lineHeight = 20.sp
    )
)