package com.zufe.oams.mapper;

import com.zufe.oams.pojo.BankFillQue;
import com.zufe.oams.pojo.BankFillQueExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankFillQueMapper {
    int countByExample(BankFillQueExample example);

    int deleteByExample(BankFillQueExample example);

    int deleteByPrimaryKey(Integer fillId);

    int insert(BankFillQue record);

    int insertSelective(BankFillQue record);

    List<BankFillQue> selectByExample(BankFillQueExample example);

    BankFillQue selectByPrimaryKey(Integer fillId);

    int updateByExampleSelective(@Param("record") BankFillQue record, @Param("example") BankFillQueExample example);

    int updateByExample(@Param("record") BankFillQue record, @Param("example") BankFillQueExample example);

    int updateByPrimaryKeySelective(BankFillQue record);

    int updateByPrimaryKey(BankFillQue record);

    List<BankFillQue> getFillQueListByPaperId(Integer paperId);

    List<BankFillQue> getRandomFillByCountAndLangId(@Param("langId") Integer langId, @Param("fillNum") Integer fillNum);
}