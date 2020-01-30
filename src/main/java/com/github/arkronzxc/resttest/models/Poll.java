package com.github.arkronzxc.resttest.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll {

    @Id
    @Column(name = "poll_id")
    Long id;

    @Column(name = "poll_name")
    String pollName;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @Column(name = "is_active")
    boolean isActive;

    @OneToMany(mappedBy = "poll")
    private List<Question> questions;
}
