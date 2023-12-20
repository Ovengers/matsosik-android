package nbt.party.o.matsosik.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap
import timber.log.Timber

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    vm: MapViewModel = hiltViewModel()
) {
    NaverMap(
        modifier = modifier.fillMaxSize()
    ) {
        val restaurants = vm.restaurants.collectAsState()
        Timber.i("restaurants : $restaurants")
    }
}