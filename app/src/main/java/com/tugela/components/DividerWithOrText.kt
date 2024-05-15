package com.tugela.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import com.tugela.ui.theme.textFieldBoarderColor


@Composable
fun DividerWithOrText() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            color = textFieldBoarderColor,
            thickness = 1.dp
        )

        Text(
            text = "or",
            modifier = Modifier.padding(horizontal = 8.dp),
            color = textFieldBoarderColor,
            fontWeight = FontWeight.Bold
        )

        Divider(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            color = textFieldBoarderColor,
            thickness = 1.dp
        )
    }
}
