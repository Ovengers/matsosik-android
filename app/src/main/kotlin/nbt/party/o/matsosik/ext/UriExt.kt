package nbt.party.o.matsosik.ext

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.OpenableColumns
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.BufferedSink
import okio.source
import java.io.InputStream


fun Uri.toMultiPart(name: String, contentResolver: ContentResolver): MultipartBody.Part? {
    contentResolver.query(this, null, null, null, null)
        ?.use { cursor: Cursor ->
            if (cursor.moveToFirst()) {
                val columnIndex = cursor.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME)
                val displayName = cursor.getString(columnIndex)
                val requestBody = object : RequestBody() {
                    override fun contentType(): MediaType? {
                        return contentResolver.getType(this@toMultiPart)?.toMediaType()
                    }

                    override fun writeTo(sink: BufferedSink) {
                        contentResolver.openInputStream(this@toMultiPart)
                            ?.use { inputStream: InputStream ->
                                sink.writeAll(inputStream.source())
                            }
                    }
                }
                MultipartBody.Part.createFormData(name, displayName, requestBody)
            }
        }
    return null
}
