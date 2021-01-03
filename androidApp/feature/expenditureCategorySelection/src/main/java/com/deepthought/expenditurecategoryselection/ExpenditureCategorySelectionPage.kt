package com.deepthought.expenditurecategoryselection

import androidx.compose.animation.transition
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.deepthought.core.common.CommonTopBar
import com.deepthought.core.ext.state
import com.deepthought.expenditurecategoryselection.animation.*
import com.deepthought.expenditurecategoryselection.component.ExpenditureCategoryAddItem
import com.deepthought.expenditurecategoryselection.component.ExpenditureCategorySelectionItem
import com.deepthought.expenditurecategoryselection.component.ExpenditureCategorySelectionList

@Composable
fun ExpenditureCategorySelectionPage(
    viewModel: ExpenditureCategorySelectionViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            ExpenditureCategorySelectionTopBar(
                viewModel = viewModel,
                navController = navController
            )
        }
    ) {
        ExpenditureCategorySelectionList(
            viewModel = viewModel,
            navController = navController
        )
    }
}

@Composable
private fun ExpenditureCategorySelectionTopBar(
    viewModel: ExpenditureCategorySelectionViewModel,
    navController: NavController
) {
    val state = viewModel.state()
    CommonTopBar(
        title = if (state.isEdit) "분류 편집" else "분류 선택",
        navigationIcon = R.drawable.ic_left_arrow,
        onClickNavigation = { navController.popBackStack() },
        action = if (state.isEdit) "완료" else "편집",
        onClickAction = {
            if (state.isEdit) {
                viewModel.intent(ExpenditureCategorySelectionEvent.OnClickEditComplete)
            } else {
                viewModel.intent(ExpenditureCategorySelectionEvent.OnClickEdit)
            }
        }
    )
}
