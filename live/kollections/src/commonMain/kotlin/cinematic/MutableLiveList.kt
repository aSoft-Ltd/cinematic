@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kollections.List
import kollections.MutableList
import kotlinx.JsExport

interface MutableLiveList<E> : MutableLiveCollection<E>, MutableLive<List<E>>, LiveList<E> {
    fun <R> update(block: (MutableList<E>) -> R): R
}