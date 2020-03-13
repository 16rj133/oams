package com.zufe.oams.service.impl;

import com.zufe.oams.mapper.PaperMapper;
import com.zufe.oams.mapper.StudentMapper;
import com.zufe.oams.mapper.StudentPaperAnswerMapper;
import com.zufe.oams.mapper.StudentPaperScoreMapper;
import com.zufe.oams.pojo.*;
import com.zufe.oams.service.StudentHomeService;
import com.zufe.oams.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeacherStudentServiceImpl  implements TeacherStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentPaperScoreMapper studentPaperScoreMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    StudentPaperAnswerMapper studentPaperAnswerMapper;
    @Autowired
    StudentHomeService studentHomeService;


    @Override
    public int updateStudentInfo(Student student) {
        int result = studentMapper.updateAllColumnById(student);
        return result;
    }

    @Override
    public int insertStudentInfo(Student student) {
        int result = studentMapper.insert(student);
        return result;
    }

    @Override
    public List<Map<String, Object>> getScoresList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        StudentPaperScoreExample studentPaperScoreExample = new StudentPaperScoreExample();
        studentPaperScoreExample.setOrderByClause("sno asc");
        List<StudentPaperScore> studentPaperScoreList = studentPaperScoreMapper.selectByExample(studentPaperScoreExample);
        for (StudentPaperScore studentPaperScore : studentPaperScoreList){
            Map<String, Object> map = new HashMap<>();
            Student student = studentMapper.selectByPrimaryKey(studentPaperScore.getSno());
            Paper paper = paperMapper.selectByPrimaryKey(studentPaperScore.getPaperId());
            map.put("paperId", studentPaperScore.getPaperId());
            long timeUsed = 0;
            if( studentPaperScore.getTimeUsed() != null){
                timeUsed = studentPaperScore.getEndTime().getTime() - studentPaperScore.getStartTime().getTime();
            }
            map.put("timeUsed", timeUsed);
            map.put("sno", student.getId());
            map.put("stuName", student.getName());
            //map.put("stuImgSrc", student.getStuImgSrc());
            map.put("paperName", paper.getPaperName());
            map.put("score", studentPaperScore.getScore());
            map.put("startTime", studentPaperScore.getStartTime());
            map.put("endTime", studentPaperScore.getEndTime());
            resultList.add(map);
        }
        return resultList;
    }
    @Override
    public List<Map<String, Object>> getPapersList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        PaperExample paperExample = new PaperExample();
        paperExample.setOrderByClause("paper_id asc");
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList) {
            Map<String, Object> map = new HashMap<>();
            map.put("label",paper.getPaperName());
            map.put("key",paper.getPaperId());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int deleteScore(String sno, Integer paperId) {
        // 删除paper_answer表该学生该试卷信息
        StudentPaperAnswerExample studentPaperAnswerExample = new StudentPaperAnswerExample();
        StudentPaperAnswerExample.Criteria criteria1 = studentPaperAnswerExample.createCriteria();
        criteria1.andSnoEqualTo(sno);
        criteria1.andPaperIdEqualTo(paperId);
        int answerResult = studentPaperAnswerMapper.deleteByExample(studentPaperAnswerExample);
        //  删除paper_score表该学生试卷信息
        StudentPaperScoreExample studentPaperScoreExample = new StudentPaperScoreExample();
        StudentPaperScoreExample.Criteria criteria = studentPaperScoreExample.createCriteria();
        criteria.andSnoEqualTo(sno);
        criteria.andPaperIdEqualTo(paperId);
        int result = studentPaperScoreMapper.deleteByExample(studentPaperScoreExample);
        // 更新试卷已参加人数字段
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        int participateNum = paper.getParticipateNum() - 1;
        paper.setParticipateNum(participateNum);
        paperMapper.updateByPrimaryKeySelective(paper);
        return result;
    }

    @Override
    public List<Map<String, Object>> searchScoresList(String sno, Integer paperId) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        StudentPaperScoreExample studentPaperScoreExample = new StudentPaperScoreExample();
        StudentPaperScoreExample.Criteria criteria = studentPaperScoreExample.createCriteria();
        if (!sno.equals("undefined")){
            criteria.andSnoLike("%" + sno + "%");
        }
        if (paperId != 0){
            criteria.andPaperIdEqualTo(paperId);
        }
        studentPaperScoreExample.setOrderByClause("sno asc");
        List<StudentPaperScore> studentPaperScoreList = studentPaperScoreMapper.selectByExample(studentPaperScoreExample);
        for (StudentPaperScore studentPaperScore : studentPaperScoreList){
            Map<String, Object> mapSearch = new HashMap<>();
            Student student = studentMapper.selectByPrimaryKey(studentPaperScore.getSno());
            Paper paper = paperMapper.selectByPrimaryKey(studentPaperScore.getPaperId());
            long timeUsed = 0;
            if( studentPaperScore.getTimeUsed() != null){
                timeUsed = studentPaperScore.getEndTime().getTime() - studentPaperScore.getStartTime().getTime();
            }
            mapSearch.put("timeUsed", timeUsed);
            mapSearch.put("paperId", studentPaperScore.getPaperId());
            mapSearch.put("sno", student.getId());
            mapSearch.put("stuName", student.getName());
            //mapSearch.put("stuImgSrc", student.getStuImgSrc());
            mapSearch.put("paperName", paper.getPaperName());
            mapSearch.put("score", studentPaperScore.getScore());
            mapSearch.put("startTime", studentPaperScore.getStartTime());
            mapSearch.put("endTime", studentPaperScore.getEndTime());
            resultList.add(mapSearch);
        }
        return resultList;
    }

    @Override
    public Map<String, Object> getChartData(Integer paperId) {
        Map<String, Object> map = new HashMap<>();
        StudentPaperScoreExample studentPaperScoreExample = new StudentPaperScoreExample();
        StudentPaperScoreExample.Criteria criteria = studentPaperScoreExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        List<StudentPaperScore> studentPaperScoreList = studentPaperScoreMapper.selectByExample(studentPaperScoreExample);

        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        Map<String, Integer> queNum = studentHomeService.getPaperQueNumByPaperId(paperId);
        int totalScore = queNum.get("singleNum")*paper.getSingleScore()
                + queNum.get("multipleNum")*paper.getMultipleScore()
                + queNum.get("judgeNum")*paper.getJudgeScore()
                + queNum.get("fillNum")*paper.getFillScore();
        Map<String, Object> paperInfo = new HashMap<>();
        paperInfo.put("paperName",paper.getPaperName());
        paperInfo.put("paperDuration",paper.getPaperDuration());
        paperInfo.put("paperDifficulty",paper.getPaperDifficulty());
        paperInfo.put("totalScore",totalScore);
        map.put("paperInfo",paperInfo);

        String[] snoData = new String[studentPaperScoreList.size()];
        int[] singleData = new int[studentPaperScoreList.size()];
        int[] multipleData = new int[studentPaperScoreList.size()];
        int[] judgeData = new int[studentPaperScoreList.size()];
        int[] fillData = new int[studentPaperScoreList.size()];
        int[] scoreData = new int[studentPaperScoreList.size()];
        long[] timeUsedData = new long[studentPaperScoreList.size()];
//        List<String> snoData = new ArrayList<>();
//        List<Integer> singleData = new ArrayList<>();
//        List<Integer> multipleData = new ArrayList<>();
//        List<Integer> judgeData = new ArrayList<>();
//        List<Integer> fillData = new ArrayList<>();
//        List<Integer> scoreData = new ArrayList<>();
//        List<Long> timeUsedData = new ArrayList<>();

        for (StudentPaperScore studentPaperScore : studentPaperScoreList){
            int i = studentPaperScoreList.indexOf(studentPaperScore);
            String sno = studentPaperScore.getSno();
            Student student = studentMapper.selectByPrimaryKey(sno);
//            snoData.add(sno + "(" + student.getStuName() + ")");
//            snoData.add(student.getStuName());
            snoData[i] = sno + "(" + student.getName() + ")";

            int single = 0;
            int multiple = 0;
            int judge = 0;
            int fill = 0;
            int score = 0;
            if(studentPaperScore.getScore() != null){
                StudentPaperAnswer studentPaperAnswerCorrect = new StudentPaperAnswer();
                studentPaperAnswerCorrect.setSno(sno);
                studentPaperAnswerCorrect.setPaperId(paperId);
                single = studentPaperAnswerMapper.selectSingleCorrectCount(studentPaperAnswerCorrect)*paper.getSingleScore();
                multiple = studentPaperAnswerMapper.selectMultipleCorrectCount(studentPaperAnswerCorrect)*paper.getMultipleScore();
                judge = studentPaperAnswerMapper.selectJudgeCorrectCount(studentPaperAnswerCorrect)*paper.getJudgeScore();
                fill = studentPaperAnswerMapper.selectFillCorrectCount(studentPaperAnswerCorrect)*paper.getFillScore();
                score = studentPaperScore.getScore();
            }
//            singleData.add(single);
//            multipleData.add(multiple);
//            judgeData.add(judge);
//            fillData.add(fill);
//            scoreData.add(score);
            singleData[i] = single;
            multipleData[i] = multiple;
            judgeData[i] = judge;
            fillData[i] = fill;
            scoreData[i] = score;

            long timeUsed = 0;
            if( studentPaperScore.getTimeUsed() != null){
                timeUsed = (studentPaperScore.getEndTime().getTime() - studentPaperScore.getStartTime().getTime())/1000;
            }
//            timeUsedData.add(timeUsed);
            timeUsedData[i] =timeUsed;
        }
        map.put("snoData",snoData);
        map.put("singleData",singleData);
        map.put("multipleData",multipleData);
        map.put("judgeData",judgeData);
        map.put("fillData",fillData);
        map.put("scoreData",scoreData);
        map.put("timeUsedData",timeUsedData);
        return map;
    }


}
