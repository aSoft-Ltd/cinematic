@file:JsExport

package cinematic

import kollections.CollectionLike
import kollections.Set
import kotlinx.JsExport

interface LiveSet<out E> : CollectionLike<E>, Live<Set<E>>