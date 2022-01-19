package com.timesheet.test;
import  com.timesheet.TimeSheetDao;
import com.timesheet.impl.TimeSheetDaoImpl;
import com.timesheet.model.Employee;
import com.timesheet.model.TimeSheet;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

public class DAOTest {
	@Test
	void connectDatabaseTest1() {
		TimeSheetDao ts = new TimeSheetDaoImpl();
		Connection con = ts.connectDatabase();
		assertNotNull(con);
	}
	
	@Test
	void insertTimeSheetTest() {
	TimeSheetDao ts = new TimeSheetDaoImpl();
	TimeSheet timeSheet = new TimeSheet();
	timeSheet.setEmpId(171);
	long time = System.currentTimeMillis();
	timeSheet.setDate(new java.sql.Date(time));
	timeSheet.setActivity("Create a connecton method");
	timeSheet.setDescription("Write a method to return connection");
	timeSheet.setHrs(1.5F);
	timeSheet.setStatus("Submitted");
	boolean flag = ts.insertTimeSheet(timeSheet);
	assertTrue(flag);
	}
	@Test
	void insertEmployeeTest1() {
		TimeSheetDao ts = new TimeSheetDaoImpl();
		Employee employee = new Employee();
		employee.setEmpid(135);
		employee.setEmpName("Ranjith");
		employee.setHcc("major Benifit");
		employee.setEmailId("sanjay.chandu.gmail.com");
		long time = System.currentTimeMillis();
		employee.setDate(new java.sql.Date(time));
		boolean flag = ts.insertEmployee(employee);
		assertTrue(flag);
	}
	@Test
	void ChangeStatustest() {
		TimeSheetDao ts = new TimeSheetDaoImpl();
		boolean flag = ts.changeStatus(121);
		assertTrue(flag);
		
		
	}
	@Test
	void getTimeSheetDetails() {
		TimeSheetDao ts = new TimeSheetDaoImpl();
		boolean flag = ts.getTimeSheetDetails(131);
		assertTrue(flag);
		
	}
	
}
