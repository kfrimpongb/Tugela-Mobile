package com.tugela.onboarding.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
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
import com.tugela.components.TugelaTextFieldWithChips
import com.tugela.data.local.PreferencesKeys
import com.tugela.data.remote.models.FreelancerModel
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.onboarding.viewmodel.AuthViewModel

@Composable
fun FreelancerProfileSetupScreen(
    navigateToAccountCreation:() -> Unit,
    viewModel: AuthViewModel = hiltViewModel()

    ) {

    val uiState by viewModel.uiState.collectAsState(AuthUiState.initState)

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var middleName by remember { mutableStateOf("") }
    var jobIndustry by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var timezone by remember { mutableStateOf("") }

    val freelancerModel =
        FreelancerModel(
            freelancerId = null,
            firstName = firstName,
            lastName = lastName,
            middleName =  middleName,
            address = address,
            city = city,
            country = country,
            currency = null,
            email = null,
            experience = experience,
            skills = skills
        )


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
                text = "Freelancer Profile Update",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )

            Spacer(Modifier.height(16.dp))
            TugelaProfileImageEdit()

            Spacer(Modifier.height(52.dp))

            Spacer(modifier = Modifier.height(16.dp))
            TugelaTextField("First Name", stringResource(id = R.string.enter_first_name), Icons.Outlined.Person){
                firstName = it
            }

            Spacer(modifier = Modifier.height(16.dp))
            TugelaTextField("Last Name", stringResource(id = R.string.enter_last_name), Icons.Outlined.Person){
                lastName = it
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
                stringResource(id = R.string.role),
                stringResource(id = R.string.enter_role),
                Icons.Outlined.Lock,
                false
            ) {
                role = it
            }

            Spacer(Modifier.height(16.dp))

            TugelaTextFieldWithChips(title = "Skills", hint = "Click on + to add the skill", {})

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
            ) {}

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBoxSample(stringResource(id = R.string.timezone), listOf("(GMT+00:00) Accra")){
                timezone = it
            }

            Spacer(Modifier.height(36.dp))

            TugelaButton(
                onClick = {
                    viewModel.onEvent(AuthEvent.UpdateFreelancer(freelancerModel))


                },
                text = stringResource(id = R.string.continue_btn)
            )

            Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun PreviewFreelancerProfileSetupScreen() {
    FreelancerProfileSetupScreen({})
}
