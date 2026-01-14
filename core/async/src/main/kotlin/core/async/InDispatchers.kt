package core.async

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatchers: InDispatchers)

enum class InDispatchers {
    Default,
    IO,
    Main
}