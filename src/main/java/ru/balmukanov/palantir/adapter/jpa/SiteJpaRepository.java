package ru.balmukanov.palantir.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.balmukanov.palantir.domain.Site;

public interface SiteJpaRepository extends JpaRepository<Site, Long> {
}
