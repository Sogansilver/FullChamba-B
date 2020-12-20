<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Tarea.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $idaccion=$datos->idaccion;
    $fechainicio=null;
    $fechafin=null;
    $idtarea=null;
    $listaTareas=null;
    switch ($idaccion) {
        case 1:
            # code...
            $fechainicio=$datos->fechainicio;
            $idtarea=$datos->idtarea;
            //ejecutar metodo
            $rpta = Tarea::updateFechainicioTarea($fechainicio,$idtarea);
        case 2:
            # code...
            $fechafin=$datos->fechafin;
            $idtarea=$datos->idtarea;
            //ejecutar metodo
            $rpta = Tarea::updateFechafinTarea($fechafin,$idtarea);
            break;
        case 3:
            # code...
            $duracion=$datos->duracion;
            $idtarea=$datos->idtarea;
            //ejecutar metodo
            $rpta = Tarea::updateDuracionTarea($duracion,$idtarea);
            break;
    }
    if ($rpta) {
        $dic["estado"] = "ok";
        $dic["mensaje"] = "funciono yeah, caso ";
        print json_encode($dic);    
    } else {
        print json_encode(array(
            "estado" => "no ok",
            "mensaje" => "Algo fallo, caso"
        ));
    }

    
}
?>