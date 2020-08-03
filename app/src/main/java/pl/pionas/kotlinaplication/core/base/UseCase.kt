package pl.pionas.kotlinaplication.core.base

import kotlinx.coroutines.*

/**
 * Created by Adrian Pionka on 03 sierpień 2020
 * adrian@pionka.com
 */
abstract class UseCase<out Type, in Params> {
    abstract suspend fun action(params: Params): Type

    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type>) -> Unit = {}
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                kotlin.runCatching {
                    action(params)
                }
            }
            onResult(result)
        }
    }
}