package com.deepthought.gogi.androidApp.di

import com.deepthought.expenditure.ExpenditureViewModel
import com.deepthought.expenditureaddition.ExpenditureAdditionViewModel
import com.deepthought.expenditurecategoryaddition.ExpenditureCategoryAdditionViewModel
import com.deepthought.expenditurecategoryselection.ExpenditureCategorySelectionViewModel
import com.deepthought.expendituredetail.ExpenditureDetailViewModel
import com.deepthought.home.HomeViewModel
import com.deepthought.inputname.InputNameViewModel
import com.deepthought.notification.NotificationViewModel
import com.deepthought.paymentdateselection.PaymentDateSelectionViewModel
import com.deepthought.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { InputNameViewModel(get(), get()) }

    viewModel { SplashViewModel(get()) }

    viewModel { HomeViewModel(get(), get(), get(), get()) }

    viewModel { NotificationViewModel() }

    viewModel { ExpenditureViewModel() }

    viewModel { ExpenditureDetailViewModel() }

    viewModel { ExpenditureAdditionViewModel(get()) }

    viewModel { ExpenditureCategorySelectionViewModel(get()) }

    viewModel { ExpenditureCategoryAdditionViewModel(get()) }

    viewModel { PaymentDateSelectionViewModel() }
}