package com.deepthought.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.deepghought.core.ext.toDefaultPriceFormat
import com.deepghought.core.theme.expenditureSection
import com.deepthought.bridge.model.Expenditure
import com.deepghought.core.theme.paragraph
import com.deepghought.core.theme.paragraphRegular
import kotlin.coroutines.CoroutineContext

@Composable
fun ExpenditureSection(
    title: String,
    totalPrice: Int,
    expenditures: List<Expenditure>
) {
    if (expenditures.isNullOrEmpty()) {
        return
    }

    val groupByPaymentDate = expenditures.groupBy { it.paymentDate }

    Column {
        ExpenditureSectionHeader(
            title = title,
            totalPrice = totalPrice
        )

        Card(
            backgroundColor = MaterialTheme.colors.expenditureSection(),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.padding(horizontal = 32.dp).padding(top = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp)
            ) {
                groupByPaymentDate.keys.forEachIndexed { index, date ->
                    groupByPaymentDate[date]?.let { expendituresByDate ->
                        val isLastItem = groupByPaymentDate.size - 1 == index
                        ExpenditureDateSection(
                            paymentDate = date,
                            expenditures = expendituresByDate,
                            isLastItem = isLastItem
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ExpenditureSectionHeader(
    title: String,
    totalPrice: Int
) {
    Row(modifier = Modifier.padding(horizontal = 36.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.paragraph(),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = "총 ${totalPrice.toDefaultPriceFormat()}원",
            style = MaterialTheme.typography
                .paragraph()
                .copy(color = MaterialTheme.colors.primary)
        )
    }
}

@Composable
private fun ExpenditureDateSection(
    paymentDate: Int,
    expenditures: List<Expenditure>,
    isLastItem: Boolean
) {
    Text(
        text = "${paymentDate}일",
        style = MaterialTheme.typography.paragraphRegular()
    )
    expenditures.forEach {
        Row {
            Text(
                text = it.name,
                style = MaterialTheme.typography.paragraph(),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "${it.price.toDefaultPriceFormat()} 원",
                style = MaterialTheme.typography.paragraphRegular()
            )
        }
    }
    if (!isLastItem) {
        Box(modifier = Modifier.height(16.dp))
    }
}