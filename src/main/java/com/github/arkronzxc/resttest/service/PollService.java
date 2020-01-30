package com.github.arkronzxc.resttest.service;

import com.github.arkronzxc.resttest.models.Poll;
import com.github.arkronzxc.resttest.repository.PollRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PollService {


    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Page<Poll> getAllPoll(Set<String> sortParam,
                                 String sortType,
                                 int pageNumber,
                                 boolean onlyActive) {
        Sort.Direction decision = Sort.Direction.ASC;
        if (sortType.equals("desc")) {
            decision = Sort.Direction.DESC;
        }

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

    public void putPoll(Poll poll) {
        pollRepository.save(new Poll(poll));
    }

    public void deletePoll(Poll poll) {
        pollRepository.delete(poll);
    }
}
