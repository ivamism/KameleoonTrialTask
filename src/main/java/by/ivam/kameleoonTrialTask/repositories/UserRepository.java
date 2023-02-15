package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByNameAndEmailAndCreationDate(String name, String email, LocalDateTime creationDate);





}