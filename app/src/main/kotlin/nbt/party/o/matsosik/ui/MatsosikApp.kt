package nbt.party.o.matsosik.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nbt.party.o.matsosik.ui.list.RestaurantScreen
import nbt.party.o.matsosik.ui.map.MapScreen

private val items = listOf(
    Screen.Map,
    Screen.List
)

@Composable
fun MatsosikApp() {
    val navController = rememberNavController()
    val selectedRoute = remember { mutableStateOf(Screen.Map.route) }
    Scaffold(
        modifier = Modifier,
        bottomBar = {
            NavigationBar {
                items.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == selectedRoute.value,
                        label = {
                            Text(
                                text = stringResource(id = item.resourceId),
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        onClick = {
                            selectedRoute.value = item.route
                            navController.navigate(item.route)
                        },
                        icon = {
                            Image(
                                painter = painterResource(id = item.icon),
                                contentDescription = item.route,
                                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onSecondaryContainer)
                            )
                        }
                    )

                }
            }
        }
    ) { contentPadding ->
        MatsosikNavHost(
            modifier = Modifier.padding(contentPadding),
            navController = navController
        )
    }
}

@Composable
fun MatsosikNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Map.route
    ) {
        composable(route = Screen.Map.route) {
            MapScreen()
        }
        composable(route = Screen.List.route) {
            RestaurantScreen()
        }
    }
}