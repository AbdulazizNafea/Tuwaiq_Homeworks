package Ex7_OOP;

import java.io.IOException;

public class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
    public int getAnnualSalary() {
        return salary *12;
    }
    public int raiseSalary(int percentage) throws IOException {
        if(percentage <=0){
            throw new IOException();
        }else {
            salary+= (salary*percentage)/100;
        }
       // salary= (salary*percentage)/100;
        return salary;
    }
    public String toString() {
        return "ID:"+id+"\nName:"+name+"\nAnnual Salary: "+getAnnualSalary();
    }
}
