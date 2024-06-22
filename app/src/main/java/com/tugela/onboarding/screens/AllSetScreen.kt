package com.tugela.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.components.TugelaBack
import com.tugela.components.TugelaButton


@Composable
fun AllSetScreen(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TugelaBack {}

        Spacer(modifier =  Modifier.height(200.dp))

        Image(
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.ic_congrats), contentDescription = null)

        Text(
            text = "You are all set",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )

        Spacer(modifier =  Modifier.height(20.dp))

        Text(
            text = "You've been assigned the job!! \n\n Be productive and gut it your best",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Row {
            TugelaButton(onClick = { /*TODO*/ }, text = "Get Started")

        }
    }

}

@Preview
@Composable
fun PreviewAllSetScreen(){
    AllSetScreen()
}