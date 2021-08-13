package com.enoca.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "member")
@SequenceGenerator(name = "id_generator", sequenceName = "seq_member", allocationSize = 1)
public class Member {

    @Id
    @Column
    @GeneratedValue(generator = "id_generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
