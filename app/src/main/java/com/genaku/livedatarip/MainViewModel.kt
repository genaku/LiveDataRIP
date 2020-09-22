package com.genaku.livedatarip

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel : ViewModel() {

    val stateFlow = ViewStateFlow<Int?>(null)
    val eventFlow = ViewEventFlow<Event>()

    fun mess() {
        eventFlow.postEvent(Event(stateFlow.value.toString()))
    }

    fun incrementCount() {
        stateFlow.postValue((stateFlow.value ?: 0) + 1)
    }

    fun decrementCount() {
        stateFlow.postValue((stateFlow.value ?: 0) - 1)
    }
}