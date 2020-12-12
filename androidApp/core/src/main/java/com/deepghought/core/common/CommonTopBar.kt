package com.deepghought.core.common

import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.deepthought.gogi.androidApp.ui.theme.*

@Composable
fun CommonTopBar(
    title: String,
    action: String,
    onClickAction: () -> Unit,
    isActionEnabled: Boolean = true,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.topAppBar(),
        title = { CommonTopAppBarTitleText(title) },
        actions = {
            if (isActionEnabled) {
                EnabledActionButton(action = action, onClickAction = onClickAction)
            } else {
                DisabledActionButton(action = action)
            }

            Box(modifier = Modifier.width(16.dp))
        },
        modifier = Modifier.preferredHeight(44.dp)
    )
}

@Composable
private fun CommonTopAppBarTitleText(title: String) {
    Text(
        title,
        style = paragraph()
    )
}

@Composable
private fun EnabledActionButton(action: String, onClickAction: () -> Unit) {
    ClickableText(
        text = AnnotatedString(
            text = action,
            spanStyle = MaterialTheme.typography
                .caption
                .copy(color = MaterialTheme.colors.black())
                .toSpanStyle()
        ),
        onClick = { onClickAction() },
    )
}

@Composable
private fun DisabledActionButton(action: String) {
    ClickableText(
        text = AnnotatedString(
            text = action,
            spanStyle = MaterialTheme.typography
                .caption
                .copy(color = colorGray600)
                .toSpanStyle()
        ),
        onClick = { }
    )
}

@Preview
@Composable
fun PreviewCommonTopBar() {
    CommonTopBar(title = "타이틀", action = "액션", onClickAction = {})
}