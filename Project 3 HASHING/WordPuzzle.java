import java.io.*;
import java.util.*;

public class WordPuzzle {
	private int row;
	private int column;
	private String [][] puzzle;
	private int wordCount;
	
	
	public void createPuzzle(int r, int c) {
		row = r;
		column = c;		
		puzzle = new String[row][column];
		/*String abc = "applebananacarrotdachory";
		int k=0;
		//Random rand = new Random();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(k<abc.length())
				{
				puzzle[i][j] = Character.toString(abc.charAt(k));
				k++;
				}
			}
		}*/	
		Random rand = new Random();
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				puzzle[i][j] = Character.toString((char) (97 + rand.nextInt(26)));
			}
		}	
	}
//////////////////////////////////////////////////////////////////////////////////////
	public void printPuzzle() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(puzzle[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	public void findWords(MyHashTable<String> ht, int type) {
		wordCount = 0;
		//check for each row
		for(int i=0; i < row; i++) {
			StringBuilder wordBuilder;
			int k = 0;
			while(k < column) {
				wordBuilder = new StringBuilder();
				for(int j = k; j < column; j++) {
					wordBuilder.append(puzzle[i][j]);
					int temp = ht.contains(wordBuilder.toString());
					if(temp == 0 && type == 1) {
						wordBuilder.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("---------------------------WORD FOUND ACROSS ROWS (LEFT TO RIGHT)------------------------------");
						System.out.println(wordBuilder); //print the formed word
					}else {}
				}
				k++;
			}
		//////////////////////////////////////////////////////////////////////////////////////////////////////	
			//check for each row in reverse
			StringBuilder wordBuilderRev;
			int kr = column - 1;
			while(kr > 0) {
				wordBuilderRev = new StringBuilder();
				wordBuilderRev.append(puzzle[i][kr]);
				for(int j = kr-1 ; j >= 0 ; j-- ) {
					wordBuilderRev.append(puzzle[i][j]);
					int temp = ht.contains(wordBuilderRev.toString());
					if(temp == 0 && type == 1) {
						wordBuilderRev.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("---------------------------WORD FOUND ACROSS ROWS (RIGHT TO LEFT)------------------------------");
						System.out.println(wordBuilderRev); //print the formed word
					}else {	}
				}
				kr--;
			}		
		}
		
		//////////////////////////////////////////////////////////////////////
		//check for words along column
		for(int j=0; j < column; j++) {
			StringBuilder wordBuilder;
			int k = 0;
			while(k < row-1) {
				wordBuilder = new StringBuilder();
				wordBuilder.append(puzzle[k][j]);
				for(int i = k+1; i < row; i++) {
					wordBuilder.append(puzzle[i][j]);
					int temp = ht.contains(wordBuilder.toString());
					if(temp == 0 && type == 1) {
						wordBuilder.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("--------------------------WORD FOUND ACROSS COLUMNS (UP TO DOWN)-------------------------------");
						System.out.println(wordBuilder); //print the formed word
					}else {	}
				}
				k++;
			}
			/////////////////////////////////////////////////////////////////////////////////////
			//check for each column in reverse
			StringBuilder wordBuilderRev;
			int kr = row - 1;
			while(kr > 0) {
				wordBuilderRev = new StringBuilder();
				wordBuilderRev.append(puzzle[kr][j]);

				for(int i = kr-1 ; i >= 0 ; i-- ) {

					wordBuilderRev.append(puzzle[i][j]);
					int temp = ht.contains(wordBuilderRev.toString());
					if(temp == 0 && type == 1) {
						wordBuilderRev.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("------------------------WORD FOUND ACROSS COLUMNS (DOWN TO UP)---------------------------------");
						System.out.println(wordBuilderRev); //print the formed word
					}else {	}
				}
				kr--;
			}		
		}
		//////////////////////////////////////////////////////////////////////////////////////////
		//check words in slanting manner. 
		StringBuilder sb1 = new StringBuilder();
		   
		for(int i=0; i<puzzle.length; i++)
		   {
			   for(int j=0; j<puzzle[0].length; j++)
			   {
				   int z = i;
				   sb1.setLength(0);
				   for(int k=j; k>=0; k--)
				   {
					   sb1.append(puzzle[z][k]);
					   if(sb1.length() <2)
		        		{z--;
						   if(z<0)
						   {break;}
						   continue;}
					   
					   int temp = ht.contains(sb1.toString());
			        	
			        	if (temp==0  && type==1)
			        	{
			        		sb1.setLength(0);
			        		break;
			        	}
			        	else if (temp == 1)
			            {
			        		wordCount++;
							System.out.println("------------------------WORD FOUND ACROSS DIAGONAL(BOTTOM LEFT TO TOP RIGHT)---------------------------------");
							System.out.println(sb1);
			        		
			            }
			        	else
			        	{
			        		
			        	}
					   z--;
					   if(z<0)
					   {break;}
				   }
				   
			   }
		   }
		///////////////////////////////////////////////////////////////////////////////////////////////	
		for(int i=1; i < row; i++) {
			StringBuilder wordBuilder;
			int k = column - 1;
			while(k > 0) {
				wordBuilder = new StringBuilder();
				wordBuilder.append(puzzle[i-1][k-1]);
				int ir = i;
				for(int j = k; j < column; j++) {
					wordBuilder.append(puzzle[ir][j]);
					int temp = ht.contains(wordBuilder.toString());
					if(temp == 0 && type == 1) {
						wordBuilder.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("--------------------------WORD FOUND ACROSS DIAGNAL (TOP RIGHT TO BOTTOM LEFT)-------------------------------");
						System.out.println(wordBuilder); //print the formed word
					}else {	}
					ir++;
					if(ir > row -1) {
						break;
					}
				
				}
				k--;
			}	
			
	//////////////////////////////////////////////////////////////////////////////////////////////////////		
			StringBuilder wordBuilderRev;
			int kr = column -1;
			while(kr > 0) {
				wordBuilderRev = new StringBuilder();
				wordBuilderRev.append(puzzle[i][kr]);
				int irr = i-1;
				for(int j = kr-1; j >= 0; j--) {
					wordBuilderRev.append(puzzle[irr][j]);
					int temp = ht.contains(wordBuilderRev.toString());
					if(temp == 0 && type == 1) {
						wordBuilderRev.setLength(0);
						break;
					}else if(temp == 1) {
						wordCount++;
						System.out.println("----------------WORD FOUND ACROSS DIAGNAL(BOTTOM RIGHT TO TOP LEFT)-----------------------------------------");
						System.out.println(wordBuilderRev); //print the formed word
					}else {	}
					irr--;
					if(irr < 0) {
						break;
					}					
				}
				kr--;
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		WordPuzzle wp = new WordPuzzle();
		MyHashTable<String> ht = new MyHashTable<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the no. of rows and column : ");
		int row = sc.nextInt();
		int column = sc.nextInt();
		if(row < 1 || column < 1) {
			System.out.println("The row and column should be grater than 0.");
		}else {
			System.out.println("Please enter the type of hashing. 0 for default and 1 for enhanced : ");
			int en = sc.nextInt();
			wp.createPuzzle(row, column);
			Scanner s1=null;
			try {
				s1 = new Scanner(new File("dictionary.txt"));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		     int wordCount = 0;
		     int prefixCount=0;
		     long hash_start=System.nanoTime();
		     while(s1.hasNext()){
		    	 String word = s1.nextLine();
		    	 if(en ==1) // if running enhanced algorithm
		    	 {
		    		StringBuilder sb = new StringBuilder();
					for(int i = 0; i < word.length(); i++) 
					{
						sb.append(word.charAt(i));
						
						if(i == word.length()-1 ) 
						{
							ht.insert(sb.toString(), true,false);
							wordCount++;
						}
						else 
						{								
							ht.insert(sb.toString(), false,true);
							prefixCount++;
						}							
					}
		    		 
		    	 }
		    	 else
		    	 {
			    	 ht.insert(word,true,false);
			    	 wordCount++;
		    	 }
		    	 
		     }
		     
		     s1.close();
		     long hash_time_fin=System.nanoTime();
		     System.out.println( "Time taken to HASH words: " + (hash_time_fin-hash_start)/1000000 + "ms" );
		     System.out.println("Dictionary loaded, total words = "+wordCount);
		     System.out.println("Dictionary loaded, total prefix words = "+prefixCount);
			ht.printMyHash();
		    long start=System.nanoTime();
		    wp.printPuzzle();
			wp.findWords(ht, en);
			long stop = System.nanoTime();
			System.out.println("Total no. of words found : " + wp.wordCount);
			System.out.println( "Time taken to find words: " + (stop-start)/1000000 + "ms" );
		}
		sc.close();		
	}
}