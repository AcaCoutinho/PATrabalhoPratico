package pt.isec.pa.apoio_poe;

import javafx.application.Application;
import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.ui.gui.MainJFX;
import pt.isec.pa.apoio_poe.ui.text.UI;
import pt.isec.pa.apoio_poe.utils.PAInput;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        switch (PAInput.chooseOption("Deseja que interface:", "Grafica", "Texto")){
            case 1 -> {
                Application.launch(MainJFX.class, args);
            }
            case 2 -> {
                PhaseContext fsm = new PhaseContext();
                UI ui = new UI(fsm);
                ui.start();
            }
        }

    }
}
