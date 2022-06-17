package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.data.Docente;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

import java.util.ArrayList;
import java.util.Arrays;

public class Phase1UI extends BorderPane {
    PhaseManager phaseManager;
    int tipo = 0;
    int actualOp = 0;

    TilePane tilePaneOp, tilePaneAl, tilePaneDoc, tilePaneProp;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
    Button btnProx, btnClose;
    Button btnAlunos, btnPropostas, btnDocentes;
    ArrayList<Button> operacoes = new ArrayList<>();
    Button btnInsere, btnConsulta, btnEdita, btnElimina;
    Button btnAvancar, btnVoltar;

    VBox useFile;
    ToggleButton tgbFile;
    TextField tfFile;

    ArrayList<TextField> alunoGUI = new ArrayList<>();
    ArrayList<TextField> docenteGUI = new ArrayList<>();

    TextField tfNomeAl, tfNomeDoc, tfSiglaC, tfSiglaR, tfGrade, tfN_aluno, tfEmailAl, tfEmailDoc, tfCa, tfTitulo, tfRd, tfAd, tfEntityId;
    ToggleButton tgbAccess;

    TextField tfConsult;

    Label displayDados;

    public Phase1UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    private void createView(){
        tfFile = new TextField();
        tfFile.setPromptText("Nome de ficheiro");

        tgbFile = new ToggleButton("Usar ficheiro");
        tgbFile.setMinWidth(100);
        tgbFile.setVisible(false);
        tgbFile.setBackground(unselectedBackground);

        displayDados = new Label();
        displayDados.setFont(new Font(20));

        tfConsult = new TextField();
        tfConsult.setMinWidth(200);

        btnVoltar = new Button("Voltar");
        btnVoltar.setMinWidth(100);
        btnVoltar.setBackground(unselectedBackground);
        btnVoltar.setDisable(true);

        btnAvancar = new Button("Avançar");
        btnAvancar.setMinWidth(100);
        btnAvancar.setBackground(unselectedBackground);
        btnAvancar.setDisable(true);

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

        tfNomeAl = new TextField();
        tfNomeAl.setPromptText("Nome");

        tfNomeDoc = new TextField();
        tfNomeDoc.setPromptText("Nome");

        tfSiglaC = new TextField();
        tfSiglaC.setPromptText("Sigla de Curso");

        tfSiglaR = new TextField();
        tfSiglaR.setPromptText("Sigla de Ramo");

        tfGrade = new TextField();
        tfGrade.setPromptText("Nota de aluno");

        tfN_aluno = new TextField();
        tfN_aluno.setPromptText("Número de aluno");

        tfEmailAl = new TextField();
        tfEmailAl.setPromptText("Email");

        tfEmailDoc = new TextField();
        tfEmailDoc.setPromptText("Email");

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

        alunoGUI.add(tfNomeAl);
        alunoGUI.add(tfEmailAl);
        alunoGUI.add(tfN_aluno);
        alunoGUI.add(tfSiglaC);
        alunoGUI.add(tfSiglaR);
        alunoGUI.add(tfGrade);

        docenteGUI.add(tfNomeDoc);
        docenteGUI.add(tfEmailDoc);

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
        tilePaneAl.setPadding(new Insets(10, 50, 10, 10));
        tilePaneAl.setAlignment(Pos.CENTER);

        tilePaneDoc = new TilePane();
        tilePaneDoc.getChildren().addAll(docenteGUI.get(0), docenteGUI.get(1));
        tilePaneDoc.setHgap(50);
        tilePaneDoc.setPadding(new Insets(10, 50, 10, 30));
        tilePaneDoc.setAlignment(Pos.CENTER);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(btnAlunos, btnDocentes, btnPropostas);
        hBox1.setPadding(new Insets(10));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(100);
        this.setTop(hBox1);

        HBox foot = new HBox();
        foot.getChildren().addAll(btnProx, btnAvancar, btnVoltar, btnClose);
        foot.setPadding(new Insets(10));
        foot.setAlignment(Pos.CENTER);
        foot.setSpacing(90);
        this.setBottom(foot);

        useFile = new VBox();
        useFile.getChildren().add(tgbFile);
        useFile.setAlignment(Pos.CENTER);
        useFile.setPadding(new Insets(10));
    }

    private void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> { update(); });

        tgbFile.setOnMouseClicked(mouseEvent -> {
            if(tgbFile.isSelected()){
                tgbFile.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
                this.setCenter(tfFile);
            }else{
                tgbFile.setBackground(unselectedBackground);
                if(tipo == 1){
                    this.setCenter(tilePaneAl);
                }else if(tipo == 2){
                    this.setCenter(tilePaneDoc);
                }else{
                    this.setCenter(tilePaneProp);
                }
            }
        });

        tfConsult.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER && tfConsult.getText() != null && tfConsult.isFocused()){
                btnAvancar.fire();
            }
        });

        tfFile.setOnKeyPressed(keyEvent -> {
            if(keyEvent.getCode() == KeyCode.ENTER && tfFile.getText() != null && tfFile.isFocused()){
                btnAvancar.fire();
            }
        });

        btnVoltar.setOnAction(actionEvent -> {
            switchMainButton(tipo);
            actualOp = 0;
            btnAvancar.setDisable(true);
            btnVoltar.setDisable(true);
            update();
        });

        btnAvancar.setOnAction(actionEvent -> {

            switch(actualOp){
                case 1 ->{
                    handleDados();
                }

                case 2 ->{
                    if(this.getCenter() != displayDados){
                        handleConsulta();
                        return;
                    }
                }

                case 3 ->{

                }

                case 4 ->{

                }
            }
            clearTf();
            switchMainButton(tipo);
            actualOp = 0;
            btnAvancar.setDisable(true);
            btnVoltar.setDisable(true);
            update();
        });

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

    private void handleConsulta() {
        this.setCenter(displayDados);
        if(tipo == 1){
            displayDados.setText(phaseManager.consultAluno(Long.parseLong(tfConsult.getText())));
        }else if(tipo == 2){
            displayDados.setText(phaseManager.consultDocente(tfConsult.getText()));
        }else{
            displayDados.setText(phaseManager.consultProposta(tfConsult.getText()));
        }
    }

    private void clearTf() {
        for(var i : alunoGUI){
            i.setText("");
        }
        for(var i : docenteGUI){
            i.setText("");
        }
        tfFile.setText("");
        tfConsult.setText("");
    }

    void mainButtons(int tipo){
        this.setLeft(null);
        tgbFile.setVisible(false);
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
                    btnDocentes.setBackground(unselectedBackground);
                    btnPropostas.setBackground(unselectedBackground);
                }
                btnAlunos.setBackground(selectedBackground);
            }
            case 2 ->{
                this.setCenter(tilePaneOp);
                for(var i : operacoes){
                    i.setVisible(true);
                    ArrayList<String> res = new ArrayList<>(Arrays.stream(i.getText().split(" ")).toList());
                    i.setText(res.get(0) + " docentes");
                }
                if(btnAlunos.getBackground() != btnPropostas.getBackground()){
                    btnAlunos.setBackground(unselectedBackground);
                    btnPropostas.setBackground(unselectedBackground);
                }
                btnDocentes.setBackground(selectedBackground);
            }
            case 3 ->{
                this.setCenter(tilePaneOp);
                for(var i : operacoes){
                    i.setVisible(true);
                    ArrayList<String> res = new ArrayList<>(Arrays.stream(i.getText().split(" ")).toList());
                    i.setText(res.get(0) + " propostas");
                }
                if(btnDocentes.getBackground() != btnAlunos.getBackground()){
                    btnDocentes.setBackground(unselectedBackground);
                    btnAlunos.setBackground(unselectedBackground);
                }
                btnPropostas.setBackground(selectedBackground);
            }
        }
    }
    
    void operationButtons(int actualOp){
        btnAvancar.setDisable(false);
        btnVoltar.setDisable(false);
        switch(actualOp){
            case 0 -> {
                btnAvancar.setDisable(true);
                btnVoltar.setDisable(true);
            }

            case 1 -> {
                this.setLeft(useFile);
                tgbFile.setVisible(true);
                if(tipo == 1){
                    switchMainButton(1);
                    this.setCenter(tilePaneAl);
                    for(var i : alunoGUI){
                        i.setVisible(true);
                    }
                    tgbAccess.setVisible(true);
                }else if(tipo == 2){
                    switchMainButton(2);
                    this.setCenter(tilePaneDoc);
                    for(var i : docenteGUI){
                        i.setVisible(true);
                    }
                }else{
                    switchMainButton(3);
                    this.setCenter(tilePaneProp);
                }
            }

            case 2 -> {
                if(tipo == 1){
                    switchMainButton(1);
                    this.setCenter(tfConsult);
                }else if(tipo == 2){
                    switchMainButton(2);
                    this.setCenter(tfConsult);
                }
            }

            case 3 -> {

            }

            case 4 -> {

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
        if(!tgbFile.isSelected()){
            tgbFile.setBackground(unselectedBackground);
        }
    }

    public void handleDados(){
        if(tipo == 1){
            switch(actualOp){
                case 1 ->{
                    if(!tgbFile.isSelected()){
                        phaseManager.insertAluno(new Aluno(Long.parseLong(tfN_aluno.getText()), tfNomeAl.getText(), tfEmailAl.getText(),
                                tfSiglaC.getText(), tfSiglaR.getText(), Double.parseDouble(tfGrade.getText()), tgbAccess.isSelected()));
                    }else{
                        phaseManager.insertAlunoFile(tfFile.getText());
                        tgbFile.setSelected(false);
                    }
                }

                case 2 ->{
                    phaseManager.consultAluno(Long.parseLong(tfN_aluno.getText()));
                }

                case 3 ->{

                }

                case 4 ->{

                }
            }
        }else if(tipo == 2){
            switch(actualOp){
                case 1 ->{
                    if(!tgbFile.isSelected()){
                        phaseManager.insertDocente(new Docente(tfNomeDoc.getText(), tfEmailDoc.getText()));
                    }else{
                        phaseManager.insertDocenteFile(tfFile.getText());
                        tgbFile.setSelected(false);
                    }
                }

                case 2 ->{
                    phaseManager.consultDocente(tfEmailDoc.getText());
                }

                case 3 ->{

                }

                case 4 ->{

                }
            }
        }else{
            /*switch(actualOp){
                case 1 ->{
                    phaseManager.insertProposta();
                }

                case 2 ->{

                }

                case 3 ->{

                }

                case 4 ->{

                }
            }*/
        }
    }

    public void switchMainButton(int tipo){
        switch(tipo){
            case 1 ->{
                if(btnDocentes.isDisabled() && btnPropostas.isDisabled()){
                    btnDocentes.setDisable(false);
                    btnPropostas.setDisable(false);
                }else{
                    btnDocentes.setDisable(true);
                    btnPropostas.setDisable(true);
                }
            }
            case 2 ->{
                if(btnAlunos.isDisabled() && btnPropostas.isDisabled()){
                    btnAlunos.setDisable(false);
                    btnPropostas.setDisable(false);
                }else{
                    btnAlunos.setDisable(true);
                    btnPropostas.setDisable(true);
                }
            }
            case 3 ->{
                if(btnDocentes.isDisabled() && btnAlunos.isDisabled()){
                    btnDocentes.setDisable(false);
                    btnAlunos.setDisable(false);
                }else{
                    btnDocentes.setDisable(true);
                    btnAlunos.setDisable(true);
                }
            }
        }
    }
}
