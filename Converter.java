package proj4;

/**
 *  CONVERTER CLASS (5/28/2020)
 *  * Converter is use to read file and convert infix notation to postfix notation
 *  * @author Quoc (Jordan) An
 *  * @version 1
 *  * I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 *  * accordance with the Union College Honor Code and the course syllabus.
 */
public class Converter {
	private FileReader fr;
	/**
	 * non-default constructor; create a FileReader instance using infile
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
		fr = new FileReader(infile);
    }


	/**
	 * Convert the data in the file from infix notation to postfix notation
	 * Print them.
	 */
	public void convert(){
		String s = fr.nextToken();
		String postFix = "";
		String inFix = "";
		Stack<Token> tokenStack = new Stack();
		String toAppend = "";
		while(s != "error on token read" && s != "EOF"){
			Token currentToken = id(s);
			if (currentToken == null){
				postFix +=s;
				inFix += s;
			}
			else{
				toAppend = currentToken.handle(tokenStack);
				postFix += toAppend;
				inFix += currentToken;
			}

			if (currentToken instanceof Semicolon){
				inFix = inFix.substring(0, inFix.length() - 1);
				System.out.println(inFix + " --> " + postFix);
				inFix = "";
				postFix = "";
			}
			s = fr.nextToken();
		}

	}


	/**
	 * Identify which token the string represents
	 * @param s The string/character input
	 * @return null if it is not a token, the appropriate token otherwise
	 */
	private Token id(String s){
    	Token ans = null;
		if (s.equals("-")){
			ans = new Minus();
		}
		else if (s.equals("+")){
			ans = new Plus();
		}
		else if (s.equals("/")){
			ans = new Divide();
		}
		else if (s.equals("*")){
			ans = new Multiply();
		}
		else if (s.equals ("^")){
			ans = new Exponent();
		}
		else if (s.equals("(")){
			ans = new LeftParen();
		}
		else if (s.equals(")")){
			ans = new RightParen();
		}
		else if (s.equals(";")){
			ans = new Semicolon();
		}
    	return ans;
	}

}
