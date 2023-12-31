package nbt.party.o.matsosik.ui.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import nbt.party.o.matsosik.ui.theme.MatsosikTheme

@Composable
fun SystemThemeSurface(
    content: @Composable () -> Unit
) {
    MatsosikTheme {
        Surface(color = MaterialTheme.colorScheme.background, content = content)
    }
}
