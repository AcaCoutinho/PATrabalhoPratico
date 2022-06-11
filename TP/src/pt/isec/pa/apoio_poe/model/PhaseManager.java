package pt.isec.pa.apoio_poe.model;

import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PhaseManager {
    private PhaseContext fsm;
    PropertyChangeSupport pcs;

    public PhaseManager() {
        fsm = new PhaseContext();
        pcs = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
