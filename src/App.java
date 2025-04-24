import Models.Person;
import View.View;
import Controllers.ShortingMethods;
import Controllers.SearchMethods;

public class App {
    private View view;
    private ShortingMethods shortingMethods;
    private SearchMethods searchMethods;
    private Person[] persons;
    private int personCount;
    private final int MAX_PERSONS = 100;
    
    public App() {
        this.view = new View();
        this.shortingMethods = new ShortingMethods();
        this.searchMethods = new SearchMethods();
        this.persons = new Person[MAX_PERSONS];
        this.personCount = 0;
    }
    
    public void start() {
        int option;
        do {
            option = view.showMenu();
            
            switch (option) {
                case 1:
                    inputPersons();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    view.displayPersons(getPersons());
                    break;
                case 4:
                    sortPersons();
                    break;
                case 5:
                    searchPerson();
                    break;
                case 0:
                    System.out.println("Gracias por usar el programa!");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (option != 0);
    }
    
    public void inputPersons() {
        int count = view.inputNumberOfPersons();
        
        // Reiniciar el arreglo si se ingresan nuevas personas
        persons = new Person[MAX_PERSONS];
        personCount = 0;
        
        for (int i = 0; i < count; i++) {
            System.out.println("\nPersona " + (i + 1) + ":");
            Person person = view.inputPerson();
            persons[personCount++] = person;
        }
        
        System.out.println("\nSe han ingresado " + count + " personas correctamente.");
    }
    
    public void addPerson() {
        if (personCount >= MAX_PERSONS) {
            System.out.println("Error: No se pueden agregar mas personas. Limite alcanzado.");
            return;
        }
        
        System.out.println("\nIngrese los datos de la nueva persona:");
        Person person = view.inputPerson();
        persons[personCount++] = person;
        
        System.out.println("\nPersona agregada correctamente.");
    }
    
    public Person[] getPersons() {
        Person[] result = new Person[personCount];
        System.arraycopy(persons, 0, result, 0, personCount);
        return result;
    }
    
    public void sortPersons() {
        if (personCount == 0) {
            System.out.println("No hay personas para ordenar.");
            return;
        }
        
        int sortOption = view.selectSortingMethod();
        
        switch (sortOption) {
            case 1:
                shortingMethods.sortByNameWithBubble(persons);
                System.out.println("Personas ordenadas por nombre (Bubble Sort).");
                break;
            case 2:
                shortingMethods.sortByNameWithSelectionDes(persons);
                System.out.println("Personas ordenadas por nombre descendente (Selection Sort).");
                break;
            case 3:
                shortingMethods.sortByAgeWithInsertion(persons);
                System.out.println("Personas ordenadas por edad (Insertion Sort).");
                break;
            case 4:
                shortingMethods.sortByNameWithInsertion(persons);
                System.out.println("Personas ordenadas por nombre (Insertion Sort).");
                break;
            default:
                System.out.println("Opcion invalida. No se realizo ningun ordenamiento.");
                break;
        }
    }
    
    public void searchPerson() {
        if (personCount == 0) {
            System.out.println("No hay personas para buscar.");
            return;
        }
        
        int searchOption = view.selectSearchCriterion();
        Person result = null;
        
        switch (searchOption) {
            case 1: // Busqueda por edad
                if (!searchMethods.isSortedByAge(persons)) {
                    System.out.println("El arreglo no esta ordenado por edad. Ordenando...");
                    shortingMethods.sortByAgeWithInsertion(persons);
                }
                
                int ageToSearch = view.inputAge();
                result = searchMethods.binarySearchByAge(getPersons(), ageToSearch);
                break;
                
            case 2: // Busqueda por nombre
                if (!searchMethods.isSortedByName(persons)) {
                    System.out.println("El arreglo no esta ordenado por nombre. Ordenando...");
                    shortingMethods.sortByNameWithInsertion(persons);
                }
                
                String nameToSearch = view.inputName();
                result = searchMethods.binarySearchByName(getPersons(), nameToSearch);
                break;
                
            default:
                System.out.println("Opcion invalida. No se realizo ninguna busqueda.");
                return;
        }
        
        view.displaySearchResult(result);
    }
    
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
}