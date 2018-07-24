package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.Share;
import cn.scau.myteam.pojo.ShareExample;
import java.util.List;

public interface ShareMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Share record);

    int insertSelective(Share record);

    List<Share> selectByExample(ShareExample example);

    Share selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);
}