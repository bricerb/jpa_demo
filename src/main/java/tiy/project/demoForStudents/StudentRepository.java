package tiy.project.demoForStudents;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer>{
    Student findByFirstName(String firstName);
    List<Student> findByGradeLevel(Integer gradeLevel);
}
