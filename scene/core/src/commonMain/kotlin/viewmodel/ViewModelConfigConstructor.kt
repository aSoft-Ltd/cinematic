@file:Suppress("NON_EXPORTABLE_TYPE", "WRONG_EXPORTED_DECLARATION")

package viewmodel

import cache.Cache
import koncurrent.Executor
import kotlinx.serialization.StringFormat
import krest.WorkManager
import logging.Logger
import viewmodel.internal.ConfigImpl
import viewmodel.internal.ConfigImpl.DEFAULT

val VIEW_MODEL_CONFIG_DEFAULT: ViewModelConfig = DEFAULT

inline fun ViewModelConfig(
    executor: Executor = DEFAULT.executor,
    logger: Logger = DEFAULT.logger,
    cache: Cache = DEFAULT.cache,
    codec: StringFormat = DEFAULT.codec,
    workManager: WorkManager = DEFAULT.workManager
): ViewModelConfig = ConfigImpl(Unit, Unit, executor, logger, cache, codec, workManager)