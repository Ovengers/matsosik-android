package nbt.party.o.matsosik.ui.common

import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import nbt.party.o.matsosik.R
import nbt.party.o.matsosik.ui.theme.MatsosikTheme
import nbt.party.o.matsosik.ui.theme.rate_start_color

@Composable
fun SystemThemeSurface(
    content: @Composable () -> Unit
) {
    MatsosikTheme {
        Surface(color = MaterialTheme.colorScheme.background, content = content)
    }
}

@Composable
fun RateStarImage(
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_star_24dp),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = rate_start_color)
    )
}
