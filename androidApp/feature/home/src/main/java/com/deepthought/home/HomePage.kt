package com.deepthought.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonConstants
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepthought.core.ext.state
import com.deepthought.core.theme.paragraph
import com.deepthought.core.theme.white
import com.deepthought.home.component.ExpenditureSection
import com.deepthought.home.component.HomeHeader

@Composable
fun HomePage(
    viewModel: HomeViewModel,
    navController: NavController
) {
    val state = viewModel.state()
    if (state.hasExpenditure) {
        ScrollableColumn {
            HomeHeader(viewModel, navController)
            HomeExpenditures(viewModel = viewModel)
        }
    } else {
        NoExpenditure(navController = navController)
    }
}

@Composable
private fun HomeExpenditures(
    viewModel: HomeViewModel
) {
    HomeTodayExpenditures(viewModel = viewModel)
    Box(modifier = Modifier.padding(top = 24.dp))
    HomeScheduledExpenditures(viewModel = viewModel)
    Box(modifier = Modifier.padding(top = 24.dp))
    HomePaidExpenditures(viewModel = viewModel)
}

@Composable
private fun HomeTodayExpenditures(
    viewModel: HomeViewModel
) {
    val state = viewModel.state()
    ExpenditureSection(
        title = "오늘 납부 예정",
        totalPrice = 100000,
        expenditures = state.todayExpenditures
    )
}

@Composable
private fun HomeScheduledExpenditures(
    viewModel: HomeViewModel
) {
    val state = viewModel.state()
    ExpenditureSection(
        title = "예정된 지출",
        totalPrice = 100000,
        expenditures = state.scheduledExpenditures
    )
}

@Composable
private fun HomePaidExpenditures(
    viewModel: HomeViewModel
) {
    val state = viewModel.state()
    ExpenditureSection(
        title = "납부한 지출",
        totalPrice = 100000,
        expenditures = state.paidExpenditures
    )
}

@Composable
private fun NoExpenditure(
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(vectorResource(id = R.drawable.ic_piggy_bank))
        Box(modifier = Modifier.height(32.dp))
        Text(
            "아직 등록된 고정 지출이 없습니다",
            style = MaterialTheme.typography.paragraph
        )
        Box(modifier = Modifier.height(32.dp))
        Button(
            onClick = { navController.navigate("expenditureAddition") },
            colors = ButtonConstants.defaultButtonColors(backgroundColor = MaterialTheme.colors.secondary)
        ) {
            Text(
                "고정 지출 등록하러 가기",
                style = MaterialTheme.typography.paragraph,
                color = MaterialTheme.colors.white,
                modifier = Modifier.padding(horizontal = 13.dp, vertical = 10.dp),
            )
        }
    }
}