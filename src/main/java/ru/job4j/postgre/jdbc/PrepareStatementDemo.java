package ru.job4j.postgre.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrepareStatementDemo implements AutoCloseable {

    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    public void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "password";
        connection = DriverManager.getConnection(url, login, password);
    }

    public void insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public City insertOutCity(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement("insert into cities(name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(3));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteAll() {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities")) {
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public void printListCity() {
        for (var elm : findAll()) {
            System.out.println(elm);
        }

    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo prepareStatementDemo = new PrepareStatementDemo();
        City cityUfa = new City(1, "Ufa", 1125933);
        City cityKras = new City(2, "Krasnodar", 948827);
        City cityMsk = new City(2, "Москва", 12655050);
//        System.out.println(cityKras);
        prepareStatementDemo.deleteAll();
        prepareStatementDemo.insert(cityUfa);
        prepareStatementDemo.insert(cityKras);
        prepareStatementDemo.insert(cityMsk);
        prepareStatementDemo.printListCity();
        prepareStatementDemo.insertOutCity(cityMsk);
        System.out.println("--------------------------");
        System.out.println(cityMsk);
        System.out.println("--------------------------");
        prepareStatementDemo.printListCity();
        System.out.println("--------------------------");
        cityKras.setName("Ekatirinadar");
        cityKras.setId(125);
        prepareStatementDemo.update(cityKras);
        prepareStatementDemo.printListCity();
        System.out.println("--------------------------");
        prepareStatementDemo.delete(126);
        prepareStatementDemo.printListCity();
        System.out.println("--------------------------");
        prepareStatementDemo.close();
    }
}

class City {

    private int id;

    private String name;

    private int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return population + " " + id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return id == city.id && population == city.population && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, population);
    }
}