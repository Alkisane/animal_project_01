// создаем класс "домашнее животное"
class domesticanimal {
    // поля класса
    private int id;
    private String type;
    private String name;
    private int age;

    // конструктор класса
    public domesticanimal(int id, String type, String name, int age) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.age = age;
    }

    // геттеры и сеттеры для полей класса

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // метод для вывода списка команд животного
    public void printCommands() {
        if (type.equals("dog")) {
            System.out.println("sit, stay, fetch");
        } else if (type.equals("cat")) {
            System.out.println("sit, pounce, scratch");
        } else if (type.equals("hamster")) {
            System.out.println("roll, hide");
        } else if (type.equals("horse")) {
            System.out.println("trot, canter, gallop");
        } else if (type.equals("donkey")) {
            System.out.println("walk, carry load, bray");
        } else {
            System.out.println("invalid animal type");
        }
    }
}

// создаем класс "счетчик"
class Counter implements AutoCloseable {
    private int value;

    // конструктор класса
    public Counter() {
        value = 0;
    }

    // метод для увеличения значения счетчика на 1
    public void add() {
        value++;
    }

    // метод интерфейса AutoCloseable для закрытия ресурсов
    @Override
    public void close() throws Exception {
        if (value > 0) {
            throw new Exception("resource not properly closed");
        }
    }

    // метод для получения значения счетчика
    public int getValue() {
        return value;
    }
}
// главный класс программы
public class AnimalRegistry {
    public static void main(String[] args) {
        // создаем объекты "домашних животных"
        DomesticAnimal animal1 = new DomesticAnimal(1, "dog", "fido", 3);
        DomesticAnimal animal2 = new DomesticAnimal(2, "cat", "whiskers", 4);
        DomesticAnimal animal3 = new DomesticAnimal(3, "hamster", "hammy", 2);

        // выводим информацию о животных
        System.out.println(animal1.getId() + "\t" + animal1.getName() + "\t" + animal1.getType() + "\t" + animal1.getAge());
        animal1.printCommands();

        System.out.println(animal2.getId() + "\t" + animal2.getName() + "\t" + animal2.getType() + "\t" + animal2.getAge());
        animal2.printCommands();

        System.out.println(animal3.getId() + "\t" + animal3.getName() + "\t" + animal3.getType() + "\t" + animal3.getAge());
        animal3.printCommands();

        // используем блок try-with-resources для работы со счетчиком
        try (Counter counter = new Counter()) {
            counter.add(); // увеличиваем значение счетчика на 1
            System.out.println("Counter value: " + counter.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}