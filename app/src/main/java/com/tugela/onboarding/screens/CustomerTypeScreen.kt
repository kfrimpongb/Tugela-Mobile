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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tugela.ui.theme.textFieldBoarderColor

@Composable
fun CustomerTypeScreen(
    navigateToProfileSetup:() -> Unit
){
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
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
                       navigateToProfileSetup.invoke()
                    }
                ,
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
                        navigateToProfileSetup.invoke()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "As a Client")
            }
        }


}

@Composable
@Preview
fun PreviewCustomerTypeScreen(){
    CustomerTypeScreen({})
}