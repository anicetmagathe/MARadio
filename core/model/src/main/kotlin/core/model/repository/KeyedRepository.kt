package core.model.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.collections.plus

interface KeyedRepository<K, V> {
    val current: StateFlow<Map<K, V>>

    fun set(key: K, values: V)

    fun clear()
}

open class InMemoryKeyedRepository<K, V> : KeyedRepository<K, V> {
    private val _current = MutableStateFlow<Map<K, V>>(emptyMap())
    override val current = _current.asStateFlow()

    override fun set(key: K, values: V) {
        _current.update { it + (key to values) }
    }

    override fun clear() {
        _current.value = emptyMap()
    }
}

