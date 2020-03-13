package com.zufe.oams.mapper;

import com.zufe.oams.pojo.Admin;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 **
 * */
@Repository
public interface AdminMapper extends BaseMapper<Admin> {

    //Admin selectById(@Param("id") String id);

    void updatePassword(@Param("id") String id, @Param("newPassword") String newPassword);


}
