package com.ivoyant.SpringKubernates.repository;

import com.ivoyant.SpringKubernates.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
