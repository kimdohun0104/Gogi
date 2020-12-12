package com.deepthought.gogi.androidApp.di

import com.deepthought.gogi.androidApp.ui.home.HomeViewModel
import com.deepthought.gogi.androidApp.ui.inputName.InputNameViewModel
import com.deepthought.gogi.androidApp.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { InputNameViewModel(get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { HomeViewModel(get()) }
}