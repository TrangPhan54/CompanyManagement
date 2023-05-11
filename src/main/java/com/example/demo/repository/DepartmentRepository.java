package com.example.demo.repository;
import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findByStartDate(LocalDate startDate);
    List<Department> findByName(String deptName);

    List <Department> findByNameContaining(String partOfName);

    List <Department> findByNameNotLike (String name);

    List <Department> findByNameIgnoreCase (String anotherName);
    @Query(value = "SELECT * FROM department d where d.start_date = :startDate", nativeQuery = true)
    List <Department> getDepartmentByStartDate (LocalDate startDate);
    @Query(value = "SELECT * FROM department d where d.department_name =:name", nativeQuery = true)
    List <Department> getDepartmentByDepartmentName (String name);
}
