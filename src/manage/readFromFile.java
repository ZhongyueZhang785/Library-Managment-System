package manage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;





import DBConnect.Book;
import DBConnect.Card;
import DBConnect.bookDAO;

public class readFromFile {
	public static ArrayList<Book> show_book() {
        ArrayList<Book> res = new ArrayList<Book>();
		return res;}
	
		@SuppressWarnings("null")
		public static void processInputOutputFiles(String[] args) {
			/*
			 *  read the content from file and print the content to the screen as well as output file
			 *  @param agrs passed from main
			 */
			
			try {
				FileReader fileReader = new FileReader("/Images/book.txt"); 
				BufferedReader finalInStream = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"UTF-8"));
				String s;//read a line into a string
				int num2 = 0;
				PrintWriter textPrintStream = null;
				String outfileName =args[1];
				textPrintStream = new PrintWriter(new FileOutputStream(outfileName));
				
				ArrayList<Book> res = new ArrayList<Book>();
				
				while ((s=finalInStream.readLine()) != null) {//read from the input file
					StringTokenizer parseWords = new StringTokenizer(s, ",");
					int num = 1;
					String bno = null;
					String category = null;
					String title = null ;
					String press = null ;
					int year = 0;	
					String author = null ;
					float price = 0 ;
					int total = 0;
					while(parseWords.hasMoreTokens())
					{	String s2 = parseWords.nextToken();
					
						switch(num) {
						case 1: bno = s2;break;
						case 2: category = s2;break;
						case 3: title = s2;break;
						case 4: press = s2;break;
						case 5: year = Integer.valueOf(s2).intValue();break;	
						case 6: author = s2;break;
						case 7: price = Float.parseFloat(s2);break;
						case 8: total = Integer.valueOf(s2).intValue();break;
					}

						num++;
						
					}
					num = 1;
					Book book = new Book(bno,category,title,press,year,author,price,total,total);
					System.out.println(book.toString());
					res.add(book);
					textPrintStream.println();
					
				}
				finalInStream.close();//close the file
				textPrintStream.close();//close the file
			} catch (Exception e) {
				System.out.println("The file is not available in default folder\n");
				//e.printStackTrace();
			}
			
		}


		public static void main(String[] args) throws ParseException {//args is the String array of command line arguments passed by JVM
			processInputOutputFiles(args);
			

			
		}
		
	
}
	
