package com.tugela.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TugelaTopLogoView()
{
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Image(
            modifier = Modifier.size(38.dp),
            painter = painterResource(id = com.tugela.R.drawable.fav ),
            contentDescription = stringResource(id = com.tugela.R.string.home_logo),
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = stringResource(id = com.tugela.R.string.app_name),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            style = MaterialTheme.typography.titleLarge
        )

    }
}

@Preview
@Composable
fun previewTugelaTopLogoView()
{
    TugelaTopLogoView()
}