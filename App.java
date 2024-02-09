import java.util.Scanner;

public class App {
    private static final int LENGTH = 50;
    public static void main(String[] args){
        // Classes Initilization
        Employee employee = new Employee();
        Scanner scan = new Scanner(System.in);

        employee.addEmpolyee(1, "Sachin Shrivastav", "Full Stack Web Dev", 17500.00);
        employee.addEmpolyee(2, "Manejar Sah Kanu", "UI/UX Disginner", 16500.00);
        // employee.displayEmployee();
        clearConsole();
        while (true) {
            System.out.println("-".repeat(LENGTH));
            print_center("Java Employee Management System", LENGTH);
            System.out.println("-".repeat(LENGTH));
            System.out.println("1.  Add Employee");
            System.out.println("2.  Update Employee");
            System.out.println("3.  Delete Employee");
            System.out.println("4.  Display Employee");
            System.out.println("5.  Exit");
            System.out.print("Select option: ");
            int sel = scan.nextInt();
            scan.nextLine(); 
            switch (sel) {
                case 1:
                // Add Employee
                    clearConsole();
                    System.out.println("-".repeat(LENGTH));
                    print_center("Add Employee", LENGTH);
                    System.out.println("-".repeat(LENGTH));
                    // Taking new employee data
                    System.out.print("Enter Employee Name: ");
                    String empName = scan.nextLine();  // Read the employee name0.
                    System.out.print("Enter Employee Post: ");
                    String empPost = scan.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    Double empSalary = scan.nextDouble();
                    int id = employee.countEmployee() + 1;
                    System.out.println(empName);
                    employee.addEmpolyee(id, empName, empPost, empSalary);
                    System.out.println("New employee added id: "+id);

                    break;
                case 2:
                    // Update Employee
                    clearConsole();
                    System.out.println("-".repeat(LENGTH));
                    print_center("Update Employee", LENGTH);
                    System.out.println("-".repeat(LENGTH));
                    System.out.print("Enter Employe ID: ");
                    int upId = scan.nextInt();
                    employee.updateEmployee(upId);
                    break;
                case 3:
                    // Delete Employee
                    System.out.print("Enter employee ID: ");
                    int delID = scan.nextInt();
                    employee.deleteEmployee(delID);
                    break;
                case 4:
                    // Display Employee
                    clearConsole();
                    employee.displayEmployee();
                    break;
                case 5:
                    // Exit the Programm
                    System.exit(0);
                    scan.close();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
    public static void print_center(Object text, int LENGTH){
        LENGTH -= text.toString().length();
        int leftMargin = (int) Math.floor(LENGTH / 2);
        System.out.print(" ".repeat(leftMargin));
        System.out.println(text.toString());
    }
    public static void clearConsole() {
        try {
            // This is for Windows systems
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
