package com.deepthought.gogi.androidApp.di

import com.deepthought.home.HomeViewModel
import com.deepthought.inputname.InputNameViewModel
import com.deepthought.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { InputNameViewModel(get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { HomeViewModel(get()) }
}