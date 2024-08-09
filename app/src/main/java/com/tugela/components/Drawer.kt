package com.tugela.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.rpc.Help
import com.tugela.R

@Composable
fun DrawerContent(navigateToProfileScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // User profile
        Row(verticalAlignment = Alignment.CenterVertically) {
            TugelaProfileImage("https://avatars.githubusercontent.com/u/52282400?v=4") {
                navigateToProfileScreen.invoke()
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Kwame Frimpong", fontWeight = FontWeight.Bold)
                Text(text = "Freelancer", color = Color.Gray)
            }
        }
        Spacer(modifier = Modifier.height(32.dp))

        // Navigation items
        DrawerItem(painter = painterResource(id = R.drawable.ic_drawer_profile), label = "Profile", onClick = navigateToProfileScreen)
        DrawerItem(painter = painterResource(id = R.drawable.ic_drawer_stats), label = "My stats", onClick = navigateToProfileScreen)
        DrawerItem(painter = painterResource(id = R.drawable.ic_drawer_settings), label = "Settings", onClick = navigateToProfileScreen)
        DrawerItem(painter = painterResource(id = R.drawable.ic_support), label = "Help & Support", onClick = navigateToProfileScreen)
        Spacer(modifier = Modifier.weight(1f))
        DrawerItem(painter = painterResource(id = R.drawable.ic_logout), label = "Logout", onClick = navigateToProfileScreen, iconColor = Color.Red )
    }
}

@Composable
fun DrawerItem(painter: Painter, label: String, onClick: () -> Unit, iconColor: Color = LocalContentColor.current) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painter, contentDescription = label, tint = iconColor)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = label)
    }
}

@Preview
@Composable
fun previewDrawer(){
    DrawerContent({})
}
