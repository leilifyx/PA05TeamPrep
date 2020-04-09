package lesson19;

public class Skeptic extends Person {

	public Skeptic(int x, int y, Country country) {
		super(x, y, country);
		// TODO Auto-generated constructor stub
	}

	public Skeptic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void tryToMove() {
		// TODO Auto-generated method stub
		tryToMoveRandomly();
	}

}
