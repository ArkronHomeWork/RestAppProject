package com.github.arkronzxc.resttest.repository;

import com.github.arkronzxc.resttest.models.Poll;
import com.github.arkronzxc.resttest.models.PollQuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {
//    @Query(value = "select * from poll as p join question as q on p.poll_id = q.question_poll_id", nativeQuery = true)

}
