package dev.ranieri.controllers;

import dev.ranieri.dtos.EmployeeInfo;
import dev.ranieri.dtos.LoginInfo;
import dev.ranieri.entities.Employee;
import dev.ranieri.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    EmployeeInfo login( @RequestBody LoginInfo loginInfo){
        Employee employee = loginService.login(loginInfo.getUsername(), loginInfo.getPassword());
        EmployeeInfo employeeInfo = new EmployeeInfo(employee.geteId(), employee.getUsername());
        return employeeInfo;
    }
}
