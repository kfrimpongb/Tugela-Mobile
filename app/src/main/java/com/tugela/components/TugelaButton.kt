package com.tugela.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.textFieldTextColor

@Composable
fun TugelaButton(
    onClick: () -> Unit,
    text: String,
){
    ElevatedButton(
        modifier = Modifier.fillMaxWidth().height(56.dp),

        colors  = ButtonDefaults.buttonColors(
            containerColor =  colorAccent,
            contentColor = Color.White,
            disabledContainerColor = textFieldTextColor,
            disabledContentColor = Color.White
        ),
        shape = RoundedCornerShape(8.dp),
        onClick = {
            onClick()
        }
    )
    {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }


}

@Preview
@Composable
fun previewButton(){
    TugelaButton({},text = "Get Started")
}