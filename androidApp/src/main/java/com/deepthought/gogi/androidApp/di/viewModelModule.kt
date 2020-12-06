package com.deepthought.gogi.androidApp.di

import com.deepthought.gogi.androidApp.ui.inputName.InputNameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { InputNameViewModel(get()) }
}