package nbt.party.o.matsosik.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import nbt.party.o.matsosik.ui.detail.DetailScreen
import nbt.party.o.matsosik.ui.list.RestaurantScreen
import nbt.party.o.matsosik.ui.main.AppViewModel
import nbt.party.o.matsosik.ui.map.MapScreen

private val bottomNavigationScreenItems = listOf(
    BottomNavigationScreen.Map,
    BottomNavigationScreen.List
)

@Composable
fun MatsosikApp(
    vm: AppViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val selectedRoute = vm.selectNavigationRoute.collectAsState()

    Scaffold(
        modifier = Modifier,
        bottomBar = {
            NavigationBar {
                bottomNavigationScreenItems.forEach { item ->
                    NavigationBarItem(
                        selected = item.route == selectedRoute.value,
                        label = {
                            Text(
                                text = stringResource(id = item.resourceId),
                                style = MaterialTheme.typography.labelMedium
                            )
                        },
                        onClick = {
                            vm.changeSelectNavigationRoute(item.route)
                            navController.navigate(item.route) {

                                // Graph Start
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) { saveState = true }
                                }
                                // Single Instance
                                launchSingleTop = true

                                // restoreState
                                restoreState = true

                            }
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
        startDestination = BottomNavigationScreen.Map.route
    ) {
        composable(route = BottomNavigationScreen.Map.route) {
            MapScreen()
        }
        composable(route = BottomNavigationScreen.List.route) {
            RestaurantScreen()
        }
        composable(route = Screen.Detail.route) {
            DetailScreen()
        }
    }
}