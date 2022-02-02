package com.estud.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.estud.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Init {
                DisplayText(text = "Hello world")
            }
        }
    }
}

@Composable
fun Init(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(topBar = { SetAppTopBar() }) {
            //content()
            val listItem = listOf("Good", "Great", "Due")
            SetScrollableList(items = listItem)
        }
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
fun SetScrollableList(items: List<String>) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items) {
                DisplayMovieCardInfo(movie = it)
            }
        }
    }
}

@Composable
fun DisplayMovieCardInfo(movie: String) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(130.dp),
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Init {
        DisplayText(text = "Hello")
    }
}
