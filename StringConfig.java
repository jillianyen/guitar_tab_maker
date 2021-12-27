import java.util.Arrays;
//contains all methods to modify each string. contains each string String
public class StringConfig
{
	String e = "e|--";
	String B = "B|--";
	String G = "G|--";
	String D = "D|--";
	String A = "A|--";
	String E = "E|--";
	
	public void printStrings()
	{
		System.out.println(e);
		System.out.println(B);
		System.out.println(G);
		System.out.println(D);
		System.out.println(A);
		System.out.println(E);
		System.out.println();
	}
	public void appendBeat()
	{
		e += "-";
		B += "-";
		G += "-";
		D += "-";
		A += "-";
		E += "-";
	}
	public void deleteBeat()//delete the very last char on each string
	{
		e = e.substring(0,e.length()-1);
		B = B.substring(0,B.length()-1);
		G = G.substring(0,G.length()-1);
		D = D.substring(0,D.length()-1);
		A = A.substring(0,A.length()-1);
		E = E.substring(0,E.length()-1);
	}
	public void deleteNote()//delete end of every string until last note
	{
		reverseAll();
		int smallest;
		int ei = firstNumIndex(e);
		int Bi = firstNumIndex(B);
		int Gi = firstNumIndex(G);
		int Di = firstNumIndex(D);
		int Ai = firstNumIndex(A);
		int Ei = firstNumIndex(E);
		smallest = smallesti(ei,Bi,Gi, Di,Ai,Ei);
		reverseAll();
		deleteUntilSmallest(smallest);
	}
	public String reverse(String string)//only used in reverseAll method
	{
		char ch;
		String reversedString = "";
		for (int i=0; i<string.length(); i++) {
			ch = string.charAt(i);
			reversedString = ch+reversedString;
	    }
		return reversedString;
	}
	public void reverseAll()
	{
		e = reverse(e);
		B = reverse(B);
		G = reverse(G);
		D = reverse(D);
		A = reverse(A);
		E = reverse(E);
	}
	public int firstNumIndex(String str)//find index of first instance of a num in str
	{
		int count = 1; 
		for(int i = 0; i<str.length();i++) {
			if(str.charAt(i) == '-') {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
	public int smallesti(int e, int B, int G, int D, int A, int E)//finds the smallest index num found from firstNumIndex
	{
		int[] temp = {e,B,G,D,A,E};
		Arrays.sort(temp);
		return temp[0];
	}
	public void deleteUntilSmallest(int i)//delete i amount of chars from the end of each string
	{
		e = e.substring(0,e.length()-i);
		B = B.substring(0,B.length()-i);
		G = G.substring(0,G.length()-i);
		D = D.substring(0,D.length()-i);
		A = A.substring(0,A.length()-i);
		E = E.substring(0,E.length()-i);
	}
	public boolean tabEmpty()
	{
		if(checkForNums(e)==true||checkForNums(B)==true||checkForNums(G)==true||checkForNums(D)==true||checkForNums(A)==true||checkForNums(E)==true) {
			return false;
		} else {
			return true;
		}
	}
	public boolean checkForNums(String str)
	{
		boolean containsDigit = false;
	    if (str != null && !str.isEmpty()) {
	        for (char c : str.toCharArray()) {
	            if (containsDigit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }
	    return containsDigit;
	}
	//adds additional '-' to string(s) if needed to make sure all strings are of same length, 
	public void makeSameLength()
	{
		int lengthe = e.length();
		int lengthB = B.length();
		int lengthG = G.length();
		int lengthD = D.length();
		int lengthA = A.length();
		int lengthE = E.length();
		
		//so the number of chars is the same in each string after doing shift notes
		if(lengthe<lengthE||lengthe<lengthA||lengthe<lengthD||lengthe<lengthG||lengthe<lengthB) {
			e+='-';
		} if(lengthE<lengthA||lengthE<lengthD||lengthE<lengthG||lengthE<lengthB||lengthE<lengthe) {
			E+='-';
		} if(lengthA<lengthE||lengthA<lengthD||lengthA<lengthG||lengthA<lengthB||lengthA<lengthe) {
			A+='-';
		} if(lengthD<lengthE||lengthD<lengthA||lengthD<lengthG||lengthD<lengthB||lengthD<lengthe) {
			D+='-';
		} if(lengthG<lengthE||lengthG<lengthA||lengthG<lengthD||lengthG<lengthB||lengthG<lengthe) {
			G+='-';
		} if(lengthB<lengthE||lengthB<lengthA||lengthB<lengthD||lengthB<lengthG||lengthB<lengthe) {
			B+='-';
		}
	}
//------------FOR EDITING STRINGS------------
	public void eshift(int fret)//if last two elements in eing are not both numbers, replace last element with fret number, if they are both numbers, remove last element, then change new last element to fret number
	{
		e = shiftHelper(e,fret);
		printStrings();
	}
	public void Bshift(int fret)
	{
		B = shiftHelper(B,fret);
		printStrings();
	}
	public void Gshift(int fret)
	{
		G = shiftHelper(G,fret);
		printStrings();
	}
	public void Dshift(int fret)
	{
		D = shiftHelper(D,fret);
		printStrings();
	}
	public void Ashift(int fret)
	{
		A = shiftHelper(A,fret);
		printStrings();
	}
	public void Eshift(int fret)
	{
		E = shiftHelper(E,fret);
		printStrings();
	}
	public String shiftHelper(String s, int fret)
	{
		if(s.charAt(s.length()-1)!='-'&&s.charAt(s.length()-2)!='-') {
			s = s.substring(0,s.length()-1);
			s = s.substring(0,s.length()-1)+fret;
		} else {
			s = s.substring(0,s.length()-1)+fret;
		}
		return s;
	}
//type is either 1 or 2. type 1 is if fret number is >9. type 2 is otherwise
	public void addeNote(int type, int fret) {
		if(type==1) {//if j>9
			e+=fret;
			B += "--";
			G += "--";
			D += "--";
			A += "--";
			E += "--";
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += fret;
			B += "-";
			G += "-";
			D += "-";
			A += "-";
			E += "-";
			appendBeat();
			printStrings();
		}
	}
	public void addBNote(int type, int fret) {
		if(type==1) {
			e += "--";
			B += fret;
			G += "--";
			D += "--";
			A += "--";
			E += "--";
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += "-";
			B += fret;
			G += "-";
			D += "-";
			A += "-";
			E += "-";
			appendBeat();
			printStrings();
		}
	}
	public void addGNote(int type, int fret) {
		if(type==1) {
			e += "--";
			B += "--";
			G += fret;
			D += "--";
			A += "--";
			E += "--";
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += "-";
			B += "-";
			G += fret;
			D += "-";
			A += "-";
			E += "-";
			appendBeat();
			printStrings();
		}
	}
	public void addDNote(int type, int fret) {
		if(type==1) {
			e += "--";
			B += "--";
			G += "--";
			D += fret;
			A += "--";
			E += "--";
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += "-";
			B += "-";
			G += "-";
			D += fret;
			A += "-";
			E += "-";
			appendBeat();
			printStrings();
		}
	}
	public void addANote(int type, int fret) {
		if(type==1) {
			e += "--";
			B += "--";
			G += "--";
			D += "--";
			A += fret;
			E += "--";
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += "-";
			B += "-";
			G += "-";
			D += "-";
			A += fret;
			E += "-";
			appendBeat();
			printStrings();
		}
	}
	public void addENote(int type, int fret) {
		if(type==1) {
			e += "--";
			B += "--";
			G += "--";
			D += "--";
			A += "--";
			E += fret;
			appendBeat();
			printStrings();
		}
		if(type==2) {
			e += "-";
			B += "-";
			G += "-";
			D += "-";
			A += "-";
			E += fret;
			appendBeat();
			printStrings();
		}
	}
//sym = symbol, so / for slide, h for hammer, p for pull
	public void lastChare(String sym)
	{
		e=e.substring(0,e.length()-1)+sym;
		printStrings();
	}
	public void lastCharB(String sym)
	{
		B=B.substring(0,B.length()-1)+sym;
		printStrings();
	}
	public void lastCharG(String sym)
	{
		G=G.substring(0,G.length()-1)+sym;
		printStrings();
	}
	public void lastCharD(String sym)
	{
		D=D.substring(0,D.length()-1)+sym;
		printStrings();
	}
	public void lastCharA(String sym)
	{
		A=A.substring(0,A.length()-1)+sym;
		printStrings();
	}
	public void lastCharE(String sym)
	{
		E=E.substring(0,E.length()-1)+sym;
		printStrings();
	}
}
