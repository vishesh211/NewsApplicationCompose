package com.example.newsapplicationcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.newsapplicationcompose.navigation.MainScreenNavigationConfigurations
import com.example.newsapplicationcompose.ui.theme.NewsApplicationComposeTheme
import com.example.newsapplicationcompose.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
private fun MainScreen(viewModel: NewsViewModel) {
    val navController = rememberNavController()

    MainScreenNavigationConfigurations(viewModel)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsApplicationComposeTheme {
        Greeting("Android")
    }
}