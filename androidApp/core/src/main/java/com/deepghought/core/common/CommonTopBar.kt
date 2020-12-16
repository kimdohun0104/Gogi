package com.deepghought.core.common

import androidx.compose.foundation.ClickableText
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.deepghought.core.R
import com.deepghought.core.theme.black
import com.deepghought.core.theme.colorGray600
import com.deepghought.core.theme.paragraph
import com.deepghought.core.theme.topAppBar

@Composable
fun CommonTopBar(
    title: String,
    navigationIcon: Int? = null,
    onClickNavigation: () -> Unit = { },
    action: String? = null,
    onClickAction: () -> Unit = { },
    isActionEnabled: Boolean = true,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.topAppBar(),
        title = { CommonTopAppBarTitleText(title) },
        actions = {
            if (action != null) {
                if (isActionEnabled) {
                    EnabledActionButton(action = action, onClickAction = onClickAction)
                } else {
                    DisabledActionButton(action = action)
                }

                Box(modifier = Modifier.width(16.dp))
            }
        },
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(onClick = onClickNavigation) {
                    Icon(asset = vectorResource(id = navigationIcon))
                }
            }
        },
        modifier = Modifier.preferredHeight(44.dp)
    )
}

@Composable
private fun CommonTopAppBarTitleText(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.paragraph
    )
}

@Composable
private fun EnabledActionButton(action: String, onClickAction: () -> Unit) {
    Text(
        text = action,
        style = MaterialTheme.typography
            .caption
            .copy(color = MaterialTheme.colors.black()),
        modifier = Modifier.clickable(onClick = { onClickAction() })
    )
}

@Composable
private fun DisabledActionButton(action: String) {
    Text(
        text = action,
        style = MaterialTheme.typography
            .caption
            .copy(color = colorGray600),
        modifier = Modifier.clickable(onClick = { })
    )
}