package org.example;

import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.hibernate.HibernateUtil;
import org.slf4j.Logger;

import java.util.List;

public class Main {
    private static Planet currentPlanet = null;
    private static Client NewClient(String name) {
        Client client = new Client();
        client.setName(name);
        return client;
    }
    private static Planet NewPlanet(String pid, String name) {
        Planet planet = new Planet();
        planet.setId(pid);
        planet.setName(name);
        currentPlanet = planet;
        return planet;
    }
    private static Planet EditPlanet(Planet planet, String newPid, String newName) {
        planet = (planet != null)? planet: new Planet();
        if (newPid != null) {
            planet.setId(newPid);
        }
        if (newName != null) {
            planet.setName(newName);
        }
        currentPlanet = planet;
        return planet;
    }

    public static void main(String[] args) {
        Logger log = HibernateUtil.getLogger();

        /** Instantiates each entity for CrudService */
        ClientCrudService clientDao = new ClientCrudService();
        PlanetCrudService planetDao = new PlanetCrudService();

        /** Create a new record of client */
        clientDao.insertClient(NewClient("Pablo Escobar"));

        /** Selects a list of 'Clients' by name 'Bush' */
        List<Client> clientsList = clientDao.getClientsByName("Bush");
        clientsList.forEach(client -> log.info("client name like 'Bush' ==> {}", client));

        /** Selects all list of 'Clients' */
        clientsList = clientDao.getClients();
        clientsList.forEach(client -> log.info("client list ==> {}", client));

        /** Deleting Client by name 'Pablo' */
        clientsList = clientDao.getClientsByName("Pablo");
        clientsList.forEach(client -> clientDao.deleteClientById(client.getId()));

        /** Insert a new Gas Giant exoplanet discovered in 2008 - wiki */
        planetDao.insertPlanet(NewPlanet("DEL111","18 Delphini b"));

        /** !!! Updating the entity Planet ID from "DEL111" to "DEL112" creates a new record !!! */
        planetDao.updatePlanet(EditPlanet(currentPlanet,"DEL112", null));

        /** but Updating the entity Planet NAME from "18 Delphini b" to "new Delphini js" keeps this record */
        planetDao.updatePlanet(EditPlanet(currentPlanet,null, "new Delphini js"));

        /** Select all list of planets*/
        List<Planet> planetsList = planetDao.getPlanets();
        planetsList.forEach(planet -> log.info("planet list ==> {}", planet));

        /** Delete some planet by name like Delphini*/
        planetsList = planetDao.getPlanetsByName("Delphini");
        planetsList.forEach(planet -> planetDao.deletePlanetById(planet.getId()));
    }
}
