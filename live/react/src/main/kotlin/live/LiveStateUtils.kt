package live

import koncurrent.Executor
import koncurrent.SynchronousExecutor
import useLiveWithExecutor
import useNullableLiveWithExecutor

@Deprecated("use cinematic instead")
inline fun <S> Live<S>.watchAsState(executor: Executor = SynchronousExecutor) = useLiveWithExecutor(this, executor)

@Deprecated("use cinematic instead")
inline fun <S> Live<S>?.watchAsState(executor: Executor = SynchronousExecutor) = useNullableLiveWithExecutor(executor, this)