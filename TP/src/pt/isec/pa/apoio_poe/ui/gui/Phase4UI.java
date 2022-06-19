package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase4UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    HBox hboxDocente;
    BorderPane borderPaneLista, borderPaneDocente;

    Button btnProx, btnClose, btnAnterior;
    Button btnAvancar, btnVoltar;
    Button btnAtribuicaoAutomatica;
    ToggleButton tgbExport, tgbLista, tgbDocente;
    TextField tfFile, tfEmail, tfNAluno, tfTipo, tfDado;
    ToggleButton tgbListaAl, tgbListaDoc;
    ToggleButton tgbPropAtribuidasOrientador, tgbPropAtribuidasSOrientador;
    ToggleButton tgbAssocia, tgbElimina, tgbEdita, tgbConsulta;

    Label displayLista, displayDados;

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

        tgbDocente = new ToggleButton("Docente");
        tgbDocente.setMinWidth(75);
        tgbDocente.setBackground(unselectedBackground);

        tgbLista = new ToggleButton("Lista");
        tgbLista.setMinWidth(75);
        tgbLista.setBackground(unselectedBackground);

        tgbExport = new ToggleButton("Exportar");
        tgbExport.setMinWidth(50);
        tgbExport.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(btnAtribuicaoAutomatica, tgbDocente, tgbLista, tgbExport);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(90);
        this.setTop(hboxCima);

        tfFile = new TextField();
        tfFile.setPromptText("Nome do ficheiro:");
        tfFile.setMaxWidth(300);

        tfEmail = new TextField();
        tfEmail.setPromptText("Email do Docente:");
        tfEmail.setMaxWidth(200);

        tfNAluno = new TextField();
        tfNAluno.setPromptText("Numero de Aluno:");
        tfNAluno.setMaxWidth(200);

        tfTipo = new TextField();
        tfTipo.setPromptText("Tipo de dado a alterar:");
        tfTipo.setMaxWidth(200);

        tfDado = new TextField();
        tfDado.setPromptText("Novo dado:");
        tfDado.setMaxWidth(200);

        displayDados = new Label();

        hboxDocente = new HBox();
        hboxDocente.setAlignment(Pos.CENTER);
        hboxDocente.setSpacing(50);
        hboxDocente.setPadding(new Insets(10));

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

        tgbAssocia = new ToggleButton("Associa");
        tgbAssocia.setBackground(unselectedBackground);
        tgbConsulta = new ToggleButton("Consulta");
        tgbConsulta.setBackground(unselectedBackground);
        tgbEdita = new ToggleButton("Edita");
        tgbEdita.setBackground(unselectedBackground);
        tgbElimina = new ToggleButton("Elimina");
        tgbElimina.setBackground(unselectedBackground);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(tgbAssocia, tgbConsulta, tgbEdita, tgbElimina);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(50);
        vBox2.setPadding(new Insets(10));

        borderPaneDocente = new BorderPane();
        borderPaneDocente.setLeft(vBox2);
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
        btnAtribuicaoAutomatica.setOnAction(actionEvent -> {
            btnAtribuicaoAutomatica.setBackground(selectedBackground);
            phaseManager.assignment(0);
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
            if(tgbDocente.isSelected()){
                tgbDocente.setSelected(false);
                tgbDocente.setBackground(unselectedBackground);
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
        tgbDocente.setOnAction(actionEvent -> {
            if(tgbExport.isSelected()){
                tgbExport.setSelected(false);
                tgbExport.setBackground(unselectedBackground);
            }
            if(tgbLista.isSelected()){
                tgbLista.setSelected(false);
                tgbLista.setBackground(unselectedBackground);
            }
            if(tgbDocente.isSelected()){
                tgbDocente.setBackground(selectedBackground);
                btnAvancar.setDisable(false);
                this.setCenter(borderPaneDocente);
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

        tgbAssocia.setOnAction(actionEvent -> {
            if(tgbAssocia.isSelected()){
                tgbAssocia.setBackground(selectedBackground);
                hboxDocente.getChildren().clear();
                hboxDocente.getChildren().addAll(tfEmail, tfNAluno);
                borderPaneDocente.setCenter(hboxDocente);
            } else {
                tgbAssocia.setBackground(unselectedBackground);
            }
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbEdita.setSelected(false);
            tgbEdita.setBackground(unselectedBackground);
            tgbElimina.setSelected(false);
            tgbElimina.setBackground(unselectedBackground);
        });
        tgbConsulta.setOnAction(actionEvent -> {
            if(tgbConsulta.isSelected()){
                tgbConsulta.setBackground(selectedBackground);
                hboxDocente.getChildren().clear();
                hboxDocente.getChildren().addAll(tfEmail, displayDados);
            } else {
                tgbConsulta.setBackground(unselectedBackground);
            }
            tgbAssocia.setSelected(false);
            tgbAssocia.setBackground(unselectedBackground);
            tgbEdita.setSelected(false);
            tgbEdita.setBackground(unselectedBackground);
            tgbElimina.setSelected(false);
            tgbElimina.setBackground(unselectedBackground);
        });
        tgbElimina.setOnAction(actionEvent -> {
            if(tgbElimina.isSelected()){
                tgbElimina.setBackground(selectedBackground);
                hboxDocente.getChildren().clear();
                hboxDocente.getChildren().addAll(tfEmail);
            } else {
                tgbElimina.setBackground(unselectedBackground);
            }
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbEdita.setSelected(false);
            tgbEdita.setBackground(unselectedBackground);
            tgbAssocia.setSelected(false);
            tgbAssocia.setBackground(unselectedBackground);
        });
        tgbEdita.setOnAction(actionEvent -> {
            if(tgbEdita.isSelected()){
                tgbEdita.setBackground(selectedBackground);
                hboxDocente.getChildren().clear();
                hboxDocente.getChildren().addAll(tfEmail, tfTipo, tfDado);
            } else {
                tgbEdita.setBackground(unselectedBackground);
            }
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbAssocia.setSelected(false);
            tgbAssocia.setBackground(unselectedBackground);
            tgbElimina.setSelected(false);
            tgbElimina.setBackground(unselectedBackground);
        });

        tfEmail.setOnKeyPressed(keyEvent -> {
            if(tgbAssocia.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null && tfNAluno.getText() != null) {
                    //phaseManager.getAluno(Long.parseLong(tfNAluno.getText())).getPropAtribuida().
                    tfEmail.clear();
                    tfNAluno.clear();
                }
            }
            if(tgbConsulta.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null){
                    displayDados.setText(phaseManager.getDocente(tfEmail.getText()).toString());
                    tfEmail.clear();
                }
            }
            if(tgbEdita.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null && tfTipo != null && tfDado != null){
                    phaseManager.editDocente(tfEmail.getText(), tfTipo.getText(), tfDado.getText());
                    tfTipo.clear();
                    tfDado.clear();
                }
            }
            if(tgbElimina.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null){
                    phaseManager.removeDocente(tfEmail.getText());
                    tfEmail.clear();
                }
            }
        });
        tfNAluno.setOnKeyPressed(keyEvent -> {
            if(tgbAssocia.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null && tfNAluno.getText() != null) {
                    //phaseManager.getAluno(Long.parseLong(tfNAluno.getText())).getPropAtribuida().
                    tfEmail.clear();
                    tfNAluno.clear();
                }
            }
        });
        tfTipo.setOnKeyPressed(keyEvent -> {
            if(tgbEdita.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null && tfTipo != null && tfDado != null){
                    phaseManager.editDocente(tfEmail.getText(), tfTipo.getText(), tfDado.getText());
                    tfEmail.clear();
                    tfTipo.clear();
                    tfDado.clear();
                }
            }
        });
        tfDado.setOnKeyPressed(keyEvent -> {
            if(tgbEdita.isSelected()){
                if(keyEvent.getCode() == KeyCode.ENTER && tfEmail.getText() != null && tfTipo != null && tfDado != null){
                    phaseManager.editDocente(tfEmail.getText(), tfTipo.getText(), tfDado.getText());
                    tfEmail.clear();
                    tfTipo.clear();
                    tfDado.clear();
                }
            }
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