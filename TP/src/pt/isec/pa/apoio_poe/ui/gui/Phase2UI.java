package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.data.Candidatura;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Phase2UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    BorderPane borderPaneLista, borderPaneCandidatura;
    VBox vbox1, vbox2;
    HBox hboxInsert, hboxEdit;
    TilePane tilePaneInsere, tilePaneConsulta, tilePaneEdit, tilePaneRemove;

    Button btnProx, btnClose, btnAnterior;
    Button btnAvancar, btnVoltar;

    ToggleButton tgbFile;
    ToggleButton tgbLista, tgbCandidatura;
    ToggleButton tgbListaAl, tgbListaProp;
    ToggleButton tgbAlAutoproposta, tgbAlCandidaturaR, tgbAlCandidatura;
    ToggleButton tgbPropAutoproposta, tgbPropDocente, tgbPropCandidaturas, tgbPropSCandidaturas;
    ToggleButton tgbInsere, tgbConsulta, tgbRemove, tgbEdit;

    TextField tfN_aluno, tfPropostasCa, tfConsulta, tfEditType, tfEditData, tfEditId, tfRemove;
    TextField tfFile;

    Label displayLista, displayCA;

    public Phase2UI(PhaseManager phaseManager){
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    public void createView() {
        displayCA = new Label();


        tfFile = new TextField();
        tfFile.setPromptText("Nome de ficheiro");

        tgbFile = new ToggleButton("Usar file");
        tgbFile.setMinWidth(60);
        tgbFile.setBackground(unselectedBackground);
        tgbFile.setAlignment(Pos.CENTER);

        tfEditData = new TextField();
        tfEditData.setPromptText("Se adicionar indicar códigos");

        tfEditType = new TextField();
        tfEditType.setPromptText("Adiciona ou Remove");

        tfEditId = new TextField();
        tfEditId.setPromptText("Número de aluno");

        tfRemove = new TextField();
        tfRemove.setPromptText("Número de aluno");

        tfConsulta = new TextField();
        tfConsulta.setPromptText("Número de aluno associado a candidatura");
        tfConsulta.setMinWidth(100);

        tfN_aluno = new TextField();
        tfN_aluno.setPromptText("Número de aluno a atribuir");
        tfN_aluno.setMinWidth(60);

        tfPropostasCa = new TextField();
        tfPropostasCa.setPromptText("Código de propostas");
        tfPropostasCa.setMinWidth(60);

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

        tgbCandidatura = new ToggleButton("Candidatura");
        tgbCandidatura.setMinWidth(75);
        tgbCandidatura.setBackground(unselectedBackground);

        tgbLista = new ToggleButton("Lista");
        tgbLista.setMinWidth(75);
        tgbLista.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(tgbCandidatura, tgbLista);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(90);
        this.setTop(hboxCima);

        HBox foot = new HBox();
        foot.getChildren().addAll(btnProx, btnAvancar, btnVoltar, btnAnterior, btnClose);
        foot.setPadding(new Insets(10));
        foot.setAlignment(Pos.CENTER);
        foot.setSpacing(90);
        this.setBottom(foot);

        tgbListaAl = new ToggleButton("Alunos");
        tgbListaAl.setMinWidth(50);
        tgbListaAl.setBackground(unselectedBackground);
        tgbListaProp = new ToggleButton("Propostas");
        tgbListaProp.setMinWidth(50);
        tgbListaProp.setBackground(unselectedBackground);

        hboxEdit = new HBox();
        hboxEdit.getChildren().addAll(tfEditId, tfEditType, tfEditData);
        hboxEdit.setAlignment(Pos.CENTER);
        hboxEdit.setSpacing(50);
        hboxEdit.setPadding(new Insets(10));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tgbListaAl, tgbListaProp);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(10));

        tgbAlAutoproposta = new ToggleButton("Autoproposto");
        tgbAlAutoproposta.setBackground(unselectedBackground);
        tgbAlCandidaturaR = new ToggleButton("Candidatura Registada");
        tgbAlCandidaturaR.setBackground(unselectedBackground);
        tgbAlCandidatura = new ToggleButton("Sem Candidatura Registada");
        tgbAlCandidatura.setBackground(unselectedBackground);

        tgbPropAutoproposta = new ToggleButton("Autoproposto");
        tgbPropAutoproposta.setBackground(unselectedBackground);
        tgbPropDocente = new ToggleButton("Docente");
        tgbPropDocente.setBackground(unselectedBackground);
        tgbPropCandidaturas = new ToggleButton("Propostas Disponiveis");
        tgbPropCandidaturas.setBackground(unselectedBackground);
        tgbPropSCandidaturas = new ToggleButton("Propostas Atribuidas");
        tgbPropSCandidaturas.setBackground(unselectedBackground);

        vbox1 = new VBox();
        vbox1.getChildren().addAll(tgbAlAutoproposta, tgbAlCandidaturaR, tgbAlCandidatura);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(50);
        vbox1.setPadding(new Insets(10));

        vbox2 = new VBox();
        vbox2.getChildren().addAll(tgbPropAutoproposta, tgbPropDocente, tgbPropCandidaturas, tgbPropSCandidaturas);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(50);
        vbox2.setPadding(new Insets(10));

        displayLista = new Label();

        borderPaneLista = new BorderPane();
        borderPaneLista.setLeft(vBox);
        borderPaneLista.setCenter(displayLista);

        tgbInsere = new ToggleButton("Insere");
        tgbInsere.setBackground(unselectedBackground);
        tgbConsulta = new ToggleButton("Consulta");
        tgbConsulta.setBackground(unselectedBackground);
        tgbRemove = new ToggleButton("Remove");
        tgbRemove.setBackground(unselectedBackground);
        tgbEdit = new ToggleButton("Edit");
        tgbEdit.setBackground(unselectedBackground);

        VBox vboxCA = new VBox();
        vboxCA.getChildren().addAll(tgbInsere, tgbConsulta, tgbRemove, tgbEdit);
        vboxCA.setAlignment(Pos.CENTER);
        vboxCA.setSpacing(50);
        vboxCA.setPadding(new Insets(10));

        borderPaneCandidatura = new BorderPane();
        borderPaneCandidatura.setLeft(vboxCA);

        hboxInsert = new HBox();
        hboxInsert.getChildren().addAll(tfN_aluno, tfPropostasCa);
        hboxInsert.setAlignment(Pos.CENTER);
        hboxInsert.setSpacing(50);
        hboxInsert.setPadding(new Insets(10));
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

        tgbCandidatura.setOnAction(actionEvent -> {
            tgbLista.setSelected(false);
            tgbLista.setBackground(unselectedBackground);
            if(tgbCandidatura.isSelected()){
                tgbCandidatura.setBackground(selectedBackground);
                this.setCenter(borderPaneCandidatura);
            } else {
                tgbCandidatura.setBackground(unselectedBackground);
            }
            update();
        });

        tgbLista.setOnAction(actionEvent -> {
            tgbCandidatura.setSelected(false);
            tgbCandidatura.setBackground(unselectedBackground);
            if(tgbLista.isSelected()){
                tgbLista.setBackground(selectedBackground);
                btnAvancar.setDisable(false);
                this.setCenter(borderPaneLista);
            } else {
                tgbLista.setBackground(unselectedBackground);
                btnAvancar.setDisable(true);
                this.setCenter(null);
            }
        });

        tgbListaAl.setOnAction(actionEvent -> {
            if(tgbListaAl.isSelected()){
                tgbListaAl.setBackground(selectedBackground);
                borderPaneLista.setRight(vbox1);
            } else {
                tgbListaAl.setBackground(unselectedBackground);
                borderPaneLista.setRight(null);
            }

            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropSCandidaturas.setSelected(false);
            tgbPropSCandidaturas.setBackground(unselectedBackground);
            tgbPropCandidaturas.setSelected(false);
            tgbPropCandidaturas.setBackground(unselectedBackground);

            tgbListaProp.setSelected(false);
            tgbListaProp.setBackground(unselectedBackground);
            update();
        });
        tgbListaProp.setOnAction(actionEvent -> {
            if(tgbListaProp.isSelected()){
                tgbListaProp.setBackground(selectedBackground);
                borderPaneLista.setRight(vbox2);
            } else {
                tgbListaProp.setBackground(unselectedBackground);
                borderPaneLista.setRight(null);
            }

            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlCandidaturaR.setSelected(false);
            tgbAlCandidaturaR.setBackground(unselectedBackground);

            tgbListaAl.setSelected(false);
            tgbListaAl.setBackground(unselectedBackground);
            update();
        });

        tgbAlAutoproposta.setOnAction(actionEvent -> {
            if(tgbAlAutoproposta.isSelected()) {
                tgbAlAutoproposta.setBackground(selectedBackground);
            } else {
                tgbAlAutoproposta.setBackground(unselectedBackground);
            }
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlCandidaturaR.setSelected(false);
            tgbAlCandidaturaR.setBackground(unselectedBackground);
            update();
        });
        tgbAlCandidaturaR.setOnAction(actionEvent -> {
            if(tgbAlCandidaturaR.isSelected()) {
                tgbAlCandidaturaR.setBackground(selectedBackground);
            } else {
                tgbAlCandidaturaR.setBackground(unselectedBackground);
            }
            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            update();
        });
        tgbAlCandidatura.setOnAction(actionEvent -> {
            if(tgbAlCandidatura.isSelected()) {
                tgbAlCandidatura.setBackground(selectedBackground);
            } else {
                tgbAlCandidatura.setBackground(unselectedBackground);
            }
            tgbAlCandidaturaR.setSelected(false);
            tgbAlCandidaturaR.setBackground(unselectedBackground);
            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            update();
        });

        tgbPropAutoproposta.setOnAction(actionEvent -> {
            if(tgbPropAutoproposta.isSelected()) {
                tgbPropAutoproposta.setBackground(selectedBackground);
            } else {
                tgbPropAutoproposta.setBackground(unselectedBackground);
            }
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropSCandidaturas.setSelected(false);
            tgbPropSCandidaturas.setBackground(unselectedBackground);
            tgbPropCandidaturas.setSelected(false);
            tgbPropCandidaturas.setBackground(unselectedBackground);
        });
        tgbPropDocente.setOnAction(actionEvent -> {
            if(tgbPropDocente.isSelected()) {
                tgbPropDocente.setBackground(selectedBackground);
            } else {
                tgbPropDocente.setBackground(unselectedBackground);
            }
            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropSCandidaturas.setSelected(false);
            tgbPropSCandidaturas.setBackground(unselectedBackground);
            tgbPropCandidaturas.setSelected(false);
            tgbPropCandidaturas.setBackground(unselectedBackground);
        });
        tgbPropCandidaturas.setOnAction(actionEvent -> {
            if(tgbPropCandidaturas.isSelected()) {
                tgbPropCandidaturas.setBackground(selectedBackground);
            } else {
                tgbPropCandidaturas.setBackground(unselectedBackground);
            }
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropSCandidaturas.setSelected(false);
            tgbPropSCandidaturas.setBackground(unselectedBackground);
        });
        tgbPropSCandidaturas.setOnAction(actionEvent -> {
            if(tgbPropSCandidaturas.isSelected()) {
                tgbPropSCandidaturas.setBackground(selectedBackground);
            } else {
                tgbPropSCandidaturas.setBackground(unselectedBackground);
            }
            tgbPropCandidaturas.setSelected(false);
            tgbPropCandidaturas.setBackground(unselectedBackground);
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
        });

        tgbFile.setOnAction(actionEvent ->{
            if(tgbFile.isSelected()){
                tgbFile.setBackground(selectedBackground);
                borderPaneCandidatura.setCenter(tfFile);
            }else{
                tgbFile.setBackground(unselectedBackground);
                borderPaneCandidatura.setCenter(hboxInsert);
            }
        });

        tgbInsere.setOnAction(actionEvent -> {
            if(tgbInsere.isSelected()){
                tgbInsere.setBackground(selectedBackground);
                borderPaneCandidatura.setCenter(hboxInsert);
                borderPaneCandidatura.setRight(tgbFile);
            } else {
                tgbInsere.setBackground(unselectedBackground);
                borderPaneCandidatura.setCenter(null);
                borderPaneCandidatura.setRight(null);
            }
            btnAvancar.setDisable(false);
            btnVoltar.setDisable(false);
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbRemove.setSelected(false);
            tgbRemove.setBackground(unselectedBackground);
            tgbEdit.setSelected(false);
            tgbEdit.setBackground(unselectedBackground);
        });

        tgbConsulta.setOnAction(actionEvent -> {
            borderPaneCandidatura.setRight(null);
            if(tgbConsulta.isSelected()){
                tgbConsulta.setBackground(selectedBackground);
                borderPaneCandidatura.setCenter(tfConsulta);
            } else {
                tgbConsulta.setBackground(unselectedBackground);
                borderPaneCandidatura.setCenter(null);
            }
            tgbInsere.setSelected(false);
            tgbInsere.setBackground(unselectedBackground);
            tgbRemove.setSelected(false);
            tgbRemove.setBackground(unselectedBackground);
            tgbEdit.setSelected(false);
            tgbEdit.setBackground(unselectedBackground);
        });
        tgbRemove.setOnAction(actionEvent -> {
            borderPaneCandidatura.setRight(null);
            if(tgbRemove.isSelected()){
                tgbRemove.setBackground(selectedBackground);
                borderPaneCandidatura.setCenter(tfRemove);
            } else {
                tgbRemove.setBackground(unselectedBackground);
                borderPaneCandidatura.setCenter(null);
            }
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbInsere.setSelected(false);
            tgbInsere.setBackground(unselectedBackground);
            tgbEdit.setSelected(false);
            tgbEdit.setBackground(unselectedBackground);
        });
        tgbEdit.setOnAction(actionEvent -> {
            borderPaneCandidatura.setRight(null);
            if(tgbEdit.isSelected()){
                tgbEdit.setBackground(selectedBackground);
                borderPaneCandidatura.setCenter(hboxEdit);
            } else {
                tgbEdit.setBackground(unselectedBackground);
                borderPaneCandidatura.setCenter(null);
            }
            tgbConsulta.setSelected(false);
            tgbConsulta.setBackground(unselectedBackground);
            tgbRemove.setSelected(false);
            tgbRemove.setBackground(unselectedBackground);
            tgbInsere.setSelected(false);
            tgbInsere.setBackground(unselectedBackground);
        });

        btnAvancar.setOnAction(actionEvent -> {
            if(tgbCandidatura.isSelected()){
                if(tgbInsere.isSelected()){
                    if(tgbFile.isSelected()){
                        phaseManager.insertCandidaturaFile(tfFile.getText());
                        tgbFile.setSelected(false);
                        tgbInsere.setSelected(false);
                        borderPaneCandidatura.setCenter(null);
                        borderPaneCandidatura.setRight(null);
                    }else{
                        ArrayList<String> propostasCa = new ArrayList<>(Arrays.asList(tfPropostasCa.getText().split("\\s+")));
                        Candidatura aux = new Candidatura(Long.parseLong(tfN_aluno.getText()));
                        aux.adicionaId(propostasCa);
                        phaseManager.insertCandidatura(aux);
                        tgbInsere.setSelected(false);
                        borderPaneCandidatura.setCenter(null);
                    }
                }
                if(tgbConsulta.isSelected()){
                    if(this.getCenter() != displayCA){
                        displayCA.setText(phaseManager.consultCandidatura(Long.parseLong(tfConsulta.getText())));
                        borderPaneCandidatura.setCenter(displayCA);
                        return;
                    }
                    tgbConsulta.setSelected(false);
                    borderPaneCandidatura.setCenter(null);
                }
                if(tgbEdit.isSelected()){
                    String tipo = null;
                    if(tfEditType.getText() == "Adiciona"){
                        tipo = "idPropostaAdiciona";
                    }
                    if(tfEditType.getText() == "Remove"){
                        tipo = "idPropostaRemove";
                    }
                    ArrayList<String> newData = new ArrayList<>(Arrays.asList(tfEditData.getText().split("\\s+")));
                    phaseManager.editCandidatura(Long.parseLong(tfEditId.getText()), tipo, newData);
                    tgbEdit.setSelected(false);
                    borderPaneCandidatura.setCenter(null);
                }
                if(tgbRemove.isSelected()){
                    phaseManager.removeCandidatura(Long.parseLong(tfRemove.getText()));
                    tgbEdit.setSelected(false);
                    borderPaneCandidatura.setCenter(null);
                }
            }
            if(tgbLista.isSelected()){
                if(tgbListaAl.isSelected()) {
                    if(tgbAlAutoproposta.isSelected()) {
                        displayLista.setText(phaseManager.listaAluno("autoproposta"));
                    }
                    if(tgbAlCandidatura.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("candidatura"));
                    }
                    if(tgbAlCandidaturaR.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("no_candidatura"));
                    }
                }
                if(tgbListaProp.isSelected()) {
                    if(tgbPropAutoproposta.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("autoproposta"));
                    }
                    if(tgbPropDocente.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("docente"));

                    }
                    if(tgbPropCandidaturas.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("candidatura"));

                    }
                    if(tgbPropSCandidaturas.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("no_candidatura"));
                    }
                }
            }
            update();
        });
    }

    public void update(){
        if(phaseManager.getPhaseState() != PhaseState.PHASE_2){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);
    }
}
