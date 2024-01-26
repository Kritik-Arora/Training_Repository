package dao;

import entity.BankAccount;
import exceptions.AccountNumberInvalidException;
import exceptions.InsufficientFundsException;
import exceptions.NegativeAmountException;

public interface IServiceProvider {
	
	double checkBalance(long accountNumber);

    boolean deposit(long accountNumber, double amount) throws NegativeAmountException, AccountNumberInvalidException;

    boolean withdraw(long accountNumber, double amount) throws NegativeAmountException, AccountNumberInvalidException, InsufficientFundsException;

    boolean createAccount(String holderName, String type, double balance);

    boolean removeAccount(long accountNumber);

    BankAccount searchAccount(long accountNumber);

		
	}



