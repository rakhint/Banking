package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;

//mapper class is used to convert the dto into jpaentity and vice versa
public class AccountMapper {
 // convert the dto into jpaentity
	public static Account mapToAccount(AccountDto accountDto) {
		Account account =new Account(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance());
		return account;
	}
	
// convert the jpaentity into dto
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto =new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
		return accountDto;
	}	
}
