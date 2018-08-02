package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.FileTable;
import cn.scau.myteam.pojo.FileTableExample;
import java.util.List;

public interface FileTableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileTable record);

    int insertSelective(FileTable record);

    List<FileTable> selectByExample(FileTableExample example);

    FileTable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileTable record);

    int updateByPrimaryKey(FileTable record);
}