package com.tugela.onboarding.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaDivider
import com.tugela.ui.theme.backgroundColor
import com.tugela.ui.theme.layoutBackground
import com.tugela.ui.theme.pagerColor
import com.tugela.ui.theme.textColor
import com.tugela.util.JobDetailsTabs
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun JobDetailsScreen(
    navigateToAllSet:() -> Unit,
    ) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            Log.d("Pager", "Page changed to: $page")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(26.dp)
    ) {
        TopBar()

        Spacer(modifier = Modifier.height(16.dp))

        TugelaDivider()

        Spacer(modifier = Modifier.height(20.dp))

        JobHeader()

        Spacer(modifier = Modifier.height(20.dp))

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            divider = {
                Spacer(modifier = Modifier.height(5.dp))
            },
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    height = 2.dp,
                    color = pagerColor  // Changed color to Red
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .wrapContentHeight()
        ) {
            JobDetailsTabs.values().forEachIndexed { index, currentTab ->
                Tab(
                    selectedContentColor = Color.White,
                    modifier = Modifier
                        .background(Color.White)
                        .border(0.dp, Color.White),
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = currentTab.text,
                            color = if (pagerState.currentPage == index) pagerColor else textColor,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    }
                )
            }
        }


        HorizontalPager(
            pageCount = JobDetailsTabs.values().size,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxSize()
        ) { page ->
            // Your pager content goes here
            when (page) {
                // For each tab, you can add corresponding composable content
                0 -> AboutJob(
                    navigateToAllSet
                )
                1 -> AboutCompany()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        RequestInterviewButton()
    }
}

@Composable
fun TopBar() {
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
            text = "Job Details",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun JobHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.verified_tick), // Replace with your logo resource
            contentDescription = "Company Logo",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Data Scientist", style = MaterialTheme.typography.labelMedium)
            Text(text = "Poly AI", style = MaterialTheme.typography.labelMedium, color = pagerColor)
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .border(2.dp, backgroundColor, CircleShape)
            .background(color = layoutBackground, shape = RoundedCornerShape(10))
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.LocationOn, contentDescription = "Remote")
            Text(text = "Remote")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.Email, contentDescription = "Full Time")
            Text(text = "Full Time")
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Outlined.ExitToApp, contentDescription = "Salary")
            Text(text = "$3500")
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row {
        Text(modifier = Modifier.weight(1f),text = "3m ago", style = MaterialTheme.typography.labelMedium, color = pagerColor)
        Text(text = "15 applicants", style = MaterialTheme.typography.labelMedium)

    }
}

@Composable
fun JobDetails() {
    Column {
        Text(text = "About the Job", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Role Overview\n\nWe are seeking a skilled and innovative data scientist to play a pivotal role in developing our cutting-edge Large Language Model API. As a data scientist on our team, you will be responsible for curating, preprocessing, and transforming vast and diverse datasets to train and fine-tune our language model.",
            style = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Key Responsibilities", style = MaterialTheme.typography.titleSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "1. Curate, preprocess, and manage large datasets for training and fine-tuning language models.\n\n2. Implement and experiment with open source models and techniques to improve model performance and language understanding.",
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun RequestInterviewButton() {
    Button(
        onClick = { /* Handle request interview action */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        Text(text = "Request Interview")
    }
}


@Composable
fun AboutJob(
    navigateToAllSet:() -> Unit
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Role Overview", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We are seeking a skilled and innovative data scientist to play a pivotal role in developing our cutting-edge Large Language Model API. As a data scientist on our team, you will be responsible for curating, preprocessing, and transforming vast and diverse datasets to train and fine-tune our language model.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Key Responsibilities", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "1. Curate, preprocess, and manage large datasets for training and fine-tuning language models.\n\n2. Implement and experiment with open source models and techniques to improve model performance and language understanding.",
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.weight(1f))
        TugelaButton(onClick = {
            navigateToAllSet.invoke()
        }, text = "Request Interview")
    }
}

@Composable
fun AboutCompany(
) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text(text = "Role Overview", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We are seeking a skilled and innovative data scientist to play a pivotal role in developing our cutting-edge Large Language Model API. As a data scientist on our team, you will be responsible for curating, preprocessing, and transforming vast and diverse datasets to train and fine-tune our language model.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Key Responsibilities", style = MaterialTheme.typography.labelMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "1. Curate, preprocess, and manage large datasets for training and fine-tuning language models.\n\n2. Implement and experiment with open source models and techniques to improve model performance and language understanding.",
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JobDetailsScreenPreview() {
    JobDetailsScreen({})
}
