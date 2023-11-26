package com.ptr.android.autorization.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ptr.android.R
import com.ptr.android.ui.theme.grey


class Autorization : ComponentActivity() {
     private val userModel: UserViewModel by viewModels()

        @OptIn(ExperimentalMaterial3Api::class)
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
                                viewModel.code.value = ""
                                Column {
                                    Image(
                                        painter = painterResource(id = R.drawable.ptr),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 108.dp )
                                            .padding(top = 160.dp, bottom = 80.dp)


                                        )

                                        Text(
                                            text = "Авторизация",
                                            Modifier.fillMaxWidth()
                                                .padding(bottom = 20.dp),
                                            textAlign = TextAlign.Center,
                                            fontSize = 22.sp,
                                            fontFamily = FontFamily(Font(R.font.sfpro))

                                        )

                                    var textState by remember { mutableStateOf("") }

                                    OutlinedTextField(
                                        value = textState,
                                        onValueChange = {
                                            if (it.length <=11){
                                                textState = it
                                            }

                                        },
                                        maxLines = 1,
                                        keyboardOptions = KeyboardOptions(
                                            imeAction = ImeAction.Done,
                                            keyboardType = KeyboardType.Number
                                        ),
                                        placeholder = { Text("Телефон") },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp)
                                            .padding(bottom = 20.dp)
                                            .height(54.dp)
                                    )
                                    Button(onClick = {
                                        val n1 = (0..9).random()
                                        val n2 = (0..9).random()
                                        val n3 = (0..9).random()
                                        val n4 = (0..9).random()
                                        viewModel.code.value = "" + n1 + n2 +n3 + n4
                                        Toast.makeText(this@Autorization, viewModel.code.value, Toast.LENGTH_SHORT).show()

                                        navController.navigate("sendSms") {}
                                    },

                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp)
                                            .height(54.dp)
                                        ,
                                        shape = RectangleShape,

                                        ) {
                                        Text(text = "Продолжить",
                                            fontSize = 18.sp)

                                    }

                                    Text(
                                        text = "При  нажатии на кнопку продолжить вам будет \n" +
                                                "выслан код для входа",
                                        Modifier.fillMaxWidth()
                                            .padding(top = 12.dp)
                                            ,
                                        textAlign = TextAlign.Center,
                                        fontSize = 12.sp,
                                        color = grey,
                                        lineHeight = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.sfpro))

                                    ) }


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
                                    Image(
                                        painter = painterResource(id = R.drawable.ptr),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 108.dp )
                                            .padding(top = 160.dp, bottom = 80.dp)


                                    )

                                    Text(
                                        text = "Авторизация",
                                        Modifier.fillMaxWidth()
                                            .padding(bottom = 20.dp),
                                        textAlign = TextAlign.Center,
                                        fontSize = 22.sp,
                                        fontFamily = FontFamily(Font(R.font.sfpro))

                                    )

                                    var textState by remember { mutableStateOf("") }

                                    OutlinedTextField(
                                        value = textState,
                                        onValueChange = {
                                            if (it.length <=4){
                                                textState = it
                                            }

                                        },
                                        maxLines = 1,
                                        keyboardOptions = KeyboardOptions(
                                            imeAction = ImeAction.Done,
                                            keyboardType = KeyboardType.Number
                                        ),
                                        placeholder = { Text("Введите код из СМС") },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp)
                                            .padding(bottom = 20.dp)
                                            .height(54.dp)
                                    )
                                    Button(onClick = {
                                        navController.navigate("register") {}
                                    },

                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 16.dp)
                                            .height(54.dp)
                                        ,
                                        shape = RectangleShape,

                                        ) {
                                        Text(text = "Продолжить",
                                            fontSize = 18.sp)

                                    }


                                    Text(
                                        text = "На номер "+viewModel.number.value+" отправлен код " + viewModel.code.value,
                                        Modifier.fillMaxWidth()
                                            .padding(top = 12.dp)
                                        ,
                                        textAlign = TextAlign.Center,
                                        fontSize = 12.sp,
                                        color = grey,
                                        lineHeight = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.sfpro))

                                    ) }


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
