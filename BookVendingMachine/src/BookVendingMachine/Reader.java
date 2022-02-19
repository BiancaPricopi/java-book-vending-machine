package BookVendingMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader
{
	Book book = new Book();
	private String makeRowForFile(Book addBook)
	{
		String bookCoded = Integer.toString(addBook.getId());
		bookCoded = bookCoded.concat("#");
		bookCoded = bookCoded.concat(addBook.getTitle());
		bookCoded = bookCoded.concat("#");
		bookCoded = bookCoded.concat(addBook.getAuthor());
		bookCoded = bookCoded.concat("#");
		bookCoded = bookCoded.concat(Integer.toString(addBook.getPages()));
		return bookCoded;
	}
	private void writeBorrowedBook()
	{
		try
		{
			FileWriter file = new FileWriter("BorrowedBooks.txt", true);
			BufferedWriter borrower = new BufferedWriter(file);
			String row = makeRowForFile(this.book);
			borrower.write(row + "\n");
			borrower.close();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	private boolean searchBookInInventory(Book searchedBook)
	{
		try
		{
			FileReader file = new FileReader("BookInventory.txt");
			BufferedReader inventory = new BufferedReader(file);
			String bookCoded = this.makeRowForFile(searchedBook);
			String row;
			while((row = inventory.readLine()) != null)
			{
				if(row.equals(bookCoded) == true)
				{
					inventory.close();
					return true;
				}
			}
			inventory.close();
			return false;
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
			return false;
		}
	}
	private boolean searchBorrowedBook(Book searchedBook)
	{
		try
		{
			FileReader file = new FileReader("BorrowedBooks.txt");
			BufferedReader inventory = new BufferedReader(file);
			String bookCoded = this.makeRowForFile(searchedBook);
			String row;
			while((row = inventory.readLine()) != null)
			{
				if(row.equals(bookCoded) == true)
				{
					inventory.close();
					return true;
				}
			}
			inventory.close();
			return false;
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
			return false;
		}
	}
	private void copyFile()
	{
		try
		{
			BufferedWriter copy = new BufferedWriter(
					new FileWriter("BorrowedBooks.txt"));
			BufferedReader br = new BufferedReader(
					new FileReader("temporaryBorrowed.txt"));
			String row;
			while((row = br.readLine()) != null)
			{
				copy.write(row + "\n");
			}
			br.close();
			copy.close();
			try 
			{
	            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Documents\\java\\BookVendingMachine\\temporaryBorrowed.txt"));
	        }
	        catch (Exception error) 
			{
	            System.out.println(error.getMessage());
	        }
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	private void deleteBorrowedBook()
	{
		try
		{
			FileReader file = new FileReader("BorrowedBooks.txt");
			BufferedReader borrowed = new BufferedReader(file);
			String bookCoded = this.makeRowForFile(this.book);
			String row;
			boolean flag = true;
			while(flag == true && (row = borrowed.readLine()) != null)
			{
				if(row.equals(bookCoded) == true)
				{
					File inputFile = new File("BorrowedBooks.txt");
					File tempFile = new File("temporaryBorrowed.txt");

					BufferedReader reader = new BufferedReader(new FileReader(inputFile));
					BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
					String currentLine;
					boolean firstBookOccurence = false;

					while((currentLine = reader.readLine()) != null)
					{
					    if(currentLine.equals(row) && firstBookOccurence == false)
					    {
					    	firstBookOccurence = true;
					    }
					    else
					    {
					    	writer.write(currentLine + System.getProperty("line.separator"));
					    }
					}
					writer.close(); 
					reader.close();
					borrowed.close();
					
					if(tempFile.length() == 0)
					{
						FileWriter file1 = new FileWriter("BorrowedBooks.txt");
						file1.close();
						try 
						{
				            Files.deleteIfExists(Paths.get("C:\\Users\\Admin\\Documents\\java\\BookVendingMachine\\temporaryBorrowed.txt"));
				        }
				        catch (Exception error) 
						{
				            System.out.println(error.getMessage());
				        }
					}
					else
					{
						copyFile();
					}
					flag = false;
				}
			}
			borrowed.close();
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
	public void borrowBook(Book bookToBorrow)
	{
		this.book = bookToBorrow;
		boolean bookFound = searchBookInInventory(this.book);
		if(bookFound == true)
		{
			System.out.println("You borrowed [" + this.book.getTitle() + "].");
			this.writeBorrowedBook();
		}
		else
		{
			System.out.println("Sorry something went wrong. Book not found.");
		}
	}
	public void returnBook(Book bookToReturn)
	{
		this.book = bookToReturn;
		boolean bookFound = this.searchBorrowedBook(this.book);
		if(bookFound == true)
		{
			System.out.println("You returned [" + this.book.getTitle() + "]");
			this.deleteBorrowedBook();
		}
		else
		{
			System.out.println("Sorry something went wrong. Book not found.");
		}
	}
	public void checkTimeToRead()
	{
		System.out.println("The loan period for borrowed book is 31 days.");
	}
	public void displayAvailableBooks()
	{
		try
		{
			FileReader file = new FileReader("BookInventory.txt");
			BufferedReader display = new BufferedReader(file);
			String displayBook;
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------Books-------------------------");
			System.out.println("------------------------------------------------------");
			while((displayBook = display.readLine()) != null)
			{
				String bookInfo[] = displayBook.split("#");
				for(int i = 0; i < bookInfo.length; i++) 
				{
					 System.out.print(bookInfo[i] + " ");
				}
				System.out.print("\n");
			}
			System.out.println("------------------------------------------------------");
			System.out.println("------------------------------------------------------");
		}
		catch(Exception error)
		{
			System.out.println(error.getMessage());
		}
	}
}
