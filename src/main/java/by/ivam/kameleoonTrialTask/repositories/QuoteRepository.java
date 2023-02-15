package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findTop10AllByOrderByScore_ScoreDesc();
    List<Quote> findTop10AllByOrderByScore_ScoreAsc();

}