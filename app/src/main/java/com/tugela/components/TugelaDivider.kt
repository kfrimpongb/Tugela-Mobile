package com.tugela.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tugela.ui.theme.textFieldBoarderColor


@Composable
fun TugelaDivider() {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(end = 8.dp),
            color = textFieldBoarderColor,
            thickness = 1.dp
        )
}

@Preview
@Composable
fun PreviewTugelaDivier(){
    TugelaDivider()
}


