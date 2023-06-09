package org.example;

import org.example.DTO.Contract;
import org.example.DTO.Employee;
import org.example.DTO.Ship;
import org.example.datastructure.MainDB;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static MainDB mainDB = new MainDB();
    static boolean menu = true;

    public static void main(String[] args) {

        while (menu) {
            System.out.println("Доброго дня! Вас вітає крюїнгове агенство `MAMA-MIA`. Оберіть операцію:"
                    + "\n1. Додати записи"
                    + "\n2. Видалити записи"
                    + "\n3. Оновити готовий запис"
                    + "\n4. Форматований друк даних контрактів"
                    + "\n5. Автоматично заповнити базу даних"
                    + "\n6. Пошук по записах"
                    + "\n0. Вийти");
            String chosenIndex = scanner.nextLine();

            try {
                int menuIndex = Integer.parseInt(chosenIndex);
                menuController(menuIndex);
            } catch (NumberFormatException ex) {
                System.out.println(ex);
            }
        }
        scanner.close();
    }

    public static void menuController(int menuIndex) {
        String chosenIndex;
        switch (menuIndex) {
            case 1:
                System.out.println("1. Додати записи:"
                        + "\n1. Додати нове судно"
                        + "\n2. Додати нового співробітника"
                        + "\n3. Додати новий контракт"
                        + "\n0. Відміна");
                chosenIndex = scanner.nextLine();

                try {
                    menuIndex = Integer.parseInt(chosenIndex);
                    addNewRecord(menuIndex);
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                break;
            case 2:
                System.out.println("- Видалити записи:"
                        + "\n1. Видалити судно"
                        + "\n2. Видалити співробітника"
                        + "\n3. Видалити контракт"
                        + "\n0. Відміна");

                chosenIndex = scanner.nextLine();

                try {
                    menuIndex = Integer.parseInt(chosenIndex);
                    deleteRecord(menuIndex);
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                break;
            case 3:
                System.out.println("- Оновити записи:"
                        + "\n1. Оновити судно"
                        + "\n2. Оновити співробітника"
                        + "\n3. Оновити контракт"
                        + "\n0. Відміна");

                chosenIndex = scanner.nextLine();

                try {
                    menuIndex = Integer.parseInt(chosenIndex);
                    updateRecord(menuIndex);
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                break;
            case 4:
                mainDB.formattedPrintDB();
                break;
            case 5:
                mainDB.autoFill();
                break;
            case 6:
                System.out.println("- Знайти записи:"
                        + "\n1. Знайти судно"
                        + "\n2. Знайти співробітника"
                        + "\n3. Знайти контракт"
                        + "\n0. Відміна");

                chosenIndex = scanner.nextLine();

                try {
                    menuIndex = Integer.parseInt(chosenIndex);
                    searchRecord(menuIndex);
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                break;
            case 0:
                System.out.println("Завершуємо сесію ...");
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }

    public static void addNewRecord(int menuIndex) {
        switch (menuIndex) {
            case 1:
                System.out.println("- Додати нове судно");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть назву судна: ");
                    String name = scanner.nextLine();

                    System.out.print("Введіть тип судна: ");
                    String type = scanner.nextLine();

                    Ship ship = new Ship(id, name, type);
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.addNewShip(ship));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }

                break;
            case 2:
                System.out.println("2. Додати нового співробітника");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть ім'я співробітника: ");
                    String name = scanner.nextLine();

                    System.out.print("Введіть посаду співробітника: ");
                    String position = scanner.nextLine();

                    Employee employee = new Employee(id, name, position);
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.addNewEmployee(employee));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }

                break;
            case 3:
                System.out.println("3. Додати новий контракт");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть тип контракту: ");
                    String contractType = scanner.nextLine();

                    System.out.print("Введіть айді співробітників (розділені комою): ");
                    String employeeIdsInput = scanner.nextLine();
                    int[] employeeIds = parseEmployeeIds(employeeIdsInput);

                    System.out.print("Введіть унікальний айді лодки: ");
                    int boatId = Integer.parseInt(scanner.nextLine());

                    Contract contract = new Contract(id, contractType, employeeIds, boatId);
                    long startTime = System.nanoTime();
                    String contractAddResult = mainDB.addNewContract(contract);
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                    System.out.println(contractAddResult);
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                }
                break;

            case 0:
                System.out.println("Повертаємось назад ...");
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }

    private static int[] parseEmployeeIds(String input) {
        String[] idsArray = input.split(",");
        int[] employeeIds = new int[idsArray.length];
        for (int i = 0; i < idsArray.length; i++) {
            employeeIds[i] = Integer.parseInt(idsArray[i].trim());
        }
        return employeeIds;
    }

    public static void deleteRecord(int menuIndex) {
        switch (menuIndex) {
            case 1:
                System.out.println("- Видалити судно");

                try {
                    System.out.print("Введіть унікальний айді судна, що треба видалити: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.deleteShip(id));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 2:
                System.out.println("- Видалити співробітника");

                try {
                    System.out.print("Введіть унікальний айді співробітника, що треба видалити: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.deleteEmployee(id));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 3:
                System.out.println("- Видалити контракт");

                try {
                    System.out.print("Введіть унікальний айді контракту, що треба видалити: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.deleteContract(id));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;

            case 0:
                System.out.println("Повертаємось назад ...");
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }

    public static void updateRecord(int menuIndex) {
        switch (menuIndex) {
            case 1:
                System.out.println("1. Оновити судно");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть назву судна: ");
                    String name = scanner.nextLine();

                    System.out.print("Введіть тип судна: ");
                    String type = scanner.nextLine();

                    Ship ship = new Ship(id, name, type);
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.updateShip(ship));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 2:
                System.out.println("2. Оновити співробітника");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть ім'я співробітника: ");
                    String name = scanner.nextLine();

                    System.out.print("Введіть посаду співробітника: ");
                    String position = scanner.nextLine();

                    Employee employee = new Employee(id, name, position);
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.updateEmployee(employee));
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 3:
                System.out.println("3. Оновити контракт");

                try {
                    System.out.print("Введіть унікальний айді: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введіть тип контракту: ");
                    String contractType = scanner.nextLine();

                    System.out.print("Введіть айді співробітників (розділені комою): ");
                    String employeeIdsInput = scanner.nextLine();
                    int[] employeeIds = parseEmployeeIds(employeeIdsInput);

                    System.out.print("Введіть унікальний айді лодки: ");
                    int boatId = Integer.parseInt(scanner.nextLine());

                    Contract contract = new Contract(id, contractType, employeeIds, boatId);
                    long startTime = System.nanoTime();
                    String contractAddResult = mainDB.updateContract(contract);
                    System.out.println(contractAddResult);
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;

            case 0:
                System.out.println("Повертаємось назад ...");
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }

    public static void searchRecord(int menuIndex) {
        switch (menuIndex) {
            case 1:
                System.out.println("- Знайти судно");

                try {
                    System.out.print("Введіть унікальний айді судна, що треба знайти: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.findShipByKey(id).getData());
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 2:
                System.out.println("- Знайти співробітника");

                try {
                    System.out.print("Введіть унікальний айді співробітника, що треба знайти: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    long startTime = System.nanoTime();
                    System.out.println(mainDB.findEmployeeByKey(id).getData());
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }

                break;
            case 3:
                System.out.println("- Знайти контракт");

                try {
                    System.out.print("Введіть унікальний айді контракту, що треба знайти: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    long startTime = System.nanoTime();
                    System.out.println(mainDB.findContractByKey(id).getData());
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;
                    System.out.println("Час виконання алгоритму: " + executionTime + " наносекунд");
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;

            case 0:
                System.out.println("Повертаємось назад ...");
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }
}