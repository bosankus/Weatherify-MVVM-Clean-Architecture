package bose.ankush.weatherify.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bose.ankush.weatherify.presentation.ui.theme.AccentColor

@Composable
fun ShowLoading(
    modifier: Modifier
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(26.dp)
                .align(Alignment.Center),
            color = AccentColor
        )
    }
}