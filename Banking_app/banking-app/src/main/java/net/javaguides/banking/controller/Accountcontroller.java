package net.javaguides.banking.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.entity.Account;
import net.javaguides.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class Accountcontroller {

	private AccountService accountService;
 
	@Autowired
	public Accountcontroller(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	//@PostMapping
	//public void addaccount(@RequestBody AccountDto accountDto){
		//accountService.createAccount(accountDto);
//}
	
	@PostMapping
	public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
	
	
	}
	
	@GetMapping(value="/name")
	public List<String> getHoldername() {
		List<String> filtername=new ArrayList<>();
		List<AccountDto> holdername =accountService.getAccountname();
		for(AccountDto namedetails:holdername ) {
			String name=namedetails.getAccountHolderName();
			filtername.add(name);
		}
		return filtername;
	
		}
	
	@GetMapping(value="/accountdetails/")
	public List<AccountDto> getAccountDetails() {
		List<AccountDto> filtername=new ArrayList<>();
		List<AccountDto> holdername =accountService.getAccountname();
		for(AccountDto namedetails:holdername ) {
			
			filtername.add(namedetails);
		}
		return filtername;
	
		}
	
	@GetMapping(value="/accountdetailsbyid/{id}")
	public AccountDto getAccountbyId(@PathVariable Long id ){
		AccountDto fetchedacc=	accountService.getAccountDetailsbyId(id);
		return fetchedacc;
	}
	
//  @PutMapping(value="/deposit/{id}")
//public 	ResponseEntity<AccountDto> depositBalance(@PathVariable Long id, @RequestBody Map<String,Double> request){
//	 
//	AccountDto updatedbal=  accountService.depositbalanceamt(id,request.get("amount") );
//	  return ResponseEntity.ok(updatedbal);
//  }
  
  @PutMapping(value="/deposit/{id}")
  public 	ResponseEntity<AccountDto> deposittBalance(@PathVariable Long id, @RequestParam double amount){
  	 
  	AccountDto updatedbal=  accountService.depositbalanceamt(id,amount );
  	  return ResponseEntity.ok(updatedbal);
    }
  
  @PutMapping(value="/withdraw/{id}")
  public ResponseEntity<AccountDto> withdrawamt(@PathVariable Long id, @RequestBody Map<String,Double> wdrawrequest){
	  AccountDto updbalnce= accountService.withbalance(id,wdrawrequest.get("amount"));
	  return ResponseEntity.ok(updbalnce);
  }
  
  @DeleteMapping(value="/delete/{id}")
  public ResponseEntity<String> deleteAcc(@PathVariable Long id){
	  accountService.deleteAccbyid(id);
	 return ResponseEntity.ok("successfully deleted");
  }
  
}