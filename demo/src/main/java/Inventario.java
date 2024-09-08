import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        inventaryStart();
    }

    public static int userOption(String text) {
        Scanner scanner = new Scanner(System.in);
        int option  = 0;
        boolean opcionValida = false;
        System.out.print(text + " ");
        while (!opcionValida) {
            try {
                option = scanner.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Por favor ingrese un número entero.");
                scanner.next();
            } 
        }
        return option;
    }

    public static Object[][] optionElection (int option, Object[][] productos) {
        switch (option) {
            case 1:
                addInventory(productos);
                break;
            case 2:
                subtractInventory(productos);
                break;
            case 3:
                searchProduct(productos);
                break;
            case 4:
                listProducts(productos);
                break;
            default:
                System.out.println("Cerrando programa");
        }
        return productos;
    }

    public static void inventaryStart() {
        Object[][] productos = new Object[10][3];
        int opcion;
        do {
            elections();
            opcion = userOption("Seleccione una opción (0 para salir)");
            optionElection(opcion, productos);
        } while (opcion != 0);
    }

    public static void elections() {
        System.out.println("--------------------");
        System.out.println("1. Agregar Productos al inventario");
        System.out.println("2. Restar Productos al inventario");
        System.out.println("3. Consultar disponibilidad de un producto");
        System.out.println("4. Listar todos los productos");
        System.out.println("0. Salir");
        System.out.println("--------------------");
    }

    public static String userString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text + " :");
        String input = scanner.nextLine();
        return input;
    }

    public static Object[][] addInventory (Object[][] listaProductos){
        System.out.println("Se va a agregar un producto");
        int id = userOption("Ingrese el id del producto: ");
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i][0] != null && listaProductos[i][0].equals(id)) {
                System.out.println("El producto ya existe");
                int cantidad = userOption("Ingrese la cantidad a agregar: ");
                listaProductos[i][2] = (int) listaProductos[i][2] + cantidad;
                return listaProductos; 
            }
        }
        String nombre = userString("Ingrese el nombre del producto");
        int cantidad = userOption("Ingrese la cantidad del producto");
        listaProductos[id][0] = id;
        listaProductos[id][1] = nombre;
        listaProductos[id][2] = cantidad;
        return listaProductos;
    }

    public static void listProducts(Object[][] listaProductos) {
        System.out.println("Listado de productos");
        System.out.println("--------------------");
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i][0] != null) {
                System.out.println("ID: " + listaProductos[i][0] + " Nombre: " + listaProductos[i][1] + " Cantidad: " + listaProductos[i][2]);
            }
        }
    }

    public static Object[][] subtractInventory (Object[][] listaProductos) {
        System.out.println("Se van a restar productos del inventario");
        int id = userOption("Ingrese el id del producto: ");
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i][0] != null && listaProductos[i][0].equals(id)) {
                int cantidad = userOption("Ingrese la cantidad a restar: ");
                if ((int) listaProductos[i][2] - cantidad < 0) {
                    System.out.println("No se puede restar la cantidad solicitada");
                } else {
                    listaProductos[i][2] = (int) listaProductos[i][2] - cantidad;
                    return listaProductos;
                }
            }
        }
        System.out.println("El producto no existe");
        return listaProductos;
    }

    public static void searchProduct(Object[][] listaProductos) {
        System.out.println("Se va a buscar un producto");
        int id = userOption("Ingrese el id del producto: ");
        for (int i = 0; i < listaProductos.length; i++) {
            if (listaProductos[i][0] != null && listaProductos[i][0].equals(id)) {
                System.out.println("ID: " + listaProductos[i][0] + " Nombre: " + listaProductos[i][1] + " Cantidad: " + listaProductos[i][2]);
                return;
            }
        }
        System.out.println("El producto no existe");
    }

    

}