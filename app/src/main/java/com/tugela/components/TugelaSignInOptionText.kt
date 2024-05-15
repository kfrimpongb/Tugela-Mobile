package com.tugela.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.textFieldBoarderColor
import com.tugela.ui.theme.textFieldTextColor

@Composable
fun TugelaSignInOptionText(
    leadingText: String,
    trailingText: String,
    endText: String,
    onClickLeadingText:() -> Unit,
    onClickTrailingText:() -> Unit
){
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ){
        Text(
            text = leadingText,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = textFieldTextColor
        )
        Spacer(modifier = Modifier.width(8.dp))

        Text(
            modifier = Modifier.clickable {
                onClickLeadingText()
            },
            text = trailingText,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorAccent,

        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.clickable {
                onClickTrailingText()
            },
            text = endText,
            style = MaterialTheme.typography.bodySmall,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorAccent
        )
    }
}


@Preview
@Composable
fun PreviewTugelaSignInOptionText(){
//    TugelaSignInOptionText("Already Signed In?", "Sign In", "Sign in as a guest")
}