package com.amazon;

import java.util.*;

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
        System.out.println(getMovieRecommendationsWithoutRecursion(A, 2));
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

    public static List<Movie> getMovieRecommendationsWithoutRecursion(Movie movie, int N) {
        if (movie == null) {
            return null;
        }

        class MovieComparatorByRating implements Comparator<Movie> {
            public int compare(Movie o1, Movie o2) {
                return (o2.getRating() - o1.getRating()) > 0 ? 1 : -1;
            }
        }

        LinkedList<Movie> queue = new LinkedList<>();
        queue.addAll(movie.getSimilarMovies());

        TreeSet<Movie> topRatedMovies = new TreeSet<>(new MovieComparatorByRating());
        topRatedMovies.addAll(movie.getSimilarMovies());
        while (topRatedMovies.size() > N) {
            topRatedMovies.pollLast();
        }

        HashSet<Movie> visitedMovies = new HashSet<>();

        while (!queue.isEmpty()) {
            Movie m = queue.poll();
            for (Movie mm : m.getSimilarMovies()) {
                if (!visitedMovies.contains(mm)) {
                    queue.add(mm);
                    visitedMovies.add(mm);
                    topRatedMovies.add(mm);

                    while (topRatedMovies.size() > N) {
                        topRatedMovies.pollLast();
                    }
                }
            }
        }

        List<Movie> list = new ArrayList<Movie>(N);
        for (Movie m : topRatedMovies) {
            list.add(m);
        }

        return list;
    }
}
