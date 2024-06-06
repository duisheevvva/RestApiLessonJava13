package peaksoft.restapilessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.restapilessonjava13.enitity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student getStudentByEmail(String email);
}
