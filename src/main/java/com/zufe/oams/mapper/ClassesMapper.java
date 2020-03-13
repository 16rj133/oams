package com.zufe.oams.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.zufe.oams.pojo.Classes;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClassesMapper extends BaseMapper<Classes> {

    Classes selectByCid(@Param("cid") String cid);

    List<Classes> selectClasses(Pagination page,
                                @Param("keyword") String keyword,
                                @Param("type") String type,
                                @Param("cid") String cid);
}
