package viewmodel.internal

import cache.Cache
import cache.CacheMock
import koncurrent.Executor
import koncurrent.SynchronousExecutor
import kotlinx.serialization.StringFormat
import kotlinx.serialization.json.Json
import krest.VoidWorkManager
import krest.WorkManager
import logging.ConsoleAppender
import logging.Logger
import viewmodel.ScopeConfig
import viewmodel.StatefulViewModelConfig

@Deprecated("use cinematic instead")
@PublishedApi
internal open class ConfigImpl<A, S>(
    override val api: A,
    override val state: S,
    override val executor: Executor,
    override val logger: Logger,
    override val cache: Cache,
    override val codec: StringFormat,
    override val workManager: WorkManager
) : ScopeConfig<A>, StatefulViewModelConfig<S> {
    companion object DEFAULT : ConfigImpl<Unit, Unit>(
        api = Unit,
        state = Unit,
        executor = SynchronousExecutor,
        logger = Logger(ConsoleAppender()),
        cache = CacheMock(),
        codec = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
        },
        workManager = VoidWorkManager
    )

    override fun <S> of(state: S) = ConfigImpl(
        api, state, executor, logger, cache, codec, workManager
    )

    override fun <R> map(transformer: (A) -> R) = ConfigImpl(
        transformer(api), state, executor, logger, cache, codec, workManager
    )
}