package com.springboot.richttms.service.schedule;

import com.springboot.richttms.pojo.movie.Movie;
import com.springboot.richttms.pojo.schedule.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface scheduleService {
    int save(String json);

    List<Schedule> query();

    int deleteByHallId(Integer id) ;

    List<Schedule> queryBymId(Integer mId);

    List<Movie> queryBycId(Integer hId);

    int update(String json);

    List<Schedule> queryMovieSchedulr(Integer cId, Integer mId);
}
