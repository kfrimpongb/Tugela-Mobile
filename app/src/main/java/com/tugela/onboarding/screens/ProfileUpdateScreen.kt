package com.tugela.onboarding.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.tugela.R
import com.tugela.components.ExposedDropdownMenuBoxSample
import com.tugela.components.TugelaBack
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaProfileImageEdit
import com.tugela.onboarding.viewmodel.AuthViewModel

@Composable
fun ProfileUpdateScreen(
    authViewModel: AuthViewModel = hiltViewModel()
){
    val navController = rememberNavController()


    Spacer(Modifier.height(32.dp))


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)

        ){

        Spacer(Modifier.height(12.dp))

        TugelaBack {
            navController.popBackStack()
        }

        Spacer(Modifier.height(42.dp))

        Text(
            text = "Profile Update",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
        )

        Spacer(Modifier.height(16.dp))
        TugelaProfileImageEdit()


        Spacer(Modifier.height(52.dp))
        ExposedDropdownMenuBoxSample("Select User Type", listOf("Freelancer", "Client")){

        }

        Spacer(modifier = Modifier.weight(1f)) // Push the button to the bottom


            TugelaButton(
                onClick = { },
                text = stringResource(id = R.string.continue_btn)
            )
        Spacer(Modifier.height(10.dp))
    }


}


@Preview
@Composable
fun PreviewProfileUpdate(){
    ProfileUpdateScreen()
}