package com.deepthought.expenditurecategoryselection.component

import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawOpacity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.deepthought.bridge.model.ExpenditureCategory
import com.deepthought.core.ext.setToSavedState
import com.deepthought.core.ext.state
import com.deepthought.core.theme.divider
import com.deepthought.expenditurecategoryselection.ExpenditureCategorySelectionViewModel
import com.deepthought.expenditurecategoryselection.R
import com.deepthought.expenditurecategoryselection.animation.*

@Composable
fun ExpenditureCategorySelectionList(
    viewModel: ExpenditureCategorySelectionViewModel,
    navController: NavController
) {
    val state = viewModel.state()

    val transitionState = transition(
        definition = expenditureCategoryDefinition,
        initState = ExpenditureCategoryState.SELECTION,
        toState =
        if (state.isEdit) ExpenditureCategoryState.ADDITION
        else ExpenditureCategoryState.SELECTION
    )

    LazyColumn {
        items(state.expenditureCategories) {
            ExpenditureCategorySelectionItem(
                expenditureCategory = it,
                transitionState = transitionState,
                navController = navController
            )
        }

        item {
            ExpenditureCategoryAddItem(navController = navController)
        }
    }
}

@Composable
fun ExpenditureCategorySelectionItem(
    expenditureCategory: ExpenditureCategory,
    transitionState: TransitionState,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable(onClick = {
            navController.setToSavedState("expenditureCategory", expenditureCategory)
            navController.popBackStack()
        })
    ) {
        Box(modifier = Modifier.width(transitionState[deleteButtonStartSize]))

        Image(
            vectorResource(id = R.drawable.ic_delete),
            Modifier.width(transitionState[deleteButtonSize])
        )

        Text(
            text = expenditureCategory.name,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.weight(1f)
                .padding(vertical = 12.dp, horizontal = 18.dp)
        )

        Icon(
            vectorResource(id = R.drawable.ic_edit),
            modifier = Modifier.drawOpacity(transitionState[editButtonOpacity])
                .padding(end = 18.dp)
                .size(12.dp)
        )
    }

    Divider(thickness = 1.dp, color = MaterialTheme.colors.divider)
}

@Composable
fun ExpenditureCategoryAddItem(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxWidth()
            .clickable(onClick = { navController.navigate("expenditureCategoryAddition") })
    ) {
        Row(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 18.dp),
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
    Divider(thickness = 1.dp, color = MaterialTheme.colors.divider)
}