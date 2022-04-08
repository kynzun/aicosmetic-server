package com.kj.web.AICosmetic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
    TestEntity findTestEntityById(Long id);
}

