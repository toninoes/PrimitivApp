package es.uca.primitivapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class AleatoriosPrimitiva {
    //Constantes que caracterizan al juego de la primitiva
    private final int TOTAL = 6;
    private final int DESDE = 1;
    private final int HASTA = 49;

    //Constantes para definir la prueba Suma de combinaciones ganadoras más frecuentes
    private final Integer SUM_MIN = 141;
    private final Integer SUM_MAX = 150;

    //Constante para la prueba de los ParesImpares
    private final Integer PARES = 3;

    //Constante para la prueba de los BajosAltos (Bajos(1-25) / Altos(26/50)) más frecuentes
    private final Integer BAJOS = 3;

    //Constante para la prueba de la MismaDecena
    private final Integer ELNUM = 2;
    private final Integer VECESELNUM = 2;

    //Constante para la prueba de las Terminaciones
    private final Integer TERDISTINTOS = 4;

    private ArrayList<Integer> combinacion;
    private Random numero;
    private Set<Integer> conjunto;
    private boolean Dec, Sum, Ter, Ba, Seg, Pi;


    /**
     * Constructor de números aleatorios de la primitiva.
     */
    public AleatoriosPrimitiva(boolean Dec, boolean Sum, boolean Ter, boolean Ba, boolean Seg, boolean Pi) {
        this.Dec = Dec;
        this.Sum = Sum;
        this.Ter = Ter;
        this.Ba = Ba;
        this.Seg = Seg;
        this.Pi = Pi;

        Long semilla = System.currentTimeMillis();
        do {
            combinacion = new ArrayList<>();
            numero = new Random(semilla);
            conjunto = new HashSet<>();

            while (conjunto.size() < TOTAL)
                conjunto.add(numero.nextInt(HASTA) + DESDE);

            semilla += System.currentTimeMillis();
            combinacion.addAll(conjunto);
            Collections.sort(combinacion);

        } while(!(BajosAltos(combinacion) && SumaCombinacion(combinacion) && ParesImpares(combinacion) &&
                  MismaDecena(combinacion) && NoSeguidos(combinacion) && TerminacionesDistintas(combinacion)));
    }


    /**
     * Devuelve la combinación de números aleatorios generado.
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getCombinacion() {
        return combinacion;
    }


    /**
     * Comprueba que el sumatorio de la combinación de números contenidos en C, esté
     * comprendido ente SUM_MIN y SUM_MAX.
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean SumaCombinacion(ArrayList<Integer> C) {
        if(Sum) {
            Integer suma = 0;
            for (Integer i : C)
                suma += i;

            return (suma >= SUM_MIN && suma <= SUM_MAX);
        } else
            return true;
    }


    /**
     * Comprueba que la combinación de números aleatorios C contenga PARES números pares y
     * por lo tanto TOTAL - PARES números impares.
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean ParesImpares(ArrayList<Integer> C) {
        if(Pi) {
            Integer pares = 0;
            for (Integer i : C)
                if (i % 2 == 0)
                    pares++;

            return (pares == PARES);
        } else
            return true;
    }


    /**
     * Comprueba que la combinación de numeros aleatorios C, contenga BAJOS numeros bajos y
     * por lo tanto TOTAL - BAJOS números altos.
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean BajosAltos(ArrayList<Integer> C) {
        if(Ba) {
            if (BAJOS == 0)
                return (C.get(BAJOS) >= 26);
            else if (BAJOS == 6)
                return (C.get(BAJOS - 1) <= 25);
            else
                return (C.get(BAJOS - 1) <= 25 && C.get(BAJOS) >= 26);
        } else
            return true;
    }

    /**
     * Comprueba que la combinación de numeros aleatorios C, contenga grupos de numeros que
     * se repitan en la misma decena
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean MismaDecena(ArrayList<Integer> C) {
        if(Dec) {
            Integer vecesElNum = 0;
            ArrayList<Integer> decenas = new ArrayList<>(5);

            for (int i = 0; i < 5; i++)
                decenas.add(0);

            for (Integer i : C) {
                if (i >= 0 && i <= 9)
                    decenas.set(0, decenas.get(0) + 1);
                else if (i >= 10 && i <= 19)
                    decenas.set(1, decenas.get(1) + 1);
                else if (i >= 20 && i <= 29)
                    decenas.set(2, decenas.get(2) + 1);
                else if (i >= 30 && i <= 39)
                    decenas.set(3, decenas.get(3) + 1);
                else if (i >= 40 && i <= 49)
                    decenas.set(4, decenas.get(4) + 1);
            }

            for (Integer i : decenas)
                if (i == ELNUM)
                    vecesElNum++;

            return (VECESELNUM == vecesElNum);
        } else
            return true;
    }


    /**
     * Comprueba que ninguno de los números de C sea consecutivo con el siguiente.
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean NoSeguidos(ArrayList<Integer> C) {
        if(Seg) {
            for (int i = 0; i < C.size() - 1; ++i)
                if (C.get(i) + 1 == C.get(i + 1))
                    return false;

            return true;
        } else
            return true;
    }


    /**
     * Comprueba que la combinación C tenga un número de terminaciones distintas igual a TERDISTINTOS
     * @param C ArrayList<Integer>
     * @return boolean
     */
    private boolean TerminacionesDistintas(ArrayList<Integer> C) {
        if(Ter) {
            ArrayList<Integer> terminaciones = new ArrayList<>(10);
            String numCad;
            char ultimaCifra;
            int terminacion, terDistintos = 0;
            for (int i = 0; i < 10; i++)
                terminaciones.add(0);

            for (Integer i : C) {
                numCad = i.toString();
                ultimaCifra = numCad.charAt(numCad.length() - 1);
                terminacion = Character.getNumericValue(ultimaCifra);
                terminaciones.set(terminacion, terminaciones.get(terminacion) + 1);
            }

            for (Integer i : terminaciones)
                if (i == 1)
                    terDistintos++;

            return (TERDISTINTOS == terDistintos);
        } else
            return true;
    }
}