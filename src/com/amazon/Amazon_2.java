package com.amazon;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Anatoly Chernysh
 */
public class Amazon_2 {

    public static void main(String[] args) {
        Movie A = new Movie(1, 1.2f);
        Movie B = new Movie(2, 3.6f);
        Movie C = new Movie(3, 2.4f);
        A.addSimilarMovie(B);
        A.addSimilarMovie(C);
        Movie D = new Movie(4, 4.8f);
        B.addSimilarMovie(D);
        System.out.println("Highest rated movies: ");
        // the result should be B, D
        System.out.println(getMovieRecommendations(A, 2));
    }

    public static Set<Movie> getMovieRecommendations(Movie movie, int N) {
        Stack<Movie> highestMovies = new Stack<>();
        Set<Movie> ignoredMovies = new HashSet<>();
        ignoredMovies.add(movie);

        for (int i = 0;i < N;i++) {
            movieRecommendationsHelper(movie, highestMovies, ignoredMovies);
            System.out.println(highestMovies.peek().getRating());
            ignoredMovies.add(highestMovies.pop());
        }
        ignoredMovies.remove(movie);
        return ignoredMovies;
    }

    public static void movieRecommendationsHelper(Movie currentMovie,
                                                  Stack<Movie> highestMovies,
                                                  Set<Movie> ignoredMovies) {
        Movie highestMovie = highestMovies.size() == 0 ? null : highestMovies.peek();
        if (highestMovie == null) {
            highestMovies.push(currentMovie);
            movieRecommendationsHelper(currentMovie, highestMovies, ignoredMovies);
        }
        else if (highestMovie.getRating() < currentMovie.getRating()) {
            highestMovies.pop();
            highestMovies.push(currentMovie);
            movieRecommendationsHelper(currentMovie, highestMovies, ignoredMovies);
        }
        else {
            for (int i = 0;i < currentMovie.getSimilarMovies().size();i++) {
                Movie similarMovie = currentMovie.getSimilarMovies().get(i);

                if (!ignoredMovies.contains(similarMovie)) {
                    if (highestMovies.peek().getRating() < similarMovie.getRating()) {
                        highestMovies.pop();
                        highestMovies.push(similarMovie);
                        movieRecommendationsHelper(similarMovie, highestMovies, ignoredMovies);
                    }
                }
            }
        }
    }
}
