package data_structure.binary_search.graph.bfs.generic;

import data_structure.graph.bfs.generic.Graph;
import data_structure.graph.bfs.generic.State;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class StateGraphTest {

    @Test
    void shouldVerifyIfTwoStatesAreLinked() {
        final var ac = State.builder().name("AC").build();
        final var al = State.builder().name("AL").build();
        final var ap = State.builder().name("AP").build();
        final var am = State.builder().name("AM").build();
        final var ba = State.builder().name("BA").build();
        final var ce = State.builder().name("CE").build();
        final var df = State.builder().name("DF").build();
        final var es = State.builder().name("ES").build();
        final var go = State.builder().name("GO").build();
        final var ma = State.builder().name("MA").build();
        final var mt = State.builder().name("MT").build();
        final var ms = State.builder().name("MS").build();
        final var mg = State.builder().name("MG").build();
        final var pa = State.builder().name("PA").build();
        final var pb = State.builder().name("PB").build();
        final var pr = State.builder().name("PR").build();
        final var pe = State.builder().name("PE").build();
        final var pi = State.builder().name("PI").build();
        final var rj = State.builder().name("RJ").build();
        final var rn = State.builder().name("RN").build();
        final var rs = State.builder().name("RS").build();
        final var ro = State.builder().name("RO").build();
        final var rr = State.builder().name("RR").build();
        final var sc = State.builder().name("SC").build();
        final var sp = State.builder().name("SP").build();
        final var se = State.builder().name("SE").build();
        final var to = State.builder().name("TO").build();

        ac.setNeighbors(Arrays.asList(am, ro));
        al.setNeighbors(Arrays.asList(se, pe, ba));
        ap.setNeighbors(Collections.singletonList(pa));
        am.setNeighbors(Arrays.asList(ac, ro, rr, pa, mt));
        ba.setNeighbors(Arrays.asList(se, al, pe, pi, to, go, mg, es));
        ce.setNeighbors(Arrays.asList(pi, pe, pb, rn));
        df.setNeighbors(Arrays.asList(go, mg));
        es.setNeighbors(Arrays.asList(ba, mg, rj));
        go.setNeighbors(Arrays.asList(df, mg, ba, to, mt, ms));
        ma.setNeighbors(Arrays.asList(pa, to, pi));
        mt.setNeighbors(Arrays.asList(ro, am, pa, to, go, ms));
        ms.setNeighbors(Arrays.asList(mt, go, mg, sp, pr));
        mg.setNeighbors(Arrays.asList(ms, go, df, ba, es, rj, sp));
        pa.setNeighbors(Arrays.asList(ap, am, ma, to, mt, rr));
        pb.setNeighbors(Arrays.asList(rn, ce, pe));
        pr.setNeighbors(Arrays.asList(ms, sp, sc));
        pe.setNeighbors(Arrays.asList(ce, pb, al, ba, pi));
        pi.setNeighbors(Arrays.asList(ma, to, ba, pe, ce));
        rj.setNeighbors(Arrays.asList(es, mg, sp));
        rn.setNeighbors(Arrays.asList(ce, pb));
        rs.setNeighbors(Collections.singletonList(sc));
        ro.setNeighbors(Arrays.asList(ac, am, mt));
        rr.setNeighbors(Arrays.asList(am, pa));
        sc.setNeighbors(Arrays.asList(pr, rs));
        sp.setNeighbors(Arrays.asList(mg, rj, pr, ms));
        se.setNeighbors(Arrays.asList(ba, al));
        to.setNeighbors(Arrays.asList(pa, ma, pi, ba, go, mt));

        final var graph = new Graph();
        graph.add(Arrays.asList(ac, al, ap, am, ba, ce, df, es, go, ma, mt, ms, mg, pa, pb, pr, pe, pi, rj, rn, rs, ro, rr, sc, sp, se, to));

        var response = graph.isLinked(ac, sp);
        Assertions.assertTrue(response);

        System.out.println("-----");
        response = graph.isLinked(rs, ce);
        Assertions.assertTrue(response);

        System.out.println("-----");
        response = graph.isLinked(ba, ac);
        Assertions.assertTrue(response);
    }
}
