package com.example.istegelsin.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindableUtil {
    companion object{
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl:String?){
            view.setImageResource(0)
            Glide.with(view.context).clear(view)

            if(!imageUrl.isNullOrBlank()){
                Glide.with(view.context)
                    .load(imageUrl)
                    .into(view)
            }
        }

        @BindingAdapter("categoryClick")
        @JvmStatic
        fun categoryClick(view: ImageView, click :Boolean){
            if (click){
                view.visibility = View.VISIBLE
            }else{
                view.visibility = View.GONE
            }
        }
    }
}