package com.ye.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ye.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		
		//Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
		// selectOne() : 조회 결과가 없다면 null반환
		
		//return loginUser;
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	
	
	
	
	
	
	
	
	
}
