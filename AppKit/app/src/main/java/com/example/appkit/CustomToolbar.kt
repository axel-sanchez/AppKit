package com.example.appkit

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @author Axel Sanchez
 */
@Composable
fun CustomToolbar(
    title: String,
    showBackButton: Boolean = false,
    onBackButtonClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title, color = Color.White) },
        backgroundColor = Color.Black,
        navigationIcon = if (showBackButton) {
            {
                IconButton(onClick = onBackButtonClick) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back", tint = Color.White)
                }
            }
        } else {
            null
        }
    )
}