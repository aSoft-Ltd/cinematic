@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import kollections.MutableSet
import kollections.Set
import kotlinx.JsExport

interface MutableLiveSet<E> : MutableLiveCollection<E>, MutableLive<Set<E>>, LiveSet<E> {
    fun <R> update(block: (MutableSet<E>) -> R): R
}