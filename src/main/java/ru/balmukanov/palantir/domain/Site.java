package ru.balmukanov.palantir.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected String host;

    protected String routForUser;

    protected int successHttpCode;

    protected int notFoundHttpCode;

    protected boolean active;

    public Site() {
        this.successHttpCode = 200;
        this.notFoundHttpCode = 404;
    }
}
