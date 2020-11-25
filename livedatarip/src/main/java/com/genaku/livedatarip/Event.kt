package com.genaku.livedatarip

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Used as a wrapper for data that is exposed via LifecycleOwner that represents an event.
 */
open class Event<out T>(val content: T?) {

    private val hasBeenHandled = AtomicBoolean(false)

    /**
     * Returns the content and prevents its use again.
     */
    fun getEventIfNotHandled(): T? = if (hasBeenHandled.get()) {
        null
    } else {
        hasBeenHandled.set(true)
        content
    }
}