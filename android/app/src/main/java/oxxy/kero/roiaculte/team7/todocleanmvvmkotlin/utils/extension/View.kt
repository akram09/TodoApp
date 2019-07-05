package oxxy.kero.roiaculte.team7.todocleanmvvmkotlin.utils.extension
import android.graphics.drawable.Drawable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.transition.Transition


fun View.cancelTransition() {
    transitionName = null


fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() { this.visibility = View.VISIBLE }

fun View.invisible() { this.visibility = View.GONE }

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
        LayoutInflater.from(context).inflate(layoutRes, this, false)
}
