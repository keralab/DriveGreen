package model;

/**
 * Will represent the state of the program amongst other information
 * Will be used to tell the user exactly what the program is doing, etc
 * 
 * @author Nolan Slade
 */
public class ProgramData {
	private boolean resultState;
	
	
	/**
	 * Constructor will set the initial program state and task
	 * 
	 * @param ps The program state
	 */
	public ProgramData() {
		resultState = false;
	}
	
	/**
	 * Will return the whether or not results have been shown
	 * 
	 * @return True if results have been shown, false otherwise
	 */
	public boolean getResultsShown() {
		return resultState;
	}
	
	
	/**
	 * Will set whether or not results have been shown
	 * 
	 * @param nv The new value
	 */
	public void setResultsShown(boolean nv) {
		resultState = nv;
	}
}
