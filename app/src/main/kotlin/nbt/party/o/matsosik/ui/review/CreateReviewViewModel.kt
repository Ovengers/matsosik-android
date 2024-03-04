package nbt.party.o.matsosik.ui.review

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateReviewViewModel @Inject constructor() : ViewModel() {

    private val _title: MutableStateFlow<String> = MutableStateFlow("")
    val title: StateFlow<String> get() = _title.asStateFlow()

    private val _content: MutableStateFlow<String> = MutableStateFlow("")
    val content: StateFlow<String> get() = _content

    private val _rating: MutableStateFlow<Float> = MutableStateFlow(0f)
    val rating: StateFlow<Float> get() = _rating

    private val _imageList: MutableStateFlow<MutableList<Uri>> = MutableStateFlow(mutableListOf())
    val imageList: StateFlow<MutableList<Uri>> get() = _imageList.asStateFlow()


    fun onRatingChanged(rating: Float) {
        _rating.value = rating
    }

    fun onContentValueChanged(value: String) {
        _content.value = value
    }

    fun addImage(uri: Uri) {
        _imageList.value.add(uri)
    }
}