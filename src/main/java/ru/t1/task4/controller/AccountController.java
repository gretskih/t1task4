package ru.t1.task4.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.task4.dto.AccountDTO;
import ru.t1.task4.exception.ControllerException;
import ru.t1.task4.exception.ServiceException;
import ru.t1.task4.model.Account;
import ru.t1.task4.service.AccountService;

@Tag(
		name="Контроллер пользователей",
		description="Предоставление возможности добавлять новых пользователей"
)
@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@Operation(
			summary = "Новый пользователь",
			description = "Создание нового пользователя с ролями"
	)
	@SecurityRequirement(name = "JWT")
	@PostMapping("/new")
	@PreAuthorize("hasAuthority('SCOPE_ADMIN')")
	public ResponseEntity<AccountDTO> newAccount(@RequestBody Account account) throws ControllerException {
		try {
			var accountOptional = accountService.save(account);
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(new AccountDTO(accountOptional.getName(), accountOptional.getRoles()));
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage(), e);
		}
	}
}
