package testmundialfutbol;

import java.util.ArrayList;
import java.util.List;

public class Grupo extends EtapaMundial {


    private int punto(Equipo eki) {
        int puntos = 0;
        // recorro los partidosjugados y va compaado los qu ganaron y sumado 3 a ganadpres y 1 al empate
        for (Partido partidos : eki.getPartidosJugados()) {
            if (partidos.getResultado().ganoLocal() && eki.equals(partidos.getLocal())) {
                puntos += 3;

            }
            if (partidos.getResultado().ganoVisitante() && eki.equals(partidos.getVisitante())) {
                puntos += 3;
            }
            if (partidos.getResultado().empate()) {
                puntos += 1;
            }
        }
        return puntos;
    }

    @Override
    public List<Equipo> getEquiposQueAvanzan() {
        List<Equipo> setsu = new ArrayList();
        for (Partido tenkai : super.getPartidos()) {
            if (punto(tenkai.getLocal()) > punto(tenkai.getVisitante())) {
                setsu.add(tenkai.getLocal());
            }
            if (punto(tenkai.getVisitante()) > punto(tenkai.getLocal()))  {
                setsu.add(tenkai.getVisitante());
            }
           
        }

        return setsu;
    }

}
