package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import model.*;

/**
 * Helyrajzi-szám ellenőrző program.
 * A felhasználótól bekér egy sztringet, majd megvizsgálja, hogy
 * az megfelel-e egy helyrajzi-szám formátumának.
 * Ha nem felel meg, akkor a hiba okának megfelelő üzenetet ír ki.
 * Ha megfelel, akkor megkeresi egy adatbázisban, hogy van-e
 * a helyrajzi-számhoz megállapított cím.
 * @author Palotai Ágnes
 * @version 1.0 
 */
public class Main extends Application {

    //private static EntityManager em;

/**
 * Megjeleníti az alkalmazás induló képernyőjét.
 * @param az induló képernyő neve
 * @throws Exception hiba esetén kivételt dob
 */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/view.fxml"));
        primaryStage.setTitle("Helyrajzi-szám ellenőrzése");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

/**
 * Az alkalmazás belépési pontja.
 * @param a program indulási paramétere
 */
    public static void main(String[] args) {

/**
 * Eljárás, amely meghívja az induló képernyőt megjelenítő
 * {@link start} eljárást.
 * @param az eljárás paramétere
 */
        launch(args);

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("hrsz_remotemysql");
        //em = emf.createEntityManager();

        //create
        //createEmployee("József", "Bük");

        //read
        //Hrsz readHrszId = readHrszById(576);
        //System.out.println(readHrszId);

        //read
        //Hrsz readHrszHrsz = readHrszByHrsz("0524/24");
        //System.out.println(readHrszHrsz);


        //update
        //updateEmployee(employee, "Miskolc");

        //delete
        //deleteEmployee(employee);

        //read név szerint
        //List<Hrsz> hrsz = readHrszBy("1");
        /*if(hrsz.isEmpty()){
            System.out.println("Üres lista.");
        }*/
        //System.out.println(hrsz);

        //em.close();
        //emf.close();
    }
/*
    private static void createEmployee(String name, String address) {
        em.getTransaction().begin();
        Employee emp = new Employee(name, address);
        em.persist(emp);
        em.getTransaction().commit();
    }*/
/*
    private static Hrsz readHrszById(Integer id) {
        return em.find(Hrsz.class, id);
    }
*/
    /*private static Hrsz readHrszByHrsz(String hrsz) {
        return em.find(Hrsz.class, hrsz);
    }*/

/*
    private static void updateEmployee(Employee emp, String newAddress) {
        em.getTransaction().begin();
        emp.setAddress(newAddress);
        em.getTransaction().commit();
    }

    private static void deleteEmployee(Employee emp) {
        em.getTransaction().begin();
        em.remove(emp);
        em.getTransaction().commit();
    }*/

    /*public static List<Hrsz> readHrszBy(String hrsz) {

        TypedQuery<Hrsz> q = em.createQuery("SELECT h FROM Hrsz h WHERE h.helyrajziszam='" + hrsz + "'", Hrsz.class);
        List<Hrsz> result = q.getResultList();
        return result;

    }*/


}