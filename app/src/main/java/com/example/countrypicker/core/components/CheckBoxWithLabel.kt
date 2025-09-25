package com.example.countrypicker.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.example.countrypicker.R
import com.example.countrypicker.ui.theme.Purple
import com.example.countrypicker.ui.theme.TextSize
import com.example.countrypicker.ui.theme.black
import com.example.countrypicker.ui.theme.blue
import com.example.countrypicker.ui.theme.gray
import com.example.countrypicker.ui.theme.white

@Composable
fun CheckboxWithLabel(
    modifier: Modifier = Modifier,
    isDark : Boolean,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onTextClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = Purple,
                uncheckedColor = gray,
                checkmarkColor = white
                ),

        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = if (isDark) white else black)) {
                    append(stringResource(R.string.i_agree_and_comply_to_the))
                    append(" ")
                }
                withStyle(style = SpanStyle(color = blue)) {
                    append(stringResource(R.string.community_guidelines))
                }
            },
            fontSize = TextSize.Small.toSp(),
            modifier = Modifier
                .clickable { onTextClick() }
        )
    }
}

