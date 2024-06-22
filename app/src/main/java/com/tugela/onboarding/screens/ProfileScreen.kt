package com.tugela.onboarding.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaDivider
import com.tugela.components.TugelaProfileImage
import com.tugela.components.textFieldBoarderColor
import com.tugela.ui.theme.Purple40
import com.tugela.ui.theme.pagerColor


@Composable
fun ProfileScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(26.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileTopBar()

        Spacer(modifier = Modifier.height(16.dp))

        TugelaDivider()

        Spacer(modifier = Modifier.height(36.dp))

        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ){

            Text(
                text = "Better market your expertise with specialized profiles",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Specialized profiles allow you to display more specific skills, deliverables, and more and help power better search results and job recommendations Learn more",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Learn more",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Purple40
            )

            Spacer(modifier = Modifier.height(42.dp))

            TugelaButton(onClick = { /*TODO*/ }, text = "Create a Specialized Profile")

            Spacer(modifier = Modifier.height(32.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box {
                        TugelaProfileImage(imageUri = "https://avatars.githubusercontent.com/u/52282400?v=4", {})
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd) // Align to bottom end of the profile image
                                .offset(x = (-4).dp, y = (-4).dp) // Adjust the offset as necessary
                                .size(12.dp)
                                .background(Color.Green, shape = CircleShape) // Green dot
                                .border(1.dp, Color.White, shape = CircleShape) // Optional white border to make the dot stand out
                        )
                    }
                }
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Text(text = "Esther Brown")
                    Row {
                        Image(painter = painterResource(id = R.drawable.outline_location_on_24), contentDescription = null )
                        Text(text = "Accra, Ghana", color = pagerColor)
                    }
                    Text(text = "10:36 am local time")
                }

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    modifier = Modifier.offset(y = 90.dp),
                    painter = painterResource(id = R.drawable.ic_plant),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AvailableNowButton()
                IconButton(onClick = {}) {
                    Box(
                        modifier = Modifier
                            .size(30.dp) // size of the circle
                            .background(textFieldBoarderColor, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_edit_pencil),
                            contentDescription = null,
                            tint = Color.Black // change the tint color if needed
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = "Data Scientist",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
                IconButton(onClick = {}) {
                    Box(
                        modifier = Modifier
                            .size(30.dp) // size of the circle
                            .background(textFieldBoarderColor, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(16.dp),
                            painter = painterResource(id = R.drawable.ic_edit_pencil),
                            contentDescription = null,
                            tint = Color.Black // change the tint color if needed
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "I'm a data scientists with 5 years of experience and a strong background in analyzing complex datasets, deriving actionable insights, and building predictive models. Proficient in Python, machine learning, Generative AI, and focused on...",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

            }
        }

        Spacer(modifier = Modifier.height(20.dp))

    }
}

@Composable
fun ProfileTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {}) {
            Icon(painter = painterResource(id =  R.drawable.baseline_chevron_left_24), contentDescription = null )
        }
        Text(
            text = "Freelancer Profile",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun AvailableNowButton() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(Color(0xFFE9F1F5))
            .border(1.dp, Color.Transparent, RoundedCornerShape(50.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bulb), // Replace with your light bulb icon resource
                contentDescription = "Light Bulb Icon",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Available now",
                color = Color(0xFF8AAFC4),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}