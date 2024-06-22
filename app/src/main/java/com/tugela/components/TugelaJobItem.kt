package com.tugela.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.ui.theme.pagerColor
import com.tugela.ui.theme.textColor

@Composable
fun TugelaJobItem(
    chips: List<String> ,// Added chips as parameter
    onClick: () -> Unit // Added onClick as parameter

) {
    var chipList by remember { mutableStateOf(chips) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { onClick() } // Added clickable modifier

    ) {
        Text(
            text = "Data Science",
            color = Color.Black,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween, // Ensure the Row takes full width
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Machine Learning",
                style = MaterialTheme.typography.labelMedium,
                color = pagerColor,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )

            Text(
                text = "35m ago",
                color = textColor,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Added space between rows

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly, // Ensure the Row takes full width
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.6f)
            ) {
                Text(
                    text = "$3500",
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                Text(
                    text = "Per month",
                    color = textColor,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Thin,
                    fontSize = 14.sp
                )
            }

            Column(
                modifier = Modifier.weight(0.6f)
            ) {
                Text(
                    text = "Intermediate",
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )

                Text(
                    text = "Experience Level",
                    color = textColor,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Thin,
                    fontSize = 14.sp
                )
            }

            Column {
                Image(
                    modifier = Modifier.size(38.dp),
                    painter = painterResource(id = R.drawable.ic_fav_untick),
                    contentDescription = stringResource(id = R.string.home_logo),
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "We are looking for a skilled frontend developer with experience in react, typescript, and the mern stack. more",
            color = textColor,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Start
        ) {
//            ChipGroupLocal(chips = chips) {
//                chipList = chips
//            }
            ChipGroupLocal(chips = chips, onRemoveChip = { chipText ->
                chipList = chipList.filter { it != chipText }
            }, showRemove = false)
        }

        Spacer(modifier = Modifier.height(26.dp))

        Row (
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = R.drawable.verified_tick),
                contentDescription = stringResource(id = R.string.home_logo),
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = "Secured Payment",
                style = MaterialTheme.typography.labelMedium,
                color = textColor,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(32.dp))

            TugelaButton(onClick = { /*TODO*/ }, text = "Apply Now")
        }
    }
}



@Preview
@Composable
fun PreviewTugelaJobItem() {
    TugelaJobItem(chips = listOf("GPT-4", "Java", "Python")) {}
}
