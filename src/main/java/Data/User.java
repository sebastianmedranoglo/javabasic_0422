package Data;

public class User {
    private String name;
    private String password;

    public User(String name, String password){
        this.name=name;
        this.password=password;
    }
    public String getName(){
        return this.name;
    }

    public boolean validateUser(String name, String password){
        return name.equals(this.name)&&password.equals(this.password);
    }
}

