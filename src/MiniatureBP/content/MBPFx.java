package MiniatureBP.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.Rand;
import arc.math.geom.Vec2;
import arc.util.Tmp;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.lineAngle;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.randLenVectors;
public class MBPFx {
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

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
    miniShockwave = new Effect(10.0F/3, 80.0F/3, (e) -> {
        Draw.color(Color.white, Color.lightGray, e.fin());
        Lines.stroke(e.fout() * 2.0F/3 + 0.2F);
        Lines.circle(e.x, e.y, e.fin() * 28.0F/3);
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
    }),

    miniRailShoot = new Effect(24.0F/3, (e) -> {
        e.scaled(10.0F/3, (b) -> {
            Draw.color(Color.white, Color.lightGray, b.fin());
            Lines.stroke(b.fout() * 1 + 0.2F);
            Lines.circle(b.x, b.y, b.fin() * 50.0F/3);
        });
        Draw.color(Pal.orangeSpark);

        for(int i : Mathf.signs) {
            Drawf.tri(e.x, e.y, 13.0F/3 * e.fout(), 85.0F/3, e.rotation + 90.0F * (float)i);
        }

    }),

    miniRailHit = new Effect(18.0F/3, 200.0F/3, (e) -> {
        Draw.color(Pal.orangeSpark);

        for(int i : Mathf.signs) {
            Drawf.tri(e.x, e.y, 10.0F/3 * e.fout(), 60.0F/3, e.rotation + 140.0F * (float)i);
        }

    }),

    miniRailTrail = new Effect(16.0F/3, (e) -> {
        Draw.color(Pal.orangeSpark);

        for(int i : Mathf.signs) {
            Drawf.tri(e.x, e.y, 10.0F/3 * e.fout(), 24.0F/3, e.rotation + 90.0F + 90.0F * (float)i);
        }

        Drawf.light(e.x, e.y, 60.0F/3 * e.fout(), Pal.orangeSpark, 0.5F);
    }),

    microExplosion = new Effect(10.0F, (e) -> {
        Draw.color(Pal.missileYellow);
        e.scaled(7.0F/3, (i) -> {
            Lines.stroke(i.fout());
            Lines.circle(e.x, e.y, 4.0F/3 + i.fin() * 10.0F);
        });
        Draw.color(Color.gray);
        Angles.randLenVectors((long)e.id, 8/3, 2.0F + 30.0F/3 * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 4.0F/3 + 0.5F));
        Draw.color(Pal.missileYellowBack);
        Lines.stroke(e.fout());
        Angles.randLenVectors((long)(e.id + 1), 6, 1.0F + 29.0F/3 * e.finpow(), (x, y) -> Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F + e.fout() * 4.0F/3));
        Drawf.light(e.x, e.y, 50.0F/3, Pal.missileYellowBack, 0.8F * e.fout());
    }),

    shootMini2 = new Effect(10.0F/3, (e) -> {
        Draw.color(Pal.lightOrange, Color.gray, e.fin());
        float w = 1.2F + 8.0F/3 * e.fout();
        Drawf.tri(e.x, e.y, w, 29.0F/3 * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, 5.0F/3 * e.fout(), e.rotation + 180.0F);
    }),

    casingMini = (new Effect(10.0F, (e) -> {
        Draw.color(Pal.lightOrange, Color.lightGray, Pal.lightishGray, e.fin());
        Draw.alpha(e.fout(0.1F));
        float rot = Math.abs(e.rotation) + 90.0F;
        int i = -Mathf.sign(e.rotation);
        float len = (2.0F/3 + e.finpow() * 2.0F) * (float)i;
        float lr = rot + e.fin() * 10.0F * (float)i;
        Fill.rect(e.x + Angles.trnsx(lr, len) + Mathf.randomSeedRange((long)(e.id + i + 7/3), e.fin()), e.y + Angles.trnsy(lr, len) + Mathf.randomSeedRange((long)(e.id + i + 8/3), e.fin()), 1.0F/3, 2.0F/3, rot + e.fin() * 50.0F * (float)i);
    })).layer(100.0F),

    shootMicro = new Effect(8.0F/3, (e) -> {
        Draw.color(Pal.lighterOrange, Pal.lightOrange, e.fin());
        float w = 1.0F/3 + 5.0F/3 * e.fout();
        Drawf.tri(e.x, e.y, w, 15.0F/3 * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, e.fout(), e.rotation + 180.0F);
    }),

    shootMircoSmoke = new Effect(20.0F/3, (e) -> {
        Draw.color(Pal.lighterOrange, Color.lightGray, Color.gray, e.fin());
        Angles.randLenVectors((long)e.id, 5, e.finpow() * 2.0F, e.rotation, 20.0F/3, (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 1.5F/3));
    }),

    hitBulletMirco = new Effect(14.0F/3, (e) -> {
        Draw.color(Color.white, Pal.lightOrange, e.fin());
        e.scaled(7.0F/3, (s) -> {
            Lines.stroke(0.5F/3 + s.fout());
            Lines.circle(e.x, e.y, s.fin() * 5.0F/3);
        });
        Lines.stroke(0.5F/3 + e.fout());
        Angles.randLenVectors((long)e.id, 5, e.fin() * 15.0F/3, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * 3.0F/3 + 1.0F/3);
        });
        Drawf.light(e.x, e.y, 20.0F/3, Pal.lightOrange, 0.6F * e.fout());
    }),

    hitMiniMeltHeal = new Effect(12.0F/3, (e) -> {
        Draw.color(Pal.heal);
        Lines.stroke(e.fout() * 2.0F/3);
        Angles.randLenVectors((long)e.id, 6, e.finpow() * 18.0F/3, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * 4.0F/3 + 1.0F/3);
        });
    }),

    miniShootHeal = new Effect(8.0F/3, (e) -> {
        Draw.color(Pal.heal);
        float w = 1.0F/3 + 5.0F/3 * e.fout();
        Drawf.tri(e.x, e.y, w, 17.0F/3 * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, 4.0F/3 * e.fout(), e.rotation + 180.0F);
    }),

    hitMiniEmpSpark = new Effect(40.0F/3, (e) -> {
        Draw.color(Pal.heal);
        Lines.stroke(e.fout() * 1.6F/3);
        Angles.randLenVectors((long)e.id, 18, e.finpow() * 27.0F/3, e.rotation, 360.0F, (x, y) -> {
            float ang = Mathf.angle(x, y);
            Lines.lineAngle(e.x + x, e.y + y, ang, e.fout() * 6.0F/3 + 1.0F/3);
        });
    }),

    tinyExplosion = new Effect(30.0F/3, (e) -> {
        Draw.color(Pal.missileYellow);
        e.scaled(7.0F/3, (i) -> {
            Lines.stroke(i.fout());
            Lines.circle(e.x, e.y, 4.0F/3 + i.fin() * 30.0F/3);
        });
        Draw.color(Color.gray);
        Angles.randLenVectors((long)e.id, 8, 2.0F/3 + 30.0F/3 * e.finpow(), (x, y) -> Fill.circle(e.x + x, e.y + y, e.fout() * 4.0F/3 + 0.5F/3));
        Draw.color(Pal.missileYellowBack);
        Lines.stroke(e.fout());
        Angles.randLenVectors((long)(e.id + 1), 6, 1.0F/3 + 29.0F/3 * e.finpow(), (x, y) -> Lines.lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1.0F/3 + e.fout() * 4.0F/3));
        Drawf.light(e.x, e.y, 50.0F/3, Pal.missileYellowBack, 0.8F * e.fout());
    }),

    shootSmokeMiniTitan = new Effect(70.0F/3, (e) -> {
        rand.setSeed((long)e.id);

        for(int i = 0; i < 13; ++i) {
            v.trns(e.rotation + rand.range(30.0F/3), rand.random(e.finpow() * 40.0F/3));
            e.scaled(e.lifetime * rand.random(0.3F/3, 1.0F), (b) -> {
                Draw.color(e.color, Pal.lightishGray, b.fin());
                Fill.circle(e.x + v.x, e.y + v.y, b.fout() * 3.4F/3 + 0.3F/3);
            });
        }

    }),

    shootMiniColor = new Effect(11.0F/3, (e) -> {
        Draw.color(e.color, Color.gray, e.fin());
        float w = 1.2F/3 + 9.0F/3 * e.fout();
        Drawf.tri(e.x, e.y, w, 32.0F/3 * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, e.fout(), e.rotation + 180.0F);
    }),

    shootSmokeSquareMini = new Effect(32.0F/3, (e) -> {
        Draw.color(Color.white, e.color, e.fin());
        rand.setSeed((long)e.id);

        for(int i = 0; i < 13; ++i) {
            float rot = e.rotation + rand.range(26.0F);
            v.trns(rot, rand.random(e.finpow() * 30.0F/3));
            Fill.poly(e.x + v.x, e.y + v.y, 4, e.fout() * 4.0F/3 + 0.2F/3, rand.random(360.0F));
        }

    }),

    miniArtilleryTrail = new Effect(50.0F/3, (e) -> {
        Draw.color(e.color);
        Fill.circle(e.x, e.y, e.rotation/3 * e.fout());
    }),

    miniArtilleryTrailSmoke = new Effect(50.0F/3, (e) -> {
        Draw.color(e.color);
        rand.setSeed((long)e.id);

        for(int i = 0; i < 13; ++i) {
            float fin = e.fin() / rand.random(0.5F, 1.0F);
            float fout = 1.0F - fin;
            float angle = rand.random(360.0F);
            float len = rand.random(0.5F, 1.0F);
            if (fin <= 1.0F) {
                Tmp.v1.trns(angle, fin * 24.0F/3 * len);
                Draw.alpha((0.5F/3 - Math.abs(fin - 0.5F/3)) * 2.0F/3);
                Fill.circle(e.x + Tmp.v1.x, e.y + Tmp.v1.y, 0.5F/3 + fout * 4.0F/3);
            }
        }

    });
}

    