package com.genaku.livedatarip

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewEventFlow<T> : StateFlow<Event<T>> {

    private val innerState = MutableStateFlow(Event<T>(null))

    override val value: Event<T>
        get() = innerState.value

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<Event<T>>) =
        innerState.collect(collector)

    override val replayCache: List<Event<T>>
        get() = innerState.replayCache

    fun postEvent(event: T) {
        innerState.value = Event(event)
    }
}