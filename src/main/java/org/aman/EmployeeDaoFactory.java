package org.aman;

public class EmployeeDaoFactory {
    public static EmployeeDao employeeDao = null;

    private EmployeeDaoFactory(){

    }
    public static EmployeeDao getEmployeeDao(){
        if(employeeDao == null){
            employeeDao = new EmployeeDaoImp();
        }
        return employeeDao;
    }
}
