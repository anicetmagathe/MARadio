package core.model.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.plus

interface SetRepository<T> {
    val current: StateFlow<Set<T>>

    fun add(value: T)

    fun clear()
}

open class InMemorySetRepository<T> : SetRepository<T> {
    private val _current = MutableStateFlow<Set<T>>(emptySet())
    override val current = _current.asStateFlow()
    override fun add(value: T) {
        _current.update { currentValues ->
            currentValues + value
        }
    }

    override fun clear() {
        _current.value = emptySet()
    }
}

