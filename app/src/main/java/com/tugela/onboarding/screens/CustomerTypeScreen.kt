package com.tugela.onboarding.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tugela.components.TugelaBack
import com.tugela.components.TugelaTopLogoView
import com.tugela.data.local.PreferencesKeys
import com.tugela.onboarding.viewmodel.AuthViewModel
import com.tugela.ui.theme.textFieldBoarderColor

@Composable
fun CustomerTypeScreen(
    popBackStack:() -> Unit,
    navigateToClientSetup:() -> Unit,
    navigateToFreelancerSetup:() -> Unit,
    authViewModel: AuthViewModel = hiltViewModel()
){

    Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(horizontal = 26.dp)
        ) {

            Spacer(modifier = Modifier.height(36.dp))

            TugelaBack {
                popBackStack
            }

            Spacer(modifier = Modifier.height(26.dp))

            TugelaTopLogoView()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Select User Type",
                style = MaterialTheme.typography.labelMedium,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(horizontal = 46.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, textFieldBoarderColor, shape = RoundedCornerShape(8.dp))
                        .clickable {
                            authViewModel.saveDataStoreValue(PreferencesKeys.USER_TYPE,"freelancer")
                            navigateToFreelancerSetup()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "As a freelancer")
                }

                Spacer(modifier = Modifier.height(24.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, textFieldBoarderColor, shape = RoundedCornerShape(8.dp))
                        .clickable {
                            authViewModel.saveDataStoreValue(PreferencesKeys.USER_TYPE,"client")
                            navigateToClientSetup.invoke()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "As a Client")
                }
            }
        }


}

@Composable
@Preview
fun PreviewCustomerTypeScreen(){
    CustomerTypeScreen({}, {}, {})
}