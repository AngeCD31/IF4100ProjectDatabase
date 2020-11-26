package edu.ucr.rp.db.logic.line;

import java.util.List;

public interface LineService<S, K> {
        void create (S student) throws LineServiceException;
        List<S> read () throws LineServiceException;
        List<S> read(K k) throws LineServiceException;
        void update (S student) throws LineServiceException;
        void delete (S student) throws LineServiceException;
        boolean isConnected();
}


