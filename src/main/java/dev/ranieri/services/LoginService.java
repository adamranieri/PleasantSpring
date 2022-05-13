package dev.ranieri.services;

import dev.ranieri.entities.Employee;

public interface LoginService {

    Employee login(String username, String password);
}
