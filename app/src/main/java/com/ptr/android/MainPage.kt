package com.ptr.android

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ptr.android.ui.theme.PTRTheme


import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity

class MainPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PTRTheme {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 60.dp),

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
                            Button(
                                onClick = { /*TODO*/ },
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 30.dp)
                            ) {
                                Text(text = "Новая Коллекция")
                            }
                        }
                    }
                    items(1){
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
                    items(1){
                        Image(
                            painter = painterResource(id = R.drawable.botton_main),
                            contentDescription = null,
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