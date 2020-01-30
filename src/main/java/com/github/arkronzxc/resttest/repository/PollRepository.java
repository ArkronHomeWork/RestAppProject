package com.github.arkronzxc.resttest.repository;

import com.github.arkronzxc.resttest.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Integer> {
//    @Query(value = "select * from poll as p join question as q on p.poll_id = q.question_poll_id", nativeQuery = true)

}
