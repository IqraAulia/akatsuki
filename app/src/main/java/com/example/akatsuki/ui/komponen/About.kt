package com.example.akatsuki.ui.komponen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.akatsuki.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutS(
    modifier: Modifier = Modifier,
    navController: NavController,

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.about))
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
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profil),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .padding(8.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = stringResource(R.string.nama),
                    fontSize = 22.sp
                )
                Text(
                    text = stringResource(R.string.email),
                    fontSize = 14.sp
                )
            }
        }
    }
}