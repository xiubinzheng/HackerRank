package com.amazon;

import java.util.ArrayList;

/**
 * @author Anatoly Chernysh
 */
public class Movie {

  private int movieId;
  private float rating;
  private ArrayList<Movie> similarMovies = new ArrayList<>();

  public Movie(int movieId, float rating) {
    this.movieId = movieId;
    this.rating = rating;
  }

  public int getMovieId() {
    return movieId;
  }

  public void setMovieId(int movieId) {
    this.movieId = movieId;
  }

  public float getRating() {
    return rating;
  }

  public void setRating(float rating) {
    this.rating = rating;
  }

  public ArrayList<Movie> getSimilarMovies() {
    return similarMovies;
  }

  public void addSimilarMovie(Movie movie) {
    this.similarMovies.add(movie);
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (movieId != movie.movieId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return movieId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("movieId=").append(movieId);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}