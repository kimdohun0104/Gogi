package com.deepthought.expenditure.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.deepthought.core.ext.toDefaultPriceFormat
import com.deepthought.core.theme.colorGray500
import com.deepthought.core.theme.paragraph
import com.deepthought.core.theme.paragraphRegular
import com.deepthought.bridge.model.Expenditure

@Composable
internal fun ExpenditureList(
    expenditures: List<Expenditure>
) {
    LazyColumnFor(items = expenditures) {
        ExpenditureListItem(it)
        Divider(thickness = 1.dp, color = colorGray500)
    }
}

@Composable
private fun ExpenditureListItem(
    expenditure: Expenditure
) {
    Column(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Row {
            Text(
                expenditure.name,
                style = MaterialTheme.typography.paragraph
                    .copy(color = MaterialTheme.colors.primary),
                modifier = Modifier.weight(1f)
            )
            Text(
                expenditure.expenditureCategory.name,
                style = MaterialTheme.typography.paragraphRegular
                    .copy(color = MaterialTheme.colors.secondary)
            )
        }

        Box(modifier = Modifier.height(8.dp))

        Row {
            Text(
                "${expenditure.price.toDefaultPriceFormat()} 원",
                style = MaterialTheme.typography.paragraphRegular,
                modifier = Modifier.weight(1f)
            )
            Text(
                "${expenditure.paymentDate}일",
                style = MaterialTheme.typography.paragraphRegular
            )
        }
    }
}