package com.ptr.android.autorization.ui.theme

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.ptr.android.MainPage
import com.ptr.android.SampleViewModel
import com.ptr.android.UserViewModel
import com.ptr.android.sharedViewModel
import androidx.activity.viewModels


class Autorization : ComponentActivity() {
     private val userModel: UserViewModel by viewModels()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                PTRTheme {

                    val navController = rememberNavController()
                    val viewModel = remember { SampleViewModel() }
                    NavHost(navController = navController, startDestination = "auth") {
                        navigation(
                            startDestination = "login",
                            route = "auth"
                        ) {
                            composable("login") {

                                val viewModel = it.sharedViewModel<SampleViewModel>(navController)
                                viewModel.number.value = "42"
                                viewModel.code.value = "4920"
                                Column {
                                    Text(text = "Login")
                                    Button(onClick = {
                                        navController.navigate("sendSms") {}
                                    }) {
                                        Text(text = "Отправить Код")
                                    }

                                }
                            }
                            composable("register") {
                                val viewModel = it.sharedViewModel<SampleViewModel>(navController)
                                val context = LocalContext.current
                                Column {
                                    Text("Регистрация")
                                    Button(onClick = {
                                        val intent = Intent(context, MainPage::class.java)
                                        context.startActivity(intent)
                                    }) {
                                        Text(text = "Зарегестрироваться")
                                    }

                                }
                            }
                            composable("sendSms") {
                                val viewModel = it.sharedViewModel<SampleViewModel>(navController)

                                Column {
                                    Text(text = "На номер "+viewModel.number.value+" отправлен код " + viewModel.code.value)
                                    Button(onClick = {
                                        navController.navigate("register") {}
                                    }) {
                                        Text(text = "Проверить Код") // simulate email password then return to login
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
        val navGraphRoute = destination.parent?.route ?: return viewModel()
        val parentEntry = remember(this) {
            navController.getBackStackEntry(navGraphRoute)
        }
        return viewModel(parentEntry)
    }
