package com.genaku.livedataripsample

import androidx.lifecycle.ViewModel
import com.genaku.livedatarip.ViewEventFlow
import com.genaku.livedatarip.ViewStateFlow
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    val counterStateFlow = ViewStateFlow<Int?>(null)
    val eventFlow = ViewEventFlow<String>()

    fun mess() {
        eventFlow.postEvent(counterStateFlow.value.toString())
    }

    fun incrementCount() {
        counterStateFlow.postValue((counterStateFlow.value ?: 0) + 1)
    }

    fun decrementCount() {
        counterStateFlow.postValue((counterStateFlow.value ?: 0) - 1)
    }
}