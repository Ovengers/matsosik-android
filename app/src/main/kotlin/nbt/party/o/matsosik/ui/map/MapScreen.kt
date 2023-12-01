package nbt.party.o.matsosik.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.NaverMap

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier
) {
    NaverMap(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}