package nbt.party.o.matsosik.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import nbt.party.o.matsosik.R
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview
import nbt.party.o.matsosik.ui.theme.rate_star_color


enum class StarState(
    @DrawableRes
    val icon: Int
) {
    FILL(R.drawable.ic_star_fill_24dp),
    EMPTY(R.drawable.ic_star_24dp)
}

@Composable
fun RatingBar(
    currentRating: Float,
    onRatingChanged: (Float) -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    maxRating: Int = 5,
) {
    Row(
        modifier = modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until maxRating) {
            val isSelected = i < currentRating

            val state = if (isSelected) StarState.FILL else StarState.EMPTY
            val starModifier = Modifier
                .selectable(
                    selected = isSelected,
                    onClick = {
                        onRatingChanged(i.toFloat())
                    }
                )
                .width(size)
                .height(size)
            RateStarImage(
                starState = state,
                color = rate_star_color,
                modifier = starModifier
            )
        }
    }
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

@DarkLightModePreview
@Composable
fun RatingBarPreview() {
    SystemThemeSurface {
        RatingBar(currentRating = 1f, onRatingChanged = {})
    }
}