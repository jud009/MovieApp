package com.estud.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.estud.movieapp.navigation.ScreenNavigation

@Composable
fun CreateHomeScreen(navController: NavController) {
    Scaffold(topBar = { SetAppTopBar() }) {
        val listItem = listOf("Good", "Great", "Due")
        SetScrollableList(navController, items = listItem)
    }
}

@Composable
fun SetAppTopBar(title: String = "My App") {
    TopAppBar(
        backgroundColor = Color.Magenta,
        elevation = 5.dp,
    ) {
        Text(text = title)
    }
}

@Composable
fun SetScrollableList(navController: NavController, items: List<String>) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items) {
                DisplayMovieCardInfo(movie = it) { movie ->
                    //Log.i("MOVIE_TAG", movie)
                    navController.navigate(
                        route = ScreenNavigation.DETAILS_SCREEN.name)
                }
            }
        }
    }
}

@Composable
fun DisplayMovieCardInfo(movie: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick(movie) },
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        elevation = 4.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                SetImage()
            }

            DisplayText(text = movie)
        }
    }
}

@Composable
fun SetImage() {
    Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Icon image")
}

@Composable
fun DisplayText(text: String) {
    Text(text = text)
}
