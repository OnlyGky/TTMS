package com.springboot.richttms.mapper.movie;

import com.springboot.richttms.pojo.movie.Movie;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Mapper
public interface movieMapper {
//    private Integer movieId;
//    private String movieName;
//    private String movieType;
//    private String movieDirect;
//    private String movieActor;
//    private String movieDescription;
//    private String movieAlltime;

    @Insert("insert into ttms_movie values(#{movieId},#{movieName},#{movieType},#{movieDirect},#{movieActor},#{movieDescription},#{movieAlltime},#{movieState})")
    int save(Movie movie);

    /**
     * 查询正在上映的电影
     * @return
     */

    @Select("select * from ttms_movie where movie_id=#{id}")
    Movie queryByID(Integer id);

    @Select("select * from ttms_movie where movie_state=#{state}")
    List<Movie> query(Integer state);

    @Update("update ttms_movie set movie_name=#{movieName},movie_type=#{movieType},movie_direct=#{movieDirect},movie_actor=#{movieActor},movie_description=#{movieDescription},movie_alltime=#{movieAlltime},movie_state=#{movieState} where movie_id=#{movieId}")
    int update(Movie movie);

    @Delete("delete from ttms_movie where movie_id=#{id}")
    int delete(Integer id);


    @Select("select img from ttms_movie where movie_id=#{movieId}")
    String queryimg(Integer movieId);

@Select("select movie_name from ttms_movie where movie_id=#{getmId}")
    String queryName(Integer getmId);
}
