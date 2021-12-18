package com.save4tomorrow.save4tomorrow.repositories;

import com.save4tomorrow.save4tomorrow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUsersById (String id);
    User findByUsername (String username);

}
