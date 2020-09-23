package com.genaku.livedatarip

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.asFlow

@ExperimentalCoroutinesApi
@FlowPreview
class ViewEventFlow<T> : Flow<T> {

    private val eventSender = BroadcastChannel<T>(1)
    private val eventReceiver = eventSender.asFlow()

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<T>) = eventReceiver.collect(collector)

    fun postEvent(event: T) {
        eventSender.offer(event)
    }
}