package com.example.countrypicker.ui.screens

import android.R.attr.padding
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.countrypicker.R
import com.example.countrypicker.core.components.AnimatedButton
import com.example.countrypicker.core.components.CheckboxWithLabel
import com.example.countrypicker.core.components.CountryPicker
import com.example.countrypicker.core.components.CountryPickerBottomSheet
import com.example.countrypicker.core.components.PhoneNumberInput
import com.example.countrypicker.ui.theme.AppTheme
import com.example.countrypicker.ui.theme.AppTheme.dimens
import com.example.countrypicker.ui.theme.Orientation
import com.example.countrypicker.ui.theme.TextSize
import com.example.countrypicker.ui.theme.black
import com.example.countrypicker.ui.theme.gray
import com.example.countrypicker.ui.theme.white

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhonePickerScreen(
    viewModel: PhonePickerViewModel = viewModel()
) {
    val selectedCountry by viewModel.selectedCountry.collectAsState()
    val phoneNumber by viewModel.phoneNumber.collectAsState()
    val showSheet by viewModel.showSheet.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val countries = viewModel.filteredCountries()
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val isDark = isSystemInDarkTheme()


    Scaffold(Modifier.fillMaxSize()) { Padding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    if (AppTheme.orientation == Orientation.Portrait) Padding else PaddingValues(
                        dimens.medium
                    )
                )
        ) {
            Text(
                text = stringResource(R.string.one_last_step),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = TextSize.Large.toSp(),
                color = if (isDark) white else black,
                modifier = Modifier.fillMaxWidth()
            )
            FreeAccountText(isDark)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = dimens.medium)
                    .clip(RoundedCornerShape(8.dp))
                    .border(
                        1.dp, if (isDark) gray else white,
                        RoundedCornerShape(dimens.medium)
                    )
                    .padding(start = dimens.medium)
            ) {
                CountryPicker(
                    onClick = { viewModel.toggleSheet(true) },
                    flagEmoji = selectedCountry.flagEmoji,
                    code = selectedCountry.code,
                    isDark = isDark
                )

                PhoneNumberInput(
                    modifier = Modifier.weight(1f),
                    isDark = isDark,
                    country = selectedCountry,
                    phoneNumber = phoneNumber,
                    onValueChange = {
                        viewModel.onPhoneChanged(it, selectedCountry)
                    }
                )
            }

            Spacer(modifier = Modifier.height(dimens.small))

            Text(
                text = stringResource(R.string.we_will_use_this_to_verify_your_account),
                color = if (isDark) white else gray,
                fontSize = TextSize.Small.toSp(),
                modifier = Modifier
                    .padding(horizontal = dimens.medium)
            )

            Spacer(modifier = Modifier.height(dimens.medium))

            CheckboxWithLabel(
                modifier = Modifier.padding(horizontal = dimens.medium),
                isDark = isDark,
                checked = checked,
                onCheckedChange = { checked = it },
                onTextClick = {
                    Toast.makeText(context, "This will open agreement", Toast.LENGTH_SHORT).show()
                }
            )

            Spacer(modifier = Modifier.height(dimens.medium))

            AnimatedButton(
                modifier = Modifier
                    .padding(dimens.medium)
                    .fillMaxWidth(),
                animationStarted = checked && phoneNumber.length == selectedCountry.numberLength,
                onNext = {
                    Toast.makeText(
                        context,
                        "This will navigate to the next Screen",
                        Toast.LENGTH_SHORT
                    ).show()

                },
                buttonText = stringResource(R.string.continuee)
            )

        }
    }

    if (showSheet) {
        CountryPickerBottomSheet(
            countries = countries,
            searchQuery = searchQuery,
            isDark = isDark,
            onSearchQueryChanged = { viewModel.onSearchQueryChanged(it) },
            onCountrySelected = { viewModel.selectCountry(it) },
            onDismissRequest = { viewModel.toggleSheet(false) }
        )
    }
}

@Composable
fun FreeAccountText(isDark: Boolean) {
    Text(
        text = buildAnnotatedString {
            append("Please login or signup for a ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("free")
            }
            append(" account to continue")
        },
        color = if (isDark) white else black,
        fontSize = TextSize.Medium.toSp(),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Preview() {
    PhonePickerScreen()
}
