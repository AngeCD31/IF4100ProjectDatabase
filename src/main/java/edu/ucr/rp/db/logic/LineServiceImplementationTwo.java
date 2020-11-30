package edu.ucr.rp.db.logic;

import edu.ucr.rp.db.domain.LineTwo;
import edu.ucr.rp.db.persistance.LinePersistanceTwo;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;

import java.util.List;

public class LineServiceImplementationTwo implements LineService<LineTwo, String>{

    private static LineServiceImplementationTwo instance;
    private static Persistance<LineTwo, String> persistance;

    public static LineServiceImplementationTwo getInstance() {
        if (instance == null)
            instance = new LineServiceImplementationTwo();
        return instance;
    }

    private LineServiceImplementationTwo() {
        persistance = new LinePersistanceTwo();

    }

    @Override
    public void create(LineTwo line) throws LineServiceException {
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
    public List<LineTwo> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineTwo> read(String key) throws LineServiceException {
        try {
            return persistance.read(key);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(LineTwo line) throws LineServiceException {
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
    public void delete(LineTwo line) throws LineServiceException {
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
