package dm.daniel.exerciselogin

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dm.daniel.exerciselogin.ui.theme.ExerciseLoginTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultLogin()
        }
    }
}

@androidx.compose.runtime.Composable
fun login() {
    var emailInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }

    Column {
        Text(
            text = stringResource(R.string.login),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontStyle = MaterialTheme.typography.h1.fontStyle
        )
        OutlinedTextField(
            value = emailInput,
            onValueChange = {emailInput = it},
            label = { Text(text = stringResource(R.string.username)) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Email,
                    contentDescription = stringResource(R.string.emailIcon)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = passwordInput,
            onValueChange = {passwordInput = it.replace(" ", "*")},
            label = { Text(text = stringResource(R.string.password)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Lock,
                    contentDescription = stringResource(R.string.passwordIcon)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            onClick = { submit() },
        ) {
            Text(
                text = stringResource(R.string.submit),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultLogin() {
    ExerciseLoginTheme {
        login()
    }
}

fun submit() {
    println("You have logged in!!!")
}