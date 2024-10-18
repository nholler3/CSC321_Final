import java.util.Scanner;

public class Walkthrough {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create table");
            System.out.println("2. Add row");
            System.out.println("3. Query records");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createTable();
                    break;
                case 2:
                    addRow();
                    break;
                case 3:
                    queryRecords();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createTable() {
        Scanner scanner = new Scanner(System.in);
        Boolean multiple = true;

        while (multiple) {

            System.out.println("Enter table name:");
            String tableName = scanner.nextLine();

            System.out.println("Enter column name and type (ex. column1 INT, column2 VARCHAR(50), ...):");
            String columns = scanner.nextLine();

            Trans.create(tableName, columns);

            System.out.println("Would you like to create another table? [Y/N]");
            String result = scanner.nextLine();
            if (result.toUpperCase().charAt(0) == 'N') {
                multiple = false;
            }
        }
    }

    public static void addRow() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter table name:");
        String tableName = scanner.nextLine();
        Boolean multiple = true;

        while (multiple) {

            System.out.println("Enter row values separated by commas (ex. value1, value2, ...):");
            String rowValues = scanner.nextLine();

            String[] values = rowValues.split(",\\s*");
            Trans.write(tableName, values);

            System.out.println("Would you like to add more rows to " + tableName + "? [Y/N]");
            String result = scanner.nextLine();
            if (result.toUpperCase().charAt(0) == 'N') {
                multiple = false;
            }
        }
    }

    public static void queryRecords() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter table name:");
        String tableName = scanner.nextLine();
        Boolean repeat = true;

        while (repeat) {
            System.out.println("Enter column name to query:");
            String columnName = scanner.nextLine();

            System.out.println("Enter optional condition (ex. column1 = 'value'):");
            String condition = scanner.nextLine();

            // Adjust condition format if there is an argument
            if (!condition.isEmpty()) {
                condition = "WHERE " + condition;
            }

            String[] result = Trans.read(tableName, columnName, condition);

            System.out.println("Query result:");
            for (String row : result) {
                System.out.println(row);
            }

            System.out.println("Would you like to do another query on " + tableName + "? [Y/N]");
            String ans = scanner.nextLine();
            if (ans.toUpperCase().charAt(0) == 'N') {
                repeat = false;
            }

        }
    }
}
