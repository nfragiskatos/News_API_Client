package com.nfragiskatos.news_api_client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nfragiskatos.news_api_client.data.model.Article
import com.nfragiskatos.news_api_client.databinding.FragmentSavedBinding
import com.nfragiskatos.news_api_client.presentation.adapter.NewsAdapter
import com.nfragiskatos.news_api_client.presentation.compose.articlelist.ArticleListItem
import com.nfragiskatos.news_api_client.presentation.viewmodel.NewsViewModel
import java.util.*


class SavedFragment : Fragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var fragmentSavedBinding: FragmentSavedBinding
    private lateinit var newsAdapter: NewsAdapter

    private lateinit var binding: FragmentSavedBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSavedBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
//        newsAdapter = (activity as MainActivity).newsAdapter
//        newsAdapter.setOnItemClickListener {
//            val bundle = Bundle().apply {
//                putSerializable("selected_article", it)
//            }
//            findNavController().navigate(
//                R.id.action_savedFragment_to_infoFragment,
//                bundle
//            )
//        }
//        initRecyclerView()
        binding.savedComposeView.setContent {
            MaterialTheme() {
                DisplaySavedArticles(viewModel = viewModel)
            }
        }

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = newsAdapter.differ.currentList[position]
                viewModel.deleteArticle(article)
                Snackbar.make(view, "Delete Successful", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo") {
                        viewModel.saveArticle(article)
                    }
                    show()
                }
            }
        }

//        ItemTouchHelper(itemTouchHelperCallback).apply {
//            attachToRecyclerView(fragmentSavedBinding.rvSaved)
//        }
    }

    @Composable
    private fun DisplaySavedArticles(articles: List<Article>) {
        LazyColumn(contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)) {
            items(
                items = articles,
                itemContent = {
                    ArticleListItem(article = it)
                }
            )
        }
    }

    @Composable
    private fun DisplaySavedArticles(viewModel: NewsViewModel) {
        val articles by viewModel.getSavedNews().observeAsState()

        if (articles == null) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        } else {
            LazyColumn(contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)) {
                items(
                    items = articles!!,
                    itemContent = {
                        ArticleListItem(article = it)
                    }
                )
            }
        }
    }
}