package ru.t1.task4.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.t1.task4.exception.ServiceException;
import ru.t1.task4.model.Account;
import ru.t1.task4.repository.AccountRepository;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder encoder;

    public Account save(Account account) throws ServiceException {
        try {
            account.setPassword(encoder.encode(account.getPassword()));
            return accountRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceException("Пользователь с именем: " + account.getName() + " уже существует", e);
        } catch (Exception e) {
            throw new ServiceException("Неизвестная ошибка", e);
        }
    }
}
