package nbt.party.o.matsosik.ui.common

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import nbt.party.o.matsosik.ui.theme.MatsosikTheme

@Composable
fun SystemThemeSurface(
    content: @Composable () -> Unit
) {
    MatsosikTheme {
        Surface(color = MaterialTheme.colorScheme.background, content = content)
    }
}

@Composable
fun VerticalSpacer(size: Dp) = Spacer(modifier = Modifier.height(size))

@Composable
fun HorizontalSpacer(size: Dp) = Spacer(modifier = Modifier.width(size))