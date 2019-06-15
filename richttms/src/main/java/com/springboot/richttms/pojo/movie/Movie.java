package com.springboot.richttms.pojo.movie;

public class Movie {
    private Integer movieId;
    private String movieName;
    private String movieType;
//    private String movieDirect;
    private String movieActor;
//    private String movieDescription;
    private String movieAlltime;
//    private Integer movieState;
    private String sc;
    private String img;

    public Movie() {
    }

//    public Movie(Integer movieId, String movieName, String movieType, String movieActor, String movieAlltime, String sc) {
//        this.movieId = movieId;
//        this.movieName = movieName;
//        this.movieType = movieType;
//        this.movieActor = movieActor;
//        this.movieAlltime = movieAlltime;
//        this.sc = sc;
//    }

    public Movie(Integer movieId, String movieName, String movieType, String movieActor, String movieAlltime, String sc, String img) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.movieActor = movieActor;
        this.movieAlltime = movieAlltime;
        this.sc = sc;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieAlltime() {
        return movieAlltime;
    }

    public void setMovieAlltime(String movieAlltime) {
        this.movieAlltime = movieAlltime;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieType='" + movieType + '\'' +
                ", movieActor='" + movieActor + '\'' +
                ", movieAlltime='" + movieAlltime + '\'' +
                ", sc='" + sc + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
