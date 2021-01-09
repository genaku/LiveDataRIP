package com.genaku.livedatarip

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

inline fun <T> LifecycleOwner.observeState(
    flow: ViewStateFlow<T>,
    crossinline action: (value: T) -> Unit
) {
    lifecycleScope.launchWhenResumed {
        flow.collect {
            action(it)
        }
    }
}

inline fun <T> LifecycleOwner.observeEvent(
    flow: ViewEventFlow<T>,
    crossinline action: (value: T) -> Unit
) {
    lifecycleScope.launchWhenResumed {
        flow.collect {
            it.getEventIfNotHandled()?.run {
                action(this)
            }
        }
    }
}