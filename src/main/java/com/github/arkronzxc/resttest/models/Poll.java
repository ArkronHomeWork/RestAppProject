package com.github.arkronzxc.resttest.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Table which contains attributes of Polls
 * Each Poll is able to contain lots of Questions
 */

@Data
@Entity
@Table(name = "poll")
@NoArgsConstructor
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poll_id")
    private Long id;

    @Column(name = "poll_name")
    private String pollName;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_active")
    private boolean isActive;

    @OrderBy("order ASC")
    @OneToMany(
            mappedBy = "poll",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Question> questions;

    @SuppressWarnings("CopyConstructorMissesField")
    public Poll(Poll poll) {
        this.pollName = poll.pollName;
        this.startDate = poll.startDate;
        this.endDate = poll.endDate;
        this.isActive = poll.isActive;
        this.questions = poll.questions;
    }
}

