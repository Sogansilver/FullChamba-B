<?php

/**
 * Representa el la estructura de las metas
 * almacenadas en la base de datos
 */
require '../Connection/Database.php';

class Tarea
{
    function __construct()
    {
    }
    
    public static function getTareaEmpleado($iduser)
    {
        // Consulta de la Universidad
        $consulta = "SELECT titulo, idtarea, fechainicio, fechafin, duracion, estado 
                    FROM `tareas` 
                    WHERE idempleado=?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($iduser));
            // Capturar primera fila del resultado
            $rows = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $rows;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function updateFechainicioTarea($fechainicio, $idtarea)
    {
        // Consulta de la Universidad
        $consulta = "UPDATE Tareas 
                    SET fechainicio=?,estado='En proceso'
                    WHERE idtarea=?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $ok = $comando->execute(array($fechainicio,$idtarea));
            return $ok;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }

    public static function updateFechafinTarea($fechafin,$idtarea)
    {
        // Consulta de la Universidad
        $consulta = "UPDATE Tareas 
                    SET fechafin=?,estado='Finalizada'
                    WHERE idtarea=?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $ok=$comando->execute(array($fechafin,$idtarea));
            return $ok;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }

    public static function updateDuracionTarea($duracion,$idtarea)
    {   

        // Consulta de la Universidad
        $consulta = "SELECT duracion  
                    FROM Tareas
                    WHERE idtarea=?";
        $tiempotarea=0;
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($idtarea));
            // Capturar primera fila del resultado
            $row = $comando->fetch(PDO::FETCH_ASSOC);
            $tiempotarea = $row["duracion"];

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -2;
        }

        if(is_null($tiempotarea)){
            $tiempotarea=0;
        }
        else{
            $tiempotarea=intval($duracion)+$tiempotarea;
        }

        $consulta = "UPDATE Tareas 
                    SET duracion=?
                    WHERE idtarea=?";
        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $ok=$comando->execute(array($tiempotarea,$idtarea));
            return $ok;
        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }

    public static function insertarTarea($idtarea,$tit,$est,$pri,$des,$idreq,$idemp){
        // Consulta de la Universidad
        $consulta = "INSERT INTO 
                    Tareas(idtarea, titulo, estado, prioridad, descripcion,idrequerimiento,idempleado)
                    VALUES (?,?,?,?,?,?,?)";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $ok=$comando->execute(array($idtarea,$tit,$est,$pri,$des,$idreq,$idemp));
            return $ok;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }

    public static function eliminarTarea($idtarea){
        // Consulta de la Universidad
        $consulta = "DELETE FROM Tareas
                    WHERE idtarea = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $ok=$comando->execute(array($idtarea));
            return $ok;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
}

?>