package com.ss.algorithms.stringmanipulation;

/**    	
Alien Fred wants to destroy the Earth, but he forgot the password that activates the planet destroyer.
You are given a String S. Fred remembers that the correct password can be obtained from S by erasing exactly one character.
Return the number of different passwords Fred needs to try.
 
Definition    	
Class:	AlienAndPassword
Method:	getNumber
Parameters:	String
Returns:	int
Method signature:	int getNumber(String S)
(be sure your method is public)
    
Constraints
-	S will contain between 1 and 50 characters, inclusive.
-	Each character in S will be an uppercase English letter ('A'-'Z').
 
Examples
0)	
    	
"A"
Returns: 1
In this case, the only password Fred needs to try is an empty string.
1)	
    	
"ABA"
Returns: 3
The following three passwords are possible in this case: "BA", "AA", "AB".
2)	
    	
"AABACCCCABAA"
Returns: 7
3)	
    	
"AGAAGAHHHHFTQLLAPUURQQRRRUFJJSBSZVJZZZ"
Returns: 26
4)	
    	
"ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"
Returns: 1
Regardless of which character we erase, we will always obtain the same string. Thus there is only one possible password: the string that consists of 49 'Z's.
**/

public class AlienAndPwd {

	public static void main(String[] args) {
		
		/** Failed Results:
		"ABABAABBBBBBBAABABBBBABAAAABAAAABBBBBAABABAABBABAB"		26		Passed	24
		"AAAABBABBBBBABABAABBAAABBABABBAAAAABBAAABABABBABAB"		28		Passed	26
		"BBBAABAAAAABAAAABBABABABABAABBABAAABABBABAAAAAABAB"		29		Passed	25
		"BBBAAABABABABBABABBABABABAAABBBBBABBAAAABBABAAAAAA"		28		Passed	26
		"YZZZZZZZZZYYZZYYZYZYZZZZYYYZYYYYYZYYYZZYYYYZYYYZYZ"		22		Passed	18
 		"DDCCDCDCCDCCCDCDCDDCCCDCDCCCDCDCCCDDDCDCDCDCCCCDCC"		32		Passed	30
		"PPQQQPQPPQPQPQPQQPQQPQPQPQQQQPPQPQPPQQQQQQPPPPQPQQ"		30		Passed	
		 **/
		
		String passwordHint = "VTSWVSSVUTVSTSVVWWVVWUTWSVTTSSTWTWSWUSVU";

		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(passwordHint);
		// strbuilder.setLength(passwordHint.length());

		System.out.println("Results : >>>> of >>>" + strbuilder.toString());
		System.out.println("Results : >>>> of >>>" + strbuilder);
		System.out.println("Results : >>>> of >>>" + strbuilder.length());
		System.out.println("Results : >>>> of >>>"
				+ strbuilder.substring(0, strbuilder.length() / 2));

		System.out.println("Results : >>>>"
				+ getRefinedStringBuilder(strbuilder).toString().length());

	}

	public static StringBuilder getRefinedStringBuilder(StringBuilder strbuilder) {
		if (strbuilder.length() > 1) {

			String firstHalf = strbuilder.substring(0, strbuilder.length() / 2);
			String secondHalf = strbuilder.substring((strbuilder.length() / 2),
					strbuilder.length());

			System.out.println("First String>>>" + firstHalf);
			System.out.println("Second String>>>" + secondHalf);

			if (firstHalf.equals(secondHalf)){
				System.out.println(firstHalf + " is equal to " + secondHalf);
				return getRefinedStringBuilder(new StringBuilder(firstHalf));
			}
			else {
				StringBuilder firstHalfStrBuilder = new StringBuilder(firstHalf);
				StringBuilder secondHalfStrBuilder = new StringBuilder(secondHalf);
				int firstHalfEndPoint = firstHalfStrBuilder.length() - 1;
				System.out.println("Length>>>"+firstHalfEndPoint);
				while (firstHalfEndPoint != -1 && firstHalfStrBuilder
						.charAt(firstHalfEndPoint) == secondHalfStrBuilder
						.charAt(0)) {
					System.out.println(firstHalfStrBuilder + " has end character same as "+ secondHalfStrBuilder );
					
					
					firstHalfStrBuilder.deleteCharAt(firstHalfEndPoint);
					firstHalfEndPoint --;
					System.out.println("So deleted  last char and results >>" + firstHalfStrBuilder + " >> " + secondHalfStrBuilder);
					System.out.println("Length2>>>"+firstHalfEndPoint);

				}
				return getRefinedStringBuilder(firstHalfStrBuilder).append(
						getRefinedStringBuilder(secondHalfStrBuilder));
			}

		} else {
			System.out.println("only one character available ::>>>"+strbuilder);
			return strbuilder;
		}
	}

}
