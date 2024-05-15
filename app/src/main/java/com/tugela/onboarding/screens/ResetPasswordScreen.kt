package com.tugela.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.textFieldBoarderColor


@Composable
fun ResetPasswordScreen(
    navigateToSignIn:() -> Unit
) {
    Column(
        modifier = Modifier
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
            text = stringResource(id = R.string.reset_password),
            style = MaterialTheme.typography.labelMedium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(46.dp))
        TugelaTextField(stringResource(id = R.string.new_pass), stringResource(id = R.string.new_pass_hint), Icons.Outlined.Lock, showPasswordToggleIcon = true){}

        Spacer(modifier = Modifier.height(26.dp))
        TugelaTextField(stringResource(id = R.string.confirm_pass), stringResource(id = R.string.confirm_hint_pass), Icons.Outlined.Lock, showPasswordToggleIcon = true){}

        Spacer(modifier = Modifier.height(26.dp))

        TugelaButton(onClick = { }, text = stringResource(id = R.string.reset_password) )

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            modifier = Modifier.clickable {navigateToSignIn.invoke()},
            text = stringResource(id = R.string.return_signIn),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorAccent,)
    }
}


@Composable
@Preview
fun PreviewResetPasswordScreen(){
    ResetPasswordScreen({})
}