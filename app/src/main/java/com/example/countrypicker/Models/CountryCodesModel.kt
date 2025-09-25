package com.example.countrypicker.Models

data class CountryCodesModel(
    val name: String,
    val code: String,
    val flagEmoji: String,
    val example: String,
    val numberLength: Int
)

fun createCountry(
    name: String,
    code: String,
    flag: String,
    numberLength: Int,
    firstDigit: String
): CountryCodesModel {
    val example = firstDigit + "x".repeat(numberLength - 1)
    return CountryCodesModel(name, code, flag, example, numberLength)
}
