package com.ptr.android

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SampleViewModel: ViewModel() {
    val code = mutableStateOf("0000")
    val number = mutableStateOf("89024462435")
}