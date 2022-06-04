package abstracts;
import java.util.Scanner;
import inheritance.*;
import Polymorphism.*;
import java.util.Random;
public class HungerGame {

	public static void main(String[] args) {
		int choice=0; //this is for the variable for choosing the action of the user to be used by scanner class later.
		int Round=0; // this is the variable for keeping track of the number of rounds passed.
		
		Ally Pete = new Helper(); //the next 2 lines are for showing how the user is helped if he/she picks option 2
		Sponsor Jabee = new Helper(); 
		
		Victor[] list= new Victor[23]; //instantiation of the array to be used for the list of competitors
		
		Scanner sc = new Scanner(System.in); //the next lines are for taking the user input
		System.out.println("Enter Player's Name: ");
		String name = sc.nextLine();
		System.out.println("Enter Player's Gender: ");
		String gender = sc.nextLine();
		System.out.println("Enter Player's District: ");
		int district = sc.nextInt();
		Random rand = new Random(); //the next 3 lines is for generating a random number for picking the terrain per round
		int upper = 8;
		int sponsorChoice = rand.nextInt(upper);
		Victor Katniss = new Victor(name,gender,district,0,sponsorChoice);
		
		list[0] = new Victor("Amber","Female",1,0,4); //instantiation of the enemies
		list[1] = new Victor("Johnny","Male",2,0,3);
		list[2] = new Victor("BabyM","Male",3,0,7);
		list[3] = new Victor("Sarah","Female",4,0,5);
		list[4] = new  Victor("Peeta","Male",5,0,4);
		list[5] = new Victor("Erwin","Female",6,0,11);
		list[6] = new Victor("Robin","Male",7,0,9);
		list[7] = new Victor("Cynthia","Female",8,0,4);
		list[8] = new Victor("Mark","Male",9,0,10);
		list[9] = new Victor("Ferdie","Male",10,0,14);
		list[10] = new Victor("Raffy","Male",11,0,12);
		list[11] = new Victor("Risa","Female",12,0,9);
		list[12] = new Victor("Last");
		
		Katniss.viewState(); //function call for viewing the details about the player
		while(Katniss.getLife() !=0) {
			Random rand1 = new Random(); //the next 3 lines is for generating a random number for picking the terrain per round
			int upperbound = 3;
			int terchoice = rand1.nextInt(upperbound);
			
			Victor enemy=list[Round]; //variable for the specific enemy for each round
			String enemyname=enemy.getName();
			
			if (terchoice==0) {	//the next lines of codes are for the terrain and the specific buffs given to specific characters based on district
				Beach terrain1= new Beach();
				terrain1.environment();
				if (Katniss.getDistrict() <5) {
					Katniss.setSponsor(2);
				}
				if (enemy.getDistrict()<5) {
					enemy.setSponsor(2);
				}
			}
			if (terchoice==1) {
				Forest terrain2= new Forest();
				terrain2.environment();
				if (Katniss.getDistrict() >4 && Katniss.getDistrict()<9) {
					Katniss.setSponsor(2);
				}
				if (enemy.getDistrict()>4 && enemy.getDistrict()<9) {
					enemy.setSponsor(2);
				}
			}
			if (terchoice==2) {
				Snow terrain3= new Snow();
				terrain3.environment();
				if (Katniss.getDistrict() <8) {
					Katniss.setSponsor(2);
				}
				if (enemy.getDistrict()<8) {
					enemy.setSponsor(2);
				}
			}
			if (enemyname=="Last") { //this is for checking if all the other competitors have been eliminated
				Katniss.Win();
				break;
			}else {
			System.out.println("You encountered "+ enemyname); //the next lines of code are for the menu and mechanics of the game
			Katniss.Menu(); //how the game works etc
			choice = sc.nextInt();
			if (choice==1) {
				Katniss.Kill(enemy);}
			if (choice==2) {
				Katniss.Attract();
				System.out.println("\nWould you like to ask another victor for help or ask for parachute?");
				System.out.println("\n1.Ask another victor for help?");
				System.out.println("\n2.Ask for parachute (Increase sponsor count)\n");
				int option = sc.nextInt();
				if (option==1) {
					Pete.HelpKill();
				}
				if (option==2) {
					Jabee.AddSponsor();
				}
			}
			if (choice ==3) {
				Katniss.Run(enemy);
			}
			Round=Round+1;
			Katniss.viewState();
			}
		}
		sc.close();
		Katniss.viewState();
	}



}