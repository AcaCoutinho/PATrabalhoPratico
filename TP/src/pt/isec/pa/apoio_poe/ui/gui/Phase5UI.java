package pt.isec.pa.apoio_poe.ui.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import pt.isec.pa.apoio_poe.model.PhaseManager;
import pt.isec.pa.apoio_poe.model.data.Phase;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

public class Phase5UI extends BorderPane {
    PhaseManager phaseManager;

    Background unselectedBackground = new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY));
    Background selectedBackground = new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY));
    Button btnSair;
    Button btnAvancar, btnVoltar;
    Button btnLista, btnExportar;

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

        btnLista = new Button("Lista");
        btnLista.setMinWidth(100);
        btnLista.setBackground(unselectedBackground);

        btnExportar = new Button("Exportar");
        btnExportar.setMinWidth(100);
        btnExportar.setBackground(unselectedBackground);

        HBox hboxCima = new HBox();
        hboxCima.getChildren().addAll(btnLista, btnExportar);
        hboxCima.setPadding(new Insets(10));
        hboxCima.setAlignment(Pos.CENTER);
        hboxCima.setSpacing(50);
        this.setTop(hboxCima);
    }

    public void registerHandlers() {
        phaseManager.addPropertyChangeListener(evt -> { update(); });

        btnSair.setOnAction(actionEvent -> {
            Platform.exit();
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
