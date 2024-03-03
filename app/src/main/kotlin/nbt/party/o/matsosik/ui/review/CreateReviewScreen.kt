package nbt.party.o.matsosik.ui.review

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nbt.party.o.matsosik.R
import nbt.party.o.matsosik.ui.common.SystemThemeSurface
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview


@Composable
fun VerticalScrollingOutlinedTextField(
    value: String,
    onValueChange: ((String) -> Unit),
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        value = value,
        onValueChange = { fieldValue: String ->
            onValueChange.invoke(fieldValue)
        }
    )
}

@Composable
fun EmptyPicture(
    currentPictureCount: Int,
    maxPictureCount: Int,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .clickable { onClick?.invoke() }
            .padding(4.dp)
            .aspectRatio(1f)
            .border(
                BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.secondary
                ), RoundedCornerShape(8.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(52.dp),
            painter = painterResource(id = R.drawable.ic_camera_24dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
            contentDescription = null
        )

        val pictureFormatString =
            stringResource(id = R.string.picture_count, currentPictureCount, maxPictureCount)
        Text(
            text = pictureFormatString,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@DarkLightModePreview
@Composable
fun VerticalScrollingTextFieldPreview() {
    SystemThemeSurface {
        VerticalScrollingOutlinedTextField(
            "가나다라마바사\n도레미파솔", { _ -> },
            Modifier.height(150.dp)
        )
    }
}

@DarkLightModePreview
@Composable
fun EmptyPicturePreview() {
    SystemThemeSurface {

        Row(modifier = Modifier.fillMaxWidth()) {
            val modifier = Modifier.weight(1f)
            EmptyPicture(0, 5, modifier)
            EmptyPicture(0, 5, modifier)
            EmptyPicture(0, 5, modifier)
            EmptyPicture(0, 5, modifier)
        }
    }

}