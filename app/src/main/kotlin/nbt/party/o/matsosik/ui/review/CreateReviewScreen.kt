package nbt.party.o.matsosik.ui.review

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import nbt.party.o.matsosik.R
import nbt.party.o.matsosik.ui.common.RatingBar
import nbt.party.o.matsosik.ui.common.SystemThemeSurface
import nbt.party.o.matsosik.ui.common.VerticalSpacer
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview


private const val CONTRACT_CONTENT_TYPE = "image/*"

@Composable
fun CreateReviewScreen(
    vm: CreateReviewViewModel = hiltViewModel()
) {
    val title = vm.title.collectAsState()
    val content = vm.content.collectAsState()
    val rating = vm.rating.collectAsState()
    val imageList = vm.imageList.collectAsState()
    val currentImageCount = vm.currentImageSize
    val maxImageCount = vm.maxImageSize

    // 갤러리 Call ActivityResult
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { notNullUri: Uri -> vm.addImage(notNullUri) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BottomSheetTopDivider()
        VerticalSpacer(size = 16.dp)
        Text(
            text = title.value,
            style = MaterialTheme.typography.titleLarge
        )
        VerticalSpacer(size = 8.dp)
        RatingBar(
            currentRating = rating.value,
            onRatingChanged = { rating: Float ->
                vm.onRatingChanged(rating)
            },
            size = 52.dp
        )
        VerticalSpacer(size = 24.dp)

        VerticalScrollingOutlinedTextField(
            value = content.value,
            onValueChange = { value: String ->
                vm.onContentValueChanged(value)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .defaultMinSize(minHeight = 150.dp)
        )

        VerticalSpacer(size = 24.dp)

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            item {
                EmptyImage(currentImageCount, maxImageCount) {
                    // TODO : Event 로 변경 필요
                    galleryLauncher.launch(CONTRACT_CONTENT_TYPE)
                }
            }

            items(imageList.value) { uri: Uri ->
                SelectImage(uri = uri)
            }
        }

        VerticalSpacer(size = 32.dp)

        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            onClick = { /*TODO*/ }) {
            Text(
                text = "리뷰 쓰기",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun BottomSheetTopDivider(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(60.dp)
            .height(6.dp)
            .background(
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(size = 3.dp)
            )
    )
}

@Composable
fun VerticalScrollingOutlinedTextField(
    value: String,
    onValueChange: ((String) -> Unit),
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        value = value,
        onValueChange = { fieldValue: String ->
            onValueChange.invoke(fieldValue)
        }
    )
}

@Composable
fun EmptyImage(
    currentImageCount: Int,
    maxImageCount: Int,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .clickable { onClick?.invoke() }
            .padding(4.dp)
            .border(
                BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.secondary
                ), RoundedCornerShape(8.dp)
            )
            .size(100.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(52.dp),
            painter = painterResource(id = R.drawable.ic_camera_24dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary),
            contentDescription = null
        )

        val pictureFormatString =
            stringResource(id = R.string.picture_count, currentImageCount, maxImageCount)
        Text(
            text = pictureFormatString,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun SelectImage(
    uri: Uri,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .border(
                BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.secondary
                ), RoundedCornerShape(8.dp)
            )
            .size(100.dp)
    ) {
        AsyncImage(
            model = uri,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@DarkLightModePreview
@Composable
fun VerticalScrollingTextFieldPreview() {
    SystemThemeSurface {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        ) {
            BottomSheetTopDivider(
                Modifier.align(Alignment.Center)
            )
        }

    }
}

@DarkLightModePreview
@Composable
fun EmptyPicturePreview() {
    SystemThemeSurface {

        Row(modifier = Modifier.fillMaxWidth()) {
            EmptyImage(0, 5)
            EmptyImage(0, 5)
            EmptyImage(0, 5)
            EmptyImage(0, 5)
        }
    }
}
