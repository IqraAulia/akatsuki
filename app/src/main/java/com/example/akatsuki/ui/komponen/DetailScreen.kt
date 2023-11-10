package com.example.akatsuki.ui.komponen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akatsuki.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailS(
    modifier: Modifier = Modifier,
    navController: NavController,
    name: String,
    photo: Int,
    description: String,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(name)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                            contentDescription = stringResource(
                                R.string.back
                            )
                        )
                    }
                }
            )
        },
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = photo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 0.dp, height = 250.dp)
                        .padding(horizontal = 12.dp, vertical = 12.dp),
                    contentScale = ContentScale.FillHeight
                )
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 12.dp)
                )
            }
        }
    }
}