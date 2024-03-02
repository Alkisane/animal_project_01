class Animals {
    private String name;
    private String birthdate;
    private List<String> commands;
    
    // конструктор
    public Animals(String name, String birthdate, List<String> commands) {
        this.name = name;
        this.birthdate = birthdate;
        this.commands = commands;
    }
    
    // геттеры и сеттеры
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public List<String> getCommands() {
        return commands;
    }
    
    public void setCommands(List<String> commands) {
        this.commands = commands;
    }
}

class Pets extends Animals {
    // конструктор
    public Pets(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class PackAnimals extends Animals {
    // конструктор
    public PackAnimals(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Dogs extends Pets {
    // конструктор
    public Dogs(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Cats extends Pets {
    // конструктор
    public Cats(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Hamsters extends Pets {
    // конструктор
    public Hamsters(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Horses extends PackAnimals {
    // конструктор
    public Horses(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Camels extends PackAnimals {
    // конструктор
    public Camels(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}

class Donkeys extends PackAnimals {
    // конструктор
    public Donkeys(String name, String birthdate, List<String> commands) {
        super(name, birthdate, commands);
    }
}
class Animals {
    private String name;
    private String birthdate;
    private List<String> commands;

    // конструктор, геттеры и сеттеры
}

class Pets extends Animals {
    // конструктор, геттеры и сеттеры
}

class PackAnimals extends Animals {
    // конструктор, геттеры и сеттеры
}

class Dogs extends Pets {
    // конструктор, геттеры и сеттеры
}

class Cats extends Pets {
    // конструктор, геттеры и сеттеры
}

class Hamsters extends Pets {
    // конструктор, геттеры и сеттеры
}

class Horses extends PackAnimals {
    // конструктор, геттеры и сеттеры
}

class Camels extends PackAnimals {
    // конструктор, геттеры и сеттеры
}

class Donkeys extends PackAnimals {
    // конструктор, геттеры и сеттеры
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Registry {
    private Map<String, List<Animals>> registry;

    public Registry() {
        registry = new HashMap<>();
    }

    public void addAnimal(String animalType, Animals animal) {
        if (!registry.containsKey(animalType)) {
            registry.put(animalType, new ArrayList<>());
        }
        registry.get(animalType).add(animal);
    }

    public void listCommands(String animalType, String animalName) {
        if (registry.containsKey(animalType)) {
            List<Animals> animals = registry.get(animalType);
            for (Animals animal : animals) {
                if (animal.getName().equals(animalName)) {
                    System.out.println(animal.getCommands());
                    return;
                }
            }
        }
        System.out.println("Animal not found!");
    }

    public void trainCommand(String animalType, String animalName, String newCommand) {
        if (registry.containsKey(animalType)) {
            List<Animals> animals = registry.get(animalType);
            for (Animals animal : animals) {
                if (animal.getName().equals(animalName)) {
                    List<String> commands = animal.getCommands();
                    commands.add(newCommand);
                    animal.setCommands(commands);
                    return;
                }
            }
        }
        System.out.println("Animal not found!");
    }

    public void listAnimalsByBirthdate(String startDate, String endDate) {
        System.out.println("Animals born between " + startDate + " and " + endDate);
        for (List<Animals> animals : registry.values()) {
            for (Animals animal : animals) {
                if (isBetween(animal.getBirthdate(), startDate, endDate)) {
                    System.out.println(animal.getName());
                }
            }
        }
    }

    private boolean isBetween(String date, String startDate, String endDate) {
        // реализация проверки нахождения даты в промежутке
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registry registry = new Registry();

        boolean running = true;
        while (running) {
            System.out.println("==== Animal Registry ====");
            System.out.println("1. Add new animal");
            System.out.println("2. List commands of an animal");
            System.out.println("3. Train an animal with new commands");
            System.out.println("4. List animals by birthdate");
            System.out.println("0. Exit");

            System.out.print("Enter option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // считываем \n после ввода числа

            switch (option) {
                case 1:
                    System.out.print("Enter animal type: ");
                    String animalType = scanner.nextLine();
                    
                    System.out.print("Enter animal name: ");
                    String animalName = scanner.nextLine();
                    
                    System.out.print("Enter animal birthdate: ");
                    String birthdate = scanner.nextLine();
                    
                    System.out.print("Enter animal commands (comma-separated): ");
                    String commandsInput = scanner.nextLine();
                    String[] commandsArray = commandsInput.split(",");
                    List<String> commandsList = new ArrayList<>();
                    for (String command : commandsArray) {
                        commandsList.add(command.trim());
                    }

                    Animals animal = new Animals(animalName, birthdate, commandsList);
                    registry.addAnimal(animalType, animal);
                    System.out.println("Animal added successfully!");
                    break;

                case 2:
                    System.out.print("Enter animal type: ");
                    animalType = scanner.nextLine();
                    
                    System.out.print("Enter animal name: ");
                    animalName = scanner.nextLine();
                    registry.listCommands(animalType, animalName);
                    break;

                case 3:
                    System.out.print("Enter animal type: ");
                    animalType = scanner.nextLine();
                    
                    System.out.print("Enter animal name: ");
                    animalName = scanner.nextLine();
                    
                    System.out.print("Enter new command: ");
                    String newCommand = scanner.nextLine();
                    registry.trainCommand(animalType, animalName, newCommand);
                    System.out.println("Command trained successfully!");
                    break;

                case 4:
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    registry.listAnimalsByBirthdate(startDate, endDate);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
}
class Animals {
    private static int counter = 0;

    public Animals() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}

Animals animal1 = new Animals();
Animals animal2 = new Animals();

System.out.println(Animals.getCounter()); // выведет 2