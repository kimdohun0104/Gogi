package com.deepthought.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepthought.bridge.model.Expenditure
import com.deepthought.home.component.ExpenditureSection
import com.deepthought.home.component.HomeHeader

@Composable
fun HomePage(
    viewModel: HomeViewModel,
    navController: NavController
) {
    ScrollableColumn {
        HomeHeader(viewModel, navController)
        ExpenditureSection(
            title = "오늘 납부 예정",
            totalPrice = 100000,
            expenditures = listOf(
                Expenditure(10, "1번타자", 1000),
                Expenditure(10, "1번타자", 1000),
                Expenditure(20, "1번타자", 1000),
                Expenditure(30, "1번타자", 1000)
            )
        )

        Box(modifier = Modifier.padding(top = 24.dp))

        ExpenditureSection(
            title = "예정된 지출",
            totalPrice = 100000,
            expenditures = listOf(
                Expenditure(10, "1번타자", 1000),
                Expenditure(10, "1번타자", 1000),
                Expenditure(20, "1번타자", 1000),
                Expenditure(30, "1번타자", 1000)
            )
        )

        Box(modifier = Modifier.padding(top = 24.dp))

        ExpenditureSection(
            title = "납부한 지출",
            totalPrice = 100000,
            expenditures = listOf()
        )
    }
}

