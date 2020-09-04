package test.java.student;

public class StudentTester {
	   public static void main(String args[]){
		     Student s1 = new Student();
		     s1.increment();
		     s1.showData();
		     Student s2 = new Student();
		     s1.increment();
		     s2.increment();
		     s2.showData();
		     Student.b++;
		     s1.showData();
		  }
}
