package com.ptr.android

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen (){
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