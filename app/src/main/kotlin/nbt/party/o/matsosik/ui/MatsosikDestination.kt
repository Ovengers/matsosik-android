package nbt.party.o.matsosik.ui

import androidx.annotation.StringRes
import nbt.party.o.matsosik.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int
) {
    data object Map : Screen("profile", R.string.map_name)
    data object List : Screen("friendslist", R.string.list_name)
}