package com.ye.mybatis.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.ye.mybatis.common.template.Template.*;
import com.ye.mybatis.member.model.dao.MemberDao;
import com.ye.mybatis.member.model.vo.Member;

public class MemberServiceImpl implements MemberService{
	
	private MemberDao mDao = new MemberDao();

	@Override
	public int insertMember(Member m) {
		// Template클래스에 있는 getSqlSession() 메소드 호출로 mybatis-config.xml 파일 읽어들여서 
		// 해당 DB와 접속된 SqlSession 객체를 받아볼 수 있음!!
		
		SqlSession sqlSession = getSqlSession();
		// 이 때 mybatis-config.xml 문서 읽어들임
		// 이 때 등록시킨 mapper.xml 문서들도 다 읽어들여짐
		
		int result = mDao.insertMember(sqlSession, m);

		if(result > 0) {
			sqlSession.commit();
		} 
		
		/* "하나"의 sql문 만을 실행할 때는 굳이 실패했을 때 rollback을 실행할 필요가 없음! */
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Member loginMember(Member m) {
		SqlSession sqlSession = getSqlSession();
		Member loginUser = mDao.loginMember(sqlSession, m);
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
