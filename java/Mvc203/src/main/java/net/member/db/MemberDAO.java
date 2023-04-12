package net.member.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.*;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
		// 커넥션 풀을 DAO 생성자에 삽입
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	// 회원가입 회원 등록
	public boolean memberInsert(MemberBean member) {
		int num = 0; // 회원번호를 초기화할 변수
		String sql = ""; 
		int result=0;

		try {
			pstmt=conn.prepareStatement("SELECT max(MEMBER_NUM) FROM MEMBER");
			rs = pstmt.executeQuery(); // sql문을 조회할때 쓰는 함수

			// 한명씩 회원의 번호 +1 해서 초기화 시킴
			if(rs.next()) { 
				num = rs.getInt(1)+1;
			}
			// 회원이 없으면 첫번째는 1이 들어감 
			else {
				num = 1;
			}

			// 컬럼은 12개
			sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getName());
			pstmt.setString(6, member.getAddarr());
			pstmt.setString(7, member.getPin());
			pstmt.setString(8, member.getYear());
			pstmt.setString(9, member.getMonth());
			pstmt.setString(10, member.getDay());
			pstmt.setString(11, member.getHobbyarr());
			pstmt.setString(12, member.getIntro());

			result = pstmt.executeUpdate();
			if(result==0) { 
				return false;
			}
			return true;
			
		}catch(Exception e) {
			System.out.println("DAO : memberInsert 에러 : " + e);
			e.printStackTrace();
			
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return false;
	}
	
	// 로그인
	public boolean memberLogin(MemberBean member) {
		String sql = "SELECT id, pw FROM MEMBER where id ='" + member.getId() + "'";
//		member.getId();
//		member.getPw();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(2).equals(member.getPw())) {
					return true;
				}
			}
			return false;
		}catch(Exception e) {
			System.out.println("DAO : memberLogin 에러 : " + e);
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return false;
	}
	
	// 회원목록
	public ArrayList<Object> memberList() {
		String sql = "SELECT * FROM MEMBER";
		ArrayList<Object> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setAddarr2(rs.getString("addr"));
				member.setPin(rs.getString("pin"));
				member.setYear(rs.getString("year"));
				member.setMonth(rs.getString("month"));
				member.setDay(rs.getString("day"));
				member.setHobbyarr2(rs.getString("hobby"));
				member.setIntro(rs.getString("intro"));
				list.add(member);
			}
			
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return null;
	}
	
	// 회원 개인정보 관리자용
	public MemberBean memberInfo(MemberBean m) {
		String sql = "SELECT * FROM MEMBER WHERE ID='"+m.getId()+"'";
		MemberBean member = new MemberBean();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setAddarr2(rs.getString("addr"));
				member.setPin(rs.getString("pin"));
				member.setYear(rs.getString("year"));
				member.setMonth(rs.getString("month"));
				member.setDay(rs.getString("day"));
				member.setHobbyarr2(rs.getString("hobby"));
				member.setIntro(rs.getString("intro"));
				
				return member;
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return null;
	}
	
	// 회원 삭제.
	public boolean memberDelete(String id) {
		String sql = "DELETE FROM MEMBER WHERE ID='"+id+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			
			if(result != 0) {
				return true;
			}
			
			return false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return false;
		
	}
}
