package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.ProjectPhase;
import cn.scau.myteam.pojo.ProjectPhaseExample;
import java.util.List;

public interface ProjectPhaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPhase record);

    int insertSelective(ProjectPhase record);

    List<ProjectPhase> selectByExample(ProjectPhaseExample example);

    ProjectPhase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectPhase record);

    int updateByPrimaryKey(ProjectPhase record);
}