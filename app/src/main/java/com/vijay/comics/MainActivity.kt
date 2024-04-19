package com.vijay.comics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.vijay.comics.features.home.model.ResultsItem
import com.vijay.comics.features.home.model.Thumbnail
import com.vijay.comics.features.home.state.ComicsUiState
import com.vijay.comics.features.home.viewmodels.ComicsListViewModel
import com.vijay.comics.ui.theme.ComicsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewmodel by viewModels<ComicsListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComicsTheme {
                Application()
            }
        }

        viewmodel.loadComicsList()
    }

    @Composable
    fun Application() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "comics-list") {
            composable("comics-list") {
                ComicsListScreen(viewmodel) {
                    viewmodel.loadComicInfo(it)
                    navController.navigate("comic-info")
                }
            }
            composable("comic-info") {
                ComicInfoScreen(viewmodel)
            }
        }
    }
}

@Composable
fun ComicInfoScreen(comicsListViewModel: ComicsListViewModel) {
    val currentComic by comicsListViewModel.currentItem.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = currentComic.thumbnail?.url,
            contentDescription = "comic image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = currentComic.title ?: "Unknown",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.wrapContentSize().padding(10.dp)
        )
    }
}


@Composable
fun ComicsListScreen(comicsListViewModel: ComicsListViewModel, onItemClick: (id:Int) -> Unit) {
    val uiState by comicsListViewModel.uiState.collectAsState()
    val retry = {
        comicsListViewModel.loadComicsList(userReload = true)
    }
    // A surface container using the 'background' color from the theme
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (uiState) {
            ComicsUiState.Empty -> EmptyScreen()
            is ComicsUiState.Failure -> FailureScreen(retry = retry)
            ComicsUiState.Loading -> LoadingScreen()
            is ComicsUiState.Success -> ListScreen((uiState as ComicsUiState.Success).list, onItemClick)
        }
        FloatingActionButton(
            modifier = Modifier
                .padding(20.dp)
                .size(50.dp)
                .align(Alignment.BottomEnd),
            containerColor = Color.Black,
            onClick = {
                comicsListViewModel.loadComicsList(true)
            }
        ) {
            Icon(
                painter = painterResource(R.drawable.refresh),
                tint = Color.White,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun EmptyScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(10.dp)
                .align(Alignment.Center),
            text = "No Employee Profiles Found",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(64.dp)
                .align(Alignment.Center),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun FailureScreen(retry: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(10.dp),
                text = "Failed to load Employee Profiles",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Red,
                textAlign = TextAlign.Center
            )
            Button(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                onClick = {
                    retry()
                }) {
                Text("Try Again")
            }
        }
    }
}

@Composable
fun ListScreen(list: List<ResultsItem>, onItemClick: (id: Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = list,
            key = {
                it.id
            }
        ) { employee ->
            ComicCard(employee, onItemClick)
        }
    }
}

val item = ResultsItem(
    id = 111,
    thumbnail = Thumbnail(
        path = "http://i.annihil.us/u/prod/marvel/i/mg/c/60/4bc69f11baf75",
        extension = "jpg"
    ),
    title = "Gun Theory (2003) #4"
)

@Composable
fun ComicCard(comicItem: ResultsItem = item, onItemClick: (id: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 10.dp, vertical = 5.dp)
            .clickable {
                onItemClick(comicItem.id)
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Black)
        ) {
            AsyncImage(
                model = comicItem.thumbnail?.url,
                contentDescription = "comic image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Text(
                text = comicItem.title ?: "",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(10.dp),
                color = Color.White
            )
        }
    }
}

