package compgc01;

/**
 * A class representing an employee
 * that inherits from user.
 * @author Qiong Peng
 * @since May/05/2021
 */
public class Employee extends User {
    
    public Employee(String firstName, String lastName, String username, String password, String email) {
        super(firstName, lastName, username, password, email);  
    }
    
    /**
     * Returns the user's type as a String.
     * @return Type
     */
    public String getType() {
        return "employee";
    }
}