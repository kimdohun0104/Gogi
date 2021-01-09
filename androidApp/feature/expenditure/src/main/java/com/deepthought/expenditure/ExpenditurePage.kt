package com.deepthought.expenditure

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.theme.colorGray500
import com.deepthought.bridge.model.Expenditure
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.bridge.model.PaymentDate
import com.deepthought.expenditure.components.ExpenditureCategoryChipRow
import com.deepthought.expenditure.components.ExpenditureList
import com.deepthought.expenditure.item.ExpenditureCategoryItem

@Composable
fun ExpenditurePage(
    viewModel: ExpenditureViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CommonTopBar(
                title = "지출",
                navigationIcon = R.drawable.ic_left_arrow,
                onClickNavigation = { navController.popBackStack() },
                action = "추가",
                onClickAction = {
                    navController.navigate("expenditureAddition")
                }
            )
        }
    ) {
        Column {
            ExpenditureCategoryChipRow(
                expenditureCategoryItems = listOf(
                    ExpenditureCategoryItem(ExpenditureCategory(0, "문화/컨텐츠"), true),
                    ExpenditureCategoryItem(ExpenditureCategory(0, "문화/컨텐츠"), false),
                    ExpenditureCategoryItem(ExpenditureCategory(0, "문화/컨텐츠"), false),
                    ExpenditureCategoryItem(ExpenditureCategory(0, "문화/컨텐츠"), true),
                )
            )

            Divider(thickness = 1.dp, color = colorGray500)

            ExpenditureList(
                expenditures = listOf(
                    Expenditure(PaymentDate(date = 10, isLastDay = false), "김도훈", 1000, ExpenditureCategory(0, "문화/컨텐츠")),
                    Expenditure(PaymentDate(date = 10, isLastDay = false), "김도훈", 1000, ExpenditureCategory(0, "문화/컨텐츠")),
                    Expenditure(PaymentDate(date = 10, isLastDay = false), "김도훈", 1000, ExpenditureCategory(0, "문화/컨텐츠")),
                    Expenditure(PaymentDate(date = 10, isLastDay = false), "김도훈", 1000, ExpenditureCategory(0, "문화/컨텐츠")),
                )
            )
        }
    }
}