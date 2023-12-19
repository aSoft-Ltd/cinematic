@file:JsExport
package cinematic

import kotlinx.JsExport
import kollections.Collection

interface MutableLiveCollection<in E> {
    fun add(element: E)

    fun remove(element: E)

    fun removeAll(elements: Collection<E>)

    fun addAll(elements: Collection<E>)

    fun clear()
}