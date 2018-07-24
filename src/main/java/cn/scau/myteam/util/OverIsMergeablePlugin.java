package cn.scau.myteam.util;

import java.lang.reflect.Field;
import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

public class OverIsMergeablePlugin extends PluginAdapter{

	@Override
	public boolean validate(List<String> arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
		// TODO Auto-generated method stub
		try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
	}

}
