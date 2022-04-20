package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Clients {
    private static List<Client> clients= new ArrayList<>();

    public static boolean addClient(Client client){
        return clients.add(client);
    }
    public static boolean transfer(int sourceAccountNumber, int destinationAccountNumber, double amount ){
        int indexSource=findByAccountNumber(sourceAccountNumber);
        int indexDestination=findByAccountNumber(destinationAccountNumber);
        if(indexDestination>=clients.size() || indexSource>= clients.size()){
            return false;
        }else{
            if(clients.get(indexSource).getAccount().transferWithdraw(amount)){
                clients.get(indexDestination).getAccount().addMoney(amount);
                return true;
            }else{
                return false;
            }
        }
    }

    private static int findByAccountNumber(int accountNumber){
        return IntStream.range(0,clients.size())
                .filter(index->clients.get(index).getAccount().getAccountNumber()==accountNumber)
                .findFirst()
                .getAsInt();

    }

    public static Optional<Client> findByUser(String name, String password){
        return clients.stream().
                filter(client -> client.getUser().validateUser(name, password))
                .findFirst();
    }

    public static boolean addMoneyToClientAccount(int accountNumber, double amount){
        int indexAccount= findByAccountNumber(accountNumber);
        if(indexAccount>= clients.size()){
            return false;
        }else{
            clients.get(indexAccount).getAccount().addMoney(amount);
            return true;
        }
    }

    public static boolean withdrawMoneyFromClientAccount(int accountNumber, double amount){
        int indexAccount=findByAccountNumber(accountNumber);
        if(indexAccount>= clients.size()){
            return false;
        }else{
            return clients.get(indexAccount).getAccount().withdraw(amount);
        }
    }

    public static String listClients(){
        return clients.stream().map(client -> client.clientInformation()).collect(Collectors.joining(""));
    }

    public static String clientInfo(int accountNumber){
        int indexAccount=findByAccountNumber(accountNumber);
        if(indexAccount>= clients.size()){
            return "Cuenta no encontrada";
        }else{
            return clients.get(indexAccount).clientInformation();
        }

    }

}
