@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kollections.List
import kollections.MutableCollectionLike
import kollections.MutableList
import kotlinx.JsExport

interface MutableLiveList<E> : MutableCollectionLike<E>, MutableLive<List<E>>, LiveList<E> {
    fun <R> update(block: (MutableList<E>) -> R): R
}