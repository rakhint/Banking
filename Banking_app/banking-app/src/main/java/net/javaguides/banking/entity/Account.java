package net.javaguides.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="accounts")
@Entity
public class Account {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@Column(name="account_holder_name")
private String accountHolderName;

public Account() {
	super();
	// TODO Auto-generated constructor stub
}

private double balance;

public Account(Long id, String accountHolderName, double balance) {
	super();
	this.id = id;
	this.accountHolderName = accountHolderName;
	this.balance = balance;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAccountHolderName() {
	return accountHolderName;
}

public void setAccountHolderName(String accountHolderName) {
	this.accountHolderName = accountHolderName;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}



}
