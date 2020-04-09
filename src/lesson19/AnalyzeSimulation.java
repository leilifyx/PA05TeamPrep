package lesson19;
import java.util.Random;

public class AnalyzeSimulation {
	
	// the maximum number of days the simulation will run
		private static int MAX_TICKS=1000;
		

		public static void main(String[] args) {
			// first we get the simulation parameters
			// from the command line

			int width = Integer.parseInt(args[0]);
			int height = Integer.parseInt(args[1]);
			int numStayHome = Integer.parseInt(args[2]);
			int numEssential = Integer.parseInt(args[3]);
			int numSkeptic = Integer.parseInt(args[4]);
			int numFrequentFlier = Integer.parseInt(args[5]);
			int numLowImmunityPerson= Integer.parseInt(args[6]);
			int numReps=Integer.parseInt(args[7]); //how many times to run simulation

			int repNum=0;
			
			int avgNumDays=0;
			int avgNumInfected=0;
			int avgPeakInfected=0;
			
			for(int run=0; run<numReps; run++){
			//create population of mixed types of people
			Population population;
			population = new MixedPopulation(numStayHome, numEssential, numSkeptic + numFrequentFlier+numLowImmunityPerson);
			population.createPeople();
			
			//create country of width width and height height
			Country country = new Country(width,height);
			
			country.population = population;
			// next we place the people into the country randomly
			population.placePeople(country);

			

			int dayNum=0;
			int peakInfected= country.getNumInfected();
			for(int k=0;k<MAX_TICKS; k++) {
				country.simulateOneStep();
				
				//finding peak infection level
				int peakInfectedTemp=country.getNumInfected();
				if(peakInfectedTemp>peakInfected){
					peakInfected=peakInfectedTemp; 
				}

				if (country.numInfected==0) {
					dayNum=k+1; //day which country has no more infected people
					break;

				}
			}
			
			repNum++;
			int numInfectedInRound=country.getNumInfected()+country.getNumRecovered();
			
			System.out.println("\n\n\nFinal State of the Country for Rep #" + repNum);
			System.out.println("number of infected over course of simulation= "+ numInfectedInRound);
			System.out.println("peak infected number = " + peakInfected);
			System.out.println("number of days = " + dayNum);
			
			avgNumDays+=dayNum;
			avgNumInfected+=numInfectedInRound;
			avgPeakInfected+=peakInfected;

		}
			
			System.out.println("\n\n\nAverage number of days it takes until there are no new infectsions = " +avgNumDays/numReps);
			System.out.println("Average number of people infected = "+ avgNumInfected/numReps);
			System.out.println("Average maximum of people infected at one time = " + avgPeakInfected/numReps);
		}
	


}
