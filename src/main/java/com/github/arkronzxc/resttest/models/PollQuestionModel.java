package com.github.arkronzxc.resttest.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PollQuestionModel {
    private Poll poll;
    private Question question;
}
