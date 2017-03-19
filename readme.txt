EI_GT	=> Carpeta referente a la preparaci�n de datos, generaci�n y entrenamiento de modelos de clasificaci�n de genes GT
		1Datos => 1 Archivo de datos positivos y 1 Directorio de datos negativos (ambos en formato .txt)
		2Datos Formato Arff EI => Archivo que mezcla datos positivos y negativos con el debido formato ARFF
		3Entrenamiento => Porci�n de datos de entrenamiento
		4Modelos => Modelos generados con el WEKA explorer usando los datos de las fases anteriores
		5Prediccon => Porci�n de los datos de prueba

IE_AG	=> Carpeta referente a la preparaci�n de datos, generaci�n y entrenamiento de modelos de clasificaci�n de genes AG
		1Datos => 1 Archivo de datos positivos y 1 Directorio de datos negativos (ambos en formato .txt)
		2Datos Formato Arff AG => Archivo que mezcla datos positivos y negativos con el debido formato ARFF
		3Entrenamiento => Porci�n de datos de entrenamiento
		4Modelos => Modelos generados con el WEKA explorer usando los datos de las fases anteriores
		5Prediccon => Porci�n de los datos de prueba
	
libreria => Jar de Weka 3.5.6 que es la version compatible con la herramienta

results  => Directorio de archivos de salida de la herramienta. Patr�n de nombre: Gen Seleccionado-Modelo Empleado-Estampa de tiempo.txt

src 	 => Paquetes de archivos fuentes:
		Archivos: Utiler�a para manipulaci�n de archivos (LeerArchivo, EscribirArchivo)
		ClasificadorSinGUI: Herramienta de clasificaci�n
			Clasificador.java => Clase Principal con metodo main que crea un objeto clasificador y llama al metodo ClasificarTXT para obtener como resultado los genes clasificados
			ClasificadorADN.java => Todos los m�todos que implican el proceso de clasificaci�n con funciones weka usando los modelos entrenados a trav�s de java

test 	 => Directorio de Archivo de Prueba. Actualmente se lee gen_SST.txt

Happy Hacking!