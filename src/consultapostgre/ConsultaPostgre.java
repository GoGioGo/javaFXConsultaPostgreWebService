/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultapostgre;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author gio
 */
public class ConsultaPostgre extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            HBox hbox=new HBox();
            hbox.setSpacing(10);
            Label la=new Label("Ingresa NIT");
            TextField nit=new TextField();
            Label nom=new Label("");
            hbox.getChildren().addAll(la, nit, nom);
            
            HBox ab=new HBox();
            Button btn=new Button("Buscar");
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    nom.setText(nombreEmpresa(Integer.parseInt(nit.getText())));
                }
            });
            
       
            ab.getChildren().addAll(btn);
            
            
            BorderPane root = new BorderPane();
            root.setTop(hbox);
            root.setBottom(ab);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Consulta PostgreSql");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private static String nombreEmpresa(int nit) {
        service.Postgre_Service service = new service.Postgre_Service();
        service.Postgre port = service.getPostgrePort();
        return port.nombreEmpresa(nit);
    }

}
