package com.github.arkronzxc.resttest.repository;

import com.github.arkronzxc.resttest.models.Poll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    /**
     * This method allows you to extract only active polls
     * @param isActive option which allows you to show only active polls
     * @see package com.github.arkronzxc.resttest.service.PollService
     */
    Page<Poll> findAllByActive(boolean isActive, Pageable pageable);
}


