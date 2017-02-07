package edu.century.pa3;

public class Token 
{
	private char character;
	private int line;

	//Token constructor
	public Token(char character, int line) {
		this.character = character;
		this.line = line;
	}

	//Getter method for character
	public char getCharacter() {
		return character;
	}

	//Setter method for character
	public void setCharacter(char character) {
		this.character = character;
	}

	//Getter method for line
	public int getLine() {
		return line;
	}

	//Setter method for line
	public void setLine(int line) {
		this.line = line;
	}

	@Override
	//To String method
	public String toString() {
		return "Token [character=" + character + ", line=" + line + "]";
	}
	
	//Equals method
	public boolean equals(Object obj)
	{
		if(obj instanceof Token)
		{
			Token token = (Token) obj;
			char otherChar = token.character;
			int otherLine = token.line;
			return(this.character == otherChar && this.line == otherLine);
		}
		return false;
	}
}
