package org.mrs.teamapi.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeDbRepository extends MongoRepository<Employee, String> {
    Employee findEmployeeByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByIdIn(List<String> ids);
}
