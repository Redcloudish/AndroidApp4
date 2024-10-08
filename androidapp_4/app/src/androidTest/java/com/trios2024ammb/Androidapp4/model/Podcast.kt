package com.trios2024ammb.Androidapp4.model

import java.util.Date

data class Podcast(
    var feedUrl: String = "",
    var feedTitle: String = "",
    var feedDesc: String = "",
    var imageUrl: String = "",
    var lastUpdated: Date = Date(),
    var episodes: List<Episode> = listOf()
)
