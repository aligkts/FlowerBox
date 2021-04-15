package com.aligkts.flowerbox.internal.databinding

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.aligkts.flowerbox.R
import com.aligkts.flowerbox.base.BaseListAdapter
import com.aligkts.flowerbox.base.ListAdapterItem
import com.aligkts.flowerbox.internal.extension.loadImage
import com.aligkts.flowerbox.internal.util.GridLayoutSpaceItemDecoration

@BindingAdapter("lottieFile")
fun setLottieFile(view: LottieAnimationView, resource: String) {
    view.setAnimation(resource)
}

@BindingAdapter("hideIfNull")
fun setVisible(view: View, obj: Any?) {
    view.visibility = if (obj == null) {
        View.GONE
    } else if (obj is String && obj.isBlank()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("visibleIf")
fun visibleIf(view: View, shouldVisible: Boolean) {
    view.visibility = if (shouldVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun submitList(view: RecyclerView, list: List<ListAdapterItem>?) {
    val adapter = view.adapter as BaseListAdapter<ViewDataBinding, ListAdapterItem>?
    adapter?.submitList(list)
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: BaseListAdapter<ViewDataBinding, ListAdapterItem>?) {
    adapter?.let {
        view.adapter = it
    }
}

@BindingAdapter("seperator")
fun setSeperator(view: RecyclerView, orientation: Int) {
    view.addItemDecoration(DividerItemDecoration(view.context, orientation))
}

@BindingAdapter("spaceItemDecoration")
fun addSpaceItemDecoration(view: RecyclerView, @Dimension space: Float) {
    val spaceItemDecoration = GridLayoutSpaceItemDecoration(space.toInt())
    view.addItemDecoration(spaceItemDecoration)
}

@BindingAdapter("imageFromUrl", "placeholderRes", "errorRes", requireAll = false)
fun setImage(
    view: ImageView,
    url: String?,
    @DrawableRes placeholderRes: Int?,
    @DrawableRes errorRes: Int?
) {
    val defaultDrawable = R.drawable.ic_placeholder

    view.loadImage(
        url,
        placeholderRes ?: defaultDrawable,
        errorRes ?: defaultDrawable
    )
}

@BindingAdapter("strikethrough")
fun setStrikethrough(view: TextView, show: Boolean) {
    view.paintFlags = if (show) {
        view.paintFlags or STRIKE_THRU_TEXT_FLAG
    } else {
        view.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
    }
}
