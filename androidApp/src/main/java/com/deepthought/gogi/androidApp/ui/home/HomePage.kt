package com.deepthought.gogi.androidApp.ui.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.SpanStyleRange
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.ui.tooling.preview.Preview
import androidx.ui.tooling.preview.PreviewParameter
import androidx.ui.tooling.preview.PreviewParameterProvider
import com.deepthought.gogi.androidApp.ext.state
import com.deepthought.gogi.androidApp.ext.toDefaultPriceFormat
import com.deepthought.gogi.androidApp.ui.home.component.HomeHeader
import org.koin.androidx.compose.getViewModel

@Composable
fun HomePage(
    viewModel: HomeViewModel,
    navController: NavController
) {
    ScrollableColumn {
        HomeHeader(viewModel)
    }
}

