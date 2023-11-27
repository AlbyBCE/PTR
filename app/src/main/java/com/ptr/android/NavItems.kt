package com.ptr.android

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val route: String,
    val label: String,
    val icon: ImageVector,
)

val listOfNavItems = listOf(
    NavItem(
        route = Screens.HomeScreen.name,
        label = "Главная",
        icon = Icons.Default.Home
    ),
    NavItem(
        route = Screens.MapScreen.name,
        label = "Магазины",
        icon = Icons.Default.Home
    ),
    NavItem(
        route = Screens.QRScreen.name,
        label = "QR",
        icon = Icons.Default.Home
    ),
    NavItem(
        route = Screens.ProfileScreen.name,
        label = "Профиль",
        icon = Icons.Default.Home
    ),

    NavItem(
        route = Screens.NotificationScreen.name,
        label = "Уведомления",
        icon = Icons.Default.Home
    )
)