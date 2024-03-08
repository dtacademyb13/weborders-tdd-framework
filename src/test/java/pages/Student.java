package pages;

public class Student {


   // Singleton pattern has 3 components:
    // private static field
    // private constructor
    // public getter method that returns the object of the class after a null check
    private static Student student;

    private Student(){}

    public static Student getStudent(){

        if(student == null){
            student =  new Student();
        }

        return student;
    }


}
