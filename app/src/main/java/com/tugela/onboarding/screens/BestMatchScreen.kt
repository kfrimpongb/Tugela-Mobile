package com.tugela.onboarding.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tugela.components.TugelaJobItem
import com.tugela.util.Constants

@Composable
fun BestMatchScreen(
    navigateToJobDetailsScreen: () -> Unit
){
    val jobItems = listOf(
        listOf("GPT-4", "Java", "Python"),
        listOf("Kotlin", "Compose", "Android"),
        listOf("React", "TypeScript", "MERN"),
        listOf("Machine Learning", "Data Science", "AI")
    )
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
    ) {
        LazyColumn {
            items(jobItems) { chips ->
                TugelaJobItem(chips = chips) {
                    // Navigate to JobDetailsScreen when an item is clicked
                    navigateToJobDetailsScreen.invoke()
                }
                Spacer(modifier = Modifier.height(16.dp)) // Add space between items
            }
        }
    }
}