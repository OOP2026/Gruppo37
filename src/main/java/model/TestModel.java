package model;
import java.util.*;

/**
 * The type Test model.
 */
public class TestModel {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		Studente s=new Studente("n","c","e","l","p","m");
		System.out.println(s.login("l","p"));
	}

}
