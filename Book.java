public class Book{
	public static int booksCounter;
	private String bookName, bookAuthor, bookId, bookType;
	private int bookCopy;
	
	Book(){
		bookName = bookAuthor = bookId = bookType = "N/A";
		bookCopy = 0;
		
		booksCounter++;
	}
	
	Book(String bookName,String bookAuthor,String bookId,String bookType,int bookCopy){
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookId = bookId;
		this.bookType = bookType;
		this.bookCopy = bookCopy;
		
		booksCounter++;
	}
	
	public void showInfo(){
		System.out.println(
		"----------------------------\n"+
		"Book Name: "+this.bookName+"\n"+
		"Author :"+this.bookAuthor+"\n"+
		"BookID :"+this.bookId+"\n"+
		"Book Type :"+this.bookType+"\n"+
		"Available Copies :"+this.bookCopy+"\n"+
		"----------------------------\n"
		);
	}
	
	public boolean addBookCopy(int copies){
		if(copies > 0){
			this.bookCopy += copies;
			return true;
		}
		
		return false;
	}
	
	public static void showTotalBookInfo(){
		System.out.println("Total ammount of books : "+booksCounter); 
	}
	
	public static void main(String args[]){
		
		Book harryPotter1 = new Book("Harry Potter 1","JK Rowling","266-55","Fantasy",4);
		Book harryPotter2 = new Book("Harry Potter 2","JK Rowling","262-25","Fantasy",5);
		Book harryPotter3 = new Book("Harry Potter 3","JK Rowling","212-37","Fantasy",7);
		Book harryPotter4 = new Book("Harry Potter 4","JK Rowling","272-58","Fantasy",2);
		
		Book example = new Book("Abcd","Abcd","555-588","AbcdAbcd",2);
		
		harryPotter1.showInfo();
		harryPotter2.showInfo();
		harryPotter3.showInfo();
		harryPotter4.showInfo();

		example.showInfo();
		
		showTotalBookInfo();
		
	}
}