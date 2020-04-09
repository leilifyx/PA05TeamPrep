package lesson19;
import java.util.Random;


public class MixedPopulation extends Population{
  int numShelterInPlace;
  int numEssential;
  int numOthers;
  Random random= new Random();

  public MixedPopulation(int numShelterInPlace, int numEssential, int numOthers){
    super(numShelterInPlace + numEssential + numOthers);
    this.numShelterInPlace = numShelterInPlace;
    this.numEssential = numEssential;
    this.numOthers = numOthers;

  }

  public void createPeople(){
    for(int i=0; i<this.numShelterInPlace; i++){
      this.addPerson(new StayAtHome());
    }
    for(int i=0; i<this.numEssential; i++){
      this.addPerson(new StayAtHomeIfSick());
    }
    
    for(int i=0; i<this.numOthers; i++){
      int chooseOther= random.nextInt(3); //0,1,2
      if(chooseOther==0){
    	  this.addPerson(new Skeptic());} 
      else if(chooseOther==1){
    	  this.addPerson(new FrequentFlier());}
      else{
    	  this.addPerson(new LowImmunityPerson());}
      
    }
  }
}
