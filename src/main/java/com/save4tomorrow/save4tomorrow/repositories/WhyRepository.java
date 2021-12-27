package com.save4tomorrow.save4tomorrow.repositories;

import com.save4tomorrow.save4tomorrow.models.Why;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhyRepository extends JpaRepository<Why, Long> {

    String getWhyById(Long id);
    Why getWhyByDescription(String description);
}
