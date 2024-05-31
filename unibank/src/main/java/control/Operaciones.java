package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class Operaciones {

    public void agregarClienteDB(Cliente cliente) {

        Connection conexion = ConexionDB.getConnection();
        try {
            String insercion = "INSERT INTO banco.clientes (identificacion, nombre1, nombre2, apellido) VALUES(?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insercion);

            // Establece los valores de los parámetros
            preparedStatement.setString(1, cliente.getId());
            preparedStatement.setString(2, cliente.getNombre1());
            preparedStatement.setString(3, cliente.getNombre2());
            preparedStatement.setString(4, cliente.getApellido());

            System.out.println("Parametros para agregar cliente:");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre1: " + cliente.getNombre1());
            System.out.println("Nombre2: " + cliente.getNombre2());
            System.out.println("Apellido: " + cliente.getApellido());

            // Ejecuta la inserción
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cliente agregado exitosamente a la base de datos.");
            } else {
                System.err.println("Error al agregar cliente a la base de datos.");
            }

            preparedStatement.close();

        } catch (Exception e) {
            System.err.println("Error al agregar cliente: " + e.getMessage());
        }

        ConexionDB.closeConnection(conexion);
    }

    public int obtenerPKCliente(Cliente cliente) {
        Connection conexion = ConexionDB.getConnection();
        int consecutivo = -1;
        try {
            String query = "SELECT consecutivo FROM banco.clientes WHERE identificacion = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, cliente.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                consecutivo = resultSet.getInt("consecutivo");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            System.err.println("Error al obtener consecutivo: " + e.getMessage());
        }

        ConexionDB.closeConnection(conexion);
        return consecutivo;
    }

    public void agregarCuentaDB(Cuenta cuenta) {

        Connection conexion = ConexionDB.getConnection();
        try {
            String insercion = "INSERT INTO banco.cuentas (numeroCuenta, cliente, saldo) VALUES(?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(insercion);

            // Establece los valores de los parámetros
            preparedStatement.setInt(1, cuenta.getNumCuenta());
            preparedStatement.setInt(2, cuenta.getCliente().getConsecutivo());
            preparedStatement.setDouble(3, cuenta.getSaldo());

            System.out.println("Parametros para agregar cuenta:");
            System.out.println("NumeroCuenta: " + cuenta.getNumCuenta());
            System.out.println("Cliente PK: " + cuenta.getCliente().getConsecutivo());
            System.out.println("Saldo: " + cuenta.getSaldo());

            // Ejecuta la inserción
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Cuenta agregada exitosamente a la base de datos.");
            } else {
                System.err.println("Error al agregar cuenta a la base de datos.");
            }

            preparedStatement.close();

        } catch (Exception e) {
            System.err.println("Error al agregar cuenta: " + e.getMessage());
        }

        ConexionDB.closeConnection(conexion);
    }

    public boolean verificarExisteCuenta(int numCuenta) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionDB.getConnection();
            String query = "SELECT COUNT(*) AS count FROM banco.cuentas WHERE numeroCuenta = ?";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, numCuenta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0;
            }
        } catch (Exception e) {
            System.err.println("Error al verificar la existencia de la cuenta: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar el resultSet: " + e.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar el preparedStatement: " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
        return false;
    }

    public Datos obtenerDatosCuenta(int numCuenta) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Datos datos = null;

        try {
            conexion = ConexionDB.getConnection();
            String query = "SELECT c.numeroCuenta, c.saldo, cl.nombre1, cl.nombre2, cl.apellido " +
                    "FROM banco.cuentas c " +
                    "JOIN banco.clientes cl ON c.cliente = cl.consecutivo " +
                    "WHERE c.numeroCuenta = ?";
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, numCuenta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String nombre1 = resultSet.getString("nombre1");
                String nombre2 = resultSet.getString("nombre2");
                String apellido = resultSet.getString("apellido");
                int numeroCuenta = resultSet.getInt("numeroCuenta");
                double saldo = resultSet.getDouble("saldo");

                datos = new Datos(nombre1, nombre2, apellido, numeroCuenta, saldo);
            } else {
                System.out.println("No se encontraron datos para el número de cuenta proporcionado.");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener los datos de la cuenta: " + e.getMessage());
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar el resultSet: " + e.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar el preparedStatement: " + e.getMessage());
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (Exception e) {
                    System.err.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return datos;
    }

    public boolean consignar(double ingreso, int numCuenta) {
        Connection conexion = ConexionDB.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String consignacion = "UPDATE banco.cuentas SET saldo=saldo + ? WHERE numeroCuenta=?";
            preparedStatement = conexion.prepareStatement(consignacion);
            preparedStatement.setDouble(1, ingreso);
            preparedStatement.setInt(2, numCuenta);

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (Exception e) {
            System.err.println("Error al actualizar saldo: " + e.getMessage());
            return false;
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conexion != null)
                    ConexionDB.closeConnection(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean retirar(double retiro, int numCuenta) {
        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionDB.getConnection();
            String consultaSaldo = "SELECT saldo FROM banco.cuentas WHERE numeroCuenta=?";
            preparedStatement = conexion.prepareStatement(consultaSaldo);
            preparedStatement.setInt(1, numCuenta);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double saldoActual = resultSet.getDouble("saldo");

                if (saldoActual >= retiro) {
                    resultSet.close();
                    preparedStatement.close();

                    String retiroSQL = "UPDATE banco.cuentas SET saldo=saldo - ? WHERE numeroCuenta=?";
                    preparedStatement = conexion.prepareStatement(retiroSQL);
                    preparedStatement.setDouble(1, retiro);
                    preparedStatement.setInt(2, numCuenta);

                    int filasAfectadas = preparedStatement.executeUpdate();

                    return filasAfectadas > 0;
                } else {
                    System.err.println("Saldo insuficiente para realizar el retiro.");
                    return false;
                }
            } else {
                System.err.println("Cuenta no encontrada.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error al actualizar saldo: " + e.getMessage());
            return false;
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (conexion != null)
                    ConexionDB.closeConnection(conexion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
