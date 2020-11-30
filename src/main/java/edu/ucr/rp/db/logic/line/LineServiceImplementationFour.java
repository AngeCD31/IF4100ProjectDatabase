package edu.ucr.rp.db.logic.line;

import edu.ucr.rp.db.domain.LineFour;
import edu.ucr.rp.db.persistance.LinePersistanceFour;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;

import java.util.List;

public class LineServiceImplementationFour implements LineService<LineFour, String>{

    private static LineServiceImplementationFour instance;
    private static Persistance<LineFour, String> persistance;

    public static LineServiceImplementationFour getInstance() {
        if (instance == null)
            instance = new LineServiceImplementationFour();
        return instance;
    }

    private LineServiceImplementationFour() {
        persistance = new LinePersistanceFour();

    }

    @Override
    public void create(LineFour line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (Integer.toString(line.getIdCard()) == null || Integer.toString(line.getIdCard()).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.create(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineFour> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineFour> read(String key) throws LineServiceException {
        try {
            return persistance.read(key);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(LineFour line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (Integer.toString(line.getIdCard()) == null || Integer.toString(line.getIdCard()).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.update(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(LineFour line) throws LineServiceException {
        try {
            persistance.delete(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public boolean isConnected() {
        return persistance.isConnected();
    }
}
