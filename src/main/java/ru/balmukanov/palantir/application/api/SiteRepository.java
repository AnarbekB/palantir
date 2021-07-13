package ru.balmukanov.palantir.application.api;

import ru.balmukanov.palantir.domain.Site;

import java.util.List;

public interface SiteRepository {
    List<Site> getAll();
    void save(Site site);
}
