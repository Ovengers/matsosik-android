package nbt.party.o.matsosik.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import nbt.party.o.matsosik.ui.BottomNavigationScreen
import javax.inject.Inject


@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel() {

    private val _selectNavigationRoute: MutableStateFlow<String> =
        MutableStateFlow(BottomNavigationScreen.Map.route)

    val selectNavigationRoute: StateFlow<String> = _selectNavigationRoute.asStateFlow()

    fun changeSelectNavigationRoute(route: String) {
        _selectNavigationRoute.value = route
    }

}