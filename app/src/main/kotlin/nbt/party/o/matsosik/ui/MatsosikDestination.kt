package nbt.party.o.matsosik.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import nbt.party.o.matsosik.R

sealed class BottomNavigationScreen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int
) {
    data object Map : BottomNavigationScreen("profile", R.string.map_name, R.drawable.ic_map_24dp)
    data object List :
        BottomNavigationScreen("friendsList", R.string.list_name, R.drawable.ic_restaurant_24dp)
}

sealed class Screen(
    val route: String
) {
    data object Detail : Screen("detail")
}