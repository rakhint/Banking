package net.javaguides.banking.service;

import java.util.List;

import net.javaguides.banking.dto.AccountDto;
//import net.javaguides.banking.entity.Account;
import net.javaguides.banking.entity.Account;

public interface AccountService {

	//public abstract Account createAccount(Account amount);
	public abstract AccountDto createAccount(AccountDto amountDto);
	public List<AccountDto> getAccountname();
	AccountDto getAccountDetailsbyId(Long id);
	AccountDto depositbalanceamt(Long id,double amount);
	AccountDto withbalance(Long id, double amount) ;
	void deleteAccbyid(Long id) ;
}
