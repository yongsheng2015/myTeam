package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.ObjectTable;
import cn.scau.myteam.pojo.ObjectTableExample;
import java.util.List;

public interface ObjectTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ObjectTable record);

    int insertSelective(ObjectTable record);

    List<ObjectTable> selectByExample(ObjectTableExample example);

    ObjectTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ObjectTable record);

    int updateByPrimaryKey(ObjectTable record);
}