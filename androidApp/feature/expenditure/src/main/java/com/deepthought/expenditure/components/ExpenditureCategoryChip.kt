package com.deepthought.expenditure.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRowFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.deepghought.core.theme.paragraph
import com.deepghought.core.theme.secondaryUnselected
import com.deepthought.expenditure.item.ExpenditureCategoryItem

@Composable
internal fun ExpenditureCategoryChipRow(
    expenditureCategoryItems: List<ExpenditureCategoryItem>
) {
    LazyRowFor(
        items = expenditureCategoryItems,
        modifier = Modifier.fillMaxWidth()
    ) {
        ExpenditureCategoryChipItem(it)
    }
}

@Composable
private fun ExpenditureCategoryChipItem(
    expenditureCategoryItem: ExpenditureCategoryItem
) {
    val backgroundColor =
        if (expenditureCategoryItem.isEnabled) MaterialTheme.colors.secondary
        else MaterialTheme.colors.secondaryUnselected

    Box(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 4.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = backgroundColor)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 7.dp),
            text = expenditureCategoryItem.expenditureCategory.name,
            style = MaterialTheme.typography.paragraph
        )
    }
}