package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

@Query ("UPDATE Score s SET s.goodVotes = s.goodVotes + 1, s.score = s.goodVotes +1 - s.badVotes WHERE s.id= ?1")
    void upVotes(long id);


@Query("SELECT Score  FROM Score s WHERE s.id = ?1")
  int getScoreById(long id);

}