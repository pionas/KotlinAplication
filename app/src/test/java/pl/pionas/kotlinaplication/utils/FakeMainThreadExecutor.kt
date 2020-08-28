package pl.pionas.kotlinaplication.utils

import androidx.arch.core.executor.TaskExecutor

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
object FakeMainThreadExecutor : TaskExecutor() {

    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

    override fun isMainThread() = true

    override fun postToMainThread(runnable: Runnable) = runnable.run()

}