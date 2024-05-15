package com.tugela.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.components.DividerWithOrText
import com.tugela.components.SignInOptionButtons
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaSignInOptionText
import com.tugela.components.TugelaTextField
import com.tugela.components.TugelaTopLogoView
import com.tugela.ui.theme.textFieldBoarderColor


@Composable
fun CreateAccountScreen(
    popToLoginScreen:() -> Unit,
    navigateToSelectCustomerType:() -> Unit
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 18.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        TugelaTopLogoView()

        Spacer(modifier = Modifier.height(36.dp))
        Text(
            text = stringResource(id = R.string.create_account),
            style = MaterialTheme.typography.labelMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(16.dp))
        TugelaTextField(stringResource(id = R.string.full_name), stringResource(id = R.string.enter_full_name), Icons.Outlined.Person){}

        Spacer(modifier = Modifier.height(16.dp))
        TugelaTextField(stringResource(id = R.string.email), stringResource(id = R.string.email_hint), Icons.Outlined.Email){}

        Spacer(modifier = Modifier.height(16.dp))
        TugelaTextField(stringResource(id = R.string.password), stringResource(id = R.string.password_hint), Icons.Outlined.Lock, true){}

        Spacer(modifier = Modifier.height(26.dp))
        TugelaButton(onClick = {
            navigateToSelectCustomerType.invoke()
        }, text = stringResource(id = R.string.create_account) )

        Spacer(modifier = Modifier.height(24.dp))

        TugelaSignInOptionText(
            leadingText = stringResource(id = R.string.already_account),
            trailingText = stringResource(id = R.string.sign_in),
            endText = stringResource(id = R.string.sign_in_guest),
            {
                popToLoginScreen.invoke()
            },
            {}
        )

        Spacer(modifier = Modifier.height(26.dp))
        DividerWithOrText()
        Spacer(modifier = Modifier.height(26.dp))

        SignInOptionButtons(icon = R.drawable.ic_google, stringResource(id = R.string.sign_up_google)) {}

        Spacer(modifier = Modifier.height(12.dp))
        SignInOptionButtons(icon = R.drawable.ic_facebook, stringResource(id = R.string.sign_up_facebook)) {}



    }
}


@Composable
@Preview
fun PreviewCreateAccountScreen(){
    CreateAccountScreen({},{})
}