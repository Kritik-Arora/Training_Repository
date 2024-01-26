package mainmod;
import entity.Bank;
import entity.BankAccount;
import exceptions.AccountNumberInvalidException;
import exceptions.InsufficientFundsException;
import exceptions.NegativeAmountException;
import dao.IServiceProvider;
import dao.ServiceProviderImpl;
import java.util.logging.Logger;
import java.lang.System.Logger.Level;
import java.util.*;
import java.util.logging.*;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
public class MainModule {
	private static final Logger logger = Logger.getLogger(MainModule.class.getName());

	    static {
	        try {
	            // Setting up a FileHandler to log to a file named "info.log"
	        	FileHandler fileHandler = new FileHandler("info.log");
	        	fileHandler.setLevel(java.util.logging.Level.INFO);
	            // Creating a SimpleFormatter
	            SimpleFormatter formatter = new SimpleFormatter();

	            // Setting the formatter for the FileHandler
	            fileHandler.setFormatter(formatter);

	            // Adding the FileHandler to the logger
	            logger.addHandler(fileHandler);
	        } catch (Exception e) {
	            logger.warning("Error setting up logger: " + e.getMessage());
	        }
	    }

	    public static void main(String[] args) throws AccountNumberInvalidException, NegativeAmountException {
	        List<BankAccount> accountList = new ArrayList<>();
	        IServiceProvider serviceProvider = new ServiceProviderImpl(accountList);

	        // Creating 3 accounts
	        logger.info("Creating 3 accounts");
	        serviceProvider.createAccount("John Doe", "Savings", 5000.0);
	        serviceProvider.createAccount("Jane Doe", "Checking", 3000.0);
	        serviceProvider.createAccount("Alice Smith", "Savings", 8000.0);

	        // Displaying initial account details
	        displayAccountDetails("Initial", accountList);

	        // Performing transactions
	        try {
	            logger.info("Performing transactions");
	            performTransactions(serviceProvider);
	        } catch (NegativeAmountException | AccountNumberInvalidException | InsufficientFundsException e) {
	            logger.warning("Exception during transactions: " + e.getMessage());
	        }

	        // Displaying updated account details
	        displayAccountDetails("Updated", accountList);

	        logger.info("Checking balance for account number 2");
			double balance = serviceProvider.checkBalance(2);
			logger.info("Balance for Account 2: " + balance);

	        logger.info("Removing account number 3");
			boolean removeStatus = serviceProvider.removeAccount(3);
			if (removeStatus) {
			    logger.info("Account 3 removed successfully.");
			} else {
			    logger.warning("Failed to remove Account 3.");
			}

	        logger.info("Creating a new account");
			serviceProvider.createAccount("Bob Johnson", "Checking", 6000.0);

	        // Displaying final account details
	        displayAccountDetails("Final", accountList);
	        
	    }

	    private static void displayAccountDetails(String status, List<BankAccount> accountList) {
	        logger.info(status + " Account Details:");
	        for (BankAccount account : accountList) {
	            logger.info(account.toString());
	        }
	        logger.info("");
	        
	    }

	    private static void performTransactions(IServiceProvider serviceProvider)
	            throws NegativeAmountException, AccountNumberInvalidException, InsufficientFundsException {
	        // Deposit and Withdraw transactions
	        logger.info("Performing Deposit and Withdraw transactions");
	        serviceProvider.deposit(1, 1000.0);
	        serviceProvider.withdraw(2, 500.0);
	        serviceProvider.deposit(3, 2000.0);
	    }
	    
	}


	
	    