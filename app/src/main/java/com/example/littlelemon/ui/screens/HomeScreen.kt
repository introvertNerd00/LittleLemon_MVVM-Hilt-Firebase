package com.example.littlelemon.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.littlelemon.DrawerContent
import com.example.littlelemon.TopAppBar
import com.example.littlelemon.UpperPanel
import com.example.littlelemon.ui.components.LowerPanel
import com.example.littlelemon.ui.viewmodel.DishViewModel

@Composable
fun HomeScreen(navController: NavHostController, viewModel: DishViewModel) {
    Column {
        TopAppBar(drawerContent = { DrawerContent() },)
        UpperPanel()
        LowerPanel(navController, viewModel = viewModel)
    }
}
