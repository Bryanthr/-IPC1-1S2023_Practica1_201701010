
package practica1ipc1;

import java.util.Scanner;

public class Practica1ipc1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String user, passw, cliente = null, cupon, nada=null;
        boolean usu, con, fina=false;
        int op1, cont=0, conta=0, nit = 0, rnit, numc =-1, seguir, factura, ncli=0;
        String[][] nombrep = new String[20][20];
        Float[][] precio = new Float[20][20];
        double tot=0, desc=0, descu=0, totall=0, porcentaje =0;
        
        System.out.println("Cajero electronico SUPER-25");
        do{
            System.out.println("Ingrese el Usuario: ");
            user = entrada.next();
            if ("cajero_201701010".equals(user)){
                usu = true;
            }else{
                usu = false;
            }
            System.out.println("Ingrese la Contraseña: ");
            passw = entrada.next();
            if ("ipc1_201701010".equals(passw)){
                con = true;
            }else{
                con = false;
            }
            if(con==true && usu==true){
                System.out.println("Bienvenido Bryant");
            }else{
                System.out.println("**************ERROR*************:");
                System.out.println("Usuario y contraseña no coinciden");
                System.out.println("*********************************");
                System.out.println("Ingrese los datos nuevamente");
            }
        }while (usu == false || con == false);
        
        do{
            System.out.println("            MENU");
            System.out.println("1. Agregar nuevos productos");
            System.out.println("2. Agregar cupones de descuento");
            System.out.println("3. Realizar ventas");
            System.out.println("4. Realizar reporte");
            System.out.println("5. Salir");
            op1 = entrada.nextInt();
            if (op1<=5 && op1 != 0){
                switch (op1){
                    case 1:
                        numc=numc+1;
                        System.out.println("Agregar productos");
                        for (int i=numc; i<=numc; i++){
                            System.out.println("Ingrese un producto");
                            nombrep[ncli][numc] = entrada.next();
                            System.out.println("Ingrese el precio del producto");
                            precio[ncli][numc] = entrada.nextFloat();
                            tot=tot+precio[ncli][numc];
                            System.out.println("¿Seguir agregando? ");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            seguir = entrada.nextInt();
                            if (seguir == 1){
                                numc=numc+1;
                            }else if(seguir == 2){
                                System.out.println(" ");
                            }else{
                                System.out.println("No ingresó ninguna opción válida");
                                System.out.println("Se guardaron los productos");
                                System.out.println("Regresando al menú principal...");
                            }
                            
                        }
                    break;
                        
                    case 2:
                        System.out.println("Agregar cupones de descuento");
                        System.out.println("Ingrese el codigo del cupón (4 caracteres): ");
                        cupon = entrada.next();
                        int cuponl = cupon.length();
                        if (cuponl == 4){
                            System.out.println("Ingrese el porcentaje de descuento del cupón:");
                            porcentaje = entrada.nextInt();
                            if (porcentaje <=0 || porcentaje >=100){
                                System.out.println("Pocentaje del cupón inválido");
                                porcentaje = 0;
                            }else{
                                System.out.println("Cupon guardado");
                            }
                        }else{
                            System.out.println("Cupón invalido");
                        }
                        
                        break;
                        
                    case 3:
                        System.out.println("Realizar ventas");
                        System.out.println("Productos ingresados: ");
                        for (int i=0; i<= numc; i++){
                            System.out.println(i+1 + ". " + nombrep[ncli][i] + " Q." + precio[ncli][i]);
                        }
                        System.out.println("Porcentaje de descuento: " + porcentaje + "%");
                        System.out.println("¿Generar factura?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        factura = entrada.nextInt();
                        if(factura == 1){
                            
                        
                            System.out.println("Ingresar NIT");
                            System.out.println("1. SI");
                            System.out.println("2. NO");
                            System.out.println("Si ingresa una opcion no válida se tomará como CF");
                            rnit = entrada.nextInt();
                            if (rnit == 1){
                                System.out.println("Ingrese el NIT del cliente: ");
                                nit = entrada.nextInt();
                                nada = entrada.nextLine();
                                System.out.println("Ingrese el nombre del cliente");
                                cliente = entrada.nextLine();
                            } else if(rnit == 2){
                                nit = 0;
                                cliente = "CF";
                                System.out.println("Cliente como CF");
                                System.out.println("");
                            } else{
                                System.out.println("No ingresó ninguna opción válida");
                                System.out.println("Se tomará como CF");
                            }
                            System.out.println("Emitiendo Factura...");
                            System.out.println(" ");
                            System.out.println("*********************************************");
                            System.out.println("-----------------SUPER-25------------------");
                            System.out.println("Nombre del Cajero: " + "Bryant Herrera Rubio");
                            System.out.println("Nombre del Cliente: "+ cliente);
                            System.out.println("Número de NIT: " + nit);
                            System.out.println("Fecha de Emisión de la factura: 9 de Febrero de 2023*");
                            for(int i=0; i<=numc; i++){
                                System.out.println( i+1 + ". Q." + precio[ncli][i] + "  " +  nombrep[ncli][i]);
                            
                            }
                            System.out.println("El subtotal es de: Q." + tot);
                            System.out.println("El descuento del cupón es de: " + porcentaje + "%");
                            desc = porcentaje/100;
                            descu = desc * tot;
                            totall=tot-descu;
                            ncli=ncli+1;
                            numc=-1;
                            System.out.println("Total a pagar: Q." + totall);
                            System.out.println("*********************************************");
                            System.out.println("Gracias por preferir SUPER-25");
                            System.out.println(" ");
                        }else if(factura==2){
                            System.out.println(" ");
                        }else{
                            System.out.println("No ingresó ninguna opción mostrada");
                            System.out.println("Regresando al menú principal...");
                            System.out.println(" ");
                        }
                        break;
                        
                    case 4:
                        System.out.println("Realizar Reporte");
                        System.out.println("***********************");
                        for(int i=0; i<= ncli; i++){
                            for(int j=0; j<=numc;j++){
                                System.out.println(nombrep[i][j] + "    1");
                            }
                        }
                        break;
                        
                    case 5:
                        System.out.println("Apagando...");
                }
            }else{
                System.out.println("ERROR: porfavor ingrese una de las opciones válidas");
            }
            
        }while (op1 != 5);
    }
    
}
