package edu.ucr.rp.db.logic;

import edu.ucr.rp.db.domain.LineFour;
import edu.ucr.rp.db.domain.View;
import edu.ucr.rp.db.persistance.LinePersistanceFour;
import edu.ucr.rp.db.persistance.Persistance;
import edu.ucr.rp.db.persistance.PersistanceException;
import edu.ucr.rp.db.persistance.ViewPersistance;

import java.util.List;

public class ViewServiceImplementation implements LineService<View, String>{

    private static ViewServiceImplementation instance;
    private static Persistance<View, String> persistance;

    public static ViewServiceImplementation getInstance() {
        if (instance == null)
            instance = new ViewServiceImplementation();
        return instance;
    }

    private ViewServiceImplementation() {
        persistance = new ViewPersistance();

    }

    @Override
    public void create(View line) throws LineServiceException {
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
    public List<View> read() throws LineServiceException {
        try {
            return persistance.read();
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public List<View> read(String s) throws LineServiceException {
        try {
            return persistance.read(s);
        } catch (PersistanceException e) {
            throw new LineServiceException(e.getMessage());
        }
    }

    @Override
    public void update(View line) throws LineServiceException {
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
    public void delete(View line) throws LineServiceException {
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
