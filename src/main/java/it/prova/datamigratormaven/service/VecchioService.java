package it.prova.datamigratormaven.service;

import it.prova.datamigratormaven.dao.vecchio.VecchioDAO;

public class VecchioService {

    private VecchioDAO vecchioDAO;


    public void setVecchioDao(VecchioDAO vecchioDAO) {
        this.vecchioDAO = vecchioDAO;

    }


}
