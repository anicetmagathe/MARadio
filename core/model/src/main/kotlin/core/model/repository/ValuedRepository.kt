package core.model.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface ValuedRepository<T> {
    val current: StateFlow<T?>

    fun clear()

    fun set(value: T)
}

open class InMemoryValuedRepository<T>(initialValue: T? = null) : ValuedRepository<T> {
    private val _current = MutableStateFlow(initialValue)
    override val current = _current.asStateFlow()

    override fun clear() {
        _current.value = null
    }

    override fun set(value: T) {
        _current.value = value
    }
}

