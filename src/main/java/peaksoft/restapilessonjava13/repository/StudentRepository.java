package peaksoft.restapilessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapilessonjava13.dto.studentDto.StudentResponse;
import peaksoft.restapilessonjava13.enitity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("select new peaksoft.restapilessonjava13.dto.studentDto.StudentResponse(" +
            "s.id," +
             "concat(s.firstName,' ',s.lastName) ,"+
            "s.email," +
            "s.createdDate," +
            "s.graduationDate," +
            "s.isBlocked)  from Student s")
    List<StudentResponse>findAllStudents();

    @Query("select new peaksoft.restapilessonjava13.dto.studentDto.StudentResponse(" +
            "s.id," +
            "concat(s.firstName,' ',s.lastName) ,"+
            "s.email," +
            "s.createdDate," +
            "s.graduationDate," +
            "s.isBlocked)  from Student s where s.id=:id")
    Optional<StudentResponse> getStudentById(Long id);

    Student getStudentByEmail(String email);
}
