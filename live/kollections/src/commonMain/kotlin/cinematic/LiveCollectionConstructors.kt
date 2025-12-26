@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package cinematic

import cinematic.internal.MutableLiveListWrapper
import cinematic.internal.MutableLiveMapWrapper
import cinematic.internal.MutableLiveSetWrapper
import kotlinx.JsExport
import kotlin.js.JsName

// ----------------------------------- MutableLiveList constructors ----------------------------------
@JsName("emptyMutableLiveListOF")
fun <E> mutableLiveListOf(): MutableLiveList<E> = MutableLiveListWrapper(mutableLiveOf(listOf()))

fun <E> mutableLiveListOf(vararg elements: E): MutableLiveList<E> = MutableLiveListWrapper(mutableLiveOf(listOf(*elements)))


// ----------------------------------- MutableLiveSet constructors ----------------------------------
@JsName("emptyMutableLiveSetOf")
fun <E> mutableLiveSetOf(): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(setOf()))

@JsName("_ignore_mutableLiveSetOf")
fun <E> mutableLiveSetOf(col: Collection<E>): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(col.toSet()))

fun <E> mutableLiveSetOf(vararg elements: E): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(setOf(*elements)))


// ----------------------------------- MutableLiveMap constructors ----------------------------------
@JsName("emptyMutableLiveMapOf")
fun <K, V> mutableLiveMapOf(): MutableLiveMap<K, V> = MutableLiveMapWrapper(mutableLiveOf(mapOf()))

fun <K, V> mutableLiveMapOf(vararg pairs: Pair<K, V>): MutableLiveMap<K, V> = MutableLiveMapWrapper(mutableLiveOf(mapOf(*pairs)))