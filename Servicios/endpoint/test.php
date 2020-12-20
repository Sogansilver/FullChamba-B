<?php

if ($_SERVER['REQUEST_METHOD'] == 'GET') {
	if (isset($_GET["funcion1"]) && $_GET["funcion1"]==True) {
		try {
			$json = file_get_contents('php://input');
			$obj = json_decode($json);
			$numero = $obj->numero;	
			if ($numero=="1") {
		    	print("funciono perfecto :)");
		    }
		    if ($numero=="2") {
		    	$dic["dato1"] = 2;
        		$dic["dato2"] = "texto";
		    	print json_encode($dic);
		    }
		    else {
		        print("funciono pero no enviaste parametros json:( ");
		    }
		}
		catch (Exception $e) {
			print(e);
			print("NO FUNCIONO");
		}
	}
	else{

		//print("NO ENVIASTE EL KEY");
		$dic["dato1"] = 0;
        $dic["dato2"] = "texto";
		print json_encode([$dic,$dic]);
	}
	
}
else{
	if ($_SERVER['REQUEST_METHOD'] == 'POST') {
		
    	$json = file_get_contents ('php://input');
    	$datos = json_decode ($json);
    	$numero=$datos->numero;
    	if ($numero=="3") {
    		header('Content-Type: application/json');
    		echo json_encode(array(
    		   	"dato1"=> "2",
                "dato2"=> "texto"));
		}
	}
}
?>

