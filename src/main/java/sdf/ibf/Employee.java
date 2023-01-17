package sdf.ibf;

public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;

    public Employee(Integer id, String firstName, String lastName, Integer salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", First Name: " + firstName + ", Last Name: " + lastName
                + ", Salary: $" + salary;
    }

}
