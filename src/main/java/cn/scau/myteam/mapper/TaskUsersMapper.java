package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.TaskUsersExample;
import cn.scau.myteam.pojo.TaskUsersKey;
import java.util.List;

public interface TaskUsersMapper {
    int deleteByPrimaryKey(TaskUsersKey key);

    int insert(TaskUsersKey record);

    int insertSelective(TaskUsersKey record);

    List<TaskUsersKey> selectByExample(TaskUsersExample example);
}