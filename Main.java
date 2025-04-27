import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void visit_to_cities(LinkedList<String> cities) {
        
        ListIterator<String> iterator = cities.listIterator();
        
        Scanner scanner = new Scanner(System.in);
        
        if (!iterator.hasNext()) { 
            System.out.println("There is no city to visit.");
            return;
        }

        boolean exit = false;
        boolean next = true;

        show_transactions();
        
        while (!exit) {
            System.out.print("Enter a transaction number: ");
            int transaction = scanner.nextInt();
            
            switch (transaction) {
                case 0:
                    show_transactions();
                    break;
                    
                case 1: // Go to next city
                	
                	if(!next) {
                		if(iterator.hasNext()) {
                			iterator.next();
                		}
                		next = true;
                	}
                	
                    if (iterator.hasNext()) {
                        System.out.println("Heading to city: " + iterator.next());
                    } else {
                        System.out.println("No more cities to visit forward.");
                        next = false;
                    }
                    break;
                    
                case 2: // Go to previous city
                	
                	if(next) {
                		if(iterator.hasPrevious()) {
                			iterator.previous();
                		}
                		next = false;
                	}
                	
                    if (iterator.hasPrevious()) {
                        System.out.println("Heading to city: " + iterator.previous());
                    } else {
                        System.out.println("You are at the start of the tour.");
                    }
                    break;
                    
                case 3:
                    exit = true;
                    System.out.println("The program is terminating...");
                    break;
                    
                default:
                    System.out.println("Invalid transaction. Please try again.");
            }
        }
    }

    public static void show_transactions() {
        System.out.println("\nAvailable Transactions:");
        System.out.println("0 - Show Transactions");
        System.out.println("1 - Go to the next city");
        System.out.println("2 - Go to the previous city");
        System.out.println("3 - Terminate the Transactions\n");
    }

    public static void main(String[] args) {
        
        LinkedList<String> cities = new LinkedList<>();
        
        cities.add("Berlin");
        cities.add("Antalya");
        cities.add("Paris");
        cities.add("Barcelona");
        
        visit_to_cities(cities);
    }
}
