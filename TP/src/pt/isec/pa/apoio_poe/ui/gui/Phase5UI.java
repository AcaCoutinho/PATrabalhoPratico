package pt.isec.pa.apoio_poe.ui.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.data.Phase;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase5UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    TilePane tilePaneLista;

    Button btnSair;
    Button btnAvancar, btnVoltar;
    Button btnListaAl, btnListaDoc, btnListaProp;

    ToggleButton tgbExport, tgbLista;
    TextField tfFile;

    int operacao = 0;

    public Phase5UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    public void createView() {
        btnVoltar = new Button("Voltar");
        btnVoltar.setMinWidth(100);
        btnVoltar.setBackground(unselectedBackground);
        btnVoltar.setDisable(true);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinWidth(100);
        btnAvancar.setBackground(unselectedBackground);
        btnAvancar.setDisable(true);

        btnSair = new Button("Sair");
        btnSair.setMinWidth(100);
        btnSair.setBackground(unselectedBackground);

        HBox foot = new HBox();
        foot.getChildren().addAll(btnAvancar, btnVoltar, btnSair);
        foot.setPadding(new Insets(10));
        foot.setAlignment(Pos.CENTER);
        foot.setSpacing(90);
        this.setBottom(foot);

        tgbLista = new ToggleButton("Lista");
        tgbLista.setMinWidth(100);
        tgbLista.setBackground(unselectedBackground);

        tgbExport = new ToggleButton("Exportar");
        tgbExport.setMinWidth(100);
        tgbExport.setBackground(unselectedBackground);

        btnListaAl = new Button("Aluno");
        btnListaAl.setMinWidth(100);
        //btnListaAl.
        btnListaDoc = new Button("Docente");
        btnListaProp = new Button("Proposta");

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(tgbLista, tgbExport);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(50);
        this.setTop(hboxCima);

        tfFile = new TextField();
        tfFile.setPromptText("Nome do ficheiro");
        tfFile.setMaxWidth(200);

        tilePaneLista = new TilePane();

    }

    public void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> { update(); });

        btnSair.setOnAction(actionEvent -> {
            Platform.exit();
        });

        tgbLista.setOnAction(actionEvent -> {
            operacao = 1;
            update();
        });

        tgbExport.setOnAction(actionEvent -> {
            if(tgbExport.isSelected()){
                tgbExport.setBackground(selectedBackground);
                this.setCenter(tfFile);
            } else {
                tgbExport.setBackground(unselectedBackground);
                this.setCenter(null);
            }
        });

        tfFile.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER && tfFile.getText() != null && tfFile.isFocused()){
                phaseManager.export(tfFile.getText());
                tfFile.clear();
                tgbExport.fire();
                update();
            }
        });
    }

    public void update() {
        if(phaseManager.getPhaseState() != PhaseState.PHASE_5){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
