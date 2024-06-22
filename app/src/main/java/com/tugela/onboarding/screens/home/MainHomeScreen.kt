package com.tugela.onboarding.screens.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugela.components.TugelaProfileImage
import com.tugela.components.TugelaSearchBar
import com.tugela.onboarding.screens.BestMatchScreen
import com.tugela.ui.theme.pagerColor
import com.tugela.ui.theme.textColor
import com.tugela.util.HomeTabs
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainHomeScreen(
    navigateToJobDetailsScreen: () -> Unit,
    navigateToProfileScreen: () -> Unit,
    openDrawer: () -> Unit // Add a parameter to handle opening the drawer

) {
    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TugelaProfileImage("https://avatars.githubusercontent.com/u/52282400?v=4", {
                openDrawer()
//                navigateToProfileScreen.invoke()
            })
            Text(
                modifier = Modifier.weight(1f),
                text = "Jobs",
                style = MaterialTheme.typography.labelMedium,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        TugelaSearchBar("Search For Job")

        Spacer(modifier = Modifier.height(24.dp))

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
            HomeTabs.values().forEachIndexed { index, currentTab ->
                Tab(
                    modifier = Modifier.background(Color.White),
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
                            fontSize = 14.sp
                        )
                    }
                )
            }
        }

        HorizontalPager(
            pageCount = HomeTabs.values().size,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            // Your pager content goes here
            when (page) {
                // For each tab, you can add corresponding composable content
                0 -> BestMatchScreen(navigateToJobDetailsScreen)
                1 -> Text("Tab Content 2", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
                2 -> Text("Tab Content 3", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)
                // Add more cases if you have more tabs
            }
        }
    }

    // Sync pager state with tab state
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            Log.d("Pager", "Page changed to: $page")
        }
    }
}

@Preview
@Composable
fun PreviewMainHomeScreen() {
    MainHomeScreen({ }, {}, {})
}
