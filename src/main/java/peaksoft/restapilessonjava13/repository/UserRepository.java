package peaksoft.restapilessonjava13.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapilessonjava13.enitity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> getUserByEmail(String email);
}
