package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BankDAO {
	
	
	public void insert() throws Exception {
		//1. 드라이버  셋팅
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. DB연결 (-> mySQL서버설정 + DB명 + id + pw)
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root"; 
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// member 테이블 생성
		String sql = "insert into member values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "qqq"); // 첫번째 물음표 
		ps.setString(2, "jung"); // 두번째 물음표
		ps.setString(3, "24"); // 세번째 물음표
		ps.setString(4, "010-1234"); // 네번째 물음표
		ps.executeUpdate(); // 위에 넣은 값들을 업데이트
		
	}
	
	
	public void update() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root"; 
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// id로 tel값 수정
		String sql = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "010-1577-1577");
		ps.setString(2, "asd");
		ps.executeUpdate();
		
		
	}
	
	
	public BankDTO dns() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root"; 
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);

		// 데이터 삭제
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "qwe");
		ps.executeUpdate();
		
		// 아이디로 회원정보검색
		String sql1 = "select * from member where id = ?";
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setString(1, "abc");
		ResultSet rs = ps1.executeQuery();
		
		BankDTO dto = new BankDTO();
		
		while(rs.next()) {
			if(rs.getString(1).equals("abc")) {
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getString(3));
				dto.setTel(rs.getString(4));
				
			}
		} return dto;
		
	
	}
	
	
	public ArrayList<BankDTO> selectAll() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root"; 
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 전체회원 정보 검색
		String sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		BankDTO dto = null;
		ArrayList<BankDTO> list = new ArrayList<>();
		while(rs.next()) { 
			dto = new BankDTO();
			String id = rs.getString(1);
			String name = rs.getString(2);
			String age = rs.getString(3);
			String tel = rs.getString(4);
			
			dto.setId(id);
			dto.setName(name);
			dto.setAge(age);
			dto.setTel(tel);
			
			list.add(dto);

		}
		return list;
	}
	}
