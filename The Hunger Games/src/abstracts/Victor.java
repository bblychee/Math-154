package abstracts;
public class Victor {
	private String name;
	private String weapon;
	private String gender;
	private int life;
	private int district;
	private int kills;
	private int sponsors;
	private static int VictorCount;	
	
	Victor(String name){ //first implementation of victor to be used if we need default values
		this.name=name;
		this.gender="Male";
		this.weapon="None";
		this.life=1;
		this.kills=0;
		this.sponsors=0;
		this.district=0;
		VictorCount++;
	}
	
	
	Victor(String name,String gender, int district, int kills, int sponsors){ //second implementation of victor to be used if we need specific values
		this.name=name;
		this.gender=gender;
		this.district=district;
		this.life=1;
		this.kills=kills;
		this.sponsors=sponsors;
		VictorCount++;
		if (this.district==1) { //for assigning different weapons for each district's victor.
			this.weapon="machete";
		}
		if (this.district==2) {
			this.weapon="spear";
		}
		if (this.district==3) {
			this.weapon="wire";
		}
		if (this.district==4) {
			this.weapon="trident";
		}
		if (this.district==5) {
			this.weapon="spear";
		}
		if (this.district==6) {
			this.weapon="awl";
		}
		if (this.district==7) {
			this.weapon="axe";
		}
		if (this.district==8) {
			this.weapon="crossbow";
		}
		if (this.district==9) {
			this.weapon="knife";
		}
		if (this.district==10) {
			this.weapon="whip";
		}
		if (this.district==11) {
			this.weapon="rock";
		}
		if (this.district==12) {
			this.weapon="bow and arrow";
		}
	}

	void Kill(Victor b) { //method for the actual fight if the 1st option is chosen by the player.
		if (this.sponsors > b.sponsors){ //checks which one has higher sponsor to determine the outcome
			System.out.println("\nPlayer " + this.name + " killed " +b.name);
			this.kills++;
			
			b.life-=1;
			this.sponsors= this.sponsors+b.sponsors;
			b.sponsors=0;
		}
		if (this.sponsors < b.sponsors) {
			System.out.println("\nPlayer "+b.name + " killed "+ this.name);
			b.kills++;
			this.life=0;
			System.out.println("\nYou died. Game over.");
		}
	}
	void Win() { //the method should the player win the game
		System.out.println("\n Congratulations! You are the victor of this year's hunger games! ");
		
	}
	void Attract() { //method should the player want to gain sponsor
		System.out.println("\nPlayer " + this.name + " gained a new sponsor.");
		this.sponsors=this.sponsors+5;
	}
	static int count() { //getter for victor count
		return VictorCount;
	}
	void Run(Victor a) { //method should the player pick the 3rd option
		System.out.println("\nYou ran away from " + a.name+ "\n");
	}
	void viewState() {
		System.out.println("\nPLAYER STATUS");
		System.out.println("\nPlayer name: "+ this.name);
		System.out.println("\nPlayer kill count: "+ this.kills);
		System.out.println("\nPlayer Weapon: "+ this.weapon);
		System.out.println("\nDistrict: "+ this.district);
		System.out.println("\nPlayer Gender: "+ this.gender);
		System.out.println("\nNumber of Sponsors: "+ this.sponsors+"\n");
	}
	public int getLife() { //getter for life attribute
		return this.life;
	}
	public String getName() {//getter for name attribute
		return this.name;
	}
	public int getSponsor() { //getter for sponsor attribute
		return this.sponsors;
	}
	public int getDistrict() { //getter for district attribute
		return this.district;
	}
	public void setSponsor(int newSponsorCount) { //setter for sponsor attribute
		this.sponsors= newSponsorCount+this.sponsors;
	}
	public void Menu() { //method for calling menu
        System.out.printf("Enter your choice:\n");
        System.out.printf(" 1. Fight Enemy\n");
        System.out.printf(" 2. Ask Help\n");
        System.out.printf(" 3. Flee\n");   
	}
}
