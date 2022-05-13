package dev.ranieri.PleasantSpring;

import dev.ranieri.entities.Employee;
import dev.ranieri.repos.EmployeeRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeRepoTest {

    @Autowired
    EmployeeRepo employeeRepo;

    @Test
    public void getEmployee(){
        Employee employee = employeeRepo.findByUsername("Eleanor99");
        Assertions.assertEquals("Eleanor99",employee.getUsername());
        System.out.println(employee);

    }
}
