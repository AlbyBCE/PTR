package com.ptr.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ptr.android.ui.theme.PTRTheme


import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
class MainPage : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PTRTheme {


                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    state = rememberLazyListState()
                ) {
                    items(1) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.banner_main_page),
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxSize()

                            )
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    val intent = Intent(context, MapActivity::class.java)
                                    context.startActivity(intent)
                                          },
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 30.dp)
                            ) {
                                Text(text = "Новая Коллекция")
                            }
                        }
                    }
                    items(1) {
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp),
                            content = {
                                items(1) { index ->
                                    Image(
                                        painter = painterResource(id = R.drawable.first_main),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillHeight,
                                        modifier = Modifier
                                            .height(180.dp)
                                            .padding(10.dp),


                                        )
                                    Image(
                                        painter = painterResource(id = R.drawable.second_main),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillHeight,
                                        modifier = Modifier
                                            .height(180.dp)
                                            .padding(10.dp),
                                        )
                                    Image(
                                        painter = painterResource(id = R.drawable.third_main),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillHeight,
                                        modifier = Modifier
                                            .height(180.dp)
                                            .padding(10.dp),

                                        )
                                }
                            }
                        )
                    }
                    items(1) {
                        Image(
                            painter = painterResource(id = R.drawable.botton_main),
                            contentDescription = "Главная",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 40.dp),

                            )
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