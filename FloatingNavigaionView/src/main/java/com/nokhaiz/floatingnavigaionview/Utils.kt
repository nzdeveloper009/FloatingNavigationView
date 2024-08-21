package com.nokhaiz.floatingnavigaionview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

/**
 * Utils class.
 *
 * @author  Syed Nokhaiz Al Hassan
 * @version 1.0.0
 * @since   2024-08-21
 */

private var dp = 0f

private fun getDp(context: Context): Float {
    return if (dp == 0f) {
        context.resources.displayMetrics.density.also { dp = it }
    } else dp
}

internal fun Float.dp(context: Context) = this * getDp(context)
internal fun Int.dp(context: Context) = this * getDp(context).toInt()

internal object DrawableHelper {

    fun changeColorDrawableVector(
        context: Context?,
        resDrawable: Int,
        @ColorInt color: Int
    ): Drawable? {
        return context?.let {
            VectorDrawableCompat.create(it.resources, resDrawable, null)?.apply {
                mutate()
                if (color != -2) {
                    colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
                }
            }
        }
    }

    fun changeColorDrawableRes(
        context: Context?,
        resDrawable: Int,
        @ColorInt color: Int
    ): Drawable? {
        return context?.let {
            ContextCompat.getDrawable(it, resDrawable)?.apply {
                mutate()
                if (color != -2) {
                    colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
                }
            }
        }
    }
}

internal object ColorHelper {

    fun mixTwoColors(@ColorInt color1: Int, @ColorInt color2: Int, amount: Float): Int {
        val inverseAmount = 1.0f - amount

        val a = (color1 ushr 24 and 0xff) * amount + (color2 ushr 24 and 0xff) * inverseAmount
        val r = (color1 ushr 16 and 0xff) * amount + (color2 ushr 16 and 0xff) * inverseAmount
        val g = (color1 ushr 8 and 0xff) * amount + (color2 ushr 8 and 0xff) * inverseAmount
        val b = (color1 and 0xff) * amount + (color2 and 0xff) * inverseAmount

        return (a.toInt() shl 24) or (r.toInt() shl 16) or (g.toInt() shl 8) or b.toInt()
    }
}

internal fun Context.getDrawableCompat(res: Int): Drawable? = ContextCompat.getDrawable(this, res)

internal inline fun <T : View?> T.runAfterDelay(delay: Long, crossinline action: T.() -> Unit) {
    this?.postDelayed({
        runCatching {
            action()
        }
    }, delay)
}

internal fun ofColorStateList(@ColorInt color: Int): ColorStateList = ColorStateList.valueOf(color)

fun <T> View?.updateLayoutParams(onLayoutChange: (T) -> Unit) {
    this?.layoutParams?.let {
        try {
            @Suppress("UNCHECKED_CAST")
            onLayoutChange(it as T)
            layoutParams = it
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}