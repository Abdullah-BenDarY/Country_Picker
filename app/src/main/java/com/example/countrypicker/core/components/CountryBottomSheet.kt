package com.example.countrypicker.core.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.countrypicker.Models.CountryCodesModel
import com.example.countrypicker.R
import com.example.countrypicker.ui.theme.AppTheme.dimens
import com.example.countrypicker.ui.theme.TextSize
import com.example.countrypicker.ui.theme.black
import com.example.countrypicker.ui.theme.darkGray
import com.example.countrypicker.ui.theme.transparent
import com.example.countrypicker.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryPickerBottomSheet(
    countries: List<CountryCodesModel>,
    searchQuery: String,
    isDark: Boolean,
    onSearchQueryChanged: (String) -> Unit,
    onCountrySelected: (CountryCodesModel) -> Unit,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismissRequest) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.medium)
        ) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = onSearchQueryChanged,
                label = {
                    Text(
                        text = stringResource(R.string.search_country),
                        color = darkGray,
                        fontSize = TextSize.Medium.toSp()
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = transparent,
                    unfocusedContainerColor = transparent,
                    focusedIndicatorColor =if (isDark) white else darkGray ,
                    unfocusedIndicatorColor = if (isDark) white else darkGray,
                    cursorColor = if (isDark) white else black
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(dimens.small))

            countries.forEach { country ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCountrySelected(country) }
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = country.flagEmoji, fontSize = TextSize.Large.toSp())
                    Spacer(modifier = Modifier.width(dimens.small))
                    Text(text = "${country.name} (${country.code})")
                }
            }
        }
    }
}