package org.example;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.hibernate.HibernateUtil;
import org.example.validator.ClientValidator;
import org.example.validator.PlanetValidator;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    static Logger log;
    private static Planet currentPlanet = null;
    private static Client NewClient(String name) {
        Client client = new Client();
        client.setName(name);
        ClientValidator clientValidator = new ClientValidator();
        List<String> errorList = clientValidator.validateClient(client);
        if (!errorList.isEmpty()) {
            errorList.forEach(e -> log.error(e, client.toString()));
            return null;
        } else {
            return client;
        }
    }
    private static Planet NewPlanet(String pid, String name) {
        Planet planet = new Planet();
        planet.setId(pid);
        planet.setName(name);
        PlanetValidator planetValidator = new PlanetValidator();
        List<String> errorList = planetValidator.validatePlanet(planet);
        if (!errorList.isEmpty()) {
            errorList.forEach(e -> log.error(e, planet.toString()));
            return null;
        } else {
            currentPlanet = planet;
            return planet;
        }
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
        log = HibernateUtil.getLogger();

        /** Instantiates each entity for CrudService */
        ClientCrudService clientDao = new ClientCrudService();
        PlanetCrudService planetDao = new PlanetCrudService();

        /** Attempting to create a new customer record with an invalid value */
        /** довжина поля name не відповідає потребі */
        clientDao.insertClient(NewClient("PE"));

        /** Create a new record of client with valid name */
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

        /** Attempting to create a new "Planet" with an invalid value ID */
        planetDao.insertPlanet(NewPlanet("del111","18 Delphini b"));

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
