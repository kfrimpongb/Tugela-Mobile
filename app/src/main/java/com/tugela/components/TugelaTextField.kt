package com.tugela.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.textFieldBoarderColor
import com.tugela.ui.theme.textFieldTextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TugelaTextField(
    title: String,
    hint: String,
    leadingIcon: ImageVector,
    showPasswordToggleIcon: Boolean = false,
    onTextValueChanged: (String) -> Unit // Callback to pass the text value
){
    var textValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(true) }

    Column {
        Text(
            text = title,
            color = textFieldTextColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        modifier = Modifier.align(Alignment.Bottom),
                        text = hint,
                        color = textFieldTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                leadingIcon = {
                    Icon(leadingIcon, contentDescription = null, tint =  textFieldBoarderColor)
                },
                trailingIcon = {
                    if (showPasswordToggleIcon){
                        IconButton(
                            onClick = { passwordVisible = !passwordVisible }
                        ) {
                            Icon(
                                painter = painterResource(id =if (passwordVisible) R.drawable.baseline_visibility else R.drawable.baseline_visibility_off ),
                                contentDescription = null
                            )
                        }
                    }
                },
                shape = RoundedCornerShape(20),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    focusedBorderColor = colorAccent, // Change focused border color
                    unfocusedBorderColor = textFieldBoarderColor, // Change unfocused border color
                    textColor = Color.Black,
                    cursorColor = textFieldBoarderColor,
                ),
                value =  textValue,
                onValueChange = {
                    textValue = it
                    onTextValueChanged(it) // Invoke the callback with updated text value
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                )
        }
    }

}

@Composable
@Preview
fun previewTextField(){
    TugelaTextField("Email","Enter your email address", Icons.Outlined.Email, false, {})
}