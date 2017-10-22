package com.amazon;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class Amazon_2 {

    public static void main(String[] args) {
        /*
        Movie A = new Movie(1, 1.2f);
        Movie B = new Movie(2, 3.6f);
        Movie C = new Movie(3, 2.4f);
        A.addSimilarMovie(B);
        A.addSimilarMovie(C);
        Movie D = new Movie(4, 4.8f);
        B.addSimilarMovie(D);
        */

        Movie m1 = new Movie(1, 6.2f);

        Movie m2 = new Movie(2, 3.6f);
        Movie m3 = new Movie(3, 2.4f);
        Movie m4 = new Movie(4, 9.8f);
        m1.addSimilarMovie(m2);
        m1.addSimilarMovie(m3);
        m1.addSimilarMovie(m4);

        Movie m5 = new Movie(5, 5.1f);
        Movie m6 = new Movie(6, 8.4f);
        Movie m7 = new Movie(7, 8.4f);
        Movie m8 = new Movie(8, 8.0f);
        m2.addSimilarMovie(m5);
        m2.addSimilarMovie(m1);

        m3.addSimilarMovie(m5);
        m3.addSimilarMovie(m1);

        m4.addSimilarMovie(m6);
        m4.addSimilarMovie(m7);
        m4.addSimilarMovie(m1);

        m6.addSimilarMovie(m7);
        m6.addSimilarMovie(m4);

        m5.addSimilarMovie(m2);
        m5.addSimilarMovie(m3);

        m7.addSimilarMovie(m8);
        m7.addSimilarMovie(m6);
        m7.addSimilarMovie(m4);

        m8.addSimilarMovie(m7);

        System.out.println("Highest rated movies: ");
        System.out.println(getMovieRecommendationsWithoutRecursion(m1, 4));
        //System.out.println(getMovieRecommendations(m1, 4));
    }

    public static Set<Movie> getMovieRecommendations(Movie movie, int N) {
        Stack<Movie> highestMovies = new Stack<>();
        List<Movie> ignoredMovies = new ArrayList<>();
        ignoredMovies.add(movie);

        for (int i = 0;i < N;i++) {
            movieRecommendationsHelper(movie, highestMovies, ignoredMovies);
            System.out.println(highestMovies.peek().getRating());
            ignoredMovies.add(highestMovies.pop());
        }
        ignoredMovies.remove(movie);

        return new HashSet<>(ignoredMovies);
    }

    public static void movieRecommendationsHelper(Movie currentMovie,
                                                  Stack<Movie> highestMovies,
                                                  List<Movie> ignoredMovies) {
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
                if ((o2.getRating() == (o1.getRating())) && (o1.getMovieId() == o2.getMovieId())) {
                    return 0;
                }
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
        visitedMovies.add(movie);

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

        while (topRatedMovies.size() > N) {
            topRatedMovies.pollLast();
        }


        List<Movie> list = new ArrayList<Movie>(N);
        for (Movie m : topRatedMovies) {
            list.add(m);
        }

        return list;
    }
}
