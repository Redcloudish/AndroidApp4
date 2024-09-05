package com.trios2024ammb.Androidapp4.repository;

import com.trios2024ammb.Androidapp4.service.ItunesService;

class ItunesRepo(private val itunesService: ItunesService) {
    suspend fun searchByTerm(term: String) =
        itunesService.searchPodcastByTerm(term)
}