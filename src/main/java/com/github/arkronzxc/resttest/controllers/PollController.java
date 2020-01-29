package com.github.arkronzxc.resttest.controllers;

import com.github.arkronzxc.resttest.models.Poll;
import com.github.arkronzxc.resttest.models.PollQuestionModel;
import com.github.arkronzxc.resttest.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Poll>> getAllPoll() {
        return ResponseEntity.ok(pollRepository.findAll());
    }
}
