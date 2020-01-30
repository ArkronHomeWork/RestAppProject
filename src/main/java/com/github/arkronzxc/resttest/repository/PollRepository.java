package com.github.arkronzxc.resttest.repository;

import com.github.arkronzxc.resttest.models.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    Page<Poll> findAllByActive(boolean isActive, Pageable pageable);
}
