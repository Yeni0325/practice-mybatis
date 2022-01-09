package com.ye.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ye.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}

}
