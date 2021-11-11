package ru.aden.hibertests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.aden.hibertests.models.User;

import java.util.List;

public class UserMain {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        UserMain userMain = new UserMain();

        System.out.println("Start adding new users to Database.");

        userMain.addNewUser("John", 15, "somemail@mail.com");
        userMain.addNewUser("Stan", 25, "2omemail@mail.com");
        userMain.addNewUser("Bella", 35, "s3omemail@mail.com");

        System.out.println("List of added users:");
        System.out.println("====================");

        List userList = userMain.listUsers();
        for (Object user : userList) {
            System.out.println(user);
        }

        System.out.println("====================");
        System.out.println("Removing second user and update first user's email:");
        userMain.removeUser(8);
        userMain.updateUserEmail(7, "newUpdatedMail@mail.com");
        System.out.println("Done \n");

        System.out.println("Final List:");
        userList = userMain.listUsers();
        for (Object user : userList) {
            System.out.println(user);
        }
    }

    //add new user
    public void addNewUser(String name, int age, String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User(name, age, email);
        session.save(user);

        transaction.commit();
        session.close();
    }

    //showAllUsers
    public List listUsers() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List users = session.createQuery("FROM User").list();

        transaction.commit();
        session.close();

        return users;
    }

    //update email to user
    public void updateUserEmail(int id, String email) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class, id);
        user.setEmail(email);
        session.update(user);

        transaction.commit();
        session.close();
    }

    //remove user from DB
    public void removeUser(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class, id);
        session.delete(user);

        transaction.commit();
        session.close();
    }
}
