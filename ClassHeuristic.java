import java.util.Random;

public class ClassHeuristic {

		public String bestFit = "";
		public int bestFitness = 0;

		public ClassHeuristic(int ITER) {
			
			String randomPoint = Q4_initialStartingPoint();
			int fitness = Q5_Fitness(randomPoint);
			for(int i = 0; i < ITER; i++) {
				
				String newRandomPoint = Q6_SmallChangeOperator(randomPoint);
				int newFitness = Q5_Fitness(newRandomPoint);
				if(newFitness > fitness) {
					fitness = newFitness;
					randomPoint = newRandomPoint;
				}
			}
			
			this.bestFit = randomPoint;
			this.bestFitness = fitness;
		}
		
		public String getPoint() {
			return bestFit;
		}
		
		public int getFitness() {
			return bestFitness;
		}
		
		public static String Q4_initialStartingPoint() {
			
			String binaryStr = "";
			
			Random rand = new Random();
			
			
			for (int a =0 ; a<24;++a){
				int n = rand.nextInt(2);
			    binaryStr += n;
			}
			
			
			return binaryStr;
		}
		
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		
		public static int Q5_Fitness(String str) {
			
//			System.out.println(str);
			if(str.length() != 24 || str == null) {
				//System.out.println("false");
				return 0;
			}
			
		
			
			for(int i = 0; i < 24; i++) {
				if(str.charAt(i) != '0') {
					if(str.charAt(i) != '1') {
					//	System.out.println(str.charAt(i));
						return 0;
						
					}
				}
			}
			
			  int len = str.length();  
		        //n determines the variable that divide the string in 'n' equal parts  
		        int n = 8;  
		        int temp = 0, chars = len/n;  
		        //Stores the array of string  
		        int[] queens = new int [n];  
		        //Check whether a string can be divided into n equal parts  
		        for(int i = 0; i < len; i = i+chars) {  
		            //Dividing string in n equal part using substring()  
//		        	we select the first 3 bits by using i and i+char
//		        	example i = 0 then i+chars = 0 + 3
		            String part = str.substring(i, i+chars);  
		            int pos = 0;
		        	
		        	if (part.equals("000")) {
						pos = 0;
						
					}else if(part.equals("001")) {
						pos = 1;
						
					}else if(part.equals("010")) {
						pos = 2;
						
					}else if(part.equals("011")) {
						pos = 3;
						

					}else if(part.equals("100")) {
						pos = 4;
						

					}else if(part.equals("101")) {
						pos = 5;
						

					}else if(part.equals("110")) {
						pos = 6;
						

					}else if(part.equals("111")) {
						pos = 7;
						

				    }
		            queens[temp] = pos;  
		            
		            temp++;  
		            
		            	
		            
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
		        
//		        To Display Matrix 
		        
//		        for (int i = 0; i < board.length; i++) { //this equals to the row in our matrix.
//		            for (int j = 0; j < board[i].length; j++) { //this equals to the column in each row.
//		               System.out.print(board[i][j] + " ");
//		            }
//		            System.out.println(); //change line on console as row comes to end in the matrix.
//		        }
		        
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
	        
//	        System.out.println("Number of vertical clashes: " + vertClash);
//	        System.out.println("Number of horizontal clashes: " + horizontalClashes);
//	        System.out.println("Number of diagonal clashes: " + diagClash);
//	        System.out.println("fitness = " + fitness);
	        
	        if ((fitness > 56) || (fitness < 0)) {
	        	return 0;
	        }
	        
	        return fitness;
	    }
		
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

		public static String Q6_SmallChangeOperator(String BinaryStr)
		{
			if(BinaryStr.length() !=24 || BinaryStr == null)
			{
				return "false";
			}
			
			for(int i = 0; i <24; i++) 
			{
				if(BinaryStr.charAt(i) != '0') 
				{
					if(BinaryStr.charAt(i) != '1') 
					{
						
						return "false";
					}
				}
			}
			
			char[] BinaryStringCharacter = BinaryStr.toCharArray();
			Random rand = new Random();
			int RandomInteger = rand.nextInt(24);
			
				if (BinaryStringCharacter[RandomInteger] == '0')
				{
					BinaryStringCharacter[RandomInteger] = '1';
				}
				else if (BinaryStringCharacter[RandomInteger] == '1')
				{
					BinaryStringCharacter[RandomInteger] = '0';
				}
				
			BinaryStr = String.valueOf(BinaryStringCharacter);
			return BinaryStr;
		}
}
