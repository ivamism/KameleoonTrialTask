package by.ivam.kameleoonTrialTask.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Data
@SpringBootTest
class ScoreServiceImplTest {

    @Autowired
    ScoreServiceImpl scoreService;
//    @Autowired
//    ScoreRepository scoreRepository;

//    @Test
//    void like() {
//        int actual = scoreService.like(2);
//        int expected = 106;
//        assertEquals(expected, actual);
//    }

//    @Test
//    void testGetScoreById() {
//        ScoreResponse scoreById = scoreService.findById(1);
//        int actual = scoreById.getGoodVotes();
//        int expected = 103;
//        assertEquals(expected, actual);
//    }

//    @Test
//    void disLike() {
//        int actual = scoreService.disLike(4);
//        int expected = 1;
//        assertEquals(expected, actual);
//    }



//    @Test
//    void getScoreById() {
//        ScoreResponse scoreResponse = scoreService.getScoreById(2);
//        int actual = scoreResponse.getScore();
//        int expected =108;
//        assertEquals(expected, actual);
//    }
}