package edu.ucr.rp.db.logic.line;

import java.util.List;

public interface LineService<L, K> {
        void create (L line) throws LineServiceException;
        List<L> read () throws LineServiceException;
        List<L> read(K k) throws LineServiceException;
        void update (L line) throws LineServiceException;
        void delete (L line) throws LineServiceException;
        boolean isConnected();
}


