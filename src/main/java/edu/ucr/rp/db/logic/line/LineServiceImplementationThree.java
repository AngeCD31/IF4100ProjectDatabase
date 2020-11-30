package edu.ucr.rp.db.logic.line;

import edu.ucr.rp.db.domain.LineThree;
import edu.ucr.rp.db.persistance.LinePersistanceThree;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;

import java.util.List;

public class LineServiceImplementationThree implements LineService<LineThree, String>{

    private static LineServiceImplementationThree instance;
    private static Persistance<LineThree, String> persistance;

    public static LineServiceImplementationThree getInstance() {
        if (instance == null)
            instance = new LineServiceImplementationThree();
        return instance;
    }

    private LineServiceImplementationThree() {
        persistance = new LinePersistanceThree();

    }

    @Override
    public void create(LineThree line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getIdCard()) == null || Integer.toString(line.getIdCard()).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.create(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineThree> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineThree> read(String key) throws LineServiceException {
        try {
            return persistance.read(key);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(LineThree line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getIdCard()) == null || Integer.toString(line.getIdCard()).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.update(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(LineThree line) throws LineServiceException {
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
