package temaWeek14Database.main;
/**
 * <h1>Database Connectivity</h1>
 * The DatabaseConnectivity program implements an app that interacts
 * with data from a Mysql database. The database is called school.
 * School database has 5 tables :classes,courses.courses_profs,
 * crosslistings and profs.
 *
 * @author Ana Maria Pantelemon
 * * @version 1.0
 * * @since   2019-09-14
 */

import java.sql.*;

public class DatabaseConnectivity {
	/**
	 * This is a static block for loading the driver needed for interaction with a MySql database
	 */
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.err.println("Driver not loaded!");
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {

		displayAllClasses();
//		displayCourse(1);
//		displayTitle();
//		displayDept();
//		displayProfName();
	}
	
	/**
	 * This is a method that create a connection with the database.
	 *
	 * @param type     set the value for database type
	 * @param host     set the value for host type
	 * @param port     set the value for adding the port
	 * @param dbName   set the value for name of the database
	 * @param userName set the value for the user of the database
	 * @param password set the value for password of the database for the specific user;
	 * @return type is connection;
	 */
	public static Connection createConnection(String type, String host, String port, String dbName, String userName, String password) {
		Connection conn = null;
		type = "mysql";
		host = "localhost";
		port = "3306";
		dbName = "school";
		userName = "root";
		password = "root";
		String url = "jdbc:" + type + "://" + host + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	/**
	 * This method is used to display all the data from classes table in
	 * similar way as in database.
	 * The columns name and order is kept as in classes database;
	 */
	public static void displayAllClasses() {
		
		Connection conn = createConnection("mysql", "localhost", "3306", "school", "root", "root");
		if (conn==null) return;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String format = "|%-10s|%10s|%10s|%12s|%12s|%10s|%10s|\n";
		try {
			ps = conn.prepareStatement("select * from classes");
			rs = ps.executeQuery();
			
			System.out.format(format, "Class_ID", "Course_ID", "days", "StartTime", "EndTime", "bldg", "room_no");
			while (rs.next()) {
				
				String class_id = rs.getString("class_id");
				String course_id = rs.getString("course_id");
				String days = rs.getString("days");
				String startTime = rs.getString("startTime");
				String endTime = rs.getString("endTime");
				String bldg = rs.getString("bldg");
				String room = rs.getString("room_no");
				System.out.format(format, class_id, course_id, days, startTime, endTime, bldg, room);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps!=null) try {
				ps.close();
			} catch (SQLException e) {
			}
			if (rs!=null) try {
				rs.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * This is a method that displays a record from courses table from the school database.
	 * The record is filtered based on a specific ID from the courses table.
	 *
	 * @param id set the value of a specific id;
	 */
	
	public static void displayCourse(int id) {
		
		if (id > 3 || id < 1) {
			System.out.println("Invalid ID");
			return;
		}
		Connection conn = createConnection("mysql", "localhost", "3306", "school", "root", "root");
		if (conn==null) return;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from courses where id=" + id);
			rs = ps.executeQuery();
			String format = "%-5s|%15s|%20s|%40s|%20s\n";
			System.out.format(format, "Id", "Area", "Title", "Description", "Prereqs");
			while (rs.next()) {
				String course = rs.getString("id");
				String area = rs.getString("area");
				String title = rs.getString("title");
				String descrip = rs.getString("descrip");
				String prereqs = rs.getString("prereqs");
				System.out.format(format, course, area, title, descrip, prereqs);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			if (ps!=null) try {
				ps.close();
			} catch (SQLException e) {
			}
			;
			if (rs!=null) try {
				rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
	}
	
	/**
	 * This method displays data from all classes whose title(when
	 * converted to all lowercase letters) begins with "intro";
	 */
	public static void displayTitle() {
		Connection conn = createConnection("mysql", "localhost", "3306", "school", "root", "root");
		if (conn==null) return;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select co.id, co.area,cl.startTime,cl.endTime, lower(co.title) as Title \n" +
					"from classes cl\n" +
					"join courses co\n" +
					"on cl.course_id=co.id \n" +
					"where co.title regexp \"^intro\"");
			
			rs = ps.executeQuery();
			String format = "%-5s|%15s|%12s|%12s|%30s\n";
			System.out.format(format, "Id", "Area", "StartTime", "EndTime", "Title");
			while (rs.next()) {
				String id = rs.getString("id");
				String area = rs.getString("area");
				String startTime = rs.getString("starttime");
				String endTime = rs.getString("endTime");
				String title = rs.getString("title");
				System.out.format(format, id, area, startTime, endTime, title);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps!=null) try {
				ps.close();
			} catch (SQLException e) {
			}
			;
			if (rs!=null) try {
				rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				conn.close();
			} catch (SQLException e) {
			}
			;
		}
	}
	
	/**
	 * This method displays data for all classes whose dept (when converted to all lowercase letters)
	 * is "cos" and whose course number begins with "3".
	 */
	public static void displayDept() {
		Connection conn = createConnection("mysql", "localhost", "3306", "school", "root", "root");
		if (conn==null) return;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String format = "%10s|%12s|%12s|%10s|%10s|%10s\n";
		try {
			ps = conn.prepareStatement("select cl.class_id, cl.startTime, cl.endtime, cl.bldg, lower(cr.dept)as dept, cr.course_no\n" +
					"from classes cl\n" +
					"join crosslistings cr\n" +
					"on cl.course_id=cr.course_id\n" +
					"where cr.dept regexp \"cos\"\n" +
					"and cr.course_no regexp \"^3\"");
			rs = ps.executeQuery();
			System.out.format(format, "Class_ID", "StartTime", "EndTime", "Bldg", "Dept", "Course_No");
			while (rs.next()) {
				String class_id = rs.getString("class_id");
				String startTime = rs.getString("startTime");
				String endTime = rs.getString("endTime");
				String bldg = rs.getString("bldg");
				String dept = rs.getString("dept");
				String course_no = rs.getString("course_no");
				System.out.format(format, class_id, startTime, endTime, bldg, dept, course_no);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps!=null) try {
				ps.close();
			} catch (SQLException e) {
			}
			;
			if (rs!=null) try {
				rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/**
	 * This method displays data for all classes whose professor name
	 * (when converted to all lowercase letters) begins with "cos".
	 */
	public static void displayProfName() {
		Connection conn = createConnection("mysql", "localhost", "3306", "school", "root", "root");
		if (conn==null) return;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String format = "%10s|%12s|%12s|%10s|%10s|%10s|%10s|%10s|%25s\n";
		try {
			ps = conn.prepareStatement("select *\n" +
					"from classes cl\n" +
					"join courses_profs cr\n" +
					"on cl.course_id=cr.course_id\n" +
					"join profs p\n" +
					"on cr.prof_id=p.prof_id \n" +
					"where p.prof_name regexp \"^cos\"");
			rs = ps.executeQuery();
			System.out.format(format, "Class_ID", "Course_ID", "Days", "StartTime", "EndTime", "Bldg", "Room_no", "Prof_id", "Prof_name");
			while (rs.next()) {
				String class_id = rs.getString("class_id");
				String course_id = rs.getString("course_id");
				String days = rs.getString("days");
				String startTime = rs.getString("startTime");
				String endTime = rs.getString("endTime");
				String bldg = rs.getString("bldg");
				String room = rs.getString("room_no");
				String prof_id = rs.getString("prof_id");
				String prof_name = rs.getString("prof_name");
				
				System.out.format(format, class_id, course_id, days, startTime, endTime, bldg, room, prof_id, prof_name);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps!=null) try {
				ps.close();
			} catch (SQLException e) {
			}
			;
			if (rs!=null) try {
				rs.close();
			} catch (SQLException e) {
			}
			;
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		
	}
}