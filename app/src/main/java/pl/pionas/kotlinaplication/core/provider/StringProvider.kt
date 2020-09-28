package pl.pionas.kotlinaplication.core.provider

import android.content.Context
import androidx.annotation.StringRes

interface StringProvider {
    fun getString(@StringRes stringId: Int): String
}

class StringProviderImpl(private val context: Context) : StringProvider {
    override fun getString(stringId: Int) = context.getString(stringId)
}