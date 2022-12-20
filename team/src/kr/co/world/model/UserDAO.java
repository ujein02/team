package kr.co.world.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.world.dto.UserDTO;
import kr.co.world.service.AES256;

public class UserDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String key = "%02x";
	
		public int idCheckPro(String userId){	//중복 아이디 체크 / 회원가입시 가입전 체크
			int cnt = 0;
			try {
				con = Oracle.getConnection();
				pstmt = con.prepareStatement(Oracle.USER_ID_CHECK);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				if(rs.next()){ cnt = cnt + 1;	} else { cnt = 0;	}
			} catch(ClassNotFoundException e){
				System.out.println("드라이버 로딩 실패");
			} catch(Exception e){
				System.out.println("SQL 구문이 처리되지 못했거나 연산이 잘못되었습니다.");
			} finally {
				Oracle.close(rs, pstmt, con);
			}
			return cnt;
		}
	
		//회원 가입
		public int addUser(UserDTO user){
			int cnt = 0;
			try {
				con = Oracle.getConnection();
				//읽은 횟수 증가
				pstmt = con.prepareStatement(Oracle.USER_JOIN);
				//id, pw, name, birth, email, tel, address
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getUserPw());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getBirth());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getTel());
				pstmt.setString(7, user.getAddress());
				cnt = pstmt.executeUpdate();
			} catch(ClassNotFoundException e){
				System.out.println("드라이버 로딩 실패");
				e.printStackTrace();
			} catch(SQLException e){
				System.out.println("SQL 구문이 처리되지 못했습니다.");
				e.printStackTrace();
			} catch(Exception e){
				System.out.println("잘못된 연산 및 요청으로 인해 목록을 불러오지 못했습니다.");
			} finally {
				Oracle.close(pstmt, con);
			}
			return cnt;
		}
		
		
	}