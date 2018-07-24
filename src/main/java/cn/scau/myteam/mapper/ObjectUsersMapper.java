package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.ObjectUsersExample;
import cn.scau.myteam.pojo.ObjectUsersKey;
import java.util.List;

public interface ObjectUsersMapper {
    int deleteByPrimaryKey(ObjectUsersKey key);

    int insert(ObjectUsersKey record);

    int insertSelective(ObjectUsersKey record);

    List<ObjectUsersKey> selectByExample(ObjectUsersExample example);
}