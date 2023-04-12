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
		// Ŀ�ؼ� Ǯ�� DAO �����ڿ� ����
		try{
			Context init = new InitialContext();
	  		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		conn = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	// ȸ������ ȸ�� ���
	public boolean memberInsert(MemberBean member) {
		int num = 0; // ȸ����ȣ�� �ʱ�ȭ�� ����
		String sql = ""; 
		int result=0;

		try {
			pstmt=conn.prepareStatement("SELECT max(MEMBER_NUM) FROM MEMBER");
			rs = pstmt.executeQuery(); // sql���� ��ȸ�Ҷ� ���� �Լ�

			// �Ѹ� ȸ���� ��ȣ +1 �ؼ� �ʱ�ȭ ��Ŵ
			if(rs.next()) { 
				num = rs.getInt(1)+1;
			}
			// ȸ���� ������ ù��°�� 1�� �� 
			else {
				num = 1;
			}

			// �÷��� 12��
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
			System.out.println("DAO : memberInsert ���� : " + e);
			e.printStackTrace();
			
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		
		return false;
	}
	
	// �α���
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
			System.out.println("DAO : memberLogin ���� : " + e);
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn != null) try {conn.close();}catch(SQLException ex) {}
		}
		return false;
	}
	
	// ȸ�����
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
	
	// ȸ�� �������� �����ڿ�
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
	
	// ȸ�� ����.
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
