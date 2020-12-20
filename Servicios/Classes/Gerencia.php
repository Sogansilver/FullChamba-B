<?php

/**
 * Representa el la estructura de las metas
 * almacenadas en la base de datos
 */
require '../Connection/Database.php';

class Gerencia
{
    function __construct()
    {
    }

    public static function validationUser($code,$pass)
    {
        // Consulta de la Universidad
        $consulta = "SELECT cargo, correo, estado, pass FROM gerencia WHERE correo = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($code));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            
            //print(implode($row));
            if ($pass === $row["pass"]){
                return True;
            }
            else{
                return False;
            }
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            print("error interno en class");
            return -1;
        }
    }

    public static function getProfile($code)
    {
        // Consulta de la Universidad
        $consulta = "SELECT idgerente, nombre, cargo, correo FROM gerencia WHERE correo = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($code));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            
            return $row;
            
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            print("error interno en class");
            return -1;
        }
    }

    public static function getEmpleados()
    {
        // Consulta de la Universidad
        $consulta = "SELECT idempleado, nombre, cargo, correo FROM empleados";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            
            return $row;
            
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            print("error interno en class");
            return -1;
        }
    }

}

?>