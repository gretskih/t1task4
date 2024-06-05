package ru.t1.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.t1.task4.model.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByName(String username);
}
