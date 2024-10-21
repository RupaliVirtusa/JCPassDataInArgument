package com.assignment.composeexample.view.testing

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Profile(var firstName: String, var lastName: String) : Parcelable