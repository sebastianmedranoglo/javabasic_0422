package Data;

public class Client {
    private User user;
    private Account account;

    public Client(User user, Account account){
        this.user=user;
        this.account=account;
    }
    public String clientInformation(){
        return "--------------------\n" +
                "Usuario: "+user.getName()+" \n" +
                "Numero de cuenta: "+ account.getAccountNumber()+" \n" +
                "Fecha de creacion de la cuenta: "+account.getOpeningDate().toString()+" \n" +
                "Balance de la cuenta: "+account.getBalance()+" \n" +
                "--------------------\n";
    }

    public Account getAccount() {
        return account;
    }

    public String getUserName(){
        return user.getName();
    }
    public User getUser(){
        return this.user;
    }
}
