package nbt.party.o.matsosik.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import nbt.party.o.matsosik.R
import nbt.party.o.matsosik.ui.common.SystemThemeSurface
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview


@Composable
fun DetailHeader(
    thumbnailImageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(16f / 9f)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = thumbnailImageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        Image(
            modifier = Modifier
                .padding(8.dp)
                .size(32.dp)
                .clickable { },
            contentScale = ContentScale.Inside,
            painter = painterResource(R.drawable.ic_arrow_back_24dp),
            contentDescription = stringResource(id = R.string.back)
        )
    }
}

@Composable
fun DetailTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun DetailAddress(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.titleMedium
    )
}

@DarkLightModePreview
@Composable
fun DetailHeaderPreview() {
    SystemThemeSurface {
        val url =
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMTdfMjUz%2FMDAxNzAwMTkyNTYxNjUy.-FS-UOMm61Q8veLrEMIvQHVrgQzd9IxvbEQQEbNh50Ig.h5S23QDcFtY8hQWGHG2Um4sAUTRDA-oiX0Sq0tJLxM8g.JPEG.a_zum_koya%2F20231117%25A3%25DF114135.jpg&type=sc960_832"
        DetailHeader(url)
    }
}

@DarkLightModePreview
@Composable
fun DetailTitlePreview() {
    SystemThemeSurface {
        val title = "우야(장어덮밥)"
        DetailTitle(title)
    }
}

@DarkLightModePreview
@Composable
fun DetailAddressPreview() {
    SystemThemeSurface {
        val title = "서울특별시 서초구 서초대로42길 41 2층"
        DetailAddress(title)
    }
}