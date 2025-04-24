package View;

import Models.Person;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    
    public View() {
        scanner = new Scanner(System.in);
    }
    
    public int showMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1. Ingresar personas");
        System.out.println("2. Anadir una persona");
        System.out.println("3. Mostrar personas");
        System.out.println("4. Ordenar personas");
        System.out.println("5. Buscar persona");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opcion: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un numero valido.");
            return -1;
        }
    }
    
    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }
    
    public int selectSortingMethod() {
        System.out.println("\n=== METODOS DE ORDENAMIENTO ===");
        System.out.println("1. Ordenar por nombre (Bubble Sort)");
        System.out.println("2. Ordenar por nombre descendente (Selection Sort)");
        System.out.println("3. Ordenar por edad (Insertion Sort)");
        System.out.println("4. Ordenar por nombre (Insertion Sort)");
        System.out.print("Seleccione un metodo de ordenamiento: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un numero valido.");
            return -1;
        }
    }
    
    public int selectSearchCriterion() {
        System.out.println("\n=== CRITERIOS DE BUSQUEDA ===");
        System.out.println("1. Buscar por edad");
        System.out.println("2. Buscar por nombre");
        System.out.print("Seleccione un criterio de busqueda: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un numero valido.");
            return -1;
        }
    }
    
    public void displayPersons(Person[] persons) {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para mostrar.");
            return;
        }
        
        System.out.println("\n=== LISTA DE PERSONAS ===");
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null) {
                System.out.println((i + 1) + ". " + persons[i]);
            }
        }
    }
    
    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("\n=== RESULTADO DE LA BUSQUEDA ===");
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("\nPersona no encontrada.");
        }
    }
    
    public int inputAge() {
        int age = -1;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Ingrese la edad: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                if (age < 0 || age > 120) {
                    System.out.println("Error: La edad debe estar entre 0 y 120 anos.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
        
        return age;
    }
    
    public String inputName() {
        String name = "";
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Ingrese el nombre: ");
            name = scanner.nextLine().trim();
            
            if (name.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacio.");
            } else {
                validInput = true;
            }
        }
        
        return name;
    }
    
    public int inputNumberOfPersons() {
        int count = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Cuantas personas desea ingresar? ");
            try {
                count = Integer.parseInt(scanner.nextLine());
                if (count <= 0) {
                    System.out.println("Error: Ingrese un numero mayor a 0.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un numero valido.");
            }
        }
        
        return count;
    }
}