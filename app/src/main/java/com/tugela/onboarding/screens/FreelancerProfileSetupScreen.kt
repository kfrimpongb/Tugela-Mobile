package com.tugela.onboarding.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugela.R
import com.tugela.components.ExposedDropdownMenuBoxSample
import com.tugela.components.TugelaBack
import com.tugela.components.TugelaButton
import com.tugela.components.TugelaProfileImageEdit
import com.tugela.components.TugelaTextField
import com.tugela.components.TugelaTextFieldWithChips

@Composable
fun FreelancerProfileSetupScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(Modifier.height(32.dp))

            Spacer(Modifier.height(12.dp))

            TugelaBack {}

            Spacer(Modifier.height(42.dp))

            Text(
                text = "Profile Update",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
            )

            Spacer(Modifier.height(16.dp))
            TugelaProfileImageEdit()

            Spacer(Modifier.height(52.dp))

            TugelaTextField(
                stringResource(id = R.string.job_industry),
                stringResource(id = R.string.enter_job_industry),
                Icons.Outlined.Lock,
                false
            ) {}

            Spacer(Modifier.height(16.dp))

            TugelaTextField(
                stringResource(id = R.string.role),
                stringResource(id = R.string.enter_role),
                Icons.Outlined.Lock,
                false
            ) {}

            Spacer(Modifier.height(16.dp))

            TugelaTextFieldWithChips(title = "Skills", hint = "Click on + to add the skill", {})

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBoxSample("Select Country", listOf("Ghana"))

            Spacer(Modifier.height(16.dp))

            TugelaTextField(
                stringResource(id = R.string.city),
                stringResource(id = R.string.enter_city),
                Icons.Outlined.Lock,
                false
            ) {}

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBoxSample(stringResource(id = R.string.timezone), listOf("(GMT+00:00) Accra"))

            Spacer(Modifier.height(36.dp))

            TugelaButton(
                onClick = { },
                text = stringResource(id = R.string.continue_btn)
            )

            Spacer(Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
fun PreviewFreelancerProfileSetupScreen() {
    FreelancerProfileSetupScreen()
}
