package ru.balmukanov.palantir.adapter.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.balmukanov.palantir.application.api.SiteRepository;
import ru.balmukanov.palantir.domain.Site;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SiteRepositoryRepositoryAdapter implements SiteRepository {
    private final SiteJpaRepository jpaRepository;

    @Override
    public List<Site> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void save(Site site) {
        jpaRepository.save(site);
    }
}
