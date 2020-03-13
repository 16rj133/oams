package com.zufe.oams.mapper;

import com.zufe.oams.pojo.ProgramingLanguage;
import com.zufe.oams.pojo.ProgramingLanguageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramingLanguageMapper {
    int countByExample(ProgramingLanguageExample example);

    int deleteByExample(ProgramingLanguageExample example);

    int deleteByPrimaryKey(Integer langId);

    int insert(ProgramingLanguage record);

    int insertSelective(ProgramingLanguage record);

    List<ProgramingLanguage> selectByExample(ProgramingLanguageExample example);

    ProgramingLanguage selectByPrimaryKey(Integer langId);

    int updateByExampleSelective(@Param("record") ProgramingLanguage record, @Param("example") ProgramingLanguageExample example);

    int updateByExample(@Param("record") ProgramingLanguage record, @Param("example") ProgramingLanguageExample example);

    int updateByPrimaryKeySelective(ProgramingLanguage record);

    int updateByPrimaryKey(ProgramingLanguage record);
}