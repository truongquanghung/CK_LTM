package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Account;

public class AccountDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static Object getAccount(String id, String pass) {
		Account a = new Account();
		a.setId(id);
		a.setPass(pass);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from Account");
			while(rs.next()) {
				String namedb=rs.getString("Username");
				String passdb=rs.getString("Password");
				//System.out.println(namedb+" "+passdb);
				if (namedb.equals(id) && passdb.equals(pass)) 
					return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static Object getListAccount() {
		List<String> res = new ArrayList<String>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from Account");
			while(rs.next()) {
				String namedb=rs.getString("Username");
				res.add(namedb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return res;
	}

	public static void editAccount(String name, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			String s = "update account set Password='"+pass+"' where Username='"+name+"'";
			stat.execute(s);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static boolean checkUsername(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from Account");
			while(rs.next()) {
				String namedb=rs.getString("Username");
				if (namedb.equals(name)) 
					return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void setAccount(String name, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			String s = "insert into account values('"+name+"','"+pass+"')";
			stat.execute(s);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public static void deleteAccount(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			String url = "jdbc:mysql://localhost/LTM?serverTimezone=UTC";
		    String userName = "root";
		    String password = "";
			Connection conn = DriverManager.getConnection(url,userName,password);
			Statement stat = conn.createStatement();
			String s = "delete from account where Username='"+name+"'";
			stat.execute(s);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
