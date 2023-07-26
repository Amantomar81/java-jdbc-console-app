package org.aman;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();

        //insert
//                Employee employee = new Employee();
//               employee.setName("Saurabhe");
//                employee.setEmail("s@gmail.com");
//

//                employeeDao.addEmployee(employee);

//
//        //Read
//        List<Employee>employeeList = employeeDao.getEmployees();
//        for(Employee employee: employeeList){
//            System.out.println(employee);
//        }

        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag){
            System.out.println("*********************************");
            System.out.println("select from the options below");
            System.out.println("********************************");
            System.out.println("PRESS 1: Add Employee");
            System.out.println("PRESS 2: Update Employee");
            System.out.println("PRESS 3: Delete Employee");
            System.out.println("PRESS 4: Get All Employee");
            System.out.println("PRESS 5: Get Employee By Id");
            System.out.println("PRESS 6: Add Exit");

            int input = sc.nextInt();
            switch (input){
                case 1: {
                    //add
                    System.out.println("Enter Name: ");
                    String name = sc.next();
                    System.out.println("Enter Email: ");
                    String email = sc.next();
                    Employee employee = new Employee();
                    employee.setName(name);
                    employee.setEmail(email);
                    employeeDao.addEmployee(employee);
                    break;
                }
                case 2: {
                    // update
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter Name: ");
                    String name = sc.next();
                    System.out.println("Enter Email: ");
                    String email = sc.next();
                    Employee employee = new Employee(id, name, email);
                    employeeDao.updateEmployee(employee);
                    break;
                }
                case 3: {
                    //delete
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    employeeDao.deleteEmployee(id);
                    break;
                }
                case 4: {
                    // get all
                    List<Employee> employeeList = employeeDao.getEmployees();
                    for(Employee employee: employeeList){
                        System.out.println(employee);
                    }
                    break;
                }
                case 5: {
                    // get by id
                    System.out.println("Enter ID: ");
                    int id = sc.nextInt();
                    Employee employee = employeeDao.getEmployeeById(id);
                    System.out.println(employee);
                    break;
                }
                case 6: {
                    // exit
                    System.out.println("Thank you ");
                    System.out.println("Exiting......");
                    flag = false;
                    break;
                }
                default:
                    System.out.println("choose between 1 - 6");
            }
        }
    }
}
