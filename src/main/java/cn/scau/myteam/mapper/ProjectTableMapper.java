package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.ProjectTable;
import cn.scau.myteam.pojo.ProjectTableExample;
import java.util.List;

public interface ProjectTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectTable record);

    int insertSelective(ProjectTable record);

    List<ProjectTable> selectByExample(ProjectTableExample example);

    ProjectTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectTable record);

    int updateByPrimaryKey(ProjectTable record);
}