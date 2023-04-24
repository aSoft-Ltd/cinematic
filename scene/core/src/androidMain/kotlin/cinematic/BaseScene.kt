package cinematic

import androidx.lifecycle.ViewModel

actual abstract class BaseScene : ViewModel() {
    protected actual open override fun onCleared() {}
}