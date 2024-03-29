package nbt.party.o.matsosik.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.ui.common.RateStarImage
import nbt.party.o.matsosik.ui.common.StarState
import nbt.party.o.matsosik.ui.common.SystemThemeSurface
import nbt.party.o.matsosik.ui.main.RestaurantViewModel
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview
import nbt.party.o.matsosik.ui.theme.rate_star_color

@Composable
fun RestaurantScreen(
    modifier: Modifier = Modifier,
    vm: RestaurantViewModel = hiltViewModel()
) {
    val restaurants = vm.restaurants.collectAsState()
    RestaurantLazyColumn(
        restaurants.value,
        modifier
    )
}

@Composable
fun RestaurantLazyColumn(
    restaurants: List<RestaurantData>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(restaurants) { item: RestaurantData ->
            RestaurantItem(item = item)
        }
    }

}

@Composable
fun RestaurantItem(
    item: RestaurantData,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .aspectRatio(16f / 9f)

    ) {

        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = item.thumbnail,
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 8.dp
                )
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val size = MaterialTheme.typography.labelSmall.fontSize.value.dp
            RateStarImage(
                starState = StarState.FILL,
                color = rate_star_color,
                modifier = Modifier.size(size)
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(
                modifier = Modifier,
                text = "4.5",
                style = MaterialTheme.typography.labelSmall,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    start = 8.dp,
                    bottom = 8.dp
                )
        ) {
            Text(
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(2.dp),
                text = item.displayName,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(2.dp),
                text = item.address,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }
    }
}


@DarkLightModePreview
@Composable
fun RestaurantItemPreview() {
    SystemThemeSurface {
        val data = RestaurantData(
            187,
            "샤브샤브 (롯데마트)",
            "서울 서초구 서초대로38길 12 롯데마트 내",
            "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzExMTdfMjUz%2FMDAxNzAwMTkyNTYxNjUy.-FS-UOMm61Q8veLrEMIvQHVrgQzd9IxvbEQQEbNh50Ig.h5S23QDcFtY8hQWGHG2Um4sAUTRDA-oiX0Sq0tJLxM8g.JPEG.a_zum_koya%2F20231117%25A3%25DF114135.jpg&type=sc960_832",
            37.4902536,
            127.0061464
        )
        RestaurantItem(data)
    }

}