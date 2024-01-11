package fr.netvolution.apilist2

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val posts = mutableStateListOf<Post>()
    private val isLoading = mutableStateOf(false)
    private val error = mutableStateOf<String?>(null)

    init {
        getPosts()
    }

    fun getPosts() {
        viewModelScope.launch {
            isLoading.value = true
            val response = try {
                RetrofitInstance.api.getPosts()
            } catch (e: Exception) {
                error.value = e.message
                null
            }
            response?.let {
                posts.addAll(it)
            }
            isLoading.value = false
        }
    }
}