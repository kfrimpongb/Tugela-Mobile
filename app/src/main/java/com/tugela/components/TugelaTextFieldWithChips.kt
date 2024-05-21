package com.tugela.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.ui.theme.colorAccent
import com.tugela.ui.theme.textFieldBoarderColor
import com.tugela.ui.theme.textFieldTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TugelaTextFieldWithChips(
    title: String,
    hint: String,
    onTextValueChanged: (String) -> Unit // Callback to pass the text value
) {
    var textValue by remember { mutableStateOf("") }
    var chips by remember { mutableStateOf(listOf<String>()) }

    Column {
        Text(
            text = title,
            color = textFieldTextColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                placeholder = {
                    Text(
                        modifier = Modifier.align(Alignment.Bottom),
                        text = hint,
                        color = textFieldTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (textValue.isNotEmpty()) {
                                chips = chips + textValue
                                textValue = ""
                                onTextValueChanged("")
                            }
                        }
                    ) {
                        Icon(Icons.Outlined.Add, contentDescription = null, tint = Color.Black)
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
                value = textValue,
                onValueChange = {
                    textValue = it
                    onTextValueChanged(it) // Invoke the callback with updated text value
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        ChipGroup(chips = chips) { chipToRemove ->
            chips = chips.filter { it != chipToRemove }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipGroup(chips: List<String>, onRemoveChip: (String) -> Unit) {
    FlowRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        chips.forEach { chipText ->
            Chip(text = chipText, onRemove = { onRemoveChip(chipText) })
        }
    }
}

@Composable
fun Chip(text: String, onRemove: () -> Unit) {
    Box(
        modifier = Modifier
            .wrapContentWidth()
            .height(32.dp)
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(color = colorAccent, shape = RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = onRemove,
                modifier = Modifier.size(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Close,
                    contentDescription = "Remove chip",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
@Preview
fun previewTugelaTextFieldWithChips() {
    TugelaTextFieldWithChips("Email", "Enter your email address", {})
}
