package com.trios2024ammb.Androidapp4.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.trios2024ammb.Androidapp4.repository.ItunesRepo
import com.trios2024ammb.Androidapp4.service.PodcastResponse

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    var  iTunesRepo: ItunesRepo? = null

    data class PodcastSummaryViewData(
        var name: String? = "",
        var lastUpdated: String? = "",
        var imageUrl: String? = "",
        var feedUrl: String? = "")

    private fun itunesPodcastToPodcastSummaryView(
        itunesPodcast: PodcastResponse.ItunesPodcast):
            PodcastSummaryViewData {
        return PodcastSummaryViewData(
            itunesPodcast.collectionCensoredName,
            itunesPodcast.releaseDate,
            itunesPodcast.artworkUrl100,
            itunesPodcast.feedUrl)
    }

    suspend fun searchPodcasts(term: String): List<PodcastSummaryViewData> {

        val results = iTunesRepo?.searchByTerm(term)


        if (results != null && results.isSuccessful) {

            val podcasts = results.body()?.results

            if (!podcasts.isNullOrEmpty()) {

                return podcasts.map { podcast ->
                    itunesPodcastToPodcastSummaryView(podcast)
                }
            }
        }

        return emptyList()
    }


}
