package com.deepthought.gogi.androidApp.di

import com.deepthought.expenditure.ExpenditureViewModel
import com.deepthought.expenditureaddition.ExpenditureAdditionViewModel
import com.deepthought.expendituredetail.ExpenditureDetailViewModel
import com.deepthought.home.HomeViewModel
import com.deepthought.inputname.InputNameViewModel
import com.deepthought.notification.NotificationViewModel
import com.deepthought.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { InputNameViewModel(get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { HomeViewModel(get()) }

    viewModel { NotificationViewModel() }

    viewModel { ExpenditureViewModel()}

    viewModel { ExpenditureDetailViewModel() }

    viewModel { ExpenditureAdditionViewModel() }
}