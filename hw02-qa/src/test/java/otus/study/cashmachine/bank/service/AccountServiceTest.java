package otus.study.cashmachine.bank.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import otus.study.cashmachine.bank.dao.AccountDao;
import otus.study.cashmachine.bank.data.Account;
import otus.study.cashmachine.bank.service.impl.AccountServiceImpl;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    AccountDao accountDao;

    @InjectMocks
    AccountServiceImpl accountServiceImpl;
    Account expectedAccount = new Account(0, BigDecimal.TEN);

    @Test
    void createAccountMock() {
// @TODO test account creation with mock and ArgumentMatcher
        when(accountDao.saveAccount(expectedAccount)).thenReturn(expectedAccount);
        assertEquals(expectedAccount, accountServiceImpl.createAccount(BigDecimal.TEN));
    }

    @Test
    void createAccountCaptor() {
//  @TODO test account creation with ArgumentCaptor
        ArgumentCaptor<Account> argumentCaptor = ArgumentCaptor.forClass(Account.class);
        when(accountDao.saveAccount(argumentCaptor.capture())).thenReturn(new Account(0, BigDecimal.TEN));
        accountServiceImpl.createAccount(BigDecimal.TEN);
        assertEquals(expectedAccount.getAmount(), argumentCaptor.getValue().getAmount());
    }

    @Test
    void addSum() {
    }

    @Test
    void getSum() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void checkBalance() {
    }
}
