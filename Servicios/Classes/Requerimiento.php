<?php

/**
 * Representa el la estructura de las metas
 * almacenadas en la base de datos
 */
require '../Connection/Database.php';

class Empleado
{
    function __construct()
    {
    }
    /*
    public static function getHorarioEst($codEst)
    {
        $consulta = "SELECT h.diaSem, h.horIni, h.horFin, s.lug, c.nomCur,c.color FROM horario h JOIN seccion s ON h.numSec=s.numSec JOIN registroseccion r ON r.numSec=s.numSec JOIN curso c ON c.codCur=s.codCur WHERE r.codEst=?";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($codEst));
            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            print("error en la consulta");
            return -1;
        }
    }

    public static function getNotesSection($codEst,$seccion)
    {
        $consulta = "SELECT listaNotas FROM `regnotas` WHERE codEst=? AND numSec=?";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($codEst,$seccion));
            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            print("error en la consulta");
            return -1;
        }
    }

    public static function getAllCourse($codEst)
    {   
        $consulta = "SELECT e.codEst, r.numSec, s.lug, c.nomCur, d.nomDoc FROM estudiante e JOIN registroseccion r ON e.codEst=r.codEst JOIN seccion s ON r.numSec=s.numSec JOIN docente d ON d.codDoc=s.codDoc JOIN curso c ON c.codCur=s.codCur WHERE e.codEst=?";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($codEst));
            return $comando->fetchAll(PDO::FETCH_ASSOC);

        } catch (PDOException $e) {
            print("error en la consulta");
            return -1;
        }
    }
    
    public static function getProfile($codEst)
    {
        // Consulta de la Universidad
        $consulta = "SELECT e.codEst, e.nomEst, COUNT(r.codRegSec) AS curEst FROM estudiante e JOIN registroseccion r ON e.codEst=r.codEst WHERE e.codEst = ?";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($codEst));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            
            //print(implode($row));
            if ($row){
                return $row;
            }
            else{
                print("respuesta vacia");
                return -2;
            }
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            print("error interno en class");
            return -1;
        }
    }
    */
    public static function validationUser($code,$pass)
    {
        // Consulta de la Universidad
        $consulta = "SELECT idempleado, nombre, pass FROM empleados WHERE idempleado = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($code));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            
            //print(implode($row));
            if ($pass === $row["pass"]){
                return true;
            }
            else{
                return false;
            }
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            print("error interno en class");
            return -1;
        }
    }

    /*
    public static function getByCode($code)
    {
        // Consulta de la Universidad
        $consulta = "SELECT codEst,
                            nomEst,
                            WHERE codEst = ?";

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
            return -1;
        }
    }
    */
}

?>