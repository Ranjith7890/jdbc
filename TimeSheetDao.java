package com.timesheet;
import java.sql.Connection;
import java.util.List;

import com.timesheet.model.Employee;
import com.timesheet.model.TimeSheet;


public interface TimeSheetDao {
	public boolean insertTimeSheet(TimeSheet timeSheet);
	public boolean insertEmployee(Employee emp);
	public  Connection connectDatabase();
	public List<TimeSheet> getAllTimeSheet();
	public List<Employee> getAllEmployee();
	public boolean getTimeSheetDetails(int empId);
	public boolean changeStatus(int empId);
	

}
