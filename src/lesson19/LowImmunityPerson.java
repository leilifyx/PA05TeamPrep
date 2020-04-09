package lesson19;
import java.util.Random;

public class LowImmunityPerson extends Person {
	Random rand=new Random();

	/*
	 * this class represent people with lower immunity, whether it be
	 * from asthma or some other ailment. For the purpose of this simulation we 
	 * shall suppose the population of these people are 4/5 StayAtHome, since they 
	 * have to have higher value on their health, but 1/5 are skeptics.
	 */
	public LowImmunityPerson(int x, int y, Country country) {
		super(x, y, country);
		// TODO Auto-generated constructor stub
		infectionProb=.85; 
		
	}

	public LowImmunityPerson() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		int i = rand.nextInt(6); //0,1,2,3,4
		if(i==0){
			tryToMoveRandomly();
		}
		//else doesn't move
		
		
	}
}
