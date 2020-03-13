package com.zufe.oams.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zufe.oams.dto.WorkSubmissionDto;
import com.zufe.oams.pojo.WorkSubmission;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Repository
public interface WorkSubmissionMapper extends BaseMapper<WorkSubmission> {

    List<WorkSubmissionDto> selectWorkSubmission(Pagination page,
                                                 @Param("workNo") String workNo,
                                                 @Param("keyword") String keyword,
                                                 @Param("teacherNo") String teacherNo,
                                                 @Param("courseNo") String courseNo,
                                                 @Param("studentNo") String studentNo,
                                                 @Param("status") String status,
                                                 @Param("classesNo") String classesNo);

    void correctionWork(@Param("id") String id, @Param("grade") String grade);

    WorkSubmission selectByWorkNoStudentNo(@Param("workNo") String workNo, @Param("studentNo") String studentNo);
}
