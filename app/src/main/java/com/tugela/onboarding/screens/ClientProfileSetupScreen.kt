package com.tugela.onboarding.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tugela.R
import com.tugela.components.ExposedDropdownMenuBoxSample
import com.tugela.components.TugelaBack
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaProfileImageEdit
import com.tugela.components.TugelaTextField
import com.tugela.data.local.PreferencesKeys
import com.tugela.data.remote.models.ClientModel
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.onboarding.viewmodel.AuthViewModel

@Composable
fun ClientProfileSetupScreen(
     navigateToAccountCreation:() -> Unit,
     viewModel: AuthViewModel = hiltViewModel()


) {
    var jobIndustry by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var timezone by remember { mutableStateOf("") }
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }

    val email = viewModel.email.collectAsState().value

    val clientProfileModel = ClientModel(
        entityName = company,
        firstName = firstname,
        lastName = lastname,
        city = city,
        address = city,
        clientId = null,
        entityId = null,
        country = country,
        currency = null,
        middleName = null,
        password = null,
        phone = null,
        email =  email

    )

    val uiState by viewModel.uiState.collectAsState(AuthUiState.initState)
    when (uiState) {
        is AuthUiState.failedState -> {
            Toast.makeText(LocalContext.current, "Authentication Failed", Toast.LENGTH_LONG).show()
        }
        is AuthUiState.successState -> {
            navigateToAccountCreation.invoke()
        }
        else -> {}
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(Modifier.height(32.dp))

            Spacer(Modifier.height(12.dp))

            TugelaBack {}

            Spacer(Modifier.height(42.dp))

            Text(
                text = "Client Profile Update",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )

            Spacer(Modifier.height(16.dp))
            TugelaProfileImageEdit()

            Spacer(Modifier.height(52.dp))

            TugelaTextField("First Name", stringResource(id = R.string.enter_first_name), Icons.Outlined.Person){
                firstname = it
            }

            Spacer(modifier = Modifier.height(16.dp))
            TugelaTextField("Last Name", stringResource(id = R.string.enter_last_name), Icons.Outlined.Person){
                lastname = it
            }

            Spacer(modifier = Modifier.height(16.dp))

            TugelaTextField(
                stringResource(id = R.string.job_industry),
                stringResource(id = R.string.enter_job_industry),
                Icons.Outlined.Lock,
                false
            ) {
                jobIndustry = it
            }

            Spacer(Modifier.height(16.dp))

            TugelaTextField(
                stringResource(id = R.string.company),
                stringResource(id = R.string.enter_company),
                Icons.Outlined.Lock,
                false
            ) {
                company = it
            }

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBoxSample("Select Country", listOf("Ghana")){
                country = it
            }

            Spacer(Modifier.height(16.dp))

            TugelaTextField(
                stringResource(id = R.string.city),
                stringResource(id = R.string.enter_city),
                Icons.Outlined.Lock,
                false
            ) {
                city = it
            }

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBoxSample(stringResource(id = R.string.timezone), listOf("(GMT+00:00) Accra")){
                timezone = it
            }

            Spacer(Modifier.height(36.dp))

            TugelaButton(
                onClick = {
                    viewModel.onEvent(AuthEvent.UpdateClient(clientProfileModel))
                },
                text = stringResource(id = R.string.continue_btn)
            )

            Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun PreviewClientProfileSetupScreen() {
    ClientProfileSetupScreen( {})
}
