package com.zufe.oams.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.zufe.oams.pojo.Classes;
import com.zufe.oams.exception.WorkException;
import com.zufe.oams.mapper.ClassesMapper;
import com.zufe.oams.service.ClassesService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2018-04-07
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public void addClasses(Classes classes) {
        Classes classes1 = classesMapper.selectByCid(classes.getCid());
        if (classes1 != null) {
            throw new WorkException("该班级号已存在");
        }
        classesMapper.insert(classes);
    }

    @Override
    public void updateClasses(Classes classes) {
        Classes classes1 = classesMapper.selectByCid(classes.getCid());
        if (classes1 != null && !classes1.getCid().equals(classes.getCid())) {
            throw new WorkException("该班级号已存在");
        }

        classesMapper.updateById(classes);
    }


    @Override
    public Page<Classes> findAll(Page page, String keyword, String type, String id) {
        List<Classes> classesList = classesMapper.selectClasses(page, keyword,type, id);
        return page.setRecords(classesList);
    }
}
