package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.SubTaskExample;
import cn.scau.myteam.pojo.SubTaskKey;
import java.util.List;

public interface SubTaskMapper {
    int deleteByPrimaryKey(SubTaskKey key);

    int insert(SubTaskKey record);

    int insertSelective(SubTaskKey record);

    List<SubTaskKey> selectByExample(SubTaskExample example);
}