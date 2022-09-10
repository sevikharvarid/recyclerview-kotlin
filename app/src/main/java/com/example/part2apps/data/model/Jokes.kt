package com.example.part2apps.data.model

data class Jokes(
    var id: String,
    var created_at : String,
    var update_at: String,
    var icon_url: String,
    var url: String,
    var value: String,
    var categories: List<String>
)


