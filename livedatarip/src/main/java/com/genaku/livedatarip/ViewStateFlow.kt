package com.genaku.livedatarip

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * View state flow
 *
 * @param T - type of view state value
 * @param [T] - initial value of view state
 */
class ViewStateFlow<T>(initial: T) : StateFlow<T> {

    private val innerState = MutableStateFlow(initial)

    override val value: T
        get() = innerState.value

    @InternalCoroutinesApi
    override suspend fun collect(collector: FlowCollector<T>) =
        innerState.collect(collector)

    override val replayCache: List<T>
        get() = innerState.replayCache

    fun postValue(value: T) {
        innerState.value = value
    }
}