package pt.isec.pa.apoio_poe.model;

import pt.isec.pa.apoio_poe.model.fsm.PhaseContext;
import pt.isec.pa.apoio_poe.model.fsm.PhaseState;

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

    public PhaseState getPhaseState() {
        return fsm.getState();
    }

    public boolean nextPhase() {
        var ret = fsm.nextPhase();
        pcs.firePropertyChange(null, null, null);
        return ret;
    }

    public void closePhase() {
        fsm.closeState();
        pcs.firePropertyChange(null, null, null);
    }
}
