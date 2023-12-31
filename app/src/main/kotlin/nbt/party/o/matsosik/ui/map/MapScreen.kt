@file:Suppress("SpellCheckingInspection", "LocalVariableName", "NonAsciiCharacters")

package nbt.party.o.matsosik.ui.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.CameraPositionState
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState
import nbt.party.o.matsosik.data.RestaurantData
import nbt.party.o.matsosik.ui.main.RestaurantViewModel

private val defaultCameraPosition = LatLng(37.489972, 127.0051895)
private const val DEFAULT_ZOOM = 15.0

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    vm: RestaurantViewModel = hiltViewModel()
) {

    val cameraPositionState: CameraPositionState = rememberCameraPositionState {
        // 카메라 초기 위치를 설정합니다.
        position = CameraPosition(defaultCameraPosition, DEFAULT_ZOOM)
    }
    NaverMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        val restaurants = vm.restaurants.collectAsState()
        restaurants.value.forEach { restaurantData: RestaurantData ->
            Marker(
                state = MarkerState(
                    position = LatLng(
                        restaurantData.latitude,
                        restaurantData.longitude
                    )
                ),
                captionText = restaurantData.displayName
            )
        }
    }
}