package org.example;

import org.example.products.Actor;
import org.example.products.ActorDAOImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ActorDAOImpl actorDAOImpl = new ActorDAOImpl();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Choose one of the below options:");
            System.out.println("1. Add \n 2. Update \n 3. Delete \n 4. View \n 5. Exit");
            int option = Integer.parseInt(sc.nextLine());
            if(option==1){
                System.out.println("Enter actor firstName:");
                String firstName = sc.nextLine();
                System.out.println("Enter actor lastName");
                String lastName = sc.nextLine();
                Actor actor = new Actor(0,firstName,lastName);
                actorDAOImpl.add(actor);
            }
            else if(option==2){
                System.out.println("Enter actor id, firstName and lastName:");
                int id = Integer.parseInt(sc.nextLine());
                String firstName = sc.nextLine();
                String lastName = sc.nextLine();
                Actor actor = new Actor(id,firstName,lastName);
                actorDAOImpl.update(actor);
            }
            else if(option==3){
                System.out.println("Enter the actor id:");
                int id = Integer.parseInt(sc.nextLine());
                actorDAOImpl.delete(id);
            }
            else if(option == 4){
                List<Actor> actors = actorDAOImpl.view();
                System.out.println(actors);
            }
            else{
                break;
            }

        }while(true);

    }
}