package dev.ranieri.services;

import dev.ranieri.entities.Employee;
import dev.ranieri.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee login(String username, String password) {
        Employee employee = employeeRepo.findByUsername(username);
        if(employee == null){
            throw new RuntimeException("No Employee with that username");
        }
        if(employee.getPassword().equals(password)){
            return employee;
        }else{
            throw  new RuntimeException("password does not match");
        }

    }
}
