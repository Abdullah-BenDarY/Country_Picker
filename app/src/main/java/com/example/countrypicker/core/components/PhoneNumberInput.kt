package com.example.countrypicker.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import com.example.countrypicker.Models.CountryCodesModel
import com.example.countrypicker.R
import com.example.countrypicker.ui.theme.AppTheme.dimens
import com.example.countrypicker.ui.theme.TextSize
import com.example.countrypicker.ui.theme.black
import com.example.countrypicker.ui.theme.gray
import com.example.countrypicker.ui.theme.transparent
import com.example.countrypicker.ui.theme.white

@Composable
fun PhoneNumberInput(
    modifier: Modifier = Modifier,
    isDark: Boolean,
    phoneNumber: String,
    country: CountryCodesModel,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = phoneNumber,
        onValueChange = { newValue -> onValueChange(newValue) },
        placeholder = {
            Text(text = country.example,
                color = gray,
                fontSize = TextSize.Medium.toSp()
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = transparent,
            unfocusedContainerColor = transparent,
            disabledContainerColor = transparent,
            focusedIndicatorColor = transparent,
            unfocusedIndicatorColor = transparent,
            disabledIndicatorColor = transparent,
            errorIndicatorColor =transparent,
            cursorColor = if (isDark) white else black
        ),
        textStyle = TextStyle(
            color = if (isDark) white else black,
            fontSize = TextSize.Medium.toSp()
        ),
        modifier = modifier
    )
}

@Composable
fun CountryPicker(
    modifier: Modifier = Modifier,
    isDark: Boolean,
    onClick: () -> Unit,
    flagEmoji: String,
    code: String
) {
    Row(
        modifier = modifier
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = flagEmoji)
        Spacer(modifier = Modifier.width(dimens.extraSmall))
        Icon(
            painter = painterResource(R.drawable.arrow_drop_down),
            contentDescription = null,
            tint = if (isDark) white else black
        )
        Spacer(modifier = Modifier.width(dimens.extraSmall))
        Text(
            text = code,
            fontSize = TextSize.Medium.toSp(),
            color = if (isDark) white else black
        )
    }
}
