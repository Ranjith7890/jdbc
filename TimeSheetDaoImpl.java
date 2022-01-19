package com.timesheet.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.timesheet.TimeSheetDao;
import com.timesheet.model.Employee;
import com.timesheet.model.TimeSheet;

public class TimeSheetDaoImpl implements TimeSheetDao {
	@Override
	public boolean insertTimeSheet(TimeSheet timeSheet) {
		Connection con = connectDatabase();
		int rows=0;
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement("insert into timesheet (empid, date, activity, description, hrs, status) values(?,?,?,?,?,?)");
			ps.setInt(1, timeSheet.getEmpId());
			ps.setDate(2, (java.sql.Date)timeSheet.getDate());
			ps.setString(3, timeSheet.getActivity());
			ps.setString(4,  timeSheet.getDescription());
			ps.setFloat(5, timeSheet.getHrs());
			ps.setString(6, timeSheet.getStatus());
			rows = ps.executeUpdate();
			if (rows > 0) flag = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public Connection connectDatabase() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","Chintu@123");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public List<TimeSheet> getAllTimeSheet() {
		Connection con = connectDatabase();
		List<TimeSheet> list= new ArrayList<TimeSheet>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from timesheet");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				TimeSheet ts = new TimeSheet();
				ts.setId(rs.getInt("id"));
				ts.setEmpId(rs.getInt("empid"));
				ts.setDate(rs.getDate("date"));
				ts.setActivity(rs.getString("activity"));
				list.add(ts);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		Connection con = connectDatabase();
		int rows=0;
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement("insert into employee (empId, empName, hcc, emailId, date) values(?,?,?,?,?)");
			ps.setInt(1, employee.getEmpid());
			ps.setString(2, employee.getEmpName());
			ps.setString(3,  employee.getHcc());
			ps.setString(4, employee.getEmailId());
			ps.setDate(5, (java.sql.Date)employee.getDate());
			rows = ps.executeUpdate();
			if (rows > 0) flag = true;		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return flag;	
    }	
	

	@Override
	public List<Employee> getAllEmployee() {
		Connection con = connectDatabase();
		List<Employee> list= new ArrayList<Employee>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmpid(rs.getInt("empId"));
				employee.setEmpName(rs.getString("empName"));
				employee.setDate(rs.getDate("date"));
				employee.setEmailId(rs.getString("empmailId"));
				list.add(employee);
			}
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		return list;
	}
	@Override
	public  boolean changeStatus(int empId) {
		Connection con = connectDatabase();
		int rows=0;
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(" UPDATE timesheet SET status = 'approved'  WHERE empid = 141 ");
		    rows = ps.executeUpdate();
			if (rows > 0) flag = true;		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return flag;
	}

	@Override
	public boolean getTimeSheetDetails(int empId) {
		Connection con = connectDatabase();
		boolean flag = false;
		try {
			PreparedStatement ps = con.prepareStatement(" SELECT * FROM timesheet WHERE empId = 121 ");
			ResultSet rs= ps.executeQuery();
			if (rs.next() ) flag = true;		
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		 finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 return flag;
	}

}
