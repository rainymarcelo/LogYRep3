
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        /*
        Hecho por Marcelo De la hoz Sierra
        CC 1037669479
         */

        MatrizEnTripleta[] mt = new MatrizEnTripleta[100];
        int mtk = 1;

        MatrizForma1[] mf1 = new MatrizForma1[100];
        int mf1k = 1;

        MatrizForma2[] mf2 = new MatrizForma2[100];
        int mf2k = 1;


        String menu = "Este programa due hecho por Marcelo De la hoz CC 1037669479\n" +
                "1.\tCrear matriz en tripletas\n" +
                "2.\tCrear matriz en forma 1\n" +
                "3.\tCrear matriz en forma 2\n" +
                "4.\tMostrar por pantalla matriz en tripletas\n" +
                "5.\tMostrar por pantalla matriz en tripletas como cuadrícula(tarea 1)\n" +
                "6.\tMostrar por pantalla matriz en forma 1 como cuadrícula(tarea 3)\n" +
                "7.\tMostrar por pantalla matriz en forma 2 como cuadrícula\n" +
                "8.\tEliminar dato en tripletas\n" +
                "9.\tEliminar dato en forma 1\n" +
                "10.\tEliminar dato en forma 2\n" +
                "11.\tAgregar dato en tripletas\n" +
                "12.\tAgregar dato en forma 1\n" +
                "13.\tAgregar dato en forma 2\n" +
                "14.\tSumar matrices(tarea 4)\n" +
                "15.\tRecorrer por columnas una matriz en tripletas(tarea 2)\n" +
                "16. Salir";

        String opcion;

        String menuSuma = "Todos los resultados de las sumas son matrices forma 2\n" +
                "1. Sumar matriz tripletas con matriz forma 1(tarea 4)\n" +
                "2. Sumar matriz tripletas con matriz forma 2\n" +
                "3. Sumar matriz forma1 con matriz forma 2\n" +
                "4. Volver";

        String opcion2;

        do {
            opcion = JOptionPane.showInputDialog(menu);

            switch (opcion) {

                case "1"://crea una matriz tripleta

                    int fila = Integer.parseInt(JOptionPane.showInputDialog("cantidad de filas de la matriz"));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("cantidad de columnas de la matriz"));
                    int datos = Integer.parseInt(JOptionPane.showInputDialog("cantidad de datos a ingresar a la matriz"));

                    Tripleta t = new Tripleta(fila, columna, 0);
                    MatrizEnTripleta matrizEnTripleta = new MatrizEnTripleta(t);

                    int k = 1;

                    while (k <= datos) {
                        int f = Integer.parseInt(JOptionPane.showInputDialog("filas del dato #" + k));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + k));
                        int v = Integer.parseInt(JOptionPane.showInputDialog("valor del dato #" + k));

                        if (f > fila || c > columna) {
                            JOptionPane.showMessageDialog(null, "Ingreso un valor de fila o columna mayor al de la matriz,\n" +
                                    "por favor vuelva a ingresar los valores de este dato");
                        }
                        if (matrizEnTripleta.datoExiste(f, c)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tmt = new Tripleta(f, c, v);
                            matrizEnTripleta.InsertarTripleta(tmt);
                            k++;
                        }
                    }

                    mt[mtk] = matrizEnTripleta;
                    mtk++;

                    JOptionPane.showMessageDialog(null, "matriz en cuadricula\n" + matrizEnTripleta.MostrarMatriz());
                    JOptionPane.showMessageDialog(null, matrizEnTripleta.mostrarMatrizTripleta());

                    break;

                case "2"://crea una matriz forma1

                    int filaf1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de filas de la matriz"));
                    int columnaf1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de columnas de la matriz"));
                    int datosf1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de datos a ingresar a la matriz"));

                    MatrizForma1 matrizForma1 = new MatrizForma1(filaf1, columnaf1);
                    matrizForma1.contruyeNodosCabeza();

                    int kf1 = 1;
                    while (kf1 <= datosf1) {
                        int f = Integer.parseInt(JOptionPane.showInputDialog("filas del dato #" + kf1));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + kf1));
                        int v = Integer.parseInt(JOptionPane.showInputDialog("valor del dato #" + kf1));

                        if (f > filaf1 || c > columnaf1) {
                            JOptionPane.showMessageDialog(null, "Ingreso un valor de fila o columna mayor al de la matriz,\n" +
                                    "por favor vuelva a ingresar los valores de este dato");
                        }
                        if (matrizForma1.datoExiste(f, c)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tmf1 = new Tripleta(f, c, v);
                            NodoDoble x = new NodoDoble(tmf1);
                            matrizForma1.conectaPorFila(x);
                            matrizForma1.conectaPorColumna(x);
                            kf1++;
                        }
                    }

                    mf1[mf1k] = matrizForma1;
                    mf1k++;

                    JOptionPane.showMessageDialog(null, matrizForma1.matrizCuadrada());
                    JOptionPane.showMessageDialog(null, matrizForma1.muestraMatriz());

                    break;

                case "3"://crea una matriz forma 2

                    int filaf2 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de filas de la matriz"));
                    int columnaf2 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de columnas de la matriz"));
                    int datosf2 = Integer.parseInt(JOptionPane.showInputDialog("cantidad de datos a ingresar a la matriz"));

                    MatrizForma2 matrizForma2 = new MatrizForma2(filaf2, columnaf2);

                    int kf2 = 1;
                    while (kf2 <= datosf2) {
                        int f = Integer.parseInt(JOptionPane.showInputDialog("filas del dato #" + kf2));
                        int c = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + kf2));
                        int v = Integer.parseInt(JOptionPane.showInputDialog("valor del dato #" + kf2));

                        if (f > filaf2 || c > columnaf2) {
                            JOptionPane.showMessageDialog(null, "Ingreso un valor de fila o columna mayor al de la matriz,\n" +
                                    "por favor vuelva a ingresar los valores de este dato");
                        }
                        if (matrizForma2.datoExiste(f, c)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tf2 = new Tripleta(f, c, v);
                            NodoDoble x = new NodoDoble(tf2);
                            matrizForma2.conectarPorFilasForma2(x);
                            matrizForma2.conectarPorColumnasForma2(x);
                            kf2++;
                        }
                    }

                    mf2[mf2k] = matrizForma2;
                    mf2k++;

                    JOptionPane.showMessageDialog(null, matrizForma2.matrizCuadrada());

                    break;

                case "4"://muestra la matriz tripleta

                    String mostrarTripleta = "";
                    for (int i = 0; i < mt.length; i++) {
                        if (mt[i] != null) {
                            mostrarTripleta += "matriz tripleta #" + i + "\n\n";
                            mostrarTripleta += mt[i].mostrarMatrizTripleta() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mostrarTripleta);

                    break;

                case "5"://muestra la matriz tripleta como cuadrada
                    String mostrarTripletaCuadrada = "";
                    for (int i = 0; i < mt.length; i++) {
                        if (mt[i] != null) {
                            mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                            mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mostrarTripletaCuadrada);

                    break;

                case "6"://Mostrar por pantalla matriz en forma 1 como cuadrícula

                    String mostrarForma1cuadrada = "";
                    for (int i = 0; i < mf1.length; i++) {
                        if (mf1[i] != null) {
                            mostrarForma1cuadrada += "matriz forma 1 #" + i + "\n\n";
                            mostrarForma1cuadrada += mf1[i].matrizCuadrada() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mostrarForma1cuadrada);

                    break;

                case "7"://Mostrar por pantalla matriz en forma 2 como cuadrícula

                    String mostrarForma2Cuadrada = "";
                    for (int i = 0; i < mf2.length; i++) {
                        if (mf2[i] != null) {
                            mostrarForma2Cuadrada += "matriz forma 2 #" + i + "\n\n";
                            mostrarForma2Cuadrada += mf2[i].matrizCuadrada() + "\n";
                        }
                    }
                    JOptionPane.showMessageDialog(null, mostrarForma2Cuadrada);

                    break;

                case "8"://Eliminar dato en tripletas

                    mostrarTripletaCuadrada = "Estas son las matrices en tripletas que ha creado\n" +
                            "seleccione a la que le va a eliminar el dato\n";
                    for (int i = 0; i < mt.length; i++) {
                        if (mt[i] != null) {
                            mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                            mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                        }
                    }
                    int eliminarmt = Integer.parseInt(JOptionPane.showInputDialog(mostrarTripletaCuadrada));
                    int eliminarCantidadmt = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a eliminar"));

                    for (int i = 1; i <= eliminarCantidadmt; i++) {
                        int eliminarmtF = Integer.parseInt(JOptionPane.showInputDialog("Fila del dato a eliminar"));
                        int eliminarmtC = Integer.parseInt(JOptionPane.showInputDialog("Columna del dato a eliminar"));

                        mt[eliminarmt].eliminarTripleta(eliminarmtF, eliminarmtC);
                    }
                    JOptionPane.showMessageDialog(null, mt[eliminarmt].MostrarMatriz());

                    break;

                case "9"://Eliminar dato en forma 1

                    mostrarForma1cuadrada = "Estas son las matrices en forma 1 que ha creado\n" +
                            "seleccione a la que le va a eliminar el dato\n";
                    for (int i = 0; i < mf1.length; i++) {
                        if (mf1[i] != null) {
                            mostrarForma1cuadrada += "matriz forma 1 #" + i + "\n\n";
                            mostrarForma1cuadrada += mf1[i].matrizCuadrada() + "\n";
                        }
                    }
                    int eliminarf1 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma1cuadrada));
                    int eliminarCantidadmf1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a eliminar"));

                    for (int i = 1; i <= eliminarCantidadmf1; i++) {
                        int eliminarmf1F = Integer.parseInt(JOptionPane.showInputDialog("Fila del dato a eliminar"));
                        int eliminarmf1C = Integer.parseInt(JOptionPane.showInputDialog("Columna del dato a eliminar"));

                        mf1[eliminarf1].eliminarDatofila(eliminarmf1F, eliminarmf1C);
                        mf1[eliminarf1].eliminarDatoColumna(eliminarmf1F, eliminarmf1C);
                    }

                    JOptionPane.showMessageDialog(null, mf1[eliminarf1].matrizCuadrada());

                    break;

                case "10"://Eliminar dato en forma 2

                    mostrarForma2Cuadrada = "Estas son las matrices en forma 2 que ha creado\n" +
                            "seleccione a la que le va a eliminar el dato\n";
                    for (int i = 0; i < mf2.length; i++) {
                        if (mf2[i] != null) {
                            mostrarForma2Cuadrada += "matriz forma 2 #" + i + "\n\n";
                            mostrarForma2Cuadrada += mf2[i].matrizCuadrada() + "\n";
                        }
                    }
                    int eliminarmf2 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma2Cuadrada));
                    int eliminarCantidadmf2 = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a eliminar"));

                    for (int i = 1; i <= eliminarCantidadmf2; i++) {
                        int eliminarmf2F = Integer.parseInt(JOptionPane.showInputDialog("Fila del dato a eliminar"));
                        int eliminarmf2C = Integer.parseInt(JOptionPane.showInputDialog("Columna del dato a eliminar"));

                        mf2[eliminarmf2].eliminaPorFilas(eliminarmf2F, eliminarmf2C);
                        mf2[eliminarmf2].eliminaPorColumnas(eliminarmf2F, eliminarmf2C);
                    }

                    JOptionPane.showMessageDialog(null, mf2[eliminarmf2].matrizCuadrada());

                    break;

                case "11"://agregar dato en tripletas

                    mostrarTripletaCuadrada = "Estas son las matrices en tripletas que ha creado\n" +
                            "seleccione a la que le va a agregar el dato\n";
                    for (int i = 0; i < mt.length; i++) {
                        if (mt[i] != null) {
                            mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                            mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                        }
                    }
                    int agregarmt = Integer.parseInt(JOptionPane.showInputDialog(mostrarTripletaCuadrada));
                    int agregarCantidadmt = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a ingresar"));

                    for (int i = 1; i <= agregarCantidadmt; i++) {
                        int filaAgregart = Integer.parseInt(JOptionPane.showInputDialog("fila del dato#" + i));
                        int columnaAgregart = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + i));
                        int valorAgregart = Integer.parseInt(JOptionPane.showInputDialog("valor dato #" + i));

                        if (mt[agregarmt].datoExiste(filaAgregart, columnaAgregart)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tamt = new Tripleta(filaAgregart, columnaAgregart, valorAgregart);
                            mt[agregarmt].InsertarTripleta(tamt);
                        }

                    }
                    JOptionPane.showMessageDialog(null, mt[agregarmt].MostrarMatriz());


                    break;

                case "12"://agregar dato en forma 1

                    mostrarForma1cuadrada = "Estas son las matrices en forma 1 que ha creado\n" +
                            "seleccione a la que le va a agregar el dato\n";
                    for (int i = 0; i < mf1.length; i++) {
                        if (mf1[i] != null) {
                            mostrarForma1cuadrada += "matriz forma 1 #" + i + "\n\n";
                            mostrarForma1cuadrada += mf1[i].matrizCuadrada() + "\n";
                        }
                    }
                    int agregarmf1 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma1cuadrada));
                    int agregarCantidadmf1 = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a ingresar"));

                    for (int i = 1; i <= agregarCantidadmf1; i++) {
                        int filaAgregarf1 = Integer.parseInt(JOptionPane.showInputDialog("fila del dato#" + i));
                        int columnaAgregarf1 = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + i));
                        int valorAgregarf1 = Integer.parseInt(JOptionPane.showInputDialog("valor dato #" + i));

                        if (mf1[agregarmf1].datoExiste(filaAgregarf1, columnaAgregarf1)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tamf1 = new Tripleta(filaAgregarf1, columnaAgregarf1, valorAgregarf1);
                            NodoDoble namf1 = new NodoDoble(tamf1);
                            mf1[agregarmf1].conectaPorFila(namf1);
                            mf1[agregarmf1].conectaPorColumna(namf1);
                        }


                    }
                    JOptionPane.showMessageDialog(null, mf1[agregarmf1].matrizCuadrada());

                    break;

                case "13"://agregar dato en forma 2

                    mostrarForma2Cuadrada = "Estas son las matrices en forma 2 que ha creado\n" +
                            "seleccione a la que le va a agregar el dato\n";
                    for (int i = 0; i < mf2.length; i++) {
                        if (mf2[i] != null) {
                            mostrarForma2Cuadrada += "matriz forma 2 #" + i + "\n\n";
                            mostrarForma2Cuadrada += mf2[i].matrizCuadrada() + "\n";
                        }
                    }
                    int agregarmf2 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma2Cuadrada));
                    int agregarCantidadmf2 = Integer.parseInt(JOptionPane.showInputDialog("cantidad datos a ingresar"));

                    for (int i = 1; i <= agregarCantidadmf2; i++) {
                        int filaAgregarf2 = Integer.parseInt(JOptionPane.showInputDialog("fila del dato#" + i));
                        int columnaAgregarf2 = Integer.parseInt(JOptionPane.showInputDialog("columna del dato #" + i));
                        int valorAgregarf2 = Integer.parseInt(JOptionPane.showInputDialog("valor dato #" + i));

                        if (mf2[agregarmf2].datoExiste(filaAgregarf2, columnaAgregarf2)) {
                            JOptionPane.showMessageDialog(null, "Ingreso unos valores de fila y columna que ya estan ocupados\n" +
                                    "por favor elimine el dato anterior antes  de ingresar el nuevo en la misma posicion");
                        } else {
                            Tripleta tamf2 = new Tripleta(filaAgregarf2, columnaAgregarf2, valorAgregarf2);
                            NodoDoble namf2 = new NodoDoble(tamf2);
                            mf2[agregarmf2].conectarPorFilasForma2(namf2);
                            mf2[agregarmf2].conectarPorColumnasForma2(namf2);
                        }
                    }
                    JOptionPane.showMessageDialog(null, mf2[agregarmf2].matrizCuadrada());

                    break;

                case "14"://sumar matrices

                    do {

                        opcion2 = JOptionPane.showInputDialog(menuSuma);

                        switch (opcion2) {

                            case "1"://suma tripleta con forma 1
                                mostrarTripletaCuadrada = "Estas son las matrices en tripletas que ha creado\n" +
                                        "seleccione a la que le va a sumar\n";
                                for (int i = 0; i < mt.length; i++) {
                                    if (mt[i] != null) {
                                        mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                                        mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                                    }
                                }
                                int sumamt = Integer.parseInt(JOptionPane.showInputDialog(mostrarTripletaCuadrada));

                                mostrarForma1cuadrada = "Estas son las matrices en forma 1 que ha creado\n" +
                                        "seleccione a la que le va a sumar\n";
                                for (int i = 0; i < mf1.length; i++) {
                                    if (mf1[i] != null) {
                                        mostrarForma1cuadrada += "matriz forma 1 #" + i + "\n\n";
                                        mostrarForma1cuadrada += mf1[i].matrizCuadrada() + "\n";
                                    }
                                }
                                int sumamf1 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma1cuadrada));

                                int fmt = mt[sumamt].retornaFila();
                                int cmt = mt[sumamt].retornaColumna();
                                int fmf1 = mf1[sumamf1].retornafila();
                                int cmf1 = mf1[sumamf1].retornaColumna();

                                if (fmt != fmf1 || cmt != cmf1) {
                                    JOptionPane.showMessageDialog(null, "las dimensiones de las matrices" +
                                            "son distintas, por lo que no se pueden sumar");
                                } else {
                                    MatrizForma2 resultadoSumamtYmf1 = mt[sumamt].sumaConForma1RetornaForma2(mf1[sumamf1]);
                                    mf2[mf2k] = resultadoSumamtYmf1;
                                    mf2k++;
                                    JOptionPane.showMessageDialog(null, mf2[mf2k - 1].matrizCuadrada());
                                }
                                break;

                            case "2"://suma tripleta con forma 2

                                mostrarTripletaCuadrada = "Estas son las matrices en tripletas que ha creado\n" +
                                        "seleccione a la que le va a sumar \n";
                                for (int i = 0; i < mt.length; i++) {
                                    if (mt[i] != null) {
                                        mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                                        mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                                    }
                                }
                                sumamt = Integer.parseInt(JOptionPane.showInputDialog(mostrarTripletaCuadrada));

                                mostrarForma2Cuadrada = "Estas son las matrices en forma 2 que ha creado\n" +
                                        "seleccione a la que le va a sumar \n";
                                for (int i = 0; i < mf2.length; i++) {
                                    if (mf2[i] != null) {
                                        mostrarForma2Cuadrada += "matriz forma 2 #" + i + "\n\n";
                                        mostrarForma2Cuadrada += mf2[i].matrizCuadrada() + "\n";
                                    }
                                }
                                int sumamf2 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma2Cuadrada));

                                fmt = mt[sumamt].retornaFila();
                                cmt = mt[sumamt].retornaColumna();
                                int fmf2 = mf2[sumamf2].retornaFila();
                                int cmf2 = mf2[sumamf2].retornaColumna();

                                if (fmt != fmf2 || cmt != cmf2) {
                                    JOptionPane.showMessageDialog(null, "las dimensiones de las matrices" +
                                            "son distintas, por lo que no se pueden sumar");
                                } else {
                                    MatrizForma2 resultadoSumamtYmf2 = mt[sumamt].sumaConForma2RetornaForma2(mf2[sumamf2]);
                                    mf2[mf2k] = resultadoSumamtYmf2;
                                    mf2k++;
                                    JOptionPane.showMessageDialog(null, mf2[mf2k - 1].matrizCuadrada());
                                }
                                break;

                            case "3":

                                mostrarForma1cuadrada = "Estas son las matrices en forma 1 que ha creado\n" +
                                        "seleccione a la que le va a sumar\n";
                                for (int i = 0; i < mf1.length; i++) {
                                    if (mf1[i] != null) {
                                        mostrarForma1cuadrada += "matriz forma 1 #" + i + "\n\n";
                                        mostrarForma1cuadrada += mf1[i].matrizCuadrada() + "\n";
                                    }
                                }
                                sumamf1 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma1cuadrada));

                                mostrarForma2Cuadrada = "Estas son las matrices en forma 2 que ha creado\n" +
                                        "seleccione a la que le va a sumar \n";
                                for (int i = 0; i < mf2.length; i++) {
                                    if (mf2[i] != null) {
                                        mostrarForma2Cuadrada += "matriz forma 2 #" + i + "\n\n";
                                        mostrarForma2Cuadrada += mf2[i].matrizCuadrada() + "\n";
                                    }
                                }
                                sumamf2 = Integer.parseInt(JOptionPane.showInputDialog(mostrarForma2Cuadrada));

                                fmf1=mf1[sumamf1].retornafila();
                                cmf1=mf1[sumamf1].retornaColumna();
                                fmf2=mf2[sumamf2].retornaFila();
                                cmf2=mf2[sumamf2].retornaColumna();
                                if (fmf1!=fmf2 || cmf1!=cmf2){
                                    JOptionPane.showMessageDialog(null, "las dimensiones de las matrices" +
                                            "son distintas, por lo que no se pueden sumar");
                                }
                                else{
                                    MatrizForma2 resultadoSumamtYmf2 = mf1[sumamf1].sumaForma1YForma2ResultadoForma2(mf2[sumamf2]);
                                    mf2[mf2k] = resultadoSumamtYmf2;
                                    mf2k++;
                                    JOptionPane.showMessageDialog(null, mf2[mf2k - 1].matrizCuadrada());
                                }

                                break;
                        }

                    } while (!"4".equals(opcion2));

                    break;

                case "15"://muestra matriz tripleta por columnas
                    mostrarTripletaCuadrada = "Estas son las matrices en tripletas que ha creado\n" +
                            "seleccione a la que le va a leer por columnas\n";
                    for (int i = 0; i < mt.length; i++) {
                        if (mt[i] != null) {
                            mostrarTripletaCuadrada += "matriz tripleta #" + i + "\n\n";
                            mostrarTripletaCuadrada += mt[i].MostrarMatriz() + "\n";
                        }
                    }
                    int traspuestamt = Integer.parseInt(JOptionPane.showInputDialog(mostrarTripletaCuadrada));

                    JOptionPane.showMessageDialog(null, mt[traspuestamt].Traspuesta().mostrarMatrizTripleta()
                            + "\n\n" + mt[traspuestamt].Traspuesta().MostrarMatriz());
                    break;

            }
        } while (!"16".equals(opcion));
    }
}
