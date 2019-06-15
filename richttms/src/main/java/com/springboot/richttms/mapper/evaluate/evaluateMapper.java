package com.springboot.richttms.mapper.evaluate;

import com.springboot.richttms.pojo.evaluate.Evaluate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface evaluateMapper {
//    private Integer evaluateId;
//    private Integer cId;
//    private Integer mId;
//    private String evaluateContext;
//    private Integer evaluateRole;

    @Insert("insert into ttms_evaluate values(#{evaluateId},#{cId},#{mId},#{evaluateContext},#{evaluateRole})")
    int save(Evaluate evaluate);

    @Delete("delete from ttms_evaluate where evaluate_id=#{id}")
    int delete(Integer id);

    @Select("select * from ttms_evaluate where c_id=#{cId}")
    List<Evaluate> queryBycId(Integer cId);

    @Select("select * from ttms_evaluate where m_id=#{mId}")
    List<Evaluate> queryBymId(Integer mId);
}
