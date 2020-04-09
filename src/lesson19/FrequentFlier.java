package lesson19;

import java.util.Random;

public class FrequentFlier extends Person {
	Random random=new Random();

	public FrequentFlier(int x, int y, Country country) {
		super(x, y, country);
		// TODO Auto-generated constructor stub
	}

	public FrequentFlier() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		findRandomUnoccupiedSpace();

	}
	
	void findRandomUnoccupiedSpace(){
		// find an open random space for the person
	      int i = random.nextInt(country.places.length);
	      int j = random.nextInt(country.places[i].length);
	      while (country.places[i][j] != null) {
	        // loop to make sure it is an open space ...
	        i = random.nextInt(country.places.length);
	        j = random.nextInt(country.places[i].length);
	      }
	      this.moveTo(i, j);
	}

}
