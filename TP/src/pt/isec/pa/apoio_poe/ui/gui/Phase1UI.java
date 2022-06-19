package pt.isec.pa.apoio_poe.ui.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.data.*;
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
    Button btnInsere, btnConsulta, btnEdita, btnElimina;
    Button btnAvancar, btnVoltar;
    ToggleButton tgbProjeto, tgbEstagio, tgbAutoProposta;

    VBox selectProp;
    VBox vBoxEdit;
    VBox useFile;
    ToggleButton tgbFile;
    TextField tfFile;

    ArrayList<Button> operacoes = new ArrayList<>();
    ArrayList<TextField> alunoGUI = new ArrayList<>();
    ArrayList<TextField> docenteGUI = new ArrayList<>();
    ArrayList<TextField> propostaGUI = new ArrayList<>();

    TextField tfNomeAl, tfNomeDoc, tfSiglaC, tfSiglaR, tfGrade, tfN_aluno, tfEmailAl, tfEmailDoc, tfCa, tfTitulo, tfRd, tfAd, tfEntityId, tfN_alunoAt, tfDocenteProp;
    ToggleButton tgbAccess;

    TextField tfConsult;

    TextField tfIdentify, tfTipoEdit, tfDadoEdit;

    TextField tfElimina;

    Label displayDados;

    public Phase1UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    //Código identificação, área de destino, ramo de destino, titulo, entity, pode ou não ter n_aluno

    private void createView(){
        tgbProjeto = new ToggleButton("Projeto");
        tgbProjeto.setMinWidth(100);

        tgbEstagio = new ToggleButton("Estagio");
        tgbEstagio.setMinWidth(100);

        tgbAutoProposta = new ToggleButton("Auto-proposta");
        tgbAutoProposta.setMinWidth(100);

        tfN_alunoAt = new TextField();
        tfN_alunoAt.setPromptText("Número de aluno a atribuir");

        tfElimina = new TextField();

        tfIdentify = new TextField();

        tfTipoEdit = new TextField();
        tfTipoEdit.setPromptText("Campo a editar");

        tfDadoEdit = new TextField();
        tfDadoEdit.setPromptText("Novos dados para o campo");

        tfFile = new TextField();
        tfFile.setPromptText("Nome de ficheiro");
        tfFile.setMaxWidth(200);

        tgbFile = new ToggleButton("Usar ficheiro");
        tgbFile.setMinWidth(100);
        tgbFile.setVisible(false);
        tgbFile.setBackground(unselectedBackground);

        displayDados = new Label();
        displayDados.setFont(new Font(15));

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

        tfDocenteProp = new TextField();
        tfDocenteProp.setPromptText("Email de docente proponetne");

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
        tfCa.setPromptText("Código de identificação");

        tfTitulo = new TextField();
        tfTitulo.setPromptText("Titulo");

        tfRd = new TextField();
        tfRd.setPromptText("Ramo de destino");

        tfAd = new TextField();
        tfAd.setPromptText("Área de destino");

        tfEntityId = new TextField();
        tfEntityId.setPromptText("Id de entidade");

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

        propostaGUI.add(tfCa);
        propostaGUI.add(tfAd);
        propostaGUI.add(tfRd);
        propostaGUI.add(tfTitulo);
        propostaGUI.add(tfEntityId);
        propostaGUI.add(tfN_alunoAt);
        propostaGUI.add(tfDocenteProp);


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

        tilePaneProp = new TilePane();
        tilePaneProp.setPrefRows(3);
        tilePaneProp.setPrefColumns(2);
        tilePaneProp.setHgap(20);
        tilePaneProp.setVgap(20);
        tilePaneProp.setPadding(new Insets(10, 50, 10, 30));
        tilePaneProp.setAlignment(Pos.CENTER);

        selectProp = new VBox();
        selectProp.getChildren().addAll(tgbProjeto, tgbEstagio, tgbAutoProposta);
        selectProp.setPadding(new Insets(10));
        selectProp.setAlignment(Pos.CENTER);
        selectProp.setSpacing(30);

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

        vBoxEdit = new VBox();
        vBoxEdit.getChildren().addAll(tfIdentify, tfTipoEdit, tfDadoEdit);
        vBoxEdit.setAlignment(Pos.CENTER);
        vBoxEdit.setPadding(new Insets(10));

        useFile = new VBox();
        useFile.getChildren().add(tgbFile);
        useFile.setAlignment(Pos.CENTER);
        useFile.setPadding(new Insets(10));
    }

    private void registerHandlers() {

        tgbEstagio.setOnMouseClicked(mouseEvent -> {
            tilePaneProp.getChildren().addAll(propostaGUI.get(0), propostaGUI.get(1), propostaGUI.get(3), propostaGUI.get(4), propostaGUI.get(5));
            this.setCenter(tilePaneProp);
        });

        tgbProjeto.setOnMouseClicked(mouseEvent -> {
            tilePaneProp.getChildren().addAll(propostaGUI.get(0), propostaGUI.get(2), propostaGUI.get(3), propostaGUI.get(6), propostaGUI.get(5));
            this.setCenter(tilePaneProp);
        });

        tgbAutoProposta.setOnMouseClicked(mouseEvent -> {
            tilePaneProp.getChildren().addAll(propostaGUI.get(0), propostaGUI.get(3), propostaGUI.get(5));
            this.setCenter(tilePaneProp);
        });

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
                    if(tgbProjeto.isSelected() || tgbEstagio.isSelected() || tgbAutoProposta.isSelected()){
                        this.setCenter(tilePaneProp);
                    }else{
                        this.setCenter(selectProp);
                    }
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
            clear();
            switchMainButton(tipo);
            actualOp = 0;
            btnAvancar.setDisable(true);
            btnVoltar.setDisable(true);
            update();
        });

        btnAvancar.setOnAction(actionEvent -> {

            switch(actualOp){
                case 1 ->{
                    handleInsert();
                }

                case 2 ->{
                    if(this.getCenter() != displayDados){
                        handleConsulta();
                        return;
                    }
                }

                case 3 ->{
                    handleEdit();
                }

                case 4 ->{
                    handleDelete();
                }
            }
            clear();
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
            phaseManager.closePhase();
            update();
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

    private void mainButtons(int tipo){
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

    private void operationButtons(int actualOp){
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
                    this.setCenter(selectProp);
                }
            }

            case 2 -> {
                this.setCenter(tfConsult);
                if(tipo == 1){
                    switchMainButton(1);
                }else if(tipo == 2){
                    switchMainButton(2);
                }else{
                    switchMainButton(3);
                }
            }

            case 3 -> {
                this.setCenter(vBoxEdit);
                if(tipo == 1){
                    tfIdentify.setPromptText("Numero de aluno");
                    switchMainButton(1);
                }else if(tipo == 2){
                    tfIdentify.setPromptText("Email de docente");
                    switchMainButton(2);
                }else{
                    tfIdentify.setPromptText("Código de identificação");
                    switchMainButton(3);
                }
            }

            case 4 -> {
                this.setCenter(tfElimina);
                if(tipo == 1){
                    tfElimina.setPromptText("Numero de aluno a eliminar");
                    switchMainButton(1);
                }else if(tipo == 2){
                    tfElimina.setPromptText("Email de docente a eliminar");
                    switchMainButton(2);
                }else{
                    tfElimina.setPromptText("Código de proposta a eliminrar");
                    switchMainButton(3);
                }
            }
        }
    }

    private void switchMainButton(int tipo){
        if(btnAlunos.isDisabled() || btnDocentes.isDisabled() || btnPropostas.isDisabled()){
            btnAlunos.setDisable(false);
            btnDocentes.setDisable(false);
            btnPropostas.setDisable(false);
        }else{
            btnAlunos.setDisable(true);
            btnDocentes.setDisable(true);
            btnPropostas.setDisable(true);
        }
    }

    private void handleInsert(){
        if(tipo == 1) {
            if (!tgbFile.isSelected()) {
                phaseManager.insertAluno(new Aluno(Long.parseLong(tfN_aluno.getText()), tfNomeAl.getText(), tfEmailAl.getText(),
                        tfSiglaC.getText(), tfSiglaR.getText(), Double.parseDouble(tfGrade.getText()), tgbAccess.isSelected()));
            }else{
                phaseManager.insertAlunoFile(tfFile.getText());
                tgbFile.setSelected(false);
            }
        }else if(tipo == 2){
            if(!tgbFile.isSelected()){
                phaseManager.insertDocente(new Docente(tfNomeDoc.getText(), tfEmailDoc.getText()));
            }else{
                phaseManager.insertDocenteFile(tfFile.getText());
                tgbFile.setSelected(false);
            }
        }else if(tipo == 3){
            if(!tgbFile.isSelected()){
                if(tgbProjeto.isSelected()){
                    if(!tfN_alunoAt.getText().equals("") && phaseManager.getDocente(tfDocenteProp.getText()) != null){
                        System.out.println("Entrei1");
                        if(phaseManager.getAluno(Long.parseLong(tfN_alunoAt.getText())) != null){
                            System.out.println("Entrei2");
                            phaseManager.insertProposta(new Projeto(tfCa.getText(), tfRd.getText(), tfTitulo.getText(), phaseManager.getDocente(tfDocenteProp.getText()), Long.parseLong(tfN_alunoAt.getText())));
                        }
                    }else{
                        phaseManager.insertProposta(new Projeto(tfCa.getText(), tfRd.getText(), tfTitulo.getText(), phaseManager.getDocente(tfDocenteProp.getText())));
                    }
                }
                if(tgbEstagio.isSelected()){
                    if(!tfN_alunoAt.getText().equals("")){
                        System.out.println("Entrei1");
                        if(phaseManager.getAluno(Long.parseLong(tfN_alunoAt.getText())) != null){
                            System.out.println("Entrei2");
                            phaseManager.insertProposta(new Estagio(tfCa.getText(), tfAd.getText(), tfTitulo.getText(), tfEntityId.getText(), Long.parseLong(tfN_alunoAt.getText())));
                        }
                    }else{
                        phaseManager.insertProposta(new Estagio(tfCa.getText(), tfRd.getText(), tfTitulo.getText(), tfEntityId.getText()));
                    }
                }
                if(tgbAutoProposta.isSelected()){
                    if(!tfN_alunoAt.getText().equals("")){
                        System.out.println("Entrei1");
                        if(phaseManager.getAluno(Long.parseLong(tfN_alunoAt.getText())) != null){
                            System.out.println("Entrei2");
                            phaseManager.insertProposta(new Autoproposto(tfCa.getText(), tfTitulo.getText(), Long.parseLong(tfN_alunoAt.getText())));
                        }
                    }
                }
            }else{
                phaseManager.insertPropostaFile(tfFile.getText());
                tgbFile.setSelected(false);
            }
        }
    }

    private void handleConsulta() {
        this.setCenter(displayDados);
        if(tipo == 1){
            if(phaseManager.getAluno(Long.parseLong(tfConsult.getText())) == null){
                displayDados.setText("Aluno não encontrado");
            }else{
                displayDados.setText(phaseManager.consultAluno(Long.parseLong(tfConsult.getText())));
            }
        }else if(tipo == 2){
            if(phaseManager.getDocente(tfConsult.getText()) == null){
                displayDados.setText("Docente não encontrado");
            }else{
                displayDados.setText(phaseManager.consultDocente(tfConsult.getText()));
            }
        }else{
            if(phaseManager.getProposta(tfConsult.getText()) == null){
                displayDados.setText("Proposta não encontrado");
            }else{
                displayDados.setText(phaseManager.consultProposta(tfConsult.getText()));
            }
        }
    }

    private void handleEdit(){
        if(tipo == 1){
            phaseManager.editAluno(Long.parseLong(tfIdentify.getText()), tfTipoEdit.getText(), tfDadoEdit.getText());
        }else if(tipo == 2){
            phaseManager.editDocente(tfIdentify.getText(), tfTipoEdit.getText(), tfDadoEdit.getText());
        }else{
            phaseManager.editProposta(tfIdentify.getText(), tfTipoEdit.getText(), tfDadoEdit.getText());
        }
    }

    private void handleDelete() {
        this.setCenter(tfElimina);
        if(tipo == 1){
            phaseManager.removeAluno(Long.parseLong(tfElimina.getText()));
        }else if(tipo == 2){
            phaseManager.removeDocente(tfElimina.getText());
        }else{
            phaseManager.removeProposta(tfElimina.getText());
        }
    }

    private void clear() {
        for(var i : alunoGUI){
            i.setText("");
        }
        for(var i : docenteGUI){
            i.setText("");
        }
        for(var i : propostaGUI){
            i.setText("");
        }
        tgbProjeto.setSelected(false);
        tgbEstagio.setSelected(false);
        tgbAutoProposta.setSelected(false);
        tilePaneProp.getChildren().clear();
        tfFile.setText("");
        tfConsult.setText("");
        tfIdentify.setText("");
        tfDadoEdit.setText("");
        tfTipoEdit.setText("");
        displayDados.setText("");
    }
}

