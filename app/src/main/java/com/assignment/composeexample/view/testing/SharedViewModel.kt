package com.assignment.composeexample.view.testing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val data: MutableLiveData<Profile> = MutableLiveData<Profile>()
}