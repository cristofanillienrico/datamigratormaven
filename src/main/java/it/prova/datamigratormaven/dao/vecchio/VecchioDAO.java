package it.prova.datamigratormaven.dao.vecchio;

import it.prova.datamigratormaven.dao.AbstractMySQLDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VecchioDAO extends AbstractMySQLDAO {

    public void setConnection(Connection connection) {
        this.connection = connection;

    }


    public ResultSet oldDataInterrogation() throws Exception {
        // prima di tutto cerchiamo di capire se possiamo effettuare le operazioni
        if (isNotActive())
            throw new Exception("Connessione non attiva. Impossibile effettuare operazioni DAO.");


        String query = "SELECT d.id, d.codice_fiscale, a.nome, a.cognome,a.`data`, count(s.id) as numero_sinistri \n" +
                "from dati_fiscali d\n" +
                "inner join anagrafica a ON  a.id_datifiscali=d.id\n" +
                "left join sinistri s ON s.id_anagrafica=a.id\n" +
                "group by d.id;";

        try (Statement ps = connection.createStatement()) {

            ResultSet rs = ps.executeQuery(query);
            return rs;


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
}
