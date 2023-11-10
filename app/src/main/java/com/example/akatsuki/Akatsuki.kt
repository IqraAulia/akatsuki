package com.example.akatsuki

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.akatsuki.model.DataAkatsuki
import com.example.akatsuki.model.Screen
import com.example.akatsuki.ui.komponen.AboutS
import com.example.akatsuki.ui.komponen.DetailS
import com.example.akatsuki.ui.theme.AkatsukiTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Akatsuki(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(stringResource(R.string.app_name))
                        },

                        actions = {
                            IconButton(onClick = { navController.navigate(Screen.About.route) }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_person),
                                    contentDescription = stringResource(R.string.about_page)
                                )
                            }
                        },
                    )
                },
            ) { paddingValues ->
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2)
                    ){
                        items(DataAkatsuki.akatsukis, key = { it.nama }) { akatsuki ->
                        AkatsukiListItem(
                            name = akatsuki.nama,
                            photo = akatsuki.image,
                            description = akatsuki.deskripsi,
                            modifier = Modifier.fillMaxWidth(),
                            navController = navController
                        )
                    }}
                }
            }
        }
        composable(
            route = Screen.Detail.route + "/{name}/{photo}/{description}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("photo") {
                    type = NavType.IntType
                },
                navArgument("description") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val photo = backStackEntry.arguments?.getInt("photo") ?: 0
            val description = backStackEntry.arguments?.getString("description") ?: ""
            DetailS(
                navController = navController,
                name = name,
                photo = photo,
                description = description,
            )
        }
        composable(Screen.About.route) {
            AboutS(navController = navController)
        }
    }

}

@Composable
fun AkatsukiListItem(
    modifier: Modifier = Modifier,
    name: String,
    photo: Int,
    description: String,
    navController: NavController
) {
    Column(

        modifier = modifier.clickable {
            navController.navigate(Screen.Detail.route + "/$name/$photo/$description")
        }
    ) {
        Image(
            painter = painterResource(id = photo),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
                .size(160.dp)

        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AkatsukiPreview() {
    AkatsukiTheme {
        Akatsuki()
    }
}