import java.util.Random;

public class Exam {

	public static void main(String[] args) {
		Character[][]  board= {

		{'.','Q','.','.','.','.','.','.'},
		{'.','.','.','.','.','Q','.','.'},
		{'Q','.','.','.','.','.','.','.'},
		{'.','.','.','.','.','.','Q','.'},
		{'.','.','.','Q','.','.','.','.'},
		{'.','.','.','.','.','.','.','Q'},
		{'.','.','Q','.','.','.','.','.'},
		{'.','.','.','.','Q','.','.','.'},				
		
        };
//		System.out.println("------First Method------");
//		System.out.println(Q1_checkCharacter(board));
//		System.out.println("------Second Method------");
//		System.out.println(Q2_validBoard(board));
//		System.out.println("------Third Method------");
//		System.out.println(Q3_generateBinaryString(board));
//		System.out.println("------Four Method------");
//		System.out.println(Q4_initialStart());
//		System.out.println("------Five Method------");
//		//System.out.println(Q5_fitnessFunction(Q4_initialStart()));
//		System.out.println(Q5_fitnessFunction("101110011110110011001000"));
//		System.out.println("------Six Method------");
//		System.out.println("000111101111011001010101");
//		System.out.println(Q6_smallChange("0001111011110110010101011"));
		System.out.println("------Seven Method------");
//		// QUESTION 77
//		// Defining a heuristic class to find the best solution
				CS2004EightQueens heuristic = new CS2004EightQueens(1000);
				System.out.println(heuristic.getSolution());
				System.out.println(heuristic.getFitness());
	}
	
	public static boolean Q1_checkCharacter(Character board[][]) {
        //1) Checking null and length	        	    	
        if ((board == null) || (board.length!=8)){
            return false;}
     
        else {
            for (int i = 0; i < board.length;++i){
                if (board[i].length!=8){
                    return false;}                
            }
        }
        
        //  CHECK CHARACTER VALIDITY
	  int Count_Character=0;
	  for (int a =0 ; a<board.length;++a){
	      for (int b =0 ; b<board[a].length;++b){
	          if (board[a][b]=='.' || board[a][b] == 'Q'){
	              Count_Character+=1;}
	      }
	  }
	  
	  if (Count_Character != 64) {
	  	return false;
	  }
	  return true;
	}
	
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
	public static boolean Q2_validBoard(Character board[][]) {
        //1) Checking null and length	        	    	
        if ((board == null) || (board.length!=8)){
            return false;}
     
        else {
            for (int i = 0; i < board.length;++i){
                if (board[i].length!=8){
                    return false;}                
            }
        }
        
        //When Valid Board but No User Input
        int Count_Dot=0;
        int Count_Queen=0;
        for (int a =0 ; a<board.length;++a){
            for (int b =0 ; b<board[a].length;++b){
                if (board[a][b]=='.'){
                    Count_Dot+=1;}
            }
        }
        
        for (int a =0 ; a<board.length;++a){
            for (int b =0 ; b<board[a].length;++b){
                if (board[a][b]=='Q'){
                    Count_Queen+=1;}
            }
        }
        
        if ((Count_Dot!=56) || (Count_Queen!=8)) {
        	return false;}	        

			return true;     
	}
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		
		public static String Q3_generateBinaryString(Character board[][]) {
		
		if(Q1_checkCharacter(board) == false ||Q2_validBoard(board) == false) {
			return "invalid board";
		}

		String binaryStr = "";
		
		for (int a = board.length-1 ; a>=0;a--){
            for (int b =0 ; b<board[a].length;++b){
                if (board[a][b]=='Q'){
                	
                	String binaryS="";
                	
					if (b == 0) {
						binaryS += "000";
					}else if(b == 1) {
						binaryS += "001";
					}else if(b == 2) {
						binaryS += "010";
					}else if(b == 3) {
						binaryS += "011";
					}else if(b == 4) {
						binaryS += "100";
					}else if(b == 5) {
						binaryS += "101";
					}else if(b == 6) {
						binaryS += "110";
					}else if(b == 7) {
						binaryS += "111";
				    }
                    binaryStr += binaryS;
               	}
            }
        }
		
		
		return binaryStr;
		
	}
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	
		public static String Q4_initialStart() {

		
		String binaryStr = "";
		
		Random rand = new Random();
		
		
		for (int a =0 ; a<24;++a){
			int n = rand.nextInt(2);
		    binaryStr += n;
		}
		
		
		return binaryStr;
	}
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		public static Double Q5_fitnessFunction(String solution) {
		
//		System.out.println(str);
		if(solution.length() != 24) {
			//System.out.println("false");
			return Double.MAX_VALUE;
		}
		if (solution == null) {
			return null;
		}
		
	
		
		for(int i = 0; i < 24; i++) {
			if(solution.charAt(i) != '0') {
				if(solution.charAt(i) != '1') {
				//	System.out.println(str.charAt(i));
					//return 0.1;
					return Double.MAX_VALUE;
					
				}
			}
		}
		
		  int len = solution.length();  
	        //n determines the variable that divide the string in 'n' equal parts  
	        int n = 8;  
	        int temp = 0, chars = len/n;  
	        //Stores the array of string  
	        int[] queens = new int [n];  
	        //Check whether a string can be divided into n equal parts  
	        for(int i = 0; i < len; i = i+chars) {  
	            //Dividing string in n equal part using substring()  
//	        	we select the first 3 bits by using i and i+char
//	        	example i = 0 then i+chars = 0 + 3
	            String part = solution.substring(i, i+chars);  
	            int location = 0;
	        	
	        	if (part.equals("000")) {
	        		location = 0;
					
				}else if(part.equals("001")) {
					location = 1;
					
				}else if(part.equals("010")) {
					location = 2;
					
				}else if(part.equals("011")) {
					location = 3;
					

				}else if(part.equals("100")) {
					location = 4;
					

				}else if(part.equals("101")) {
					location = 5;
					

				}else if(part.equals("110")) {
					location = 6;
					

				}else if(part.equals("111")) {
					location = 7;
					

			    }
	            queens[temp] = location;  
	            
	            temp++;          		            
	        }  
	        
	        if(queens.length != 8) {
	        	return 0.2;
	        }
	             
	      //  To create board
	        char[][] board = new char[n][n];
	        
	        for(int i = 0; i < queens.length; i++) { 
	        	for(int j = 0; j < queens.length; j++) {
	        		if (j == queens[i]) {
	        			board[i][j] = 'Q';
	        		}
	        		else {
	        			board[i][j] = '.';
	        		}
	        	}
	            
	            
	        } 
	        
//	        To Display Matrix 
	        
//	        for (int i = 0; i < board.length; i++) { //this equals to the row in our matrix.
//	            for (int j = 0; j < board[i].length; j++) { //this equals to the column in each row.
//	               System.out.print(board[i][j] + " ");
//	            }
//	            System.out.println(); //change line on console as row comes to end in the matrix.
//	        }
	        
	        //vertical clash
	        int vertCount = 0 ;
	        int vertClash = 0;
	        for(int i = 0; i < queens.length; i++) { 
	        	for(int j = 0; j < queens.length; j++) {
	        		if(board[i][j] == 'Q') {
	        			for (int a = 0; a < 8; a++) {
	        				if(board[a][j] == 'Q') {
	        					vertCount += 1;
	        					
	        				}
	        			}
	        			
	        			if(vertCount > 1) {
	        				vertClash += vertCount - 1;
	        			}
	        			vertCount = 0;
	        			
	        		}
	        	}
	        }
			
		
        // Check for horizontal clashes
	        int horizontalClashes = 0;
	        int horizC = 0;

	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[i].length; j++) {
	                
	                
	                if(board[i][j] == 'Q') {
	                	for (int a = 0; a < 8; a++) {
	        				if(board[i][a] == 'Q') {
	        					horizC ++;
	        					
	        				}
	        			}
	                	
	                	if(horizC > 1) {
	                		horizontalClashes += horizC - 1;
	        			}
	        			horizC = 0;
	                }
	            }
	        }
        
      //  Diagonal Check
        int diagClash = 0;
       
        for (int i=0;i<queens.length;++i) {
            for (int j=i+1;j<8;++j) {
                if (queens[i]-queens[j]==i-j|| queens[i]-queens[j]==j-i) {
                    diagClash=diagClash+2;
                }
            }}
        
        int totalclashes = 0; int fitness = 0;
        totalclashes = vertClash + horizontalClashes + diagClash;
        fitness = 56 - totalclashes;

        // Print the number of clashes
        
//        System.out.println("Number of vertical clashes: " + vertClash);
//        System.out.println("Number of horizontal clashes: " + horizontalClashes);
//        System.out.println("Number of diagonal clashes: " + diagClash);
//        System.out.println("fitness = " + fitness);
        
        if ((fitness > 56) || (fitness < 0)) {
        	return 0.3;
        }
        
        return (double) fitness;
    }
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//
//		Test 1: if String is invalid then null should be returned. [1 mark]
//
//		An invalid String should include the following checks:
//
//		- A check for null
//		- A check for empty
//		- A check that each digit is binary as defined in the assessment brief
//		- A check for the correct String length (size of solution)
//
//		Test 2: if Test 1 has been passed, then the method should return the changed solution. [1 mark]
	//public static String Q6_SmallChangeOperator(String BinaryStr)
	public static String Q6_smallChange (String solution) {
	
		if(solution.length() !=24 || solution == null || solution.length()==0)
		{
			return null;
		}
		
		for(int i = 0; i <24; i++) 
		{
			if(solution.charAt(i) != '0') 
			{
				if(solution.charAt(i) != '1') 
				{
					
					return null;
				}
			}
		}
		
		char[] X = solution.toCharArray();
		Random rand = new Random();
		int RandomInt = rand.nextInt(24);
		
			if (X[RandomInt] == '0')
			{
				X[RandomInt] = '1';
			}
			else if (X[RandomInt] == '1')
			{
				X[RandomInt] = '0';
			}
			
		solution = String.valueOf(X);
		return solution;
	}
	
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

	
	
}