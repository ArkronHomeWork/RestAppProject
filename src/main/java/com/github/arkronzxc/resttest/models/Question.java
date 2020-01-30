package com.github.arkronzxc.resttest.models;

import javax.persistence.*;

@Entity
@Table(name ="question")
public class Question {
    @Id
    @Column(name = "question_id")
    int id;

    @Column(name = "question_text")
    String questionText;

    @Column(name ="order")
    int order;

    @ManyToOne
    @JoinColumn(name = "question_poll_id", referencedColumnName = "poll_id")
    private Poll poll;



}
