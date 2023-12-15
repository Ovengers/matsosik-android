package nbt.party.o.matsosik.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import nbt.party.o.matsosik.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int
) {
    data object Map : Screen("profile", R.string.map_name, R.drawable.ic_matsosik_map_24dp)
    data object List : Screen("friendslist", R.string.list_name, R.drawable.ic_maksosik_restaurant_24dp)
}