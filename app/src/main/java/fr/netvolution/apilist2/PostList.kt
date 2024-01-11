package fr.netvolution.apilist2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun PostList(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val posts = viewModel.posts

    LazyColumn(
        state = rememberLazyListState()
    ) {
        items(posts.size) {
            val post = posts[it]
            ListItem(
                modifier = Modifier.fillMaxWidth(),
                leadingContent = { Text(text = post.id.toString()) },
                headlineContent = { Text(text = post.title) },
                supportingContent = { Text(text = post.body) }
            )
        }
    }
}