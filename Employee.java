import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Employee {
    private ArrayList<HashMap<String, Object>> empolyeeData = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void addEmpolyee(Integer id, String name, String post, double salary){
        HashMap<String,Object> emp = new HashMap<>();
        emp.put("id", id);
        emp.put("name", name);
        emp.put("post", post);
        emp.put("salary",salary);
        empolyeeData.add(emp);
    }
    void updateEmployee(Integer id){
        HashMap<String, Object> empUpdate = null;
        for (int i = 0; i < empolyeeData.size(); i++) {
            if (empolyeeData.get(i).get("id") == id) {
                empUpdate = empolyeeData.get(i);
                empolyeeData.remove(i);
                break;
            }
        }
        // Taking input from user
        System.out.print("Enter your new name: ");
        String newName = scan.nextLine();
        System.out.print("Enter your new post: ");
        String newPost = scan.nextLine();
        System.out.print("Enter your new salary: ");
        double newSalary = scan.nextDouble();
        // Updating to hashmap and adding to list

        empUpdate.put("name", newName);
        empUpdate.put("salary", newSalary);
        empUpdate.put("post", newPost);
        empolyeeData.add(empUpdate);

    }
    // Displaying all Employers
    void displayEmployee(){
        
        System.out.printf("%-5s %-20s %-25s %-10s\n", "Id", "Name", "Post", "Salary");
        System.out.println("-".repeat(67));
        for (HashMap<String,Object> hashMap : empolyeeData) {
            System.out.printf("%-5s %-20s %-25s %-10s\n", hashMap.get("id"), hashMap.get("name"), hashMap.get("post"), hashMap.get("salary"));
        }
        System.out.println("-".repeat(67));
        scan.nextLine();
    }
    // Delete Employee
    void deleteEmployee(Integer id){
        for (int i = 0; i < empolyeeData.size(); i++) {
            if (empolyeeData.get(i).get("id") == id) {
                empolyeeData.remove(i);
                break;
            }
        }
    }
    int countEmployee(){
        return empolyeeData.size();
    }
}
