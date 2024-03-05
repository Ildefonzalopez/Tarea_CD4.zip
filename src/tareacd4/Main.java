package tareacd4;

import banco.CtaCorriente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
 public static final Logger loger = Logger.getLogger("mensajes");

    
   
    public static void main(String[] args) throws IOException {
         operativa_cuenta ();
    }

    public static void  operativa_cuenta () throws IOException {
      
         CtaCorriente miCuenta;
        
        double saldoActual;

        miCuenta = new CtaCorriente("Koldo García Ábalos","0001-2345-07-1234567890",5000,0);
    
        loger.log(Level.INFO, "El saldo inicial es de {0}euros", miCuenta);

        try {
            Scanner entrada = new Scanner(System.in);
            loger.info("¿Cuánto desea retirar?");
            double importe = entrada.nextDouble();
            miCuenta.retirar(importe);
          loger.log(Level.INFO, "El saldo actual de su cuenta es {0}euros", miCuenta);
        } catch (IllegalArgumentException e) {
            loger.info("Fallo al retirar");
        }
        try {
            Scanner entrada = new Scanner(System.in);
           loger.info("¿Cuánto desea ingresar en su cuenta?");
            double importe = entrada.nextDouble();
            miCuenta.ingresar(importe);
            loger.log(Level.INFO, "El saldo actual de su cuenta es {0} euros", miCuenta);
        } catch (IllegalArgumentException e) {
            loger.log(Level.INFO,"Fallo al ingresar");
        }
    }
}