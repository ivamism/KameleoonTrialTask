package by.ivam.kameleoonTrialTask.repositories;

import by.ivam.kameleoonTrialTask.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}