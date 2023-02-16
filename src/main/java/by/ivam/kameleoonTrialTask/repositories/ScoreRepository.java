package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

}