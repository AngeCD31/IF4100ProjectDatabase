package edu.ucr.rp.db.logic.line;

import edu.ucr.rp.db.domain.Line;
import edu.ucr.rp.db.persistance.LinePersistance;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;

import java.util.List;

public class LineServiceImplementation implements LineService<Line, String>{

    private static LineServiceImplementation instance;
    private static Persistance<Line, String> persistance;

    public static LineServiceImplementation getInstance() {
        if (instance == null)
            instance = new LineServiceImplementation();
        return instance;
    }

    private LineServiceImplementation() {
        persistance = new LinePersistance();

    }

    @Override
    public void create(Line line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (line.getName() == null || line.getName().isEmpty())
            throw new LineServiceException("Debe ingresar un nombre.");
        try {
            persistance.create(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<Line> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<Line> read(String key) throws LineServiceException {
        try {
            return persistance.read(key);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(Line line) throws LineServiceException {
        if (line == null)
            throw new LineServiceException("No se puede agregar una línea nula.");
        if (Integer.toString(line.getNumberLine()) == null || (Integer.toString(line.getIdCard())).isEmpty())
            throw new LineServiceException("Número de línea inválido.");
        if (line.getName() == null || line.getName().isEmpty())
            throw new LineServiceException("Debe ingresar un nombre.");
        try {
            persistance.update(line);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(Line line) throws LineServiceException {
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
