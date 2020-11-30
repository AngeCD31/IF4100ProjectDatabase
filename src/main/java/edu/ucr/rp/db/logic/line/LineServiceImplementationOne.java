package edu.ucr.rp.db.logic.line;

import edu.ucr.rp.db.domain.LineOne;
import edu.ucr.rp.db.persistance.LinePersistanceOne;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;

import java.util.List;

public class LineServiceImplementationOne implements LineService<LineOne, String>{

    private static LineServiceImplementationOne instance;
    private static Persistance<LineOne, String> persistance;

    public static LineServiceImplementationOne getInstance() {
        if (instance == null)
            instance = new LineServiceImplementationOne();
        return instance;
    }

    private LineServiceImplementationOne() {
        persistance = new LinePersistanceOne();

    }

    @Override
    public void create(LineOne line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getNumberLine())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (Integer.toString(line.getIdCard()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.create(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineOne> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<LineOne> read(String key) throws LineServiceException {
        try {
            return persistance.read(key);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(LineOne line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getNumberLine())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (Integer.toString(line.getIdCard()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Debe ingresar un ID.");
        try {
            persistance.update(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(LineOne line) throws LineServiceException {
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
