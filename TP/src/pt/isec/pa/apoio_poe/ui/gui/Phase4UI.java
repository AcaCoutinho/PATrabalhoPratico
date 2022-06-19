package pt.isec.pa.apoio_poe.ui.gui;

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

public class Phase4UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    BorderPane borderPaneLista;

    Button btnProx, btnClose, btnAnterior;
    Button btnAvancar, btnVoltar;
    Button btnAtribuicaoAutomatica;
    ToggleButton tgbExport, tgbLista;
    TextField tfFile;
    ToggleButton tgbListaAl, tgbListaDoc;
    ToggleButton tgbPropAtribuidasOrientador, tgbPropAtribuidasSOrientador;

    Label displayLista;

    public Phase4UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    public void createView() {
        btnVoltar = new Button("Voltar");
        btnVoltar.setMinWidth(60);
        btnVoltar.setBackground(unselectedBackground);
        btnVoltar.setDisable(true);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinWidth(60);
        btnAvancar.setBackground(unselectedBackground);
        btnAvancar.setDisable(true);

        btnProx = new Button("Proxima Fase");
        btnProx.setMinWidth(60);
        btnProx.setBackground(unselectedBackground);

        btnClose = new Button("Fecha Fase");
        btnClose.setMinWidth(60);
        btnClose.setBackground(unselectedBackground);

        btnAnterior = new Button("Fase Anterior");
        btnAnterior.setMinWidth(60);
        btnAnterior.setBackground(unselectedBackground);

        HBox foot = new HBox();
        foot.getChildren().addAll(btnProx, btnAvancar, btnVoltar, btnAnterior, btnClose);
        foot.setPadding(new Insets(10));
        foot.setAlignment(Pos.CENTER);
        foot.setSpacing(90);
        this.setBottom(foot);

        btnAtribuicaoAutomatica = new Button("Atribuicao Automatica");
        btnAtribuicaoAutomatica.setMinWidth(75);
        btnAtribuicaoAutomatica.setBackground(unselectedBackground);

        tgbLista = new ToggleButton("Lista");
        tgbLista.setMinWidth(75);
        tgbLista.setBackground(unselectedBackground);

        tgbExport = new ToggleButton("Exportar");
        tgbExport.setMinWidth(50);
        tgbExport.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(btnAtribuicaoAutomatica, tgbLista, tgbExport);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(90);
        this.setTop(hboxCima);

        tfFile = new TextField();
        tfFile.setPromptText("Nome do ficheiro:");
        tfFile.setMaxWidth(300);

        tgbListaAl = new ToggleButton("Aluno");
        tgbListaAl.setMinWidth(50);
        tgbListaAl.setBackground(unselectedBackground);
        tgbListaDoc = new ToggleButton("Docente");
        tgbListaDoc.setMinWidth(50);
        tgbListaDoc.setBackground(unselectedBackground);

        tgbPropAtribuidasOrientador = new ToggleButton("Atribuido com Orientador");
        tgbPropAtribuidasOrientador.setMinWidth(80);
        tgbPropAtribuidasOrientador.setBackground(unselectedBackground);
        tgbPropAtribuidasSOrientador = new ToggleButton("Atribuido sem Orientador");
        tgbPropAtribuidasSOrientador.setMinWidth(80);
        tgbPropAtribuidasSOrientador.setBackground(unselectedBackground);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tgbListaAl, tgbListaDoc);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(10));

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(tgbPropAtribuidasOrientador, tgbPropAtribuidasSOrientador);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(50);
        vBox.setPadding(new Insets(10));

        borderPaneLista = new BorderPane();
        borderPaneLista.setLeft(vBox);
        borderPaneLista.setRight(vBox1);
        borderPaneLista.setCenter(displayLista);
    }

    public void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> { update(); });

        btnProx.setOnAction(actionEvent -> {
            phaseManager.nextPhase();
            update();
        });
        btnClose.setOnAction(actionEvent -> {
            phaseManager.closePhase();
            update();
        });
        btnAnterior.setOnAction(actionEvent -> {
            if(!phaseManager.previousPhase()){
                btnAnterior.setDisable(true);
            }
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
                update();
            }
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

        tgbListaAl.setOnAction(actionEvent -> {
            if(tgbListaAl.isSelected()){
                tgbListaAl.setBackground(selectedBackground);
            } else {
                tgbListaAl.setBackground(unselectedBackground);
            }
            tgbListaDoc.setSelected(false);
            tgbListaDoc.setBackground(unselectedBackground);
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
            update();
        });

        tgbPropAtribuidasOrientador.setOnAction(actionEvent -> {
            if(tgbPropAtribuidasOrientador.isSelected()){
                tgbPropAtribuidasOrientador.setBackground(selectedBackground);
            } else {
                tgbPropAtribuidasOrientador.setBackground(unselectedBackground);
            }
            tgbPropAtribuidasSOrientador.setSelected(false);
            tgbPropAtribuidasSOrientador.setBackground(unselectedBackground);
        });
        tgbPropAtribuidasSOrientador.setOnAction(actionEvent -> {
            if(tgbPropAtribuidasSOrientador.isSelected()){
                tgbPropAtribuidasSOrientador.setBackground(selectedBackground);
            } else {
                tgbPropAtribuidasSOrientador.setBackground(unselectedBackground);
            }
            tgbPropAtribuidasOrientador.setSelected(false);
            tgbPropAtribuidasOrientador.setBackground(unselectedBackground);
        });

        btnAvancar.setOnAction(actionEvent -> {
            if(tgbLista.isSelected()){
                if(tgbListaAl.isSelected()){
                    if(tgbPropAtribuidasOrientador.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("atribuida"));
                    }
                    if(tgbPropAtribuidasSOrientador.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("no_atribuida"));
                    }
                }
                if(tgbListaDoc.isSelected()){
                    displayLista.setText(phaseManager.listaDocente(""));
                }
            }
            update();
        });
    }

    public void update() {
        if(phaseManager.getPhaseState() != PhaseState.PHASE_4){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
