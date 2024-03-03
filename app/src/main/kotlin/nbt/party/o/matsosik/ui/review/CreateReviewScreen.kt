package nbt.party.o.matsosik.ui.review

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nbt.party.o.matsosik.ui.common.SystemThemeSurface
import nbt.party.o.matsosik.ui.preview.DarkLightModePreview




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


@DarkLightModePreview
@Composable
fun VerticalScrollingTextFieldPreview() {
    SystemThemeSurface {
        VerticalScrollingOutlinedTextField(
            "가나다라마바사\n도레미파솔", { _ -> },
            Modifier.height(150.dp)
        )
    }
}