@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kotlinx.JsExport
import kotlinx.JsName

@JsName("MutableLiveArray")
interface MutableLiveList<E> : MutableLiveCollection<E>, MutableLive<List<E>>, LiveList<E> {
    fun <R> update(block: (MutableList<E>) -> R): R
}