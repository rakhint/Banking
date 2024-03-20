package net.javaguides.banking.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.mapper.AccountMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;

@Service
public class Accountserviceimpl implements AccountService{
   
	private AccountRepository accountRepository;//Injecting dependency of repository Interface
	
	//Constructor injection
	@Autowired
	public Accountserviceimpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}


	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount= accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	
	@Override
	public List<AccountDto> getAccountname(){
		List<AccountDto> holderdetails = new ArrayList<>();
		List<Account> savedname= accountRepository.findAll();
		for (Account acthldrname : savedname) {
		AccountDto name=AccountMapper.mapToAccountDto(acthldrname);
		holderdetails.add(name);
		}
		
		return holderdetails;
	}
	
	@Override
	public AccountDto getAccountDetailsbyId(Long id) {
		//orElseThrow isliye daale hai kyuki in case id ny hoga toh we are handling it
		Account fetchedbyid=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
		AccountDto fetchedbyidcovdto= AccountMapper.mapToAccountDto(fetchedbyid);
		return fetchedbyidcovdto;
	}
	
	@Override
	public AccountDto depositbalanceamt(Long id , double amount) {
		Account fetchedbyid=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));	
		Double Total= fetchedbyid.getBalance()+amount;
		fetchedbyid.setBalance(Total);
		Account savedaccount= accountRepository.save(fetchedbyid);
		return AccountMapper.mapToAccountDto(savedaccount);
		
	}
	
	@Override
	public AccountDto withbalance(Long id, double amount) {
		Account fetchedbyid=accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));	
		if(fetchedbyid.getBalance()<amount) {
			throw new RuntimeException("Insufficient bal");
		}
		else {
		double leftbal=fetchedbyid.getBalance() - amount;
		fetchedbyid.setBalance(leftbal);
		Account savebal= accountRepository.save(fetchedbyid);
		return AccountMapper.mapToAccountDto(savebal);
		}
	
	}
	
	@Override
	public void deleteAccbyid(Long id) {
    Account fetchbyid=accountRepository.findById(id).orElseThrow(()-> new RuntimeException ("id does not exist"));
    if(fetchbyid!=null)
    accountRepository.deleteById(id);

	}
    
}
