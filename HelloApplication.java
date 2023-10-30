package com.example.hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class HelloApplication extends Application {
    public static ArrayList<Books> bo = new ArrayList<>();
    private static File file;
    @Override
    public void start(Stage Primarystage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Label intro_label=new Label("Welcome To LMS");   intro_label.setId("intro_label");
        Label select_label=new Label("Please select one of the following");  select_label.setId("select_label");
        ToggleGroup group = new ToggleGroup();
        RadioButton button1 = new RadioButton("Create a New Library"); button1.setId("button1");
        RadioButton button2 = new RadioButton("Open an existing Library"); button2.setId("button2") ;
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);

        Label select_label2=new Label("Please Enter Library Name");  select_label2.setId("select_label2");
        TextField libraryName=new TextField();  libraryName.setId("libraryName");
       // TextField tf2=new TextField();
        Button button = new Button("Next") ; button.setId("button");
        Button button_Proceed = new Button("PROCEED to Library Options") ;  button_Proceed.setId("button_proceed");
        Label result_label=new Label();   result_label.setId("result_label");
        Label bo_label=new Label();
        VBox root = new VBox() ;
        root.setId("root");
       root.getChildren().addAll(intro_label, select_label, button1,button2, select_label2, libraryName, button, result_label  ) ;
        button_Proceed.setVisible(false);
        root.getChildren().add(button_Proceed);
        VBox root22 = new VBox() ;
        root22.setId("root22");

        BorderPane twoRoot = new BorderPane();
        twoRoot.setLeft(root) ;
        twoRoot.setRight(root22);

        ImageView logoImageView = new ImageView(new Image("file:/C:/Users/Win10/Desktop/AppDev/helloFX/lms.png"));
        logoImageView.setPreserveRatio(true);
        //logoImageView.setFitHeight(2000);
        logoImageView.setFitWidth(300);
        Label myName=new Label("Fady Moussa");   myName.setId("myName");

// Add the ImageView to root22
        root22.getChildren().add(logoImageView);
        root22.getChildren().add(myName) ;
        Scene scene1 = new Scene(twoRoot, 700, 700);
        scene1.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());

// END OF SCENE 1_______________________________________________________________________________

        Primarystage.setTitle("try!");
        Primarystage.setScene(scene1);
        Primarystage.show();
        //________________________________________________________________________________________
//SCENE 2___________________________________________________________________________________________
        Label select2_label=new Label("Please select one of the following options");
        select2_label.setId("select2_label");
        ToggleGroup group2 = new ToggleGroup();
        RadioButton option1 = new RadioButton("INSERT A NEW BOOK");  option1.setId("option1");
        RadioButton option2 = new RadioButton("DELETE A BOOK"); option2.setId("option2");
        RadioButton option3 = new RadioButton("DISPLAY ALL BOOKS");  option3.setId("option3");
        RadioButton option4 = new RadioButton("CHECK OUT A BOOK");  option4.setId("option4");
        RadioButton option5 = new RadioButton("CHECK IN A BOOK");  option5.setId("option5");
        option1.setToggleGroup(group2);
        option2.setToggleGroup(group2);
        option3.setToggleGroup(group2);
        option4.setToggleGroup(group2);
        option5.setToggleGroup(group2);

        Button next = new Button ("NEXT") ;  next.setId("next");

        Button backButton = new Button("Back To Main Menu") ;  backButton.setId("backButton");

        VBox root2 = new VBox() ;
        root2.setId("root2");

        ImageView logo2ImageView = new ImageView(new Image(getClass().getResource("books2.jpg").toExternalForm()));
        logo2ImageView.setPreserveRatio(true);

        Label result_scene2=new Label(); result_scene2.setId("result_scene2");

        root2.getChildren().addAll(select2_label, option1, option2, option3, option4, option5, next, backButton, result_scene2 ) ;
        root2.getChildren().add(logo2ImageView) ;
        Scene scene2 = new Scene(root2, 700, 700) ;
        scene2.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());

        //END OF SCENE2________________________________________________________________________________________

        //SCENE_ADD____________________________________________________________________________________
        Label intro_add =new Label("Please Enter Book Details"); intro_add.setId("intro_add");

        Label bookID_add =new Label("Please Enter Book BarCode"); bookID_add.setId("bookID_add");
        TextField bookID=new TextField();  bookID.setId("bookID");

        Label bookTitle_add =new Label("Please Enter Book Title"); bookTitle_add.setId("bookTitle_add");
        TextField bookTitle=new TextField();  bookTitle.setId("bookTitle");

        Label bookAuthor_add =new Label("Please Enter Book Author"); bookAuthor_add.setId("bookAuthor_add");
        TextField bookAuthor=new TextField();  bookAuthor.setId("bookAuthor");

        Button saveAdd = new Button("SAVE AND EXIT") ;  saveAdd.setId("saveADD");

        VBox rootAdd = new VBox(); rootAdd.setId("rootADD");
        rootAdd.getChildren().addAll(intro_add, bookID_add, bookID, bookTitle_add, bookTitle, bookAuthor_add, bookAuthor, saveAdd) ;

        rootAdd.getChildren().add(logo2ImageView) ;
        Scene addScene = new Scene(rootAdd, 700, 700) ;
        addScene.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());
//___________________________________________________________________________________________________________________

        //Scene_Delete____________________________________________________________________________________________
        Label intro_delete =new Label("Please Enter Book ID To DELETE!!"); intro_delete.setId("intro_delete");

        TextField booktoDelete=new TextField();  booktoDelete.setId("booktoDelete");

        Button saveDelete = new Button("SAVE AND EXIT") ;  saveDelete.setId("saveDelete");

        VBox rootDelete = new VBox(); rootDelete.setId("rootDelete");

        rootDelete.getChildren().addAll(intro_delete, booktoDelete, saveDelete) ;
        rootDelete.getChildren().add(logo2ImageView) ;

        Scene deleteScene = new Scene(rootDelete, 700, 700) ;
        deleteScene.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());

 //______________________________________________________________________________________________________________


        //Scene_Display__________________________________________________________________________________________

        Label intro_Display =new Label("DISPLAYING ALL BOOKS!!"); intro_Display.setId("intro_Display");

        Label bo_Label = new Label () ; bo_Label.setId("bo_Label");

        Button exit_Display = new Button("Exit to Menu");  exit_Display.setId("exit_Display");

        VBox rootDisplay = new VBox(); rootDisplay.setId("rootDisplay");

        rootDisplay.getChildren().addAll(intro_Display, bo_Label, exit_Display) ;

        Scene displayScene = new Scene(rootDisplay, 700, 700) ;
        displayScene.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());

 //___________________________________________________________________________________________________________

      // Scene_checkout___________________________________________________________________________________

        Label intro_Checkout =new Label("PLEASE ENTER BOOK ID TO CHECK OUT !!"); intro_Checkout.setId("intro_Checkout");

        TextField booktoCheckout=new TextField();  booktoCheckout.setId("booktoCheckout");

        Button checkout = new Button("Find AND Check-Out") ;  checkout.setId("checkout");

        Label result_Checkout =new Label(); result_Checkout.setId("result_Checkout");
        Label result2_Checkout =new Label(); result2_Checkout.setId("result2_Checkout");

        Button exit_checkout = new Button("Exit to Menu") ;  exit_checkout.setId("exit_checkout");

        VBox rootCheckout = new VBox(); rootCheckout.setId("rootCheckout");

        rootCheckout.getChildren().addAll(intro_Checkout, booktoCheckout, checkout, result_Checkout, result2_Checkout, exit_checkout) ;

        Scene checkoutScene = new Scene (rootCheckout, 700, 700) ;
        checkoutScene.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());


        //___________________________________________________________________________________________________________

        // Scene_checkIn______________________________________________________________________________________
        Label intro_Checkin =new Label("PLEASE ENTER BOOK ID TO CHECK IN !!"); intro_Checkin.setId("intro_Checkin");

        TextField booktoCheckin=new TextField();  booktoCheckin.setId("booktoCheckin");

        Button checkin = new Button("Find AND Check-IN") ;  checkin.setId("checkin");

        Label result_Checkin =new Label(); result_Checkin.setId("result_Checkin");
        Label result2_Checkin =new Label(); result2_Checkin.setId("result2_Checkin");

        Button exit_checkin = new Button("Exit to Menu") ;  exit_checkin.setId("exit_checkin");

        VBox rootCheckin = new VBox(); rootCheckin.setId("rootCheckin");

        rootCheckin.getChildren().addAll(intro_Checkin, booktoCheckin, checkin, result_Checkin, result2_Checkin, exit_checkin) ;

        Scene checkinScene = new Scene (rootCheckin, 700, 700) ;
        checkinScene.getStylesheets().add(getClass().getResource("stylingscene1.css").toExternalForm());


        // ACTION LISTENERS_____________________________________________________________
        button.setOnAction(e -> {
            System.out.println("working!!") ;
            String answer = libraryName.getText() ;
           if (button1.isSelected()) {
               file = new File(answer + ".csv"); // Assign 'file' here
               result_label.setText("a new file has been created: "+answer);
               result_label.setStyle("-fx-text-fill: green;");
               //bo = loadBooksFromFile(file);
              // root.getChildren().add(button_Proceed) ;
               button_Proceed.setVisible(true); // Initially, hide the button

           }

            if (button2.isSelected()) {
                file = new File(answer + ".csv"); // Assign 'file' here
                if (file.exists()) {
                    result_label.setText("File is Found: "+answer);
                    result_label.setStyle("-fx-text-fill: #08a608;");
                    bo = loadBooksFromFile(file);
                 //   root.getChildren().add(button_Proceed) ;
                    button_Proceed.setVisible(true); // Hide the button
                } else {
                    result_label.setText("File is NOT Found: "+answer);
                    result_label.setStyle("-fx-text-fill: red;");
                    button_Proceed.setVisible(false); // Hide the button
                }
            }



        });

        button_Proceed.setOnAction(e -> {
            if (button1.isSelected()) {
                bo = new ArrayList<>();
                saveBooksToFile(bo, file);
                Primarystage.setScene(scene2);
            }

            if (file != null ) {
                Primarystage.setScene(scene2);
            } else {

                result_label.setText("FILE NOT FOUND. Please create or select an existing library first.");
                result_label.setStyle("-fx-text-fill: red;");
                button_Proceed.setVisible(false); // Hide the button
            }

        });

        //BACK BUTTON ON SCENE2
        backButton.setOnAction(e -> {
            Primarystage.setScene(scene1);
            result_label.setText("");
            button_Proceed.setVisible(false); // Hide the button


        });

        //NEXT BUTTON ON SCENE 2_____________________OPTIONS__________________________________
        next.setOnAction(e -> {

         if (option1.isSelected())   {
             Primarystage.setScene(addScene);
         }
         if (option2.isSelected()) {
             Primarystage.setScene(deleteScene);
            }
         if (option3.isSelected()) {
             bo_Label.setText(displayBooks(bo));
             Primarystage.setScene(displayScene);
            }
         if (option4.isSelected()) {
             Primarystage.setScene(checkoutScene);
         }
         if (option5.isSelected()) {
             Primarystage.setScene((checkinScene));
         }


        });

        //________________________________________________________________________________________

        saveAdd.setOnAction(e ->{
            int id = Integer.parseInt(bookID.getText());
            String title = bookTitle.getText() ;
            String author = bookAuthor.getText() ;
            addingBooks(id, title, author);
            saveBooksToFile(bo, file);
            result_scene2.setText("New Book Was Just Added!");

            Primarystage.setScene(scene2);
        });


        saveDelete.setOnAction(e -> {
            int idtoDelete = Integer.parseInt(booktoDelete.getText());
            boolean checkDelete = deletingBooks(idtoDelete);
            saveBooksToFile(bo, file);

            if (checkDelete){
                result_scene2.setText("A Book Was Just Deleted!");
                result_scene2.setStyle("-fx-text-fill: green;");
            } else {
                result_scene2.setText("Failed To Delete!");
                result_scene2.setStyle("-fx-text-fill: red;");

            }
            Primarystage.setScene(scene2);
        });


        exit_Display.setOnAction(e -> {
            saveBooksToFile(bo, file);
            result_scene2.setText("ALL BOOKS WERE DISPLAYED!!");
            result_scene2.setStyle("-fx-text-fill: green;");
            Primarystage.setScene(scene2);

        });


        checkout.setOnAction(e -> {
            int idtoCheckout = Integer.parseInt(booktoCheckout.getText());

          //  checkOutBook(idtoCheckout) ;
            CheckOutResult checkOutResult = checkOutBook(idtoCheckout);

            LocalDate dueDate = checkOutResult.getDueDate();
            boolean success = checkOutResult.isSuccess();

            if (success) {
                result_Checkout.setText("book: "+idtoCheckout+" is successfully CHECKED-OUT !!");
                result_Checkout.setStyle("-fx-text-fill: green;");
                result2_Checkout.setText("PLEASE RETURN BOOK BY: "+dueDate);
                result2_Checkout.setStyle("-fx-text-fill: green;");
            } else {
                result_Checkout.setText("Failed to Check-Out!!");
                result_Checkout.setStyle("-fx-text-fill: red;");
                result2_Checkout.setText("Book with barcode ' "+idtoCheckout+"' NOT FOUND!!!");
                result2_Checkout.setStyle("-fx-text-fill: red;");
            }

        });


        exit_checkout.setOnAction(e -> {
            result_Checkout.setText("");
            result2_Checkout.setText("");
            Primarystage.setScene(scene2);
        });


        checkin.setOnAction(e -> {
            int idtoCheckin = Integer.parseInt(booktoCheckin.getText());

            boolean checkinSuccess = checkInBook(idtoCheckin) ;

            if (checkinSuccess) {
                result_Checkin.setText("book: "+idtoCheckin+" is Successfully CHECKED-IN");
                result_Checkin.setStyle("-fx-text-fill: green;");
                LocalDate currentDate = LocalDate.now();

                result2_Checkin.setText("Check-In Date: "+currentDate);
                result2_Checkin.setStyle("-fx-text-fill: green;");

            } else {
                result_Checkin.setText("Failed to Check-Out!!");
                result_Checkin.setStyle("-fx-text-fill: red;");

                result2_Checkin.setText("Book with barcode ' "+idtoCheckin+"' NOT FOUND!!!");
                result2_Checkin.setStyle("-fx-text-fill: red;");

            }
        });

        exit_checkin.setOnAction(e -> {
            result_Checkin.setText("");
            result2_Checkin.setText("");
            Primarystage.setScene(scene2);
        });

/*
        button_Proceed.setOnAction(e -> {
            root.getChildren().add(bo_label) ;
            bo_label.setText(displayBooks(bo));
            saveBooksToFile(bo , file);

        });
        */

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void createNewFile(String filepath) {

        File file = new File(filepath+".csv");
        try {
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("New File is Created Succssefuly");

            } else {
                System.out.println("FAILED TO CREATE THE FILE");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Books> loadBooksFromFile (File file) {
        ArrayList<Books> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int barcode = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    books.add(new Books(barcode, title, author));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    private static String displayBooks(ArrayList<Books> books) {
        StringBuilder bookString = new StringBuilder();
        for (Books book : books) {
            System.out.println(book);
            bookString.append(book).append("\n");
        }
        return bookString.toString();
    }

    private static void saveBooksToFile(ArrayList<Books> books, File file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Books book : books) {
                writer.println(book.getBarcode() + "," + book.getTitle() + "," + book.getAuthor());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void addingBooks(int barcode, String title, String author){

        bo.add(new Books(barcode, title, author));


    }


    static boolean deletingBooks (int barcodeToDelete) {

        boolean removed = false ;
        Iterator<Books> iterator =  bo.iterator() ;

        while (iterator.hasNext()) {
            Books book  = iterator.next() ;

            if (book.getBarcode() == barcodeToDelete) {
                iterator.remove();
                removed = true ;
                break ;
            }
        }

        if (removed) {
            System.out.println("Book with ID " + barcodeToDelete + " has been deleted.");
            return true ;
        } else {
            System.out.println("Book with ID " + barcodeToDelete + " not found.");
            return false ;
        }

        // saveBooksToFile(bo, file);

    }


    //____________________________ testing method

    public static class CheckOutResult {
        private LocalDate dueDate;
        private boolean success;

        public CheckOutResult(LocalDate dueDate, boolean success) {
            this.dueDate = dueDate;
            this.success = success;
        }

        public LocalDate getDueDate() {
            return dueDate;
        }

        public boolean isSuccess() {
            return success;
        }
    }

    public static CheckOutResult checkOutBook(int barcode) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = null;
        boolean success = false;

        for (int i = 0; i < bo.size(); i++) {
            if (bo.get(i).getBarcode() == barcode) {
                dueDate = currentDate.plusDays(14);
                System.out.println("Checking OUT:");
                System.out.println(bo.get(i).getBarcode() + " " + bo.get(i).getTitle() + " " + bo.get(i).getAuthor() + " ");
                System.out.println("Checked OUT in : " + currentDate);
                System.out.println("MUST BE RETURNED BY: " + dueDate);
                System.out.println("Thank You!!!");
                success = true;
            }
        }

        if (dueDate == null) {
            System.out.println("Book with barcode " + barcode + " not found!!!");
        }

        return new CheckOutResult(dueDate, success);
    }





    //___________________________ end of checking out method

    public static boolean checkInBook (int barcode) {
        LocalDate currentDate = LocalDate.now();
        //LocalDate dueDate ;
        boolean checkIn = false ;
        for (int i = 0; i < bo.size(); i++) {
            if (bo.get(i).getBarcode() == barcode) {
                // dueDate = currentDate.plusDays(14);
                System.out.println("Checking IN:");
                System.out.println(bo.get(i).getBarcode() + " " + bo.get(i).getTitle() + " " + bo.get(i).getAuthor() + " ");
                System.out.println("Check in Date : " + currentDate);
                checkIn = true ;
                System.out.println("Thank You!!!");


            }

        }

        if (checkIn) {
            System.out.println("Book with barcode " + barcode + " is checked in!!!.");
            return true ;
        }

        else {

            System.out.println("Book with barcode " + barcode + " is NOT FOUND!!!.");
           return false ;
        }


    }

//___________________________________________

}




