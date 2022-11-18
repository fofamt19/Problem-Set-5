import java.util.Random;
import java.util.Scanner;
    public class Adventure {
        public static void main(String[]args){
            //System objects
            Scanner scnr = new Scanner (System.in);
            Random rand = new Random();

            //Game Variables
            String[] enemies = {"Virus", "Bacterium","Parasite","Protozoan"};
            int maxPathogenHealth = 75;
            int enemyPathogenDamage = 25;

            //Player Variables
            int health = 100;
            int attackDamage = 50;
            int medicineTablets = 3;
            int medicineDose = 30;
            int medicineDropChance = 50; //Percent chance to drop a health potion while fighting

            boolean running = true;//Shows that game is running

            System.out.println("Welcome to Pathogen, the Adventure Game!");
            System.out.println("In this game, you'll fight the ultimate battle: the battle between host and personified pathogen!");

            GAME:   //Label
            while(running){
                System.out.println("-------------------------------");//Separator

                int pathogenHealth = rand.nextInt(maxPathogenHealth);
                String pathogen = enemies[rand.nextInt(enemies.length)];
                System.out.println("\tA " + pathogen + " has invaded your immune system!");

                while(pathogenHealth > 0){ //enemy is alive
                    System.out.println("\tYour HP: " + health);
                    System.out.println("\t" + pathogen + "'s HP: " + pathogenHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t1. Attack with science!");
                    System.out.println("\t2. Take medicine.");
                    System.out.println("\t3. Take a nap and hope that helps.");

                    String input = scnr.nextLine();
                    if(input.equals("1")){
                        int damageDealt = rand.nextInt(attackDamage);
                        int damageTaken = rand.nextInt(enemyPathogenDamage);

                        pathogenHealth -= damageDealt; //This getting to 0 would end loop
                        health -= damageTaken;

                        System.out.println("\t> You strike the " + pathogen + " for " + damageDealt + " damage.");
                        System.out.println("\t> You receive " + damageTaken + " in retaliation.");
                        if (health<1){
                            System.out.println("\t> You have taken too much damage and are too weak to go on.");
                            break;
                        }
                    }
                    else if(input.equals("2")){
                        if(medicineTablets>0){
                            health += medicineDose;
                            medicineTablets--;
                            System.out.println("\t> You take medicine, healing yourself for " + medicineDose + ".");
                            System.out.println("\t> You now have " + health + " HP.");
                            System.out.println("\t> You have "+medicineTablets+ " medicine tablets left.");
                        }
                        else{
                            System.out.println("\t> You have no medicine tablets left! Defeat pathogens for a chance to get one!");
                        }
                    }
                    else if(input.equals("3")){
                        System.out.println("\tYou sleep off "+ pathogen + "!");
                        continue GAME;   //moves to the next iteration of the loop using the label of the main while loop
                    }
                    else{   //Validation
                        System.out.println("\tInvalid command!");   //will go back up to while loop
                    }
                }   //end of enemy while loop
                if(health<1){
                    System.out.println("\t> You go to the ER to get some expert medical care.");
                    break;  //breaks out of main running loop to go to end game stuff
                }

                System.out.println("-------------------------------");//Separator
                System.out.println(" * " + pathogen + " was defeated! *");
                System.out.println(" * You have " + health + " HP left.");
                if(rand.nextInt(100) < medicineDropChance){
                    medicineTablets++;
                    System.out.println(" * The pathogen dropped a health potion.");
                    System.out.println(" * You have " + medicineTablets + " medicine tablet(s).");
                }
                System.out.println("-------------------------------");//Separator
                System.out.println("What would you like to do?");
                System.out.println("1. Continue fighting pathogens");
                System.out.println("2. End Game");

                String input = scnr.nextLine();
                while(!input.equals("1")&&!input.equals("2")){  //Validation checker
                    System.out.println("Invalid command.");
                    input = scnr.nextLine();  //When input is invalid, we get the next input
                    //If the next thing is valid, we move out of while loop
                }
                if(input.equals("1")){
                    System.out.println("You continue battling pathogens!");
                }
                else if(input.equals("2")){
                    System.out.println("You take a break from fighting personified pathogens!");
                    break;  //Breaks out of running while loop
                }

            }
            System.out.println("-------------------------------");//Separator
            System.out.println("Thanks for playing! Stay healthy!");
            System.out.println("-------------------------------");//Separator
        }
    }


