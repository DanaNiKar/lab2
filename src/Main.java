import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
    //создается массив деревьев
    private static ArrayList<Tree> forest = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        userChoice = menu.menu();

        while (userChoice < 6)

            switch (userChoice) {
                case 1:
                    System.out.println("Вы решили добавить пустое дерево");
                    addEmptyTree();
                    userChoice = menu.menu();
                    break;
                case 2:
                    System.out.println("Вы решили добавить дерево с данными");
                    addTreeWithInf();
                    userChoice = menu.menu();
                    break;
                case 3:
                    System.out.println("Вы решили отредактировать данные");
                    editTree();
                    userChoice = menu.menu();
                    break;
                case 4:
                    System.out.println("Вы решили вывести информацию");
                    displayTrees();
                    userChoice = menu.menu();
                    break;
                case 5:
                    System.out.println("Вы решили отсортировать");
                    sortByAge();
                    userChoice = menu.menu();
                    break;
                default:
                    System.out.println("Вы ввели не то");
                    break;
            }
    }

    //метод, добавляющий пустое дерево
    private static void addEmptyTree() {
        forest.add(new Tree());
        System.out.println("Пустое дерево добавлено");
    }

    //метод, добавляющий дерево с информацией
    private static void addTreeWithInf() {
        System.out.print("Введите возраст дерева: ");
        int age = scanner.nextInt();
        System.out.print("Введите высоту дерева (в метрах): ");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите вид дерева: ");
        String species = scanner.nextLine();
        System.out.print("Введите местоположение дерева: ");
        String location = scanner.nextLine();
        forest.add(new Tree(age, height, species, location));
        System.out.println("Дерево с данными добавлено");
    }

    //метод, редактирующий дерево
    private static void editTree() {
        if (forest.isEmpty()) {
            System.out.println("Деревьев нет");
            return;
        }

        System.out.print("Необходимо ввести индекс дерева (от 0 до " + (forest.size() - 1) + "): ");
        int index = scanner.nextInt();
        if (index < 0 || index >= forest.size()) {
            System.out.println("Неверный индекс");
            return;
        }

        Tree tree = forest.get(index);
        System.out.println("Что отредактировать?");
        System.out.println("1. Возраст");
        System.out.println("2. Высоту");
        System.out.println("3. Вид");
        System.out.println("4. Местоположение");
        int choice = scanner.nextInt();
        //scanner.nextLine(); КАК РАБОТАЕТ С И БЕЗ

        switch (choice) {
            case 1:
                System.out.println("Введите новый возраст: ");
                tree.setAge(scanner.nextInt());
                break;
            case 2:
                System.out.println("Введите новую высоту: ");
                tree.setHeight(scanner.nextDouble());
                break;
            case 3:
                System.out.println("Введите новый вид: ");
                tree.setSpecies(scanner.nextLine());
                break;
            case 4:
                System.out.println("Введите новое местоположение: ");
                tree.setLocation(scanner.nextLine());
                break;
            default:
                System.out.println("Неверный выбор");
        }
        System.out.println("Дерево успешно отредактировано");
    }

    //метод, показывающий все деревья
    private static void displayTrees() {
        if (forest.isEmpty()) {
            System.out.println("Деревьев нет");
            return;
        }
        for (int i = 0; i < forest.size(); i++) {
            Tree tree = forest.get(i);
            tree.displayInfo(i);

            //вывод дополнительной функции на основе известных значений
            System.out.println("Зрелое ли дереве: " + ((tree.isMature()) ? "Да" : "Нет"));
            System.out.println();
        }
    }

    //метод, сортирующий деревья по возрасту
    private static void sortByAge() {
        if (forest.isEmpty()) {
            System.out.println("Деревьев нет");
            return;
        }
        //сортировка
        forest.sort(Comparator.comparingInt(Tree::getAge));
        //отображение
        for (int i = 0; i < forest.size(); i++) {
            Tree tree = forest.get(i);
            tree.displayInfo(i);
        }
        System.out.println("Деревья отсортированы по возрасту");
    }
}
