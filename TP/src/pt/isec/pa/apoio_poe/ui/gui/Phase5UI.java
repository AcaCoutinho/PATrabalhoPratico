package pt.isec.pa.apoio_poe.ui.gui;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;


public class Phase5UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    BorderPane borderPaneLista;

    Button btnSair;
    Button btnAvancar, btnVoltar;
    ToggleButton tgbListaAl, tgbListaDoc, tgbListaProp;

    ToggleButton tgbExport, tgbLista;
    ToggleButton tgbAlAtribuida, tgbAlCandidatura, tgbPropDisponiveis, tgbPropAtribuidas;
    TextField tfFile;
    Label displayLista;

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

        tgbListaAl = new ToggleButton("Aluno");
        tgbListaAl.setMinWidth(50);
        tgbListaAl.setBackground(unselectedBackground);
        tgbListaDoc = new ToggleButton("Docente");
        tgbListaDoc.setMinWidth(50);
        tgbListaDoc.setBackground(unselectedBackground);
        tgbListaProp = new ToggleButton("Proposta");
        tgbListaProp.setMinWidth(50);
        tgbListaProp.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(tgbLista, tgbExport);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(50);
        this.setTop(hboxCima);

        tgbAlAtribuida = new ToggleButton("Alunos com Projeto");
        tgbAlAtribuida.setBackground(unselectedBackground);
        tgbAlCandidatura = new ToggleButton("Alunos com Candidatura");
        tgbAlCandidatura.setBackground(unselectedBackground);
        tgbPropAtribuidas = new ToggleButton("Propostas Atribuidas");
        tgbPropAtribuidas.setBackground(unselectedBackground);
        tgbPropDisponiveis = new ToggleButton("Propostas Disponiveis");
        tgbPropDisponiveis.setBackground(unselectedBackground);

        displayLista = new Label();
        displayLista.setText("klandw");

        tfFile = new TextField();
        tfFile.setPromptText("Nome do ficheiro");
        tfFile.setMaxWidth(200);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tgbListaAl, tgbListaDoc, tgbListaProp);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(10));

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(tgbAlAtribuida, tgbAlCandidatura, tgbPropAtribuidas, tgbPropDisponiveis);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(50);
        vBox.setPadding(new Insets(10));

        borderPaneLista = new BorderPane();
        borderPaneLista.setLeft(vBox);
        borderPaneLista.setRight(vBox1);
        borderPaneLista.setCenter(displayLista);
    }

    public void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> {
            update();
        });

        btnSair.setOnAction(actionEvent -> {
            Platform.exit();
        });

        tgbListaAl.setOnAction(actionEvent -> {
            if(tgbListaAl.isSelected()){
                tgbListaAl.setBackground(selectedBackground);
            } else {
                tgbListaAl.setBackground(unselectedBackground);
            }
            tgbListaDoc.setSelected(false);
            tgbListaDoc.setBackground(unselectedBackground);
            tgbListaProp.setSelected(false);
            tgbListaProp.setBackground(unselectedBackground);

            update();
        });

        tgbListaDoc.setOnAction(actionEvent -> {
            if(tgbListaDoc.isSelected()){
                tgbListaDoc.setBackground(selectedBackground);
            } else {
                tgbListaDoc.setBackground(unselectedBackground);
            }
            tgbListaAl.setSelected(false);
            tgbListaAl.setBackground(unselectedBackground);
            tgbListaProp.setSelected(false);
            tgbListaProp.setBackground(unselectedBackground);

            update();
        });

        tgbListaProp.setOnAction(actionEvent -> {
            if(tgbListaProp.isSelected()){
                tgbListaProp.setBackground(selectedBackground);
            } else {
                tgbListaProp.setBackground(unselectedBackground);
            }

            tgbListaDoc.setSelected(false);
            tgbListaDoc.setBackground(unselectedBackground);
            tgbListaAl.setSelected(false);
            tgbListaAl.setBackground(unselectedBackground);

            update();
        });

        tgbLista.setOnAction(actionEvent -> {
            if(tgbExport.isSelected()){
                tgbExport.setSelected(false);
                tgbExport.setBackground(unselectedBackground);
            }

            if(tgbLista.isSelected()){
                tgbLista.setBackground(selectedBackground);
                btnAvancar.setDisable(false);
                this.setCenter(borderPaneLista);
            } else {
                tgbLista.setBackground(unselectedBackground);
                this.setCenter(null);
            }
        });

        tgbAlAtribuida.setOnAction(actionEvent -> {
            if(tgbAlAtribuida.isSelected()){
                tgbAlAtribuida.setBackground(selectedBackground);
            } else {
                tgbAlAtribuida.setBackground(unselectedBackground);

            }
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);

        });
        tgbAlCandidatura.setOnAction(actionEvent -> {
            if(tgbAlCandidatura.isSelected()){
                tgbAlCandidatura.setBackground(selectedBackground);
            } else {
                tgbAlCandidatura.setBackground(unselectedBackground);
            }
            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);
        });
        tgbPropAtribuidas.setOnAction(actionEvent -> {
            if(tgbPropAtribuidas.isSelected()){
                tgbPropAtribuidas.setBackground(selectedBackground);
            } else {
                tgbPropAtribuidas.setBackground(unselectedBackground);
            }
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
        });
        tgbPropDisponiveis.setOnAction(actionEvent -> {
            if(tgbPropDisponiveis.isSelected()){
                tgbPropDisponiveis.setBackground(selectedBackground);
            } else {
                tgbPropDisponiveis.setBackground(unselectedBackground);
            }
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);
        });

        tgbExport.setOnAction(actionEvent -> {
            if(tgbLista.isSelected()) {
                tgbLista.setSelected(false);
                tgbLista.setBackground(unselectedBackground);
            }
            if(tgbExport.isSelected()){
                tgbExport.setBackground(selectedBackground);
                this.setCenter(tfFile);
            } else {
                tgbExport.setBackground(unselectedBackground);
                this.setCenter(null);
            }
            update();
        });

        tfFile.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER && tfFile.getText() != null && tfFile.isFocused()){
                phaseManager.export(tfFile.getText());
                tfFile.clear();
                tgbExport.fire();
                update();
            }
        });

        btnAvancar.setOnAction(actionEvent -> {
            if(tgbListaAl.isSelected()){
                if(tgbAlCandidatura.isSelected())
                    displayLista.setText(phaseManager.listaAluno("candidatura"));
                if(tgbAlAtribuida.isSelected())
                    displayLista.setText(phaseManager.listaAluno("atribuida"));
            }
            if(tgbListaDoc.isSelected()){
                displayLista.setText(phaseManager.listaDocente(null));
            }
            if(tgbListaProp.isSelected()){
                if(tgbPropDisponiveis.isSelected())
                    displayLista.setText(phaseManager.listaProposta("disponiveis"));
                if(tgbPropAtribuidas.isSelected())
                    displayLista.setText(phaseManager.listaProposta("atribuidas"));
            }
            update();
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
