package com.collection.Test;

import com.collection.Dao.BookDAO;
import com.collection.Dao.BookDaoImpl;
import com.collection.pojo.Book;
import com.collection.pojo.CompareAuthor;
import com.collection.pojo.CompareId;
import com.collection.pojo.CompareName;
import com.collection.pojo.ComparePrice;




import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner (System.in);
		Book b;
		BookDaoImpl bimpl=new BookDaoImpl();
		ArrayList<Book> blist;
		
		int option;
		int id;
		String name;
		String author;
		double price;
		boolean flag;
		boolean exit=false;
		System.out.println("==========welcome to our website================");
		do {
			System.out.println("\n\n Enter the option");
			System.out.println("Add book--------->1");
			System.out.println("show book by name---------->2");
			System.out.println("update book--------->3");
			System.out.println("show all books-------->4");
			System.out.println("delete book--------->5");
			System.out.println("show book id--------->6");
			System.out.println("Exit--------->7");
			
			option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
	        case 1:System.out.println("Enter name:-");
			name=sc.nextLine();
			
			System.out.println("Enter author name:-");
			author=sc.nextLine();
			
			System.out.println("Enter price:-");
			price=sc.nextDouble();
			sc.nextLine();
			
			b=new Book();
			b.setAuthor(author);
			b.setName(name);
			b.setPrice(price);
			
			flag=bimpl.addBook(b);
			
			if(flag)
				System.out.println("Book added to database successfully.....");
			else
				System.out.println("Error while adding Book,PLEASE TRY AGAIN.....");
			break;
									
			case 2:System.out.println("Enter book name you want to view");
			name=sc.nextLine();
			
			b=bimpl.showByName(name);
			
			if(b==null)
				System.out.println(" Sorry!! No such book found");
			else {
				System.out.println("\n------------The Book details-----------");
				System.out.println(b);
			}
			break;	
			
			case 3:System.out.println("Enter book name to be updated.........");
			name=sc.nextLine();
			
			b=bimpl.showByName(name);
			if(b==null)
				System.out.println("Check the name given.......No such book available for update");
			else {
				System.out.println("\n----------The book details-------------- ");
				System.out.println(b);
			
			System.out.println("\n want to update book?Enter y for YES and n for NO");
			char choice=sc.next().charAt(0);
			sc.nextLine();
			
			if(choice=='n')
				System.out.println("Thankyou*****");
			else if(choice=='y') {
				System.out.println("Enter name:-");
				name=sc.nextLine();
				
				System.out.println("Enter author:-");
				author=sc.nextLine();
				
				System.out.println("Enter price:-");
				price=sc.nextDouble();
				sc.nextLine();
				
				b=new Book();
				b.setAuthor(author);
				b.setName(name);
				b.setPrice(price);
				
				flag=bimpl.addBook(b);
				
				if(flag)
					System.out.println("Book updated successfully.....");
				else
					System.out.println("Error while updating Book,PLEASE TRY AGAIN.....");
				}
			else
				System.out.println("Please give y or n as input for yes or no");
			}
		     break;
					
			case 4:
				blist=bimpl.showAllBooks();
				if(blist==null)
					System.out.println("please add books ,database is empty");
				else {
					System.out.println("list by name--->name");
					System.out.println("list by price--->price");
					System.out.println("list by author---->author");
					System.out.println("list by id--->id");
					
					String listType=sc.nextLine();
					listType=listType.toLowerCase();
					
					switch(listType) {
					case "name": Collections.sort(blist,new CompareName());
					
					System.out.println("--list of books---");
					for(Book b1:blist) {
						System.out.println(b1);
						System.out.println("*************************");
					}
					break;
					
					case "price":Collections.sort(blist,new ComparePrice());
					System.out.println("--list of books---");
					for(Book b1:blist) {
						System.out.println(b1);
						System.out.println("*************************");
				}
			        break;
			        
                case "author":Collections.sort(blist,new CompareAuthor());
					

					System.out.println("--list of books---");
					for(Book b1:blist) {
						System.out.println(b1);
						System.out.println("*************************");
				}
					break;
					
                case "id":Collections.sort(blist,new CompareId());
				System.out.println("--list of books---");
				for(Book b1:blist) {
					System.out.println(b1);
					System.out.println("*************************");
			}
				break;
				default:System.out.println("Please give input correctly");
			        
			}
		}
      break;
			 
			case 5:blist=bimpl.showAllBooks();
				

				System.out.println("--list of books---");
				for(Book b1:blist) {
					System.out.println(b1);
					System.out.println("*************************");
			}
				System.out.println("Please enter id of book you want to delete....");
				id=sc.nextInt();
				sc.nextLine();
				flag=bimpl.deleteBook(id);
				
				if(flag)
					System.out.println("Book deleted from database");
				else
					System.out.println("Error while deleting book");
				break;
				 
			 case 6:
				 System.out.println("Enter id of book to be viewed");
					
					id=sc.nextInt();
					sc.nextLine();
					
					b=bimpl.showById(id);
					
					if(b==null)
						System.out.println("NoBook found with this id");
					else {
						System.out.println("--------------Book Details-----------");
						System.out.println(b);}
					break;
			 case 7:
				 System.out.println("Are you sure you want to exit? y for yes and n for no");
				 char e=sc.next().charAt(0);
				 sc.nextLine();
				
					if(e=='y') {
						System.out.println("Thankyou visit again");
					exit=true;}
					else if(e=='n') {
						System.out.println("Cool");}
					else
						System.out.println("please give y for yes and n for no");
					break;
					
					
			 default:System.out.println("Please give input correctly..Number between 1 to 7");}}
					while(exit==false);
		
		purchase p=BookShopping ::PurchaseSomething; 
		p.show();	
	}

}
