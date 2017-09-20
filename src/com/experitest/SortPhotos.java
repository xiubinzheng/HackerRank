package com.experitest;

import java.util.*;

/**
 * @author Anatoly Chernysh
 */
public class SortPhotos {

    public static class Photo {

        private String name;

        private String city;

        private String timestamp;

        public Photo(String name, String city, String timestamp) {
            this.name = name;
            this.city = city;
            this.timestamp = timestamp;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Photo)) return false;

            Photo photo = (Photo) o;

            if (city != null ? !city.equals(photo.city) : photo.city != null) return false;
            if (name != null ? !name.equals(photo.name) : photo.name != null) return false;
            if (timestamp != null ? !timestamp.equals(photo.timestamp) : photo.timestamp != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (city != null ? city.hashCode() : 0);
            result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
            return result;
        }
    }

    private static List<Photo> createPhotos(String rawPhotos) {
        final String []nonFormattedPhotos = rawPhotos.split("\\n");
        final List<Photo> photos = new ArrayList<>();

        for (String nonFormattedPhoto : nonFormattedPhotos) {
            String []photoInfo = nonFormattedPhoto.split(",");
            photos.add(new Photo(photoInfo[0].trim(), photoInfo[1].trim(), photoInfo[2].trim()));
        }

        return photos;
    }

    private static Map<String, List<Photo>> groupPhotosByCity(List<Photo> photos) {
        final Map<String, List<Photo>> photosGroupedByCity = new HashMap<>();

        for (Photo photo : photos) {
            if (photosGroupedByCity.containsKey(photo.getCity())) {
                photosGroupedByCity.get(photo.getCity()).add(photo);
            }
            else {
                List<Photo> newPhotoList = new ArrayList<>();
                newPhotoList.add(photo);
                photosGroupedByCity.put(photo.getCity(), newPhotoList);
            }
        }

        return photosGroupedByCity;
    }

    private static String getFileExtension(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i);
        }

        return extension;
    }

    private static String createNewPhotoNames(List<Photo> photos, Map<String, List<Photo>> photosGroupedByCity) {
        final StringBuilder newPhotoNames = new StringBuilder();
        for (Photo photo : photos) {
            List<Photo> photosByCity  = photosGroupedByCity.get(photo.getCity());
            Collections.sort(photosByCity, new Comparator<Photo>() {
                @Override
                public int compare(Photo o1, Photo o2) {
                    return o1.getTimestamp().compareTo(o2.getTimestamp());
                }
            });

            int photoIndex = photosByCity.indexOf(photo) + 1;
            newPhotoNames.append(photo.getCity()); // city
            newPhotoNames.append(String.format("%0" + String.valueOf(photosByCity.size()).length() + "d", photoIndex) ); // photo number
            newPhotoNames.append(getFileExtension(photo.getName())); // file extension
            newPhotoNames.append("\n");
        }

        return newPhotoNames.toString();
    }

    public static String solution(String S) {
        final List<Photo> photos = createPhotos(S);
        final Map<String, List<Photo>> photosGroupedByCity = groupPhotosByCity(photos);
        return createNewPhotoNames(photos, photosGroupedByCity);
    }


    public static void main(String[] args) {
        String s = "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                + "john.png, London, 2015-06-20 15:13:22\n"
                + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
                + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
                + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
                + "e.jpg, Warsaw, 2016-01-02 09:49:09\n"
                + "f.jpg, Warsaw, 2016-01-02 10:55:32\n"
                + "g.jpg, Warsaw, 2016-02-29 22:13:11";
        System.out.println(solution(s));
    }
}
