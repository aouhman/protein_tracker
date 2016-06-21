package com.simpleprogram;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class Program {
    public static void main(String[] args) {
        System.out.println("Hello world");
        PopulateSampleData();
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User ");
        List<User> users = query.list();
        for (User user :
                users) {
            System.out.println(user.getName());
        }
        session.getTransaction().commit();
        session.close();
        HibernateUtilities.getSessionFactory().close();
    }

    /*
    public static void main(String[] args) {
        System.out.println("Hibernate");
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setName("messi");
//V2        user.getHistory().add(new UserHistory(new Date(),"Set the goal to 250"));
//V3        user.getHistory().put("GL123",new UserHistory(new Date(),"Set the name"));
//V4        user.getHistory().add(new UserHistory(new Date(),"Set the name"));
        user.addHistory(new UserHistory(new Date(), "Set the name"));
        user.getProteinData().setGoal(250);
//V3        user.getHistory().put("GL124",new UserHistory(new Date(),"Set the goal to 250"));
//V4        user.getHistory().add(new UserHistory(new Date(),"Set the goal to 250"));
        user.addHistory(new UserHistory(new Date(), "Set the goal to 250"));
        user.getGoalAlerts().add(new GoalAlert("congratulations"));
        user.getGoalAlerts().add(new GoalAlert("You did it!!!"));
        user.setProteinData(new ProteinData());
        session.save(user);
        session.getTransaction().commit();
        session.beginTransaction();


        User loadedUser = (User) session.get(User.class, new Integer(1)); //load return un exception lorsque L'identifiant  inexistent
        System.out.print(loadedUser.getName());
        loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
//V2        for (UserHistory history : loadedUser.getHistory()) {
//V3        for (Map.Entry<String,UserHistory>history : loadedUser.getHistory().entrySet() ) {
        for (UserHistory history : loadedUser.getHistory()) {
//V2               System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
//V3               System.out.println("Key value :" + history.getKey());
//V3           System.out.println(history.getValue().getEntryTime().toString() + " " + history.getValue().getEntry());
            System.out.println(history.getEntryTime().toString() + " " + history.getEntry());
        }

//V2        user.getHistory().add(new UserHistory(new Date(),"add 50 protein"));
//V3        user.getHistory().put("GL125",new UserHistory(new Date(),"add 50 protein"));
//V4        user.getHistory().add(new UserHistory(new Date(),"add 50 protein"));
        user.addHistory(new UserHistory(new Date(), "add 50 protein"));
        session.getTransaction().commit();

        session.close();
        HibernateUtilities.getSessionFactory().close();

    }
    */
    private static void PopulateSampleData() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        session.beginTransaction();

        User joe = CreateUser("Joe", 500, 50, "Good job", "You made it!");
        session.save(joe);

        User bob = CreateUser("Bob", 500, 50, "Taco Time!");
        session.save(bob);

        User amy = CreateUser("Amy", 250, 200, "Yes!");
        session.save(amy);
        session.getTransaction().commit();
        session.close();

    }

    private static User CreateUser(String name, int goal, int total, String... alerts) {
        User user = new User();
        user.setName(name);
        user.getProteinData().setGoal(goal);
        user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));
        user.getProteinData().setTotal(total);
        user.addHistory(new UserHistory(new Date(), "Set total to" + total));
        for (String alert :
                alerts) {
            user.getGoalAlerts().add(new GoalAlert(alert));
        }
        return user;
    }


}