// import java.util.TreeSet;

// class Student implements Comparable<Student>{
//     int rollno;
//     String name;
//     public Student(int rollno,String name){
//         this.rollno=rollno;
//         this.name=name;
//     }
//     @Override
//     public int compareTo(Student s){
//         return this.rollno-s.rollno;
//     }
//     public String toString(){
//         return rollno +"-"+name;
//     }
// }
// class treeset{
//     public static void main(String[] args) {
//         TreeSet<Student> students= new TreeSet<>();
//         students.add(new Student(3,"abc"));
//         students.add(new Student(1,"qwe"));
//         students.add(new Student(2,"xyz"));
//         System.out.println(students);
//     }
// }




//write a java program to create a generic method that takes a list
//of namy type and a target ekement. it returns the index of the
//first occurenece of the target elemenyt in th elist return -1
//if the target element vannot be found


import java.util.*;

class treeset {
    public static void main(String[] args) {
        System.out.println("Employees sorted by name in ascending order");

        TreeSet<Employee> gfg = new TreeSet<>(new FirstComparator());

        gfg.add(new Employee(1, "ram", 24));
        gfg.add(new Employee(2, "ram", 25));
        gfg.add(new Employee(3, "ram", 26));
        gfg.add(new Employee(4, "ram", 27));

        for (Employee employee : gfg) {
            System.out.println(employee);
        }
    }
}

class FirstComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int nameCompare = e1.name.compareTo(e2.name);
        if (nameCompare == 0) {
            // Add tie-breaker to treat same name as different entries
            return Integer.compare(e1.id, e2.id);
        }
        return nameCompare;
    }
}

class Employee {
    public int id;
    public String name;
    public Integer age;

    Employee() {}

    Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.age;
    }
}

