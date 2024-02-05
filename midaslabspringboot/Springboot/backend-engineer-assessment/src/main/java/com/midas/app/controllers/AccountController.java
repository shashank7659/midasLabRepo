package com.midas.app.controllers;
package com.midas.app.models.User;

import com.midas.app.enums.ProviderType;
import com.midas.app.mappers.Mapper;
import com.midas.app.models.Account;
import com.midas.app.services.AccountService;
import com.midas.generated.api.AccountsApi;
import com.midas.generated.model.AccountDto;
import com.midas.generated.model.CreateAccountDto;
import com.midas.workflow.UserSignupWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.midas.app.models.User.ProviderType;

@Controller
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController implements AccountsApi {

  @Autowired
  AccountService accountService;
  @Autowired
  WorkflowClient workflowClient;
  private final Logger logger = LoggerFactory.getLogger(AccountController.class);

  @Override
  @PostMapping("/signup")
  public ResponseEntity<AccountDto> createUserAccount(
      @RequestBody CreateAccountDto createAccountDto) {
    logger.info("Creating account for user with email: {}", createAccountDto.getEmail());

    // Set providerType as STRIPE
    createAccountDto.setProviderType(ProviderType.STRIPE);

//    WorkflowOptions options =
//        WorkflowOptions.newBuilder().setTaskQueue("user-signup-tasks").build();
//    UserSignupWorkflow workflow = workflowClient.newWorkflowStub(UserSignupWorkflow.class, options);

    // Execute the workflow for user signup
    Account account = workflow.signupUser(createAccountDto);

    return new ResponseEntity<>(Mapper.toAccountDto(account), HttpStatus.CREATED);
  }

  @Override
  @GetMapping
  public ResponseEntity<List<AccountDto>> getUserAccounts() {
    logger.info("Retrieving all accounts");

    List<Account> accounts = accountService.getAccounts();
    List<AccountDto> accountsDto = accounts.stream().map(Mapper::toAccountDto).toList();

    return new ResponseEntity<>(accountsDto, HttpStatus.OK);
  }
}
