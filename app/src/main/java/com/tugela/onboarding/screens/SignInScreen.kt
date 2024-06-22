package com.tugela.onboarding.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.tugela.components.DividerWithOrText
import com.tugela.components.SignInOptionButtons
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaProgressBar
import com.tugela.components.TugelaSignInOptionText
import com.tugela.components.TugelaTextField
import com.tugela.components.TugelaTopLogoView
import com.tugela.data.local.PreferencesKeys
import com.tugela.data.models.requests.SignInModel
import com.tugela.onboarding.events.AuthEvent
import com.tugela.onboarding.state.AuthState.AuthUiState
import com.tugela.onboarding.viewmodel.AuthViewModel


@Composable
fun SignInScreen(
    navigateToSignUp: () -> Unit,
    navigateToForgetScreen: () -> Unit,
    navigateToClientSetup:() -> Unit,
    navigateToFreelancerSetup:() -> Unit,
    navigateToMainScreen: () -> Unit,
    viewModel: AuthViewModel = hiltViewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val signInModel = SignInModel(email, password)
    val context = LocalContext.current

    val uiState by viewModel.uiState.collectAsState(AuthUiState.initState)

    val isProgressBarVisible = when (uiState) {
        is AuthUiState.loadingState -> true
        is AuthUiState.successState -> false
        is AuthUiState.failedState -> false
        else -> false
    }

    when (uiState) {
        is AuthUiState.failedState -> {
            Toast.makeText(context, "Authentication Failed", Toast.LENGTH_LONG).show()
        }
        is AuthUiState.successState -> {
            viewModel.saveDataStoreValue(PreferencesKeys.EMAIL, email)
            viewModel.saveDataStoreBooleanValue(PreferencesKeys.IS_SIGNED_IN, true)
            val isProfileComplete = (uiState as AuthUiState.successState).isProfileComplete
            val customerType = (uiState as AuthUiState.successState).userType
            Toast.makeText(LocalContext.current, isProfileComplete.toString(), Toast.LENGTH_LONG).show()
            if (isProfileComplete){
                navigateToMainScreen.invoke()
            } else {

                if (customerType == "client"){
                    navigateToClientSetup.invoke()
                } else {
                    navigateToFreelancerSetup.invoke()
                }
            }
        }
        else -> {}
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 18.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            TugelaTopLogoView()

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = stringResource(id = R.string.sign_in),
                style = MaterialTheme.typography.labelMedium,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(16.dp))
            TugelaTextField(
                stringResource(id = R.string.email),
                stringResource(id = R.string.email_hint),
                Icons.Outlined.Email
            ) {
                email = it
            }

            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))
            TugelaTextField(
                stringResource(id = R.string.password),
                stringResource(id = R.string.password_hint),
                Icons.Outlined.Lock,
                true
            ) {
                password = it
            }

            Spacer(modifier = Modifier.height(26.dp))
            TugelaButton(
                onClick = {
                    viewModel.onEvent(AuthEvent.SignInEvent(signInModel))
                },
                text = stringResource(id = R.string.sign_in)
            )

            Spacer(modifier = Modifier.height(24.dp))
            TugelaSignInOptionText(
                leadingText = stringResource(id = R.string.dont_account),
                trailingText = stringResource(id = R.string.sign_up),
                endText = stringResource(id = R.string.forget_password),
                onClickLeadingText = navigateToSignUp,
                onClickTrailingText = navigateToForgetScreen
            )

            Spacer(modifier = Modifier.height(26.dp))
            DividerWithOrText()
            Spacer(modifier = Modifier.height(26.dp))

            SignInOptionButtons(icon = R.drawable.ic_google, stringResource(id = R.string.sign_up_google)) {}

            Spacer(modifier = Modifier.height(12.dp))
            SignInOptionButtons(icon = R.drawable.ic_facebook, stringResource(id = R.string.sign_up_facebook)) {}
        }
        TugelaProgressBar(isVisible = isProgressBarVisible)
    }
}

@Composable
@Preview
fun PreviewSignInScreen() {
    // Preview your SignInScreen
}
