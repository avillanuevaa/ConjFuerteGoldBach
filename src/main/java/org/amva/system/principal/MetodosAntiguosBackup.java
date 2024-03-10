package org.amva.system.principal;

import org.amva.system.util.ConstantesUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static org.amva.system.util.ConstantesUtil.*;
import static org.amva.system.util.ConstantesUtil.obtienePrimosDesdeBDLong;

public class MetodosAntiguosBackup {


    public static void ALGOPRIMA01()
    {
        // Creamos el ArrayList
        List<Integer> P = new ArrayList<>();
        P.add(2);P.add(3);P.add(5);
        P.add(7);P.add(11);P.add(13);
        P.add(17);P.add(19);P.add(23);

        Integer N = 25, M=0;
        Integer NF = 183337;
        Integer NJ = ((int) Math.sqrt(NF));


        int K = 0, J = 0, I = 8, K0 = 0, K2=0, K1=0;
        System.out.println("NJ " + NJ);

        //System.out.println(ConstantesUtil.CARGO_TEXTO);
        try (
                BufferedWriter escritor = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+ConstantesUtil.PRIMBASEtxt));
                //BufferedWriter escritor2 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo2))
        )
        {
            while (N < NF)
            {
                N = N + 2;
                for (M = 1; M <= 2; M++) {//For M=1 to 2
                    N = N + 2; K = 1;
                    for (J = 2; J <= 8; J++){//For j=2 to 8
                        if (N % P.get(J) == 0) {
                            K = 0;
                            break;
                        }
                    }//END For j=2 to 8

                    if (K == 1) {
                        I = I + 1;
                        P.add(N);//P[I] = N;
                        if (P.get(I) < NJ + 1) {
                            K0 = I;
                        }
                    }
                }//END For M=1 to 2
            }//END while (N < NF)

            K2 = I;
            System.out.println("PRINT K2: " + K2);
            System.out.println("PRINT NF: " + NF);
            K = K0;

            for (J = 9; J <= K0; J++)
            {
                K1 = K + 1;
                N = P.get(J) * P.get(J);

                for (I = K1; I <= K2; I++) {
                    if (P.get(I) > 0) {
                        if (P.get(I) % P.get(J) == 0)
                        {
                            P.set(I,0);
                        }
                        else {
                            if (P.get(I) <= N) {
                                K = I;
                            }
                        }


                    }
                }//end for (I = K1; I <= K2; I++)
            }//END for (J = 9; J <= K0; J++)

            J = K0;
            K0 = K0 + 1;

            for (I = K0; I <= K2; I++) {
                N = P.get(I);
                if (N > 0) {
                    J = J + 1;
                    //REEMPLAZAR
                    P.set(J,N);
                }
            } //END For i= K0 to K2
            K2 = J;
            System.out.println("AFTER PRINT K2: " + K2);
            int x=0;
            for (int z = 0; z <=K2; z++)
            {x++;
                if(x<=1000){
                    escritor.write(P.get(z) + ";");
                }
                else{
                    x=0;
                    escritor.write(P.get(z) + ";\n");
                }

            }
        }
        catch (Exception ex)
        {System.out.println("Exception: " + ex.toString());}
    }

    public static void ALGOPRIMA02()
    {
        List<Integer> P =  new ArrayList<>();
        Integer NK, I;
        //lee la primera BD (txt)
        P = obtienePrimosDesdeBDInteger( ConstantesUtil.rutaResultados+ConstantesUtil.PRIMBASEtxt);
        NK = P.size()-1;
        I = NK;

        // P//vamos a leer de labase
        Integer NF = 18300001;
        Integer N = 183337, M = 0;
        int K = 0, J = 0, K0 = 0, K2 = 0, K1 = 0;

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+ PPRIMBAS001txt));
             //BufferedWriter escritor2 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo2))
        )
        {


            while (N < NF)
            {
                N = N + 2;

                for (M = 1; M <= 2; M++){//For M=1 to 2
                    N = N + 2; K = 1;

                    for (J = 2; J <= 80; J++){

                        if (N % P.get(J) == 0)
                        {
                            K = 0;
                            break;
                        }
                    }//END For j=2 to 80

                    if (K == 1)
                    {
                        I = I + 1;
                        P.add(N);//P[I] = N;

                    }
                }//END For M=1 to 2

            }//END while (N < NF)

            K2 = I;
            System.out.println("PRINT K2: " + (K2-NK));
            K = NK;

            for (J = 81; J <= 587; J++)
            {
                K1 = K + 1;
                N = P.get(J) * P.get(J);

                for (I = K1; I <= K2; I++)
                {
                    if (P.get(I) > 0)
                    {
                        if (P.get(I) % P.get(I) == 0)
                        {
                            P.set(I,0);

                        }
                        else
                        {
                            if (P.get(I) <= N)
                            {
                                K = I;
                            }
                        }


                    }
                }//end for (I = K1; I <= K2; I++)
            }//END for (J = 9; J <= K0; J++)

            J = NK;


            for (I = NK+1; I <= K2; I++)
            {
                N = P.get(I);
                if (N > 0)
                {
                    J = J + 1;
                    //REEMPLAZAR
                    P.set(J,N);
                }
            } //END For i= K0 to K2
            K2 = J;
            System.out.println("AFTER PRINT J-NK: " + (J-NK));


            int x=0;
            for (int z = 0; z <=K2; z++)
            {x++;
                if(x<=1000){
                    escritor.write(P.get(z) + ";");
                }
                else{
                    x=0;
                    escritor.write(P.get(z) + ";\n");
                }

            }


        }
        catch (Exception ex)
        {System.out.println("Exception: " + ex.toString());}


    }


    public static void ALGOPRIMA03_b()
    {
        List<Long> Q = new ArrayList<>();
        List<Long> P = new ArrayList<>();

        Long NF = 6000000001L;
        Long N = 18333001L;
        Long NJ = 0L;
        //lee la primera BD (txt)
        Q = obtienePrimosDesdeBDLong( ConstantesUtil.rutaResultados+ConstantesUtil.PPRIMBAS000txt);
        P.add(N);

        Long M =0L , K0 = 0L;

        int J=2,I=0,K2 = 0, K1 = 0,K = 0;

        try
                (BufferedWriter escritor = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+ConstantesUtil.PPRIMBAS001txt));
                 //BufferedWriter escritor2 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo2))
                )
        {
            while (N < NF)
            {
                N = N + 2;

                for (M = 1L; M <= 2; M++)
                {//For M=1 to 2
                    N = N + 2; K = 1;

                    for (J = 2; J <= 100; J++)
                    {

                        if (N % Q.get(J)== 0)
                        {
                            K = 0;
                            break;
                        }
                    }//END For j=2 to 80

                    if (K == 1)
                    {
                        I = I + 1;
                        P.add(N);//P[I] = N;
                        // System.out.println(N+";");
                    }
                }//END For M=1 to 2

            }//END while (N < NF)

            K2 = I;
            System.out.println("PRINT K2" + (K2));
            NJ = ((long) Math.sqrt(NF))+1;

            J = 101; K = 0;
            //pasarGarbageCollector();
            while (Q.get(J) < NJ)
            {
                K=J-1;
                N = Q.get(K) * Q.get(K);

                for (I = 1; I <= K2; I++) {
                    if (P.get(I) > 0) {//----
                        if (P.get(I) %Q.get(J)== 0)
                        {
                            P.set(I,0L);
                        }
                    }//---
                }  //END FOR
                J = J + 1;
            }//END WHILE
            J = 0;

            for (I = 1; I <= K2; I++)
            {
                N = P.get(I);
                if (N > 0)
                {
                    J = J + 1;
                    //REEMPLAZAR
                    P.set(J,N);
                }

            }// END FOR

            System.out.println("PRINT K2: " + (K2));
            K2 = J;

            int x=0;
            for (int z = 0; z <=K2; z++)
            {x++;
                if(x<=1000){
                    escritor.write(P.get(z) + ";");
                }
                else{
                    x=0;
                    escritor.write(P.get(z) + ";\n");
                }

            }

        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.toString());
        }


    }


    public static void ALGOPRIMA03_06_03_24()
    {
        List<Long> Q = new ArrayList<>();
        List<Long> P = new ArrayList<>();

        Long NF = 6000000001L;
        Long N = 18333001L;
        Long NJ = 0L;
        //lee la primera BD (txt)
        Q = obtienePrimosDesdeBDLong( ConstantesUtil.rutaResultados+ConstantesUtil.PPRIMBAS000txt);
        P.add(N);

        Long M =0L , K0 = 0L;

        int J=2,I=0,K2 = 0, K1 = 0,K = 0;

        try
                (BufferedWriter escritor = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+ConstantesUtil.PPRIMBAS001txt));
                 //BufferedWriter escritor2 = new BufferedWriter(new FileWriter(ConstantesUtil.rutaResultados+nomarchivo2))
                )
        {
            while (N < NF)
            {
                N = N + 2;

                for (M = 1L; M <= 2; M++)
                {//For M=1 to 2
                    N = N + 2; K = 1;

                    for (J = 2; J <= 100; J++)
                    {

                        if (N % Q.get(J)== 0)
                        {
                            K = 0;
                            break;
                        }
                    }//END For j=2 to 80

                    if (K == 1)
                    {
                        I = I + 1;
                        P.add(N);//P[I] = N;
                        // System.out.println(N+";");
                    }
                }//END For M=1 to 2

            }//END while (N < NF)

            K2 = I;
            System.out.println("PRINT K2" + (K2));
            NJ = ((long) Math.sqrt(NF))+1;

            J = 101; K = 0;
            //pasarGarbageCollector();
            while (Q.get(J) < NJ)
            {
                K1 = K + 1;
                N = Q.get(J) * Q.get(J);

                for (I = K1; I <= K2; I++) {
                    if (P.get(I) > 0) {//----
                        if (P.get(I) %Q.get(J)== 0)
                        {
                            P.set(I,0L);
                        }
                        else
                        {
                            if (P.get(I) <= N)
                            {
                                K = I;
                            }
                        }
                    }//---
                }  //END FOR
                J = J + 1;
            }//END WHILE
            J = 0;

            for (I = 1; I <= K2; I++)
            {
                N = P.get(I);
                if (N > 0)
                {
                    J = J + 1;
                    //REEMPLAZAR
                    P.set(J,N);
                }

            }// END FOR

            System.out.println("PRINT K2: " + (K2));
            K2 = J;

            int x=0;
            for (int z = 0; z <=K2; z++)
            {x++;
                if(x<=1000){
                    escritor.write(P.get(z) + ";");
                }
                else{
                    x=0;
                    escritor.write(P.get(z) + ";\n");
                }

            }

        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex.toString());
        }


    }
    public static void pasarGarbageCollector(){

        Runtime garbage = Runtime.getRuntime();
        garbage.gc();

    }




}
