package kg.delletenebre.yamus.utils

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kg.delletenebre.yamus.api.YandexApi

object BindingAdapters {
    @JvmStatic @BindingAdapter("glideImgSrc")
    fun ImageView.glideImgSrc(imageUrl: String) {
        Glide.with(this.context)
                .load(YandexApi.getImage(imageUrl, 200))
                .into(this)
    }

    @JvmStatic @BindingAdapter("glideCircle")
    fun ImageView.glideCircle(imageUrl: String) {
        Glide.with(this.context)
                .load(YandexApi.getImage(imageUrl, 200))
                .apply(RequestOptions.circleCropTransform())
                .into(this)
    }

    @JvmStatic @BindingAdapter("glideImgSrc", "glideImgSize")
    fun ImageView.glideImgSrc(imageUrl: String, size: Int) {
        Glide.with(this.context)
                .load(YandexApi.getImage(imageUrl, size))
                .into(this)
    }

    @JvmStatic @BindingAdapter("backgroundColor")
    fun ImageView.backgroundColor(color: String) {
        this.setBackgroundColor(Color.parseColor(color))
    }
}