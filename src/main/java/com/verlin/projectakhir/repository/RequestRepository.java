package com.verlin.projectakhir.repository;

import com.verlin.projectakhir.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
