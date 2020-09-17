package pl.pionas.kotlinaplication.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pl.pionas.kotlinaplication.core.adapter.BindableAdapter
import pl.pionas.kotlinaplication.core.base.UiState

/**
 * Created by Adrian Pionka on 07 wrzesień 2020
 * adrian@pionka.com
 */
object BindingAdapters {


    @BindingAdapter("showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, uiState: UiState) {
        progressBar.visibility = if (uiState == UiState.Pending) View.VISIBLE else View.GONE
    }


    @BindingAdapter("showOnIdleState")
    @JvmStatic
    fun showOnIdleState(recyclerView: RecyclerView, uiState: UiState) {
        recyclerView.visibility = if (uiState == UiState.Idle) View.VISIBLE else View.GONE
    }

    @BindingAdapter("items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["imageUrl", "placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageUrl: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .placeholder(placeholder)
            .into(imageView)

    }

}