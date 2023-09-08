package com.gintophilip.asyncDemo.repositories;

import com.gintophilip.asyncDemo.entities.RandomUUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomUUIDRepository extends JpaRepository<RandomUUID,Long> {
}
