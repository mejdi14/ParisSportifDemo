package com.bk.core.data

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val parisSportifDispatchers: ParisSportifDispatchers)

enum class ParisSportifDispatchers {
    IO
}
