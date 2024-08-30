package org.example.infrastructure.database;

import org.example.domain.Proporcion;
import org.example.usecase.ProporcionRepository;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProporcionRepositoryImpl implements ProporcionRepository
{
    private static final String URL = "jdbc:postgresql://localhost:5432/Proporciones";
    private static final String USER = "postgres";
    private static final String PASSWORD = "TVOGVGmcl9xDmc21";

    @Override
    public Proporcion save(Proporcion proporcion)
    {
        String query = "INSERT INTO proporciones (total, medida1, medida2, separador) VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, proporcion.getTotal());
            preparedStatement.setInt(2, proporcion.getMedida1());
            preparedStatement.setInt(3, proporcion.getMedida2());
            preparedStatement.setInt(4, proporcion.getSeparador());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt("id");
                System.out.println("Proporción guardada con ID: " + generatedId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proporcion;
    }

    @Override
    public List<Proporcion> getAll()
    {
        String query = "SELECT * FROM proporciones";
        List<Proporcion> proporciones = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Iterar sobre cada fila del resultado
            while (resultSet.next()) {
                // Crear un nuevo objeto Proporcion y llenar sus campos
                Proporcion proporcion = new Proporcion();
                proporcion.setTotal(resultSet.getInt("total"));
                proporcion.setMedida1(resultSet.getInt("medida1"));
                proporcion.setMedida2(resultSet.getInt("medida2"));
                proporcion.setSeparador(resultSet.getInt("separador"));

                // Agregar el objeto Proporcion a la lista
                proporciones.add(proporcion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proporciones;
    }

    public Proporcion getProporcionById(int id) {
        String query = "SELECT * FROM proporciones WHERE id = ?";
        Proporcion proporcion = null;

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                proporcion = new Proporcion();
                proporcion.setTotal(resultSet.getInt("total"));
                proporcion.setMedida1(resultSet.getInt("medida1"));
                proporcion.setMedida2(resultSet.getInt("medida2"));
                proporcion.setSeparador(resultSet.getInt("separador"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return proporcion;
    }
}