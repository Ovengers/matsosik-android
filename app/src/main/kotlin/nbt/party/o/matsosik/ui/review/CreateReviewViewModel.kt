package nbt.party.o.matsosik.ui.review

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateReviewViewModel @Inject constructor() : ViewModel() {

    private val _title: MutableStateFlow<String> = MutableStateFlow("")
    val title: StateFlow<String> get() = _title.asStateFlow()

    private val _content: MutableStateFlow<String> = MutableStateFlow("")
    val content: StateFlow<String> get() = _content

    private val _rating: MutableStateFlow<Float> = MutableStateFlow(0f)
    val rating: StateFlow<Float> get() = _rating

    private val _imageList: MutableStateFlow<List<Uri>> = MutableStateFlow(mutableListOf())
    val imageList: StateFlow<List<Uri>> get() = _imageList.asStateFlow()

    private val _event: MutableSharedFlow<CreateReviewEvent> = MutableSharedFlow()
    val event: SharedFlow<CreateReviewEvent> get() = _event.asSharedFlow()

    private val _currentImageCount: MutableStateFlow<Int> = MutableStateFlow(imageList.value.size)
    val currentImageCount get() = _currentImageCount.asStateFlow()

    val maxImageSize = MAX_IMAGE_SIZE

    init {
        collectImageCount()
    }

    private fun collectImageCount() {
        viewModelScope.launch {
            _imageList.collect { list: List<Uri> ->
                _currentImageCount.value = list.size
            }
        }
    }

    fun onRatingChanged(rating: Float) {
        _rating.value = rating
    }

    fun onContentValueChanged(value: String) {
        _content.value = value
    }

    fun addImage(uri: Uri) {
        _imageList.value += uri
    }

    fun removeImage(uri: Uri) {
        _imageList.value -= uri
    }

    fun onLaunchGallery() = viewModelScope.launch {
        if (_imageList.value.size >= MAX_IMAGE_SIZE) {
            _event.emit(CreateReviewEvent.ShowDialog("5개 이상 추가 할 수 없습니다."))
            return@launch
        }
        _event.emit(CreateReviewEvent.LaunchGallery)
    }

    companion object {
        private const val MAX_IMAGE_SIZE = 5
    }

    sealed interface CreateReviewEvent {
        data class ShowDialog(val message: String) : CreateReviewEvent
        data object LaunchGallery : CreateReviewEvent
    }
}