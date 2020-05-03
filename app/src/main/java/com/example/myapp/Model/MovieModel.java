package com.example.myapp.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class MovieModel {
    private final List<Results> results;

    private final int page;

    private final int totalResults;

    private final Dates dates;

    private final int totalPages;

    public MovieModel(List<Results> results, int page, int totalResults, Dates dates,
                      int totalPages) {
        this.results = results;
        this.page = page;
        this.totalResults = totalResults;
        this.dates = dates;
        this.totalPages = totalPages;
    }

    public List<Results> getResults() {
        return results;
    }

    public int getPage() {
        return page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public Dates getDates() {
        return dates;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public static class Results {
        private final double popularity;

        private final int voteCount;

        private final boolean video;

        private final String posterPath;

        private final int id;

        private final boolean adult;

        private final String backdropPath;

        private final String originalLanguage;

        private final String originalTitle;

        private final List<Integer> genreIds;

        private final String title;

        private final double voteAverage;

        private final String overview;

        private final String releaseDate;

        public Results(double popularity, int voteCount, boolean video, String posterPath, int id,
                       boolean adult, String backdropPath, String originalLanguage, String originalTitle,
                       List<Integer> genreIds, String title, double voteAverage, String overview,
                       String releaseDate) {
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.video = video;
            this.posterPath = posterPath;
            this.id = id;
            this.adult = adult;
            this.backdropPath = backdropPath;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.genreIds = genreIds;
            this.title = title;
            this.voteAverage = voteAverage;
            this.overview = overview;
            this.releaseDate = releaseDate;
        }

        public double getPopularity() {
            return popularity;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public boolean isVideo() {
            return video;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public int getId() {
            return id;
        }

        public boolean isAdult() {
            return adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public String getTitle() {
            return title;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }
    }

    public static class Dates {
        private final String maximum;

        private final String minimum;

        public Dates(String maximum, String minimum) {
            this.maximum = maximum;
            this.minimum = minimum;
        }

        public String getMaximum() {
            return maximum;
        }

        public String getMinimum() {
            return minimum;
        }
    }
}