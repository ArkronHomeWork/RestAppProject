package com.github.arkronzxc.resttest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * This table provides you with link of poll_id, it's text and displayed order(indication of how many questions should
 *      be sorted )
 */

@Data
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "q_order")
    private int order;

    @JsonIgnore
    @JoinColumn(name = "question_poll_id")
    @ManyToOne
    private Poll poll;

}
