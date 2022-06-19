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

public class Phase3UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));

    HBox selectAtAuto;
    BorderPane borderPaneLista;
    VBox vbox1, vbox2;

    Button btnProx, btnClose, btnAnterior;
    Button btnAvancar, btnVoltar;
    Button btnAtribuicaoAutomatica, btnAtribuicaoManual, btnRemover;
    Button btnAutoAt1, btnAutoAt2;

    ToggleButton tgbExport, tgbLista;
    ToggleButton tgbListaAl, tgbListaProp;
    ToggleButton tgbAlAutoproposta, tgbAlCandidatura, tgbAlAtribuida, tgbAlSAtribuidas;
    ToggleButton tgbPropAutoproposta, tgbPropDocente, tgbPropDisponiveis, tgbPropAtribuidas;

    TextField tfFile;
    Label displayLista;

    public Phase3UI(PhaseManager phaseManager) {
        this.phaseManager = phaseManager;

        createView();
        registerHandlers();
        update();
    }

    public void createView() {
        btnAutoAt1 = new Button("Comparação");

        btnAutoAt2 = new Button("Atribuição");

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

        selectAtAuto = new HBox();

        selectAtAuto.getChildren().addAll(btnAutoAt1, btnAutoAt2);

        btnAtribuicaoAutomatica = new Button("Atribuicao Automatica");
        btnAtribuicaoAutomatica.setMinWidth(50);
        btnAtribuicaoAutomatica.setBackground(unselectedBackground);

        tgbLista = new ToggleButton("Lista");
        tgbLista.setMinWidth(50);
        tgbLista.setBackground(unselectedBackground);

        btnAtribuicaoManual = new Button("Atribuicao Manual");
        btnAtribuicaoManual.setMinWidth(50);
        btnAtribuicaoManual.setBackground(unselectedBackground);

        btnRemover = new Button("Remover");
        btnRemover.setMinWidth(50);
        btnRemover.setBackground(unselectedBackground);

        tgbExport = new ToggleButton("Exportar");
        tgbExport.setMinWidth(50);
        tgbExport.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(btnAtribuicaoAutomatica, btnAtribuicaoManual, btnRemover, tgbLista, tgbExport);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(50);
        this.setTop(hboxCima);

        tfFile = new TextField();
        tfFile.setPromptText("Nome do ficheiro:");
        tfFile.setMaxWidth(300);

        tgbListaAl = new ToggleButton("Alunos");
        tgbListaAl.setMinWidth(50);
        tgbListaAl.setBackground(unselectedBackground);
        tgbListaProp = new ToggleButton("Propostas");
        tgbListaProp.setMinWidth(50);
        tgbListaProp.setBackground(unselectedBackground);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tgbListaAl, tgbListaProp);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(50);
        vBox.setPadding(new Insets(10));

        tgbAlAutoproposta = new ToggleButton("Autoproposto");
        tgbAlAutoproposta.setBackground(unselectedBackground);
        tgbAlCandidatura = new ToggleButton("Candidatura");
        tgbAlCandidatura.setBackground(unselectedBackground);
        tgbAlAtribuida = new ToggleButton("Proposta Atribuida");
        tgbAlAtribuida.setBackground(unselectedBackground);
        tgbAlSAtribuidas = new ToggleButton("Sem Proposta Atribuida");
        tgbAlSAtribuidas.setBackground(unselectedBackground);

        tgbPropAutoproposta = new ToggleButton("Autoproposto");
        tgbPropAutoproposta.setBackground(unselectedBackground);
        tgbPropDocente = new ToggleButton("Docente");
        tgbPropDocente.setBackground(unselectedBackground);
        tgbPropDisponiveis = new ToggleButton("Propostas Disponiveis");
        tgbPropDisponiveis.setBackground(unselectedBackground);
        tgbPropAtribuidas = new ToggleButton("Propostas Atribuidas");
        tgbPropAtribuidas.setBackground(unselectedBackground);

        vbox1 = new VBox();
        vbox1.getChildren().addAll(tgbAlAutoproposta, tgbAlCandidatura, tgbAlAtribuida, tgbAlSAtribuidas);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(50);
        vbox1.setPadding(new Insets(10));

        vbox2 = new VBox();
        vbox2.getChildren().addAll(tgbPropAutoproposta, tgbPropDocente, tgbPropDisponiveis, tgbPropAtribuidas);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(50);
        vbox2.setPadding(new Insets(10));

        borderPaneLista = new BorderPane();
        borderPaneLista.setLeft(vBox);
        borderPaneLista.setCenter(displayLista);
    }

    public void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> {
            update();
        });

        btnAutoAt1.setOnAction(actionEvent -> {
            phaseManager.assignment(0);
        });

        btnAutoAt2.setOnAction(actionEvent -> {
            phaseManager.assignment(1);
        });

        btnAtribuicaoAutomatica.setOnAction(actionEvent ->{
            if(!phaseManager.getIsClosed(2)){
                System.out.println("Dentro assignment 0");
                phaseManager.assignment(0);
                return;
            }
            this.setCenter(selectAtAuto);
        });

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
            update();
        });

        btnAvancar.setOnAction(actionEvent -> {
            if(tgbLista.isSelected()){
                if(tgbListaAl.isSelected()){
                    if(tgbAlAutoproposta.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("autoproposta"));
                    }
                    if(tgbAlCandidatura.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("candidatura"));
                    }
                    if(tgbAlAtribuida.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("atribuida"));
                    }
                    if(tgbAlSAtribuidas.isSelected()){
                        displayLista.setText(phaseManager.listaAluno("no_atribuida"));
                    }
                }
                if(tgbListaProp.isSelected()){
                    if(tgbPropAutoproposta.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("autoproposta"));
                    }
                    if(tgbPropDocente.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("docente"));
                    }
                    if(tgbPropDisponiveis.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("disponiveis"));
                    }
                    if(tgbPropAtribuidas.isSelected()){
                        displayLista.setText(phaseManager.listaProposta("atribuida"));
                    }
                }
            }
            update();
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
                borderPaneLista.setRight(vbox1);
            } else {
                tgbListaAl.setBackground(unselectedBackground);
                borderPaneLista.setRight(null);
            }
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
            tgbListaAl.setSelected(false);
            tgbListaAl.setBackground(unselectedBackground);
            update();
        });

        tgbAlAtribuida.setOnAction(actionEvent -> {
            if(tgbAlAtribuida.isSelected()){
                tgbAlAtribuida.setBackground(selectedBackground);
            } else {
                tgbAlAtribuida.setBackground(unselectedBackground);
            }

            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            tgbAlSAtribuidas.setSelected(false);
            tgbAlSAtribuidas.setBackground(unselectedBackground);
        });
        tgbAlAutoproposta.setOnAction(actionEvent -> {
            if(tgbAlAutoproposta.isSelected()){
                tgbAlAutoproposta.setBackground(selectedBackground);
            } else {
                tgbAlAutoproposta.setBackground(unselectedBackground);
            }

            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
            tgbAlSAtribuidas.setSelected(false);
            tgbAlSAtribuidas.setBackground(unselectedBackground);
        });
        tgbAlCandidatura.setOnAction(actionEvent -> {
            if(tgbAlCandidatura.isSelected()){
                tgbAlCandidatura.setBackground(selectedBackground);
            } else {
                tgbAlCandidatura.setBackground(unselectedBackground);
            }

            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            tgbAlSAtribuidas.setSelected(false);
            tgbAlSAtribuidas.setBackground(unselectedBackground);
        });
        tgbAlSAtribuidas.setOnAction(actionEvent -> {
            if(tgbAlSAtribuidas.isSelected()){
                tgbAlSAtribuidas.setBackground(selectedBackground);
            } else {
                tgbAlSAtribuidas.setBackground(unselectedBackground);
            }

            tgbAlCandidatura.setSelected(false);
            tgbAlCandidatura.setBackground(unselectedBackground);
            tgbAlAutoproposta.setSelected(false);
            tgbAlAutoproposta.setBackground(unselectedBackground);
            tgbAlAtribuida.setSelected(false);
            tgbAlAtribuida.setBackground(unselectedBackground);
        });

        tgbPropDocente.setOnAction(actionEvent -> {
            if(tgbPropDocente.isSelected()){
                tgbPropDocente.setBackground(selectedBackground);
            } else {
                tgbPropDocente.setBackground(unselectedBackground);
            }

            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
        });
        tgbPropAutoproposta.setOnAction(actionEvent -> {
            if(tgbPropAutoproposta.isSelected()){
                tgbPropAutoproposta.setBackground(selectedBackground);
            } else {
                tgbPropAutoproposta.setBackground(unselectedBackground);
            }

            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
        });
        tgbPropDisponiveis.setOnAction(actionEvent -> {
            if(tgbPropDisponiveis.isSelected()){
                tgbPropDisponiveis.setBackground(selectedBackground);
            } else {
                tgbPropDisponiveis.setBackground(unselectedBackground);
            }

            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropAtribuidas.setSelected(false);
            tgbPropAtribuidas.setBackground(unselectedBackground);
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
        });
        tgbPropAtribuidas.setOnAction(actionEvent -> {
            if(tgbPropAtribuidas.isSelected()){
                tgbPropAtribuidas.setBackground(selectedBackground);
            } else {
                tgbPropAtribuidas.setBackground(unselectedBackground);
            }

            tgbPropAutoproposta.setSelected(false);
            tgbPropAutoproposta.setBackground(unselectedBackground);
            tgbPropDocente.setSelected(false);
            tgbPropDocente.setBackground(unselectedBackground);
            tgbPropDisponiveis.setSelected(false);
            tgbPropDisponiveis.setBackground(unselectedBackground);
        });
    }

    public void update() {
        if(phaseManager.getPhaseState() != PhaseState.PHASE_3){
            this.setVisible(false);
            return;
        }
        System.out.println(phaseManager.getIsClosed(2));
        if(!phaseManager.getIsClosed(2)){
            btnAtribuicaoManual.setDisable(true);
            btnClose.setDisable(true);
        }
        this.setVisible(true);
    }
}
