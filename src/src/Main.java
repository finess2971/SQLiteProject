package src;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			String dbFile = "myfirst.db";
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			Statement stat = con.createStatement();
			String sql;
			int cnt;
			
			System.out.println("\n새 데이터 추가");
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('아이유', '여성/솔로', '2000, 2010, 2020년대', '2008년', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('거미', '여성/솔로', '2000, 2010, 2020년대', '2003년/그대 돌아오면', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('방탄소년단', '남성/그룹', '2010, 2020년대', '2013년/No More Dream', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('이무진', '남성/솔로', '2010, 2020년대', '2018년/누구없소', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('Maroon 5', '남성/밴드', '1990, 2000, 2010, 2020년대', '1994년/Must Get Out', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('양다일', '남성/솔로', '2010, 2020년대', '2015년/널', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("새로운 데이터 추가 완료");
			}else {
				System.out.println("데이터 추가 오류 발생");
				stat.close();
				return;
			}
			
			
			System.out.println("\n데이터 조회");
			sql = "select * from g_artists";
			ResultSet rs = stat.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String a_type = rs.getString("a_type");
				String a_year = rs.getString("a_year");
				String debut = rs.getString("debut");
				System.out.println(id + " " + name + " " + a_type + " " + a_year + " " + debut);
			}
			
			System.out.println("\n데이터 수정");
			sql = "update g_artists set debut = '2008년/미아'"
					+"where name = '아이유' ;";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("데이터 수정 완료");
			}else {
				System.out.println("데이터 수정 오류 발생");
				stat.close();
				return;
			}
			
			System.out.println("\n데이터 삭제");
			sql = "delete from g_artists where name = '양다일' ;";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("데이터 삭제 완료");
			}else {
				System.out.println("데이터 삭제 오류 발생");
				stat.close();
				return;
			}
			
			System.out.println("\n최종 데이터 조회");
			sql = "select * from g_artists";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String a_type = rs.getString("a_type");
				String a_year = rs.getString("a_year");
				String debut = rs.getString("debut");
				String regdate = rs.getString("regdate");
				System.out.println(id + " " + name + " " + a_type + " " + a_year + " " + debut + " " + regdate);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			

			

		
		
	}

}
