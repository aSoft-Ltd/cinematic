@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package live

import kollections.MapEntry
import kollections.iListOf
import kollections.iMapOf
import kollections.iSetOf
import kollections.toISet
import live.internal.MutableLiveListWrapper
import live.internal.MutableLiveMapWrapper
import live.internal.MutableLiveSetWrapper
import kotlin.js.JsExport
import kotlin.js.JsName

// ----------------------------------- MutableLiveList constructors ----------------------------------
@Deprecated("use cinematic instead")
@JsName("emptyMutableLiveListOF")
fun <E> mutableLiveListOf(): MutableLiveList<E> = MutableLiveListWrapper(mutableLiveOf(iListOf()))

@Deprecated("use cinematic instead")
fun <E> mutableLiveListOf(vararg elements: E): MutableLiveList<E> = MutableLiveListWrapper(mutableLiveOf(iListOf(*elements)))


// ----------------------------------- MutableLiveSet constructors ----------------------------------
@Deprecated("use cinematic instead")
@JsName("emptyMutableLiveSetOf")
fun <E> mutableLiveSetOf(): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(iSetOf()))

@Deprecated("use cinematic instead")
@JsName("_ignore_mutableLiveSetOf")
fun <E> mutableLiveSetOf(col: Collection<E>): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(col.toISet()))

@Deprecated("use cinematic instead")
fun <E> mutableLiveSetOf(vararg elements: E): MutableLiveSet<E> = MutableLiveSetWrapper(mutableLiveOf(iSetOf(*elements)))


// ----------------------------------- MutableLiveMap constructors ----------------------------------
@Deprecated("use cinematic instead")
@JsName("emptyMutableLiveMapOf")
fun <K, V> mutableLiveMapOf(): MutableLiveMap<K, V> = MutableLiveMapWrapper(mutableLiveOf(iMapOf()))

@Deprecated("use cinematic instead")
fun <K, V> mutableLiveMapOf(pairs: MapEntry<K, V>): MutableLiveMap<K, V> = MutableLiveMapWrapper(mutableLiveOf(iMapOf(pairs)))
