package com.estudos.consultarcep.domain.di

import com.estudos.consultarcep.domain.usecase.CepUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory {
                CepUseCase(repositoryImpl = get())
            }
        }
    }
}