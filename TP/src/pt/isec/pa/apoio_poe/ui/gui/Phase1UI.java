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
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

import java.util.ArrayList;
import java.util.Arrays;

public class Phase1UI extends BorderPane {
    PhaseManager phaseManager;
    int tipo = 0;
    int actualOp = 0;

    TilePane tilePaneOp, tilePaneAl;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
    Button btnProx, btnClose;
    Button btnAlunos, btnPropostas, btnDocentes;
    ArrayList<Button> operacoes = new ArrayList<>();
    Button btnInsere, btnConsulta, btnEdita, btnElimina;

    Button btnAvancar;

    ArrayList<TextField> alunoGUI = new ArrayList<>();

    TextField tfNome, tfSiglaC, tfSiglaR, tfGrade, tfN_aluno, tfEmail, tfCa, tfTitulo, tfRd, tfAd, tfEntityId;

    ToggleButton tgbAccess;

    Label displayTipo;

    public Phase1UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    private void createView(){
        btnAvancar = new Button("Avançar");
        btnAvancar.setMinWidth(100);
        btnAvancar.setBackground(unselectedBackground);
        btnAvancar.setVisible(false);

        btnProx = new Button("Proxima Fase");
        btnProx.setMinWidth(100);
        btnProx.setBackground(unselectedBackground);

        btnClose = new Button("Fecha Fase");
        btnClose.setMinWidth(100);
        btnClose.setBackground(unselectedBackground);

        btnAlunos = new Button("Alunos");
        btnAlunos.setMinWidth(75);
        btnAlunos.setBackground(unselectedBackground);

        btnDocentes = new Button("Docentes");
        btnDocentes.setMinWidth(75);
        btnDocentes.setBackground(unselectedBackground);

        btnPropostas = new Button("Propostas");
        btnPropostas.setMinWidth(75);
        btnPropostas.setBackground(unselectedBackground);

        btnInsere = new Button("Insere");

        btnConsulta = new Button("Consulta");

        btnEdita = new Button("Edita");

        btnElimina = new Button("Elimina");

        tfNome = new TextField();
        tfNome.setPromptText("Nome");

        tfSiglaC = new TextField();
        tfSiglaC.setPromptText("Sigla de Curso");

        tfSiglaR = new TextField();
        tfSiglaR.setPromptText("Sigla de Ramo");

        tfGrade = new TextField();
        tfGrade.setPromptText("Nota de aluno");

        tfN_aluno = new TextField();
        tfN_aluno.setPromptText("Número de aluno");

        tfEmail = new TextField();
        tfEmail.setPromptText("Email");

        tfCa = new TextField();
        tfCa.setPromptText("Código smth");

        tfTitulo = new TextField();
        tfTitulo.setPromptText("Titulo");

        tfRd = new TextField();
        tfRd.setPromptText("Ramo smth");

        tfAd = new TextField();
        tfAd.setPromptText("Ad");

        tfEntityId = new TextField();
        tfEntityId.setPromptText("Id de identidade");

        tgbAccess = new ToggleButton("Acesso de aluno a estágio");
        tgbAccess.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));

        operacoes.add(btnInsere);
        operacoes.add(btnConsulta);
        operacoes.add(btnEdita);
        operacoes.add(btnElimina);

        alunoGUI.add(tfNome);
        alunoGUI.add(tfEmail);
        alunoGUI.add(tfN_aluno);
        alunoGUI.add(tfSiglaC);
        alunoGUI.add(tfSiglaR);
        alunoGUI.add(tfGrade);

        for(var i : operacoes){
            i.setMinWidth(200);
            i.setMinHeight(100);
        }

        tilePaneOp = new TilePane();
        tilePaneOp.getChildren().addAll(operacoes.get(0), operacoes.get(1), operacoes.get(2), operacoes.get(3));
        tilePaneOp.setPrefRows(2);
        tilePaneOp.setPrefColumns(2);
        tilePaneOp.setHgap(20);
        tilePaneOp.setVgap(20);
        tilePaneOp.setPadding(new Insets(10, 50, 10, 50));
        tilePaneOp.setAlignment(Pos.CENTER);

        tilePaneAl = new TilePane();
        tilePaneAl.getChildren().addAll(alunoGUI.get(0), alunoGUI.get(1), alunoGUI.get(2), alunoGUI.get(3), alunoGUI.get(4), alunoGUI.get(5), tgbAccess);
        tilePaneAl.setPrefRows(4);
        tilePaneAl.setPrefColumns(2);
        tilePaneAl.setHgap(20);
        tilePaneAl.setVgap(20);
        tilePaneAl.setPadding(new Insets(10, 50, 10, 50));
        tilePaneAl.setAlignment(Pos.CENTER);


        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(btnAlunos, btnDocentes, btnPropostas);
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(100);
        this.setTop(hBox1);

        /*displayTipo = new Label();
        displayTipo.setPrefWidth(Integer.MAX_VALUE);
        displayTipo.setStyle("-fx-background-color: #d0d0d0; -fx-font-size: 16; -fx-font-family: 'Roboto Light'");
        displayTipo.setBorder(new Border(new BorderStroke(Color.GREEN, BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        displayTipo.setPadding(new Insets(10));*/

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(btnProx, btnAvancar, btnClose);
        hBox2.setPadding(new Insets(10));
        hBox2.setSpacing(190);
        this.setBottom(hBox2);
    }

    private void registerHandlers() {
        tgbAccess.setOnMouseClicked(mouseEvent -> {
            if(tgbAccess.isSelected()){
                tgbAccess.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
            }else{
                tgbAccess.setBackground(new Background(new BackgroundFill(Color.ORANGERED, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });

        btnProx.setOnAction(actionEvent -> {
            phaseManager.nextPhase();
            update();
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

        btnInsere.setOnAction(actionEvent -> {
            actualOp = 1;
            update();
        });

        btnConsulta.setOnAction(actionEvent -> {
            actualOp = 2;
            update();
        });

        btnEdita.setOnAction(actionEvent -> {
            actualOp = 3;
            update();
        });

        btnElimina.setOnAction(actionEvent -> {
            actualOp = 4;
            update();
        });
    }

    void mainButtons(int tipo){
        for(var i : alunoGUI){
            i.setVisible(false);
        }
        btnAvancar.setVisible(false);
        tgbAccess.setVisible(false);
        switch(tipo){
            case 0 ->{
                for(var i : operacoes){
                    i.setVisible(false);
                }
            }
            case 1 -> {
                this.setCenter(tilePaneOp);
                for(var i : operacoes){
                    i.setVisible(true);
                    ArrayList<String> res = new ArrayList<>(Arrays.stream(i.getText().split(" ")).toList());
                    i.setText(res.get(0) + " alunos");
                }
                if(btnDocentes.getBackground() != btnPropostas.getBackground()){
                    btnDocentes.setBackground(unselectedBackground);;
                    btnPropostas.setBackground(unselectedBackground);;
                }
                btnAlunos.setBackground(selectedBackground);
            }
            case 2 ->{
                for(var i : operacoes){
                    i.setVisible(true);
                    ArrayList<String> res = new ArrayList<>(Arrays.stream(i.getText().split(" ")).toList());
                    i.setText(res.get(0) + " docentes");
                }
                if(btnAlunos.getBackground() != btnPropostas.getBackground()){
                    btnAlunos.setBackground(unselectedBackground);;
                    btnPropostas.setBackground(unselectedBackground);;
                }
                btnDocentes.setBackground(selectedBackground);
            }
            case 3 ->{
                for(var i : operacoes){
                    i.setVisible(true);
                    ArrayList<String> res = new ArrayList<>(Arrays.stream(i.getText().split(" ")).toList());
                    i.setText(res.get(0) + " propostas");
                }
                if(btnDocentes.getBackground() != btnAlunos.getBackground()){
                    btnDocentes.setBackground(unselectedBackground);;
                    btnAlunos.setBackground(unselectedBackground);;
                }
                btnPropostas.setBackground(selectedBackground);
            }
        }
    }
    
    void operationButtons(int actualOp){
        switch(actualOp){
            case 0 -> {

            }

            case 1 -> {
                for(var i : operacoes){
                    i.setVisible(false);
                }
                btnAvancar.setVisible(true);
                if(tipo == 1){
                    this.setCenter(tilePaneAl);
                    for(var i : alunoGUI){
                        i.setVisible(true);
                    }
                    tgbAccess.setVisible(true);
                }
            }

            case 2 -> {
                for(var i : operacoes){
                    i.setVisible(false);
                }
            }

            case 3 -> {
                for(var i : operacoes){
                    i.setVisible(false);
                }
            }

            case 4 -> {
                for(var i : operacoes){
                    i.setVisible(false);
                }
            }
        }
    }

    private void update(){
        if(phaseManager.getPhaseState() != PhaseState.PHASE_1){
            this.setVisible(false);
            return;
        }
        this.setVisible(true);

        mainButtons(tipo);

        operationButtons(actualOp);

        //displayTipo.setText("Current tipo: " + tipo);
    }
}
