package com.deepthought.gogi.androidApp.ui.home.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.SpanStyleRange
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.deepthought.gogi.androidApp.R
import com.deepthought.gogi.androidApp.ext.state
import com.deepthought.gogi.androidApp.ext.toDefaultPriceFormat
import com.deepthought.gogi.androidApp.ui.home.HomeState
import com.deepthought.gogi.androidApp.ui.home.HomeViewModel

@Composable
fun HomeHeader(viewModel: HomeViewModel) {
    val state = viewModel.state()

    ConstraintLayout(
        modifier = Modifier.padding(24.dp).padding(top = 32.dp).fillMaxWidth()
    ) {
        val (headerTitle, editBtn, notificationBtn) = createRefs()

        HomeHeaderTitle(state, headerTitle)
        HomeHeaderNotification(notificationBtn)
        HomeHeaderEdit(editBtn, notificationBtn)
    }
}

@Composable
private fun ConstraintLayoutScope.HomeHeaderTitle(
    state: HomeState,
    headerTitle: ConstrainedLayoutReference
) {
    val totalExpenditureText = state.totalExpenditure.toDefaultPriceFormat()
    val title = "${state.userName} 님의\n이번 달 고정 지출\n${totalExpenditureText} 원"

    val startIndexOfFixedExpenditure = title.indexOf("고정 지출")
    val endIndexOfFixedExpenditure = startIndexOfFixedExpenditure + "고정 지출".length

    val startIndexOfTotalExpenditure = endIndexOfFixedExpenditure + 1
    val endIndexOfTotalExpenditure = startIndexOfTotalExpenditure + totalExpenditureText.length

    Text(
        text = AnnotatedString(
            text = title,
            spanStyles = listOf(
                SecondaryColorSpanRange(
                    start = 0,
                    end = state.userName.length
                ),
                SecondaryColorSpanRange(
                    start = startIndexOfFixedExpenditure,
                    end = endIndexOfFixedExpenditure
                ),
                SecondaryColorSpanRange(
                    start = startIndexOfTotalExpenditure,
                    end = endIndexOfTotalExpenditure
                )
            )
        ),
        style = MaterialTheme.typography.h1,
        modifier = Modifier.constrainAs(headerTitle) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
        }
    )
}

@Composable
fun ConstraintLayoutScope.HomeHeaderNotification(
    notificationBtnRef: ConstrainedLayoutReference
) {
    Icon(
        asset = vectorResource(id = R.drawable.ic_notification),
        modifier = Modifier.constrainAs(notificationBtnRef) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }.zIndex(0f)
    )
}

@Composable
fun ConstraintLayoutScope.HomeHeaderEdit(
    editBtnRef: ConstrainedLayoutReference,
    notificationBtnRef: ConstrainedLayoutReference
) {

    Icon(
        asset = vectorResource(id = R.drawable.ic_edit),
        modifier = Modifier.constrainAs(editBtnRef) {
            end.linkTo(notificationBtnRef.start)
            top.linkTo(notificationBtnRef.top)
            bottom.linkTo(notificationBtnRef.bottom)
        }.padding(end = 7.dp)
    )
}

@Composable
private fun SecondaryColorSpanRange(start: Int, end: Int): SpanStyleRange =
    SpanStyleRange(
        item = SpanStyle(color = MaterialTheme.colors.secondary),
        start,
        end
    )