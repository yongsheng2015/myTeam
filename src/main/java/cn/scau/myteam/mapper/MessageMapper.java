package cn.scau.myteam.mapper;

import cn.scau.myteam.pojo.Message;
import cn.scau.myteam.pojo.MessageExample;
import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}