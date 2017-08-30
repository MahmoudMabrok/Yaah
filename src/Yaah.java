
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

/**
 *
 * @author mo3tamed
 */
public class Yaah  extends Application {

    String s;

    String[] enVal = {"a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "z", "x", "c", "v", "b", "n", "m", ",", ".", "/"};
    String[] arVal = {"ش", "س", "ي", "ب", "ل", "ا", "ت", "ن", "م", "ك", "ط", "ض", "ص", "ث", "ق", "ف", "غ", "ع", "ه", "خ", "ح", "ج", "د", "ئ", "ء", "ؤ", "ر", "لا", "ى", "ة", "و", "ز", "ظ"};

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        Label l1 = new Label ();
        l1.setText("Overcome Problem of  write of english "
                + "\n/ Arbic but you you need other \n "
                + " or your pc dont support Arbic"
                + "\n Just copy text and click button "
                + "\n then ctrl + v  ");
        Button btn1 = new Button();
        Button btn2 = new Button();
        btn.setText("Say 'Hello World'");

        btn.setOnAction((ActionEvent event) -> {
            btn.setText("i ve clicked");

        });
        btn.setText("Get Copied text ");
        btn1.setText("E to A");
        btn2.setText("A to E");


        //  Group root = new Group();
        VBox  vBox = new VBox ();

        vBox.getChildren().addAll(l1,btn, btn1, btn2);
        vBox.setSpacing(10);
        //vBox.setStyle("-fx-background-fill: blue;");

        vBox.setStyle("-fx-background-color: linear-gradient(to bottom, #33ccff 0%, #ff99cc 100%)" );


        l1.setLayoutX(45);
        l1.setStyle("-fx-text-fill: black;");
        btn.setLayoutX(10);
        btn.setLayoutY(100);

        btn1.setLayoutX(150);
        btn1.setLayoutY(220);

        btn2.setLayoutX(100);
        btn2.setLayoutY(140);

        // data 
        btn.setOnAction((ActionEvent e) -> {
            try {
                this.s = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(Yaah.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        btn1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                turnEngToArab();
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                turnArabToEng();
            }
        });


        Scene scene = new Scene(vBox, 300, 250 );

        primaryStage.setTitle("Yaah");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void turnArabToEng() {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < arVal.length; j++) {
                if (s.charAt(i) == arVal[j].charAt(0)) {
                    s = s.replace(s.charAt(i), enVal[j].charAt(0));
                }
            }

            StringSelection news = new StringSelection(s);

            Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard2.setContents(news, null);

        }

    }

    public void turnEngToArab() {

        String ss = s;

        for (int i = 0; i < ss.length(); i++) {
            for (int j = 0; j < enVal.length; j++) {
                if (ss.charAt(i) == enVal[j].charAt(0)) {
                    ss = ss.replace(ss.charAt(i), arVal[j].charAt(0));
                }
            }

            StringSelection news = new StringSelection(ss);

            Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard2.setContents(news, null);

        }

    }

}