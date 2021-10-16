package com.nfragiskatos.news_api_client

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.nfragiskatos.news_api_client.databinding.FragmentInfoBinding
import com.nfragiskatos.news_api_client.presentation.viewmodel.NewsViewModel


class InfoFragment : Fragment() {

    private lateinit var fragmentInfoBinding: FragmentInfoBinding
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        newsViewModel = (activity as MainActivity).viewModel
        val args: InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if (!article.url.isNullOrBlank()) {
                loadUrl(article.url)
            }
        }
        fragmentInfoBinding.fabSave.setOnClickListener {
            newsViewModel.saveArticle(article)
            Snackbar.make(view, "Save Successful", Snackbar.LENGTH_LONG).show()
        }
    }
}