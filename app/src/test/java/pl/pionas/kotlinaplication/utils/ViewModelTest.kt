package pl.pionas.kotlinaplication.utils

import androidx.arch.core.executor.ArchTaskExecutor
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

/**
 * Created by Adrian Pionka on 24 sierpień 2020
 * adrian@pionka.com
 */
open class ViewModelTest {
    @BeforeEach
    fun setUp() {
        ArchTaskExecutor.getInstance().setDelegate(FakeMainThreadExecutor)
    }

    @AfterEach
    fun tearDown() {
        ArchTaskExecutor.getInstance().setDelegate(null)
    }
}