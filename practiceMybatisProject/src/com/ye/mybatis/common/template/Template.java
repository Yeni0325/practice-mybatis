package com.ye.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해서 => SqlSessionFactory 필요
		// SqlSessionFactory생성하기 위해서 => SqlSessionFactoryBuilder필요
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream steam = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(steam).openSession(false);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return sqlSession;
	}
	
	
	
}
