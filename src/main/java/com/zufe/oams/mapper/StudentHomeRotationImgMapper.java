package com.zufe.oams.mapper;

import com.zufe.oams.pojo.StudentHomeRotationImg;
import com.zufe.oams.pojo.StudentHomeRotationImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentHomeRotationImgMapper {
    int countByExample(StudentHomeRotationImgExample example);

    int deleteByExample(StudentHomeRotationImgExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(StudentHomeRotationImg record);

    int insertSelective(StudentHomeRotationImg record);

    List<StudentHomeRotationImg> selectByExample(StudentHomeRotationImgExample example);

    StudentHomeRotationImg selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") StudentHomeRotationImg record, @Param("example") StudentHomeRotationImgExample example);

    int updateByExample(@Param("record") StudentHomeRotationImg record, @Param("example") StudentHomeRotationImgExample example);

    int updateByPrimaryKeySelective(StudentHomeRotationImg record);

    int updateByPrimaryKey(StudentHomeRotationImg record);
}