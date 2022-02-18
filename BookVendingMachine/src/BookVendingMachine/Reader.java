package BookVendingMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Reader
{
	Book book = new Book();
	private boolean searchBookInInventory(Book searchedBook)
	{
		try
		{
			FileReader file = new FileReader("BookInventory.txt");
			BufferedReader inventory = new BufferedReader(file);
			String bookCoded = Integer.toString(searchedBook.getId());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(searchedBook.getTitle());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(searchedBook.getAuthor());
			bookCoded = bookCoded.concat("#");
			bookCoded = bookCoded.concat(Integer.toString(searchedBook.getPages()));
			String row;
			while((row = inventory.readLine()) != null)
			{
				if(row.equals(bookCoded) == true)
				{
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
	public void borrowBook(Book bookToBorrow)
	{
		this.book = bookToBorrow;
		boolean bookFound = searchBookInInventory(this.book);
		if(bookFound == true)
		{
			System.out.println("You borrowed [" + this.book.getTitle() + "].");
		}
		else
		{
			System.out.println("Sorry something went wrong. Book not found.");
		}
	}
	public void returnBook()
	{
		
	}
	public void checkTimeToRead()
	{
		System.out.println("The loan period for borrowed book is 31 days.");
	}

}
