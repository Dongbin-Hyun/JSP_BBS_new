package kr.ac.kopo.kopo44.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.kopo44.DTO.UserDTO;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn;//자바와 데이터베이스 연결
	private PreparedStatement pstmt;//쿼리문 대기 및 설정
	private ResultSet rset;//결과값 받아오기 (블로그에서는 rs라고 선언)
	
	private static UserDAOImpl instance;
	
	//기본 생성자
	//UserDAO가 실행되면 자동으로 생성되는 부분
	//메소드마다 반복되는 코드를 이곳에 넣으면 코드가 간소화된다.
	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BOARD","root","gusehdqls92410!@");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static UserDAOImpl getInstance() {
		if (instance == null) {
			instance = new UserDAOImpl();
		}
		return instance;
	}
	
	
	//로그인영역
	@Override
	public int login (String userID, String userPassword) {
		String sql = "select userPassword from USER WHERE userID = ?";
		try {
			pstmt = conn.prepareStatement(sql);//sql쿼리문을 대기 시킨다.
			pstmt.setString(1, userID);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				if (rset.getString(1).equals(userPassword)) {
					return 1;//로그인 성공
				} else
					return 0;//비밀번호 틀림
			}
			return -1;//아이디 없음
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -2;//오류
	}
	//회원가입 영역
	@Override
	public int join (UserDTO user) {
		String sql = "insert into USER(userID, userPassword, userName, userGender, userEmail) values (?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPassword());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserGender());
			pstmt.setString(5, user.getUserEmail());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
