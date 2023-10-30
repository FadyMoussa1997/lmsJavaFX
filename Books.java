package com.example.hellofx;

public class Books {


    private int barcode ;
    private String title ;
    private String author ;



//constructor method for the books

    public Books(int barcode, String title, String author) {
        this.setBarcode(barcode);
        this.setTitle(title);
        this.setAuthor(author);
    }



    public int getBarcode () {

        return barcode ;
    }

    public void setBarcode (int barcode) {
        this.barcode = barcode ;
    }


    public String getTitle() {
        return title ;

    }

    public void setTitle (String title) {
        this.title = title ;
    }

    public String getAuthor () {
        return author ;
    }

    public void setAuthor (String author) {
        this.author = author ;
    }
    // to string method to display book details
    public String toString() {

        return barcode+". "+title+", "+author ;
    }
}
