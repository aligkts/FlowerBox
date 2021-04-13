package com.aligkts.flowerbox.internal.extension

fun <T> List<T>?.thisOrEmptyList() = this ?: emptyList()

/*fun List<MovieGenreEntity>.convertMovieGenres(): List<MovieGenreUiModel> = this.map {
    MovieGenreUiModel(it.id, it.name)
}

fun List<TvShowGenreEntity>.convertTvShowGenres(): List<TvShowGenreUiModel> = this.map {
    TvShowGenreUiModel(it.id, it.name)
}*/
