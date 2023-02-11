package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}