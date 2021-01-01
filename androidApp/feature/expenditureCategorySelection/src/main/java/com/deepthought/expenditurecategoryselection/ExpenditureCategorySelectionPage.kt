package com.deepthought.expenditurecategoryselection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.ripple.RippleOpacity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.deepghought.core.common.CommonTopBar
import com.deepghought.core.theme.divider
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.expenditurecategoryselection.animation.*

@Composable
fun ExpenditureCategorySelectionPage(
    viewModel: ExpenditureCategorySelectionViewModel,
    navController: NavController
) {
    Scaffold(
        topBar = {
            CommonTopBar(
                title = "분류 선택",
                navigationIcon = R.drawable.ic_close,
                onClickNavigation = { navController.popBackStack() },
                action = "편집",
                onClickAction = {}
            )
        }
    ) {
        Column {
            val state = transition(
                definition = expenditureCategoryDefinition,
                initState = ExpenditureCategoryState.SELECTION,
                toState = ExpenditureCategoryState.ADDITION
            )

            LazyColumnFor(
                items = (0..5).map { ExpenditureCategory(it, "문화/컨텐츠") }
            ) {
                ExpenditureCategorySelectionItem(
                    expenditureCategory = it,
                    state = state
                )
            }

            ExpenditureCategoryAddItem()
            Divider(thickness = 1.dp, color = MaterialTheme.colors.divider)
        }
    }
}

@Composable
private fun ExpenditureCategorySelectionItem(
    expenditureCategory: ExpenditureCategory,
    state: TransitionState
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(modifier = Modifier.width(state[deleteButtonStartSize]))

        Image(
            vectorResource(id = R.drawable.ic_delete),
            Modifier.width(state[deleteButtonSize])
        )

        Text(
            text = expenditureCategory.name,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.weight(1f)
                .padding(vertical = 12.dp, horizontal = 18.dp)
        )

        Icon(
            vectorResource(id = R.drawable.ic_edit),
            modifier = Modifier.drawOpacity(state[editButtonOpacity])
                .padding(end = 18.dp)
                .size(12.dp)
        )
    }

    Divider(thickness = 1.dp, color = MaterialTheme.colors.divider)
}

@Composable
private fun ExpenditureCategoryAddItem() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_plus),
            modifier = Modifier.size(12.dp)
        )
        Box(modifier = Modifier.width(12.dp))
        Text(
            text = "추가",
            style = MaterialTheme.typography.caption,
        )
    }
}