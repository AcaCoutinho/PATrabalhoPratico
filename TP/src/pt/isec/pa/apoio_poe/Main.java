package pt.isec.pa.apoio_poe;

import pt.isec.pa.apoio_poe.model.data.Aluno;
import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.ui.text.UI;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PhaseContext fsm = new PhaseContext();
        UI ui = new UI(fsm);
        ui.start();
    }
}
