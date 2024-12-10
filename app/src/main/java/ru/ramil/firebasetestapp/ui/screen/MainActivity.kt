package ru.ramil.firebasetestapp.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.ramil.firebasetestapp.ui.Application
import ru.ramil.firebasetestapp.ui.theme.FirebaseTestAppTheme
import ru.ramil.firebasetestapp.ui.view_model.MainViewModel
import ru.ramil.firebasetestapp.ui.view_model.ViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val mainViewModel by lazy{
        viewModelFactory.create(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Application.appComponent.inject(this)

        mainViewModel.onCreate()

        enableEdgeToEdge()

        setContent {
            FirebaseTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Token(
                        mainViewModel.tokenLiveData.observeAsState(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Token(token : State<String?>, modifier: Modifier = Modifier) {
     Text(
        text = "my Firebase token is: \"${token.value}\"",
        modifier = modifier
    )
}