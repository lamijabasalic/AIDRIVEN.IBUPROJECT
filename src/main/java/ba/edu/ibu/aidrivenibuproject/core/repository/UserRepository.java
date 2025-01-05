package ba.edu.ibu.aidrivenibuproject.core.repository;

import ba.edu.ibu.aidrivenibuproject.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
