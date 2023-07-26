package org.aman;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDao{
    Connection connection;
    public EmployeeDaoImp(){
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addEmployee(Employee newEmployee) throws SQLException {
        String sql = "INSERT INTO employee (name, email) values  (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newEmployee.getName());
        preparedStatement.setString(2, newEmployee.getEmail());
        int count = preparedStatement.executeUpdate();
        if(count > 0){
            System.out.println("employee saved");
        }
        else{
            System.out.println("Opps! something went wrong try again");
        }
    }


    @Override
    public void updateEmployee(Employee updateEmployee) throws SQLException {
        String sql = "UPDATE employee SET name = ?, email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, updateEmployee.getName());
        preparedStatement.setString(2, updateEmployee.getEmail());
        preparedStatement.setInt(3,updateEmployee.getId());
        int count = preparedStatement.executeUpdate();
        if(count>0){
            System.out.println("employee updated");
        }
        else{
            System.out.println("Opps! something went wrong try again");
        }
    }


    @Override
    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        int count = preparedStatement.executeUpdate();
        if(count>0){
            System.out.println("employee deleted");
        }
        else{
            System.out.println("Opps! something went wrong try again");
        }
    }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "select * from employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            Employee employee = new Employee(id, name,email);
            employeeList.add(employee);
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(int empId) throws SQLException {
        String sql = "select * from employee where id  = "+empId;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String email = resultSet.getString(3);
        Employee employee = new Employee(id, name,email);
        return employee;

    }
}
