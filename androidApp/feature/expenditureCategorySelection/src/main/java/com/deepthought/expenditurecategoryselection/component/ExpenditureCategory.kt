package com.deepthought.expenditurecategoryselection.component

import androidx.compose.animation.core.TransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import com.deepthought.core.theme.divider
import com.deepthought.expenditurecategoryselection.R
import com.deepthought.expenditurecategoryselection.animation.deleteButtonSize
import com.deepthought.expenditurecategoryselection.animation.deleteButtonStartSize
import com.deepthought.expenditurecategoryselection.animation.editButtonOpacity

@Composable
fun ExpenditureCategorySelectionItem(
    expenditureCategory: ExpenditureCategory,
    transitionState: TransitionState
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
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
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 18.dp)
            .clickable(onClick = { navController.navigate("expenditureCategoryAddition") }),
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
    Divider(thickness = 1.dp, color = MaterialTheme.colors.divider)
}