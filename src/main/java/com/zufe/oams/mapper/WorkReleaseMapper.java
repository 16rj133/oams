package com.zufe.oams.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zufe.oams.dto.WorkReleaseDto;
import com.zufe.oams.pojo.WorkRelease;
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
public interface WorkReleaseMapper extends BaseMapper<WorkRelease> {

    List<WorkReleaseDto> selectWorkRelease(Pagination page,
                                           @Param("keyword") String keyword,
                                           @Param("teacherNo") String teacherNo);

    List<WorkReleaseDto> selectWorkReleaseForStudent(Pagination page,
                                                     @Param("keyword") String keyword,
                                                     @Param("studentNo") String studentNo);
}
