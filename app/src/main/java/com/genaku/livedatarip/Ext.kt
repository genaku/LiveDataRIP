package com.genaku.livedatarip

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

inline fun <T> LifecycleOwner.observe(flow: Flow<T>, crossinline action: (value: T) -> Unit) {
    lifecycleScope.launchWhenResumed {
        flow.collect {
            action(it)
        }
    }
}