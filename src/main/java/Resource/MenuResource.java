package Resource;

import Data.Client;

public class MenuResource {


    public static String menuOptions(){
        return "######################################\n" +
                "Bienvenido a GlobantBank \n" +
                "Presione: \n" +
                "1--> Ingresar a su cuenta \n" +
                "2--> Crear una cuenta \n" +
                "3--> Listar todas las cuentas \n" +
                "4--> Salir \n" +
                "######################################\n";
    }
    public  static String clientOptions(Client client){
        return "______________________\n" +
                "Bienvenido Señor/a "+client.getUserName()+" \n" +
                "Presione: \n" +
                "1--> Consignar dinero en su cuenta de ahorros \n" +
                "2--> Retirar dinero de su cuenta de ahorros(Puede generar sobrecostos) \n" +
                "3--> Transferir dinero a otras cuentas (Puede generar sobrecostos) \n" +
                "4--> Consultar informacion de su cuenta \n" +
                "5--> Salir \n" +
                "______________________";
    }

    public static String getUserName(){
        return "Por favor ingrese el nombre de usuario ";
    }

    public static String getPassword(){
        return "Por favor ingrese su contrasena ";
    }

    public static String userNotExist(){
        return "Usuario o contrasena invalidos";
    }
    public static String setAmount(){
        return "Por favor ingrese el valor";
    }

    public static String success(){
        return "Transaccion exitosa";
    }

    public static String error(){
        return "Transaccion exitosa intentelo mas tarde";
    }

    public static String setAccountNumber(){
        return "Por favor ingrese el numero de cuenta al que quiere transferir";
    }

    public static String exception(){
        return "Ocurrio un error";
    }
}
