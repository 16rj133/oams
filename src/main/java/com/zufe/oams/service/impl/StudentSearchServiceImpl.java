package com.zufe.oams.service.impl;

import com.zufe.oams.mapper.PaperMapper;
import com.zufe.oams.mapper.ProgramingLanguageMapper;
import com.zufe.oams.pojo.Paper;
import com.zufe.oams.pojo.PaperExample;
import com.zufe.oams.pojo.ProgramingLanguage;
import com.zufe.oams.service.StudentSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentSearchServiceImpl implements StudentSearchService{

    @Autowired
    PaperMapper paperMapper;
    @Autowired
    ProgramingLanguageMapper programingLanguageMapper;

    @Override
    public List<Map<String, Object>> getSearchPapers(String keyword) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        PaperExample paperExample = new PaperExample();
        PaperExample.Criteria criteria = paperExample.createCriteria();
        criteria.andPaperNameLike("%" + keyword + "%");
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList){
            Map<String, Object> map = new HashMap<>();
            map.put("paperId",paper.getPaperId());
            map.put("paperName",paper.getPaperName());
            map.put("paperCreateTime",paper.getPaperCreateTime());
            map.put("paperDuration",paper.getPaperDuration());
            map.put("paperDifficulty",paper.getPaperDifficulty());
            map.put("paperType",paper.getPaperType());
            map.put("participateNum",paper.getParticipateNum());
            ProgramingLanguage programingLanguage = programingLanguageMapper.selectByPrimaryKey(paper.getLangId());
            map.put("langName",programingLanguage.getLangName());
            map.put("langImgSrc",programingLanguage.getLangImgSrc());
            resultList.add(map);
        }
        return resultList;
    }
}
