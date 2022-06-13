package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase1UI extends BorderPane {
    PhaseManager phaseManager;
    int tipo = 0;

    Button btnProx, btnClose;
    Button btnAlunos, btnPropostas, btnDocentes;
    Button btnInsere, btnConsulta, btnEdita, btnElimina;

    Label displayTipo;

    public Phase1UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    private void createView(){
        btnProx = new Button("Proxima Fase");
        btnAlunos.setMinWidth(100);
        btnAlunos.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        btnAlunos = new Button("Alunos");
        btnAlunos.setMinWidth(75);
        btnAlunos.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        btnDocentes = new Button("Docentes");
        btnDocentes.setMinWidth(75);
        btnDocentes.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        btnPropostas = new Button("Propostas");
        btnPropostas.setMinWidth(75);
        btnPropostas.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        btnInsere = new Button("Insere");
        btnInsere.setMinWidth(150);

        btnConsulta = new Button("Consulta");
        btnConsulta.setMinWidth(150);

        btnEdita = new Button("Edita");
        btnEdita.setMinWidth(150);

        btnElimina = new Button("Elimina");
        btnElimina.setMinWidth(150);

        TilePane tilePane = new TilePane();
        tilePane.getChildren().addAll(btnInsere, btnConsulta, btnEdita, btnElimina);
        tilePane.setPrefRows(2);
        tilePane.setPrefColumns(2);
        tilePane.setHgap(10);
        tilePane.setVgap(10);
        this.setCenter(tilePane);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnAlunos, btnDocentes, btnPropostas);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(50);
        this.setTop(hBox);


        displayTipo = new Label();
        displayTipo.setPrefWidth(Integer.MAX_VALUE);
        displayTipo.setStyle("-fx-background-color: #d0d0d0; -fx-font-size: 16; -fx-font-family: 'Roboto Light'");
        displayTipo.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        displayTipo.setPadding(new Insets(10));
        this.setBottom(displayTipo);


    }

    private void registerHandlers() {
        btnProx.setOnAction(actionEvent -> {

        });

        btnClose.setOnAction(actionEvent -> {

        });

        btnAlunos.setOnAction(actionEvent -> {
            tipo = 1;
            update();
        });

        btnDocentes.setOnAction(actionEvent -> {
            tipo = 2;
            update();
        });

        btnPropostas.setOnAction(actionEvent -> {
            tipo = 3;
            update();
        });
    }

    private void update(){
        if(phaseManager.getPhaseState() != PhaseState.PHASE_1){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        switch(tipo){
            case 0 ->{

            }
            case 1 -> {
                if(btnDocentes.getBackground() != btnPropostas.getBackground()){
                    btnDocentes.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                    btnPropostas.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                }
                btnAlunos.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            case 2 ->{
                if(btnAlunos.getBackground() != btnPropostas.getBackground()){
                    btnAlunos.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                    btnPropostas.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                }
                btnDocentes.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
            case 3 ->{
                if(btnDocentes.getBackground() != btnAlunos.getBackground()){
                    btnDocentes.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                    btnAlunos.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));;
                }
                btnPropostas.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        }
        displayTipo.setText("Current tipo: " + btnAlunos.getBackground());
    }
}
