package com.springboot.richttms.service.movie;

import com.springboot.richttms.pojo.movie.Movie;

import java.util.List;

public interface movieService {
    int save(String json);

    List<Movie> query(Integer state);

    int update(String json);

    int delete(Integer id);
}
