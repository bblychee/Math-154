package inheritance;

public class Helper implements Ally, Sponsor{
	public void HelpKill() {
		System.out.println("\nAn ally helped you win for this round.");
	}
	
	public void AddSponsor() {
		System.out.println("You have gained sponsor thanks to a comrade outside the battlefield.");
	}
}
