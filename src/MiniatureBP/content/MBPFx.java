package MiniatureBP.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Mathf;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
public class MBPFx {
    public static final Effect
    miniFlakExplosion = new Effect(20, e -> {
        color(Pal.bulletYellow);

        e.scaled(6, i -> {
            stroke(i.fout());
            Lines.circle(e.x, e.y, 1f + i.fin() * 10f);
        });

        color(Color.gray);

        randLenVectors(e.id, 5, 2f + 7.66f * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() + 0.5f));

        color(Pal.lighterOrange);
        stroke(e.fout());

        randLenVectors(e.id + 1, 4, 1f + 7.66f * e.finpow(), (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout()));

        Drawf.light(e.x, e.y, 16.66f, Pal.lighterOrange, 0.8f * e.fout());
    }),

    miniBlastExplosion = new Effect(22, e -> {
        color(Pal.missileYellow);

        e.scaled(6, i -> {
            stroke(i.fout());
            Lines.circle(e.x, e.y, 1f + i.fin() * 15f);
        });

        color(Color.gray);

        randLenVectors(e.id, 5, 2f + 7.66f * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 1.33f + 0.5f));

        color(Pal.missileYellowBack);
        stroke(e.fout());

        randLenVectors(e.id + 1, 4, 1f + 7.66f * e.finpow(), (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout()));

        Drawf.light(e.x, e.y, 15f, Pal.missileYellowBack, 0.8f * e.fout());
    }),

    miniGreenLaserCharge = new Effect(80f, 100f, e -> {
        color(Pal.heal);
        stroke(e.fin());
        Lines.circle(e.x, e.y, 4f + e.fout() * 33.33f);

        Fill.circle(e.x, e.y, e.fin() * 6.66f);

        randLenVectors(e.id, 20, 13.33f * e.fout(), (x, y) -> {
            Fill.circle(e.x + x, e.y + y, e.fin() * 2f);
            Drawf.light(e.x + x, e.y + y, e.fin() * 5f, Pal.heal, 0.7f);
        });

        color();

        Fill.circle(e.x, e.y, e.fin() * 3.33f);
        Drawf.light(e.x, e.y, e.fin() * 6.66f, Pal.heal, 0.7f);
    }).followParent(true).rotWithParent(true),

    miniSapExplosion = new Effect(25, e -> {
        color(Pal.sapBullet);

        e.scaled(6, i -> {
            stroke(i.fout());
            Lines.circle(e.x, e.y, 3f + i.fin() * 26.66f);
        });

        color(Color.gray);

        randLenVectors(e.id, 9, 2f + 23.33f * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 1.33f + 0.5f));

        color(Pal.sapBulletBack);
        stroke(e.fout());

        randLenVectors(e.id + 1, 8, 1f + 20f * e.finpow(), (x, y) -> lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout()));

        Drawf.light(e.x, e.y, 30f, Pal.sapBulletBack, 0.8f * e.fout());
    });
}

    