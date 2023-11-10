package com.example.akatsuki.model

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail")
    object About : Screen("about")
}