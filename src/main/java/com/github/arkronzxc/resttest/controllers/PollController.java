package com.github.arkronzxc.resttest.controllers;

import com.github.arkronzxc.resttest.models.Poll;
import com.github.arkronzxc.resttest.service.PollService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    /**
     * @see package com.github.arkronzxc.resttest.service.PollService
     * @param sortParam Set of params
     * @param sortType either Ascending Sort or Descending Sort
     * @param pageNumber to pick needed page with data
     * @param onlyActive to select which Pools should be shown: active or inactive
     * @return a builder with the status set to {@linkplain HttpStatus#OK OK} with all suitable Polls.
     */

    @GetMapping("/all")
    public ResponseEntity<Page<Poll>> getAllPoll(@RequestParam(required = false,
            defaultValue = "sd", name = "sp") Set<String> sortParam,
                                                 @RequestParam(required = false,
                                                         defaultValue = "asc", name = "st") String sortType,
                                                 @RequestParam(required = false, defaultValue = "0", name = "pn")
                                                         int pageNumber,
                                                 @RequestParam(required = false,
                                                         defaultValue = "false", name = "is")
                                                         boolean onlyActive) {
        return ResponseEntity.ok(pollService.getAllPoll(sortParam, sortType, pageNumber, onlyActive));
    }

    /**
     * @see package com.github.arkronzxc.resttest.service.PollService
     * @param poll to choose the name of creating Poll
     * @return a builder with the status set to {@linkplain HttpStatus#OK OK}
     */

    @PutMapping
    public ResponseEntity<Void> putPoll(@RequestBody Poll poll) {
        pollService.putPoll(poll);
        return ResponseEntity.ok().build();
    }

    /**
     * @see package com.github.arkronzxc.resttest.service.PollService
     * @param poll to choose the name of changing poll
     * @return a builder with the status set to {@linkplain HttpStatus#OK OK}.
     */

    @PostMapping
    public ResponseEntity<Void> updatePoll(@RequestBody Poll poll) {
        pollService.putPoll(poll);
        return ResponseEntity.ok().build();
    }

    /**
     * @see package com.github.arkronzxc.resttest.service.PollService
     * @param poll to select a poll to delete.
     */

    @DeleteMapping
    public ResponseEntity<Void> deletePoll(@RequestBody Poll poll) {
        pollService.deletePoll(poll);
        return ResponseEntity.ok().build();
    }
}
