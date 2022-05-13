package dev.ranieri.repos;

import dev.ranieri.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Employee findByUsername(String username);
}
