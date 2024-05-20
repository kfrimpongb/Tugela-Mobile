package com.tugela.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.dropdownTextColor
import com.tugela.ui.theme.textColor
import com.tugela.ui.theme.textFieldTextColor


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun ExposedDropdownMenuBoxSample(
    title: String,
    options: List<String>
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    val icon = if (expanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropDown
    val optionss = listOf("Option 1", "Option 2", "Option 3")
    val keyboardController = LocalSoftwareKeyboardController.current

    Column {
        Text(
            text = title,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(8.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
                if (expanded) {
                    keyboardController?.hide()
                }
            }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                shape = RoundedCornerShape(10),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth(),
                label = { Text(text ="Select") },
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Dropdown Arrow"
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorAccent,
                    unfocusedBorderColor = textFieldBoarderColor,
                    focusedLabelColor = dropdownTextColor,
                    unfocusedLabelColor = dropdownTextColor
                ),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedText = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ExposedDropdownMenuBoxSamplePreview() {
    MaterialTheme {
        ExposedDropdownMenuBoxSample("Select User Type",listOf("Freelancer, Client"))
    }
}