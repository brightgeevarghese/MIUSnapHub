package edu.miu.listdemo.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/***
 * [Quote] is the data class to hold the quote text and imageResourceId
 */
data class Quote(
    @StringRes val stringResourceID: Int,
    @DrawableRes val imageResourceId: Int
)
