package de.nordakademie.iaa.roommanagement.action;

public class ExitAction extends Action {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLabel() {
        return "Beenden!";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() throws Exception {
        System.out.println("Raumverwaltung beendet!");
        System.exit(0);
    }

}
