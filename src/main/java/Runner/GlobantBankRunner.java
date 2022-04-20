package Runner;

import Data.Account;
import Data.Client;
import Data.Clients;
import Data.User;
import Resource.MenuResource;

import java.util.Optional;
import java.util.Scanner;

public class GlobantBankRunner {
    public static void main(String[] args) {
        Optional<Client> currentClient;
        Scanner scan = new Scanner(System.in);
        int menuOption=0;
        String auxUserName;
        String auxPassword;
        double auxAmount;
        int auxAccountNumber;


        do {
            try {
                System.out.println(MenuResource.menuOptions());
                menuOption = scan.nextInt();
                switch (menuOption) {
                    case 1:
                        System.out.println(MenuResource.getUserName());
                        auxUserName = scan.next();
                        System.out.println(MenuResource.getPassword());
                        auxPassword = scan.next();
                        currentClient = Clients.findByUser(auxUserName, auxPassword);
                        if (currentClient.isPresent()) {
                            menuOption = 0;
                            do {
                                System.out.println(MenuResource.clientOptions(currentClient.get()));
                                menuOption = scan.nextInt();
                                switch (menuOption) {
                                    case 1:
                                        System.out.println(MenuResource.setAmount());
                                        auxAmount = scan.nextDouble();
                                        System.out.println(Clients.addMoneyToClientAccount(currentClient.get().getAccount().getAccountNumber(), auxAmount) ?
                                                MenuResource.success() : MenuResource.error());
                                        break;
                                    case 2:
                                        System.out.println(MenuResource.setAmount());
                                        auxAmount = scan.nextDouble();
                                        System.out.println(Clients.withdrawMoneyFromClientAccount(currentClient.get().getAccount().getAccountNumber(), auxAmount) ?
                                                MenuResource.success() : MenuResource.error());
                                        break;
                                    case 3:
                                        System.out.println(MenuResource.setAmount());
                                        auxAmount = scan.nextDouble();
                                        System.out.println(MenuResource.setAccountNumber());
                                        auxAccountNumber = scan.nextInt();
                                        System.out.println(Clients.transfer(currentClient.get().getAccount().getAccountNumber(), auxAccountNumber, auxAmount) ?
                                                MenuResource.success() : MenuResource.error());
                                        break;
                                    case 4:
                                        System.out.println(Clients.clientInfo(currentClient.get().getAccount().getAccountNumber()));
                                    default:
                                        break;
                                }
                            } while (menuOption != 5);
                        } else {
                            System.out.println(MenuResource.userNotExist());
                        }
                        break;
                    case 2:
                        System.out.println(MenuResource.getUserName());
                        auxUserName = scan.next();
                        System.out.println(MenuResource.getPassword());
                        auxPassword = scan.next();
                        System.out.println(Clients.addClient(new Client(new User(auxUserName, auxPassword), new Account())) ?
                                MenuResource.success() : MenuResource.error());
                        break;
                    case 3:
                        System.out.println(Clients.listClients());
                        break;
                    default:
                        break;
                }
            }catch(Exception e){
                System.out.println(MenuResource.exception());
            }
        }while(menuOption!=4);

    }
}
