package com.github.arkronzxc.resttest.service;

import com.github.arkronzxc.resttest.models.Poll;
import com.github.arkronzxc.resttest.repository.PollRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * REST service which providing the following methods:
 *      Getting all Polls (you can specify one or more parameters for filtering or leave it with default values)
 *      Creating a Poll (method is able to receive all of the Poll and Question data)
 *      Updating a Poll (method is able to receive all of the Poll and Question data)
 *      Deleting a Poll
 * At the first start service independently create the necessary objects in the database using Liquibase
 *      {@see resources.db.changelog.db.changelog-master.yaml}
 */

@Service
public class PollService {


    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    /**
     * @param sortParam allows to choose the needed params. Default value is "sd" which means "start_date".
     *                 You can enumerate as many, as you need and as your columns in db allows you to.
     * @param sortType allows you to choose either Ascending sort or Descending sort
     * @param pageNumber pick the needed page. Each page contains 10 results
     * @param onlyActive signature which allows you to show only active polls
     * @return a new {@link Page} which contains all satisfying elements
     */

    public Page<Poll> getAllPoll(Set<String> sortParam,
                                 String sortType,
                                 int pageNumber,
                                 boolean onlyActive) {
        Sort.Direction decision = Sort.Direction.ASC;
        if (sortType.equals("desc")) {
            decision = Sort.Direction.DESC;
        }

        /*
          Array with is used to set up @param sortParam in {@code PollService}
         */

        String[] sortArray = sortParam.stream()
                .sequential()
                .map(s -> switch (s) {
                    case "pn" -> "pollName";
                    case "ed" -> "endDate";
                    case "is" -> "isActive";
                    default -> "startDate";
                })
                .toArray(String[]::new);

        Pageable page = PageRequest.of(pageNumber, 10, decision, sortArray);
        if (!onlyActive) {
            return pollRepository.findAll(page);
        }
        return pollRepository.findAllByActive(true, page);
    }

    /**
     * This method allows you to put a new poll or change existing one via Post or Put request
     * @param poll to choose the name of creating or changing poll
     */

    public void putPoll(Poll poll) {
        pollRepository.save(new Poll(poll));
    }

    /**
     * This method allows you to delete certain poll via Delete request
     * @param poll to select a poll to delete
     */

    public void deletePoll(Poll poll) {
        pollRepository.delete(poll);
    }
}
