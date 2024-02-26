package nbt.party.o.matsosik.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import nbt.party.o.matsosik.R


enum class StarState(
    @DrawableRes
    val icon: Int
) {
    FILL(R.drawable.ic_star_fill_24dp),
    HALF(R.drawable.ic_start_half_24dp),
    EMPTY(R.drawable.ic_star_24dp)
}

@Composable
fun RateStarImage(
    starState: StarState,
    color: Color,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = starState.icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color = color)
    )
}
