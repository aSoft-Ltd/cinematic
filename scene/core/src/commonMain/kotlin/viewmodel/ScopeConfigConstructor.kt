package viewmodel

import cache.Cache
import koncurrent.Executor
import kotlinx.serialization.StringFormat
import krest.WorkManager
import logging.Logger
import viewmodel.internal.ConfigImpl
import viewmodel.internal.ConfigImpl.DEFAULT

@Deprecated("use cinematic instead")
inline fun <A> ScopeConfig(
    api: A,
    executor: Executor = DEFAULT.executor,
    logger: Logger = DEFAULT.logger,
    codec: StringFormat = DEFAULT.codec,
    cache: Cache = DEFAULT.cache,
    workManager: WorkManager = DEFAULT.workManager
): ScopeConfig<A> = ConfigImpl(api, Unit, executor, logger, cache, codec, workManager)