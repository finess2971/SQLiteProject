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
			
			System.out.println("\n�� ������ �߰�");
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('������', '����/�ַ�', '2000, 2010, 2020���', '2008��', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('�Ź�', '����/�ַ�', '2000, 2010, 2020���', '2003��/�״� ���ƿ���', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('��ź�ҳ��', '����/�׷�', '2010, 2020���', '2013��/No More Dream', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('�̹���', '����/�ַ�', '2010, 2020���', '2018��/��������', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('Maroon 5', '����/���', '1990, 2000, 2010, 2020���', '1994��/Must Get Out', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			sql = "insert into g_artists (name, a_type, a_year, debut, regdate)"
					+ "values ('�����', '����/�ַ�', '2010, 2020���', '2015��/��', datetime('now', 'localtime'));";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("���ο� ������ �߰� �Ϸ�");
			}else {
				System.out.println("������ �߰� ���� �߻�");
				stat.close();
				return;
			}
			
			
			System.out.println("\n������ ��ȸ");
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
			
			System.out.println("\n������ ����");
			sql = "update g_artists set debut = '2008��/�̾�'"
					+"where name = '������' ;";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("������ ���� �Ϸ�");
			}else {
				System.out.println("������ ���� ���� �߻�");
				stat.close();
				return;
			}
			
			System.out.println("\n������ ����");
			sql = "delete from g_artists where name = '�����' ;";
			cnt = stat.executeUpdate(sql);
			if(cnt > 0) {
				System.out.println("������ ���� �Ϸ�");
			}else {
				System.out.println("������ ���� ���� �߻�");
				stat.close();
				return;
			}
			
			System.out.println("\n���� ������ ��ȸ");
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
