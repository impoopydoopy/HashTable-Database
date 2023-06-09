package org.example.datastructure;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.DTO.Contract;
import org.example.DTO.Employee;
import org.example.DTO.Ship;

@Data
@NoArgsConstructor
public class MainDB {

    HashTable employeesDB = new HashTable();
    HashTable shipsDB = new HashTable();
    HashTable contractsDB = new HashTable();

    //region Add operations
    public String addNewEmployee(Employee employee) {
        employeesDB.addNode(employee);
        return "Success!";
    }

    public String addNewShip(Ship ship) {
        shipsDB.addNode(ship);
        return "Success!";
    }

    public String addNewContract(Contract contract) {
        contractsDB.addNode(contract);
        return "Success!";
    }

    public void autoFill() {
        fillEmployees(employeesDB);
        fillShips(shipsDB);
        fillContracts(contractsDB);
    }

    private void fillEmployees(HashTable employeesDB) {
        employeesDB.addNode(new Employee(
                56798,
                "Байонета Анатольївна",
                "Кок"
        ));

        employeesDB.addNode(new Employee(
                84376,
                "Аніта Ахмад",
                "Капітан судна"
        ));

        employeesDB.addNode(new Employee(
                444444,
                "Гвідо Міста",
                "Капітан судна"
        ));

        employeesDB.addNode(new Employee(
                12333,
                "Гарі Потер",
                "Юнга"
        ));

        employeesDB.addNode(new Employee(
                11111,
                "Озі Озборн",
                "Штурман"
        ));

        employeesDB.addNode(new Employee(
                4567453,
                "Наруто Удзумакі",
                "Юнга"
        ));
    }

    private void fillShips(HashTable shipsDB) {
        shipsDB.addNode(new Ship(
                2308,
                "Бобрік",
                "Атомна підлодка"
        ));

        shipsDB.addNode(new Ship(
                2303,
                "Веном",
                "Транспортне судно"
        ));

        shipsDB.addNode(new Ship(
                2408,
                "Тітанік",
                "Лідокол"
        ));

        shipsDB.addNode(new Ship(
                2345,
                "Дезнот",
                "Буксір"
        ));

        shipsDB.addNode(new Ship(
                24508,
                "Джо-Джо",
                "Пасажирське судно"
        ));
    }

    private void fillContracts(HashTable contractsDB) {
        contractsDB.addNode(new Contract(
                1888,
                "Воєнні навчання",
                new int[]{12333, 444444},
                2308
        ));

        contractsDB.addNode(new Contract(
                1890,
                "Перевезення діамантів",
                new int[]{84376, 4567453},
                2303
        ));

        contractsDB.addNode(new Contract(
                1818,
                "Круїз до Японії",
                new int[]{56798, 11111},
                24508
        ));
    }
    //endregion

    //region Find operations

    public Employee findEmployeeByKey(int key) {
        return (Employee) employeesDB.findNodeByKey(key);
    }

    public Ship findShipByKey(int key) {
        return (Ship) shipsDB.findNodeByKey(key);
    }

    public Contract findContractByKey(int key) {
        return (Contract) contractsDB.findNodeByKey(key);
    }

    //endregion

    //region Delete operations

    public String deleteEmployee(int key) {
        employeesDB.deleteNode(key);
        return "Successfully deleted employee!";
    }

    public String deleteShip(int key) {
        shipsDB.deleteNode(key);
        return "Successfully deleted ship!";
    }

    public String deleteContract(int key) {
        contractsDB.deleteNode(key);
        return "Successfully deleted contract!";
    }

    //endregion

    //region Update operations

    public String updateEmployee(Employee employee) {
        employeesDB.updateNode(employee);
        return "Successfully updated employee!";
    }

    public String updateShip(Ship ship) {
        shipsDB.updateNode(ship);
        return "Successfully updated ship!";
    }

    public String updateContract(Contract contract) {
        contractsDB.updateNode(contract);
        return "Successfully updated contract!";
    }

    //endregion

    public void formattedPrintDB() {
        System.out.println("\n\tWelcome!\nActive contracts in our DB:");
        for (int i = 0; i < HashTable.TABLE_SIZE; i++) {
            if (contractsDB.database[i] == null) {
                continue;
            }

            System.out.println("\n--------------------------------------------------\n");

            Contract current = (Contract) contractsDB.database[i];

            System.out.println("ID[" + current.getKey() + "] " + current.getContractType()
                    + "\n\tShip: " + shipsDB.findNodeByKey(current.getShipID()).getData()
                    + "\n\n\tCrew: ");

            for (int id :
                    current.getEmployeeID()) {
                System.out.println("\t\t" + employeesDB.findNodeByKey(id).getData());
            }

            System.out.println("\n--------------------------------------------------\n");
        }
    }
}