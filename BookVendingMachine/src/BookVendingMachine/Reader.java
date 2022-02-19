package BookVendingMachine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

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
}
