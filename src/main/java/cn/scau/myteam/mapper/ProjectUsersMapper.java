package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.ProjectUsersExample;
import cn.scau.myteam.pojo.ProjectUsersKey;
import java.util.List;

public interface ProjectUsersMapper {
    int deleteByPrimaryKey(ProjectUsersKey key);

    int insert(ProjectUsersKey record);

    int insertSelective(ProjectUsersKey record);

    List<ProjectUsersKey> selectByExample(ProjectUsersExample example);
}