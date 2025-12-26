@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kotlinx.JsExport

interface MutableLiveSet<E> : MutableLiveCollection<E>, MutableLive<Set<E>>, LiveSet<E> {
    fun <R> update(block: (MutableSet<E>) -> R): R
}