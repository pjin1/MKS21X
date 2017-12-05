public class Book{
    private String author, title, ISBN;
    public Book(){}
    public Book(String author, String title, String ISBN){
    		this.author = author;
    		this.title = title;
    		this.ISBN = ISBN;
    }

    public getAuthor(){ 
    		return author;
    }
    
    public getTitle(){
    		return title;
    }

    public getISBN(){
    		return ISBN;
    }

    public toString(){
    		return title + ", " + author + ", " + ISBN;
    }

}
