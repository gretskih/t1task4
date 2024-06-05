package ru.t1.task4.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.t1.task4.exception.ServiceException;
import ru.t1.task4.model.Account;
import ru.t1.task4.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AccountServiceTest {

    private AccountRepository accountRepository;
    private BCryptPasswordEncoder encoder;

    @BeforeEach
    public void setup() {
        accountRepository = mock(AccountRepository.class);
        encoder = mock(BCryptPasswordEncoder.class);
    }

    @Test
    public void testSave() throws ServiceException {
        AccountService accountService = new AccountService(accountRepository, encoder);
        Account account = new Account(1L, "testUser", "password", "ROLE_USER");

        when(encoder.encode(anyString())).thenReturn("encodedPassword");
        when(accountRepository.save(any(Account.class))).thenReturn(account);

        Account savedAccount = accountService.save(account);

        assertEquals("encodedPassword", savedAccount.getPassword());
        verify(encoder, times(1)).encode(anyString());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    public void testSaveDataIntegrityViolationException() {
        AccountService accountService = new AccountService(accountRepository, encoder);
        Account account = new Account(1L, "existingUser", "password", "ROLE_USER");

        when(encoder.encode(anyString())).thenReturn("encodedPassword");
        when(accountRepository.save(any(Account.class))).thenThrow(new DataIntegrityViolationException("Duplicate entry"));

        ServiceException exception = assertThrows(ServiceException.class, () -> accountService.save(account));
        assertEquals("Пользователь с именем: existingUser уже существует", exception.getMessage());
    }
}