package MiniatureBP.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Rect;
import mindustry.ai.types.DefenderAI;
import mindustry.ai.types.FlyingFollowAI;
import mindustry.ai.types.HugAI;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.content.UnitTypes;
import mindustry.entities.Effect;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ExplosionEffect;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.part.DrawPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.part.ShapePart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.ErekirUnitType;
import mindustry.type.unit.MissileUnitType;
import mindustry.type.unit.NeoplasmUnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.BlockFlag;

public class MBPMinis {
    public static UnitType
    //Serpulo
    miniReign,miniCorvus,miniToxopid,miniEclipse,miniOct,miniOmura,miniNavanax,
    //Serpulo Misc
    miniFlare,
    //Erekir
    miniConquer,miniCollaris,miniDisrupt,miniLatum,
    //Erekir Misc
    miniRenale;
    public static void load(){

        miniReign = new UnitType("mini-reign"){{
            localizedName = "Baby Reign";
            speed = 0.6f;
            hitSize = 26f / 3f;
            rotateSpeed = 1.65f;
            health = 24000 / 3f;
            armor = 18f / 3f;
            mechStepParticles = true;
            stepShake = 0.75f / 3f;
            drownTimeMultiplier = 6f;
            mechFrontSway = 1.9f / 3f;
            mechSideSway = 0.6f / 3f;
            constructor = MechUnit::create;
            ammoType = new ItemAmmoType(Items.thorium);

            weapons.add(
                    new Weapon("mini-boi-mini-reign-weapon"){{
                        top = false;
                        y = 1f / 3f;
                        x = 5f;
                        shootY = 11f / 3f;
                        reload = 9f;
                        recoil = 5f / 3f;
                        shake = 2f / 3f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.bang;

                        bullet = new BasicBulletType(13f / 3f, 40){{
                            pierce = true;
                            pierceCap = 10;
                            width = 14f / 3f;
                            height = 33f / 3f;
                            lifetime = 30f / 3f;
                            shootEffect = Fx.shootSmall;
                            fragVelocityMin = 0.4f;

                            hitEffect = MBPFx.miniBlastExplosion;
                            splashDamage = 18f;
                            splashDamageRadius = 13f / 3f;

                            fragBullets = 3;
                            fragLifeMin = 0f;
                            fragRandomSpread = 30f;

                            fragBullet = new BasicBulletType(9f / 3f, 10){{
                                width = 10f / 3f;
                                height = 10f / 3f;
                                pierce = true;
                                pierceBuilding = true;
                                pierceCap = 3;

                                lifetime = 40f / 3f;
                                hitEffect = MBPFx.miniFlakExplosion;
                                splashDamage = 15f;
                                splashDamageRadius = 10f / 3f;
                            }};
                        }};
                    }}

            );
        }};

        miniCorvus = new UnitType("mini-corvus"){{
            localizedName = "Baby Corvus";
            hitSize = 29f / 3f;
            health = 18000f / 3f;
            armor = 9f / 3f;
            stepShake = 1.5f / 3f;
            rotateSpeed = 1.5f;
            drownTimeMultiplier = 6;
            legCount = 4;
            legLength = 4;
            legBaseOffset = 3;
            legMoveSpace = 1.5f;
            legForwardScl = 0.58f;
            hovering = true;
            shadowElevation = 0.2f / 3f;

            constructor = LegsUnit::create;
            ammoType = new PowerAmmoType(4000 / 3f);
            groundLayer = Layer.legUnit;

            speed = 0.5f;

            drawShields = false;

            weapons.add(new Weapon("mini-boi-mini-corvus-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 0.8f;
                top = false;
                mirror = false;
                shake = 14f / 3f;
                shootY = 5f / 3f;
                x = y = 0;
                reload = 300f;
                recoil = 0f;

                cooldownTime = 300f;

                shootStatusDuration = 60f * 2f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = MBPFx.miniGreenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new LaserBulletType(){{
                    length = 460f / 3f;
                    damage = 200;
                    width = 75f / 3f;

                    lifetime = 65f / 3f;

                    lightningSpacing = 35f / 3f;
                    lightningLength = 5 / 3;
                    lightningDelay = 1.1f / 3f;
                    lightningLengthRand = 15 / 3;
                    lightningDamage = 50 / 3f;
                    lightningAngleRand = 40f / 3f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = MBPFx.miniGreenLaserCharge;

                    healPercent = 25f / 3f;
                    collidesTeam = true;

                    sideAngle = 15f / 3f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};

        miniToxopid = new UnitType("mini-toxopid"){{
            localizedName = "Baby Toxopid";
            drag = 0.1f;
            speed = 0.6f;
            hitSize = 26f / 3f;
            health = 7300f;
            armor = 4;
            lightRadius = 140f / 3f;

            rotateSpeed = 1.9f;
            drownTimeMultiplier = 3f;

            legCount = 8;
            legMoveSpace = 0.9f;
            legLength = 19;
            legExtension = -5;
            legBaseOffset = 2;
            stepShake = 1;
            legLengthScl = 0.93f;
            rippleScale = 3;
            legSpeed = 0.2f;
            ammoType = new ItemAmmoType(Items.graphite, 4);

            legSplashDamage = 1;
            legSplashRange = 6;

            hovering = true;
            shadowElevation = 0.95f / 3f;
            groundLayer = Layer.legUnit;
            constructor = LegsUnit::create;

            weapons.add(
                    new Weapon("mini-boi-mini-purple-mount"){{
                        y = -5f / 3f;
                        x = 11f / 3f;
                        shootY = 7f / 3f;
                        reload = 30;
                        shake = 4f / 3f;
                        rotateSpeed = 2f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.shootBig;
                        rotate = true;
                        shadow = 12f / 3f;
                        recoil = 1.0f;

                        shoot = new ShootSpread(2, 17f / 3f);

                        bullet = new ShrapnelBulletType(){{
                            length = 90f / 3f;
                            damage = 40;
                            width = 25f / 3f;
                            serrationLenScl = 7f / 3f;
                            serrationSpaceOffset = 60f / 3f;
                            serrationFadeOffset = 0f;
                            serrations = 10 / 3;
                            serrationWidth = 6f / 3f;
                            fromColor = Pal.sapBullet;
                            toColor = Pal.sapBulletBack;
                            shootEffect = smokeEffect = Fx.sparkShoot;
                        }};
                    }});

            weapons.add(new Weapon("mini-boi-mini-toxopid-cannon"){{
                y = -14f / 3f;
                x = 0f;
                shootY = 22f / 3f;
                mirror = false;
                reload = 210;
                shake = 10f / 3f;
                recoil = 10f / 3f;
                rotateSpeed = 1f;
                ejectEffect = Fx.casing2;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 30f / 3f;

                rotationLimit = 80f;

                bullet = new ArtilleryBulletType(1, 16){{
                    hitEffect = MBPFx.miniSapExplosion;
                    knockback = 0.8f / 3f;
                    lifetime = 80f;
                    width = height = 25f / 3f;
                    collidesTiles = collides = true;
                    ammoMultiplier = 4f / 3f;
                    splashDamageRadius = 80f / 3f;
                    splashDamage = 75f / 3f;
                    backColor = Pal.sapBulletBack;
                    frontColor = lightningColor = Pal.sapBullet;
                    lightning = 2;
                    lightningLength = 20 / 3;
                    smokeEffect = Fx.shootBigSmoke2;
                    hitShake = 10f / 3f;
                    lightRadius = 40f / 3f;
                    lightColor = Pal.sap;
                    lightOpacity = 0.6f / 3f;

                    status = StatusEffects.sapped;
                    statusDuration = 60f * 10;

                    fragLifeMin = 0.1f;
                    fragBullets = 9;

                    fragBullet = new ArtilleryBulletType(2.3f, 10){{
                        hitEffect = MBPFx.miniSapExplosion;
                        knockback = 0.8f / 3f;
                        lifetime = 40f;
                        width = height = 20f / 3f;
                        collidesTiles = false;
                        splashDamageRadius = 70f / 3f;
                        splashDamage = 40f / 3f;
                        backColor = Pal.sapBulletBack;
                        frontColor = lightningColor = Pal.sapBullet;
                        lightning = 2;
                        lightningLength = 5 / 3;
                        smokeEffect = Fx.shootBigSmoke2;
                        hitShake = 5f / 3f;
                        lightRadius = 30f / 3f;
                        lightColor = Pal.sap;
                        lightOpacity = 0.5f;

                        status = StatusEffects.sapped;
                        statusDuration = 60f * 10;
                    }};
                }};
            }});
        }};

        miniFlare = new UnitType("mini-flare"){{
            localizedName = "Baby Flare";
            engineSize = 2.5F/3;
            outlineRadius = 1;
            speed = 2.7F;
            accel = 0.08F;
            drag = 0.04F;
            flying = true;
            health = 23;
            engineOffset = 5.75F/3;
            hitSize = 9.0F/3;
            itemCapacity = 10;
            targetFlags = new BlockFlag[]{BlockFlag.generator, null};
            constructor = UnitEntity::create;
            weapons.add(new Weapon(){{
                y = 0.0F;
                x = 2.0F/3;
                reload = 20.0F;
                shootY = 1;
                ejectEffect = MBPFx.casingMini;
                bullet = new BasicBulletType(2.5F/3, 9.0F/3){{
                    width = 7.0F/3;
                    height = 9.0F/3;
                    lifetime = 35.0F;
                    hitEffect = MBPFx.hitBulletMirco;
                    despawnEffect = MBPFx.hitBulletMirco;
                    shootEffect = MBPFx.shootMicro;
                    smokeEffect = MBPFx.shootMircoSmoke;
                    ammoMultiplier = 2.0F;
                }};
                shootSound = Sounds.pew;
            }});
        }};

        miniEclipse = new UnitType("mini-eclipse"){{
            localizedName = "Baby Eclipse";
                speed = 0.54F;
                accel = 0.04F;
                drag = 0.04F;
                rotateSpeed = 1.0F;
                flying = true;
                lowAltitude = true;
                health = 7300;
                engineOffset = 38.0F/3;
                engineSize = 7.3F/3;
                hitSize = 58.0F/3;
                armor = 4;
                constructor = UnitEntity::create;
                targetFlags = new BlockFlag[]{BlockFlag.reactor, BlockFlag.battery, BlockFlag.core, null};
                ammoType = new ItemAmmoType(Items.thorium);
                final BulletType fragBullet = new FlakBulletType(4.0F/3, 15.0F/3){{
                    shootEffect = Fx.shootBig;
                    hitEffect = MBPFx.miniFlakExplosion;
                    explodeRange = 10.0F;
                    width = 8.0F/3;
                    height = 10.0F/3;
                    ammoMultiplier = 4.0F;
                    splashDamage = 65.0F/3;
                    splashDamageRadius = 25.0F/3;
                    collidesGround = true;
                    lifetime = 47.0F;
                    status = StatusEffects.blasted;
                    statusDuration = 60.0F/3;
                }};
                weapons.add(new Weapon("mini-boi-mini-laser-mount"){{
                        shake = 4.0F/3;
                        shootY = 9.0F/3;
                        x = 18.0F/3;
                        y = 5.0F/3;
                        rotateSpeed = 2.0F;
                        reload = 45.0F;
                        recoil = 4.0F/3;
                        shootSound = Sounds.laser;
                        shadow = 20.0F/3;
                        rotate = true;
                        bullet = new LaserBulletType(){{
                            damage = 40;
                            sideAngle = 20.0F/3;
                            sideWidth = 1.5F/3;
                            sideLength = 80.0F/3;
                            width = 25.0F/3;
                            length = 230.0F/3;
                            shootEffect = MBPFx.miniShockwave;
                            colors = new Color[]{Color.valueOf("ec7458aa"), Color.valueOf("ff9c5a"), Color.white};
                        }};
                    }},
                    new Weapon("mini-boi-mini-artillery"){{
                        x = 11.0F/3;
                        y = 27.0F/3;
                        rotateSpeed = 2.0F;
                        reload = 9.0F;
                        shootSound = Sounds.shoot;
                        shadow = 7.0F/3;
                        rotate = true;
                        recoil = 0.5F/3;
                        shootY = 7.25F/3;
                        bullet = fragBullet;
                    }},
                    new Weapon("mini-boi-mini-artillery"){{
                        y = -13.0F/3;
                        x = 20.0F/3;
                        reload = 12.0F;
                        ejectEffect = Fx.casing1;
                        rotateSpeed = 7.0F;
                        shake = 1.0F/3;
                        shootSound = Sounds.shoot;
                        rotate = true;
                        shadow = 12.0F/3;
                        shootY = 7.25F/3;
                        bullet = fragBullet;
                    }}
                );
            }
        };
        miniOct = new UnitType("mini-oct"){{
            localizedName = "Baby Oct";
            aiController = DefenderAI::new;
            constructor = PayloadUnitLegacyOct::create;
            armor = 5;
            health = 24000.0F/3;
            speed = 0.8F;
            rotateSpeed = 1.0F;
            accel = 0.04F;
            drag = 0.018F;
            flying = true;
            engineOffset = 46.0F/3;
            engineSize = 7.8F/3;
            faceTarget = false;
            hitSize = 66.0F/3;
            payloadCapacity = 1936.0F/3;
            buildSpeed = 4.0F/3;
            drawShields = false;
            lowAltitude = true;
            buildBeamOffset = 43.0F/3;
            ammoCapacity = 1;
            abilities.add(new ForceFieldAbility(140.0F/3, 4.0F/3, 2300, 480.0F/3, 8, 0.0F), new RepairFieldAbility(40F, 120.0F, 140.0F/3));
        }};
        miniOmura = new UnitType("mini-omura") {{
            localizedName = "Baby Omura";
            health = 7300;
            speed = 0.62F;
            drag = 0.18F;
            hitSize = 58.0F/3;
            armor = 5;
            accel = 0.19F;
            rotateSpeed = 0.9F;
            faceTarget = false;
            ammoType = new PowerAmmoType(4000.0F/3);
            constructor = UnitWaterMove::create;
            float spawnTime = 900.0F/3;
            abilities.add(new UnitSpawnAbility(miniFlare, spawnTime, 19.25F/3, -31.75F/3), new UnitSpawnAbility(miniFlare, spawnTime, -19.25F/3, -31.75F/3));
            trailLength = 70/3;
            waveTrailX = 23.0F/3;
            waveTrailY = -32.0F/3;
            trailScl = 3.5F/3;
            weapons.add(new Weapon("mini-boi-mini-omura-cannon") {{
                reload = 110.0F;
                cooldownTime = 90.0F;
                mirror = false;
                x = 0.0F;
                y = -3.5F/3;
                rotateSpeed = 1.4F;
                rotate = true;
                shootY = 23.0F/3;
                shake = 6.0F/3;
                recoil = 10.5F/3;
                shadow = 50.0F/3;
                shootSound = Sounds.railgun;
                ejectEffect = Fx.none;
                bullet = new RailBulletType() {{
                    shootEffect = MBPFx.miniRailShoot;
                    length = 500.0F/3;
                    pointEffectSpace = 60.0F/3;
                    pierceEffect = MBPFx.miniRailHit;
                    pointEffect = MBPFx.miniRailTrail;
                    hitEffect = MBPFx.microExplosion;
                    smokeEffect = MBPFx.shootMini2;
                    damage = 420;
                    pierceDamageFactor = 0.5F/3;
                }};
            }});
        }};

        miniNavanax = new UnitType("mini-navanax") {{
            localizedName = "Baby Navanax";
            health = 6600;
            speed = 0.65F;
            drag = 0.17F;
            hitSize = 58.0F/3;
            armor = 5;
            accel = 0.2F;
            rotateSpeed = 1.1F;
            faceTarget = false;
            ammoType = new PowerAmmoType(4500.0F/3);
            trailLength = 70/3;
            waveTrailX = 23.0F/3;
            waveTrailY = -32.0F/3;
            trailScl = 3.5F/3;
            buildSpeed = 3.5F/3;
            constructor = UnitWaterMove::create;

                for(final float mountY : new float[]{-29.25F/3, 12.5F/3}) {
                    int[] var6 = Mathf.signs;
                    int var7 = var6.length;

                    for(int var8 = 0; var8 < var7; ++var8) {
                        final float sign = (float)var6[var8];
                        weapons.add(new Weapon("mini-boi-mini-plasma-laser-mount") {{
                            shadow = 20.0F/3;
                            controllable = false;
                            autoTarget = true;
                            mirror = false;
                            shake = 3.0F/3;
                            shootY = 7.0F/3;
                            rotate = true;
                            x = 21.0F/3 * sign;
                            y = mountY;
                            targetInterval = 20.0F;
                            targetSwitchInterval = 35.0F;
                            rotateSpeed = 3.5F;
                            reload = 170.0F;
                            recoil = 1.0F/3;
                            shootSound = Sounds.beam;
                            continuous = true;
                            cooldownTime = reload;
                            immunities.add(StatusEffects.burning);
                            bullet = new ContinuousLaserBulletType() {{
                                maxRange = 90.0F/3;
                                damage = 27.0F/3;
                                length = 95.0F/3;
                                hitEffect = MBPFx.hitMiniMeltHeal;
                                drawSize = 200.0F/3;
                                lifetime = 155.0F/3;
                                shake = 1.0F/3;
                                shootEffect = MBPFx.miniShootHeal;
                                smokeEffect = Fx.none;
                                width = 4.0F/3;
                                largeHit = false;
                                incendChance = 0.01F;
                                incendSpread = 5.0F/3;
                                incendAmount = 1/3;
                                healPercent = 0.4F/3;
                                collidesTeam = true;
                                colors = new Color[]{Pal.heal.cpy().a(0.2F), Pal.heal.cpy().a(0.5F), Pal.heal.cpy().mul(1.2F), Color.white};
                            }};
                        }});
                    }
                }

                weapons.add(new Weapon("mini-boi-mini-emp-cannon-mount") {{
                    rotate = true;
                    x = 17.5F/3;
                    y = -6.5F/3;
                    reload = 65.0F;
                    shake = 3.0F/3;
                    rotateSpeed = 2.0F;
                    shadow = 30.0F/3;
                    shootY = 7.0F/3;
                    recoil = 4.0F/3;
                    cooldownTime = reload - 10.0F;
                    shootSound = Sounds.laser;
                    bullet = new EmpBulletType() {{
                        float rad = 100.0F/3;
                        scaleLife = true;
                        lightOpacity = 0.7F;
                        unitDamageScl = 0.8F;
                        healPercent = 20.0F/3;
                        timeIncrease = 3.0F/3;
                        timeDuration = 1200.0F;
                        powerDamageScl = 3.0F;
                        damage = 60.0F/3;
                        hitColor = lightColor = Pal.heal;
                        lightRadius = 70.0F/3;
                        clipSize = 250.0F/3;
                        shootEffect = MBPFx.hitMiniEmpSpark;
                        smokeEffect = MBPFx.shootMircoSmoke;
                        lifetime = 40F;
                        sprite = "circle-bullet";
                        backColor = Pal.heal;
                        frontColor = Color.white;
                        width = height = 12.0F/3;
                        shrinkY = 0.0F;
                        speed = 5.0F/3;
                        trailLength = 20/3;
                        trailWidth = 6.0F/3;
                        trailColor = Pal.heal;
                        trailInterval = 3.0F/3;
                        splashDamage = 70.0F/3;
                        splashDamageRadius = rad;
                        hitShake = 4.0F/3;
                        trailRotation = true;
                        status = StatusEffects.electrified;
                        hitSound = Sounds.plasmaboom;
                        trailEffect = new Effect(16.0F/3, (e) -> {
                            Draw.color(Pal.heal);
                            for(int s : Mathf.signs) {
                                Drawf.tri(e.x, e.y, 4.0F/3, 30.0F/3 * e.fslope(), e.rotation + 90.0F * (float)s);
                            }
                        });
                        hitEffect = new Effect(50.0F/3, 100.0F/3, (e) -> {
                            e.scaled(7.0F/3, (b) -> {
                                Draw.color(Pal.heal, b.fout());
                                Fill.circle(e.x, e.y, rad);
                            });
                            Draw.color(Pal.heal);
                            Lines.stroke(e.fout());
                            Lines.circle(e.x, e.y, rad);
                            int points = 10;
                            float offset = Mathf.randomSeed((long)e.id, 360.0F);
                            for(int i = 0; i < points; ++i) {
                                float angle = (float)i * 360.0F / (float)points + offset;
                                Drawf.tri(e.x + Angles.trnsx(angle, rad), e.y + Angles.trnsy(angle, rad), 6.0F/3, 50.0F/3 * e.fout(), angle);
                            }
                            Fill.circle(e.x, e.y, 12.0F/3 * e.fout());
                            Draw.color();
                            Fill.circle(e.x, e.y, 6.0F/3 * e.fout());
                            Drawf.light(e.x, e.y, rad * 1.6F/3, Pal.heal, e.fout());
                        });
                    }};
                }});
            }
        };


        //erekir
        miniConquer = new TankUnitType("mini-conquer") {
            {
                localizedName = "Baby Conquer";
                constructor = TankUnit::create;
                hitSize = 46.0F/3;
                treadPullOffset = 1/3;
                speed = 0.48F;
                health = 7300;
                armor = 8;
                crushDamage = 5.0F/3;
                rotateSpeed = 0.8F;
                float xo = 115.5F/3;
                float yo = 115.5F/3;
                treadRects = new Rect[]{new Rect(27.0F/3 - xo, 152.0F/3 - yo, 56.0F/3, 73.0F/3), new Rect(24.0F/3 - xo, 42.0F/3 - yo, 29.0F/3, 17.0F/3), new Rect(59.0F/3 - xo, 9.0F/3 - yo, 39.0F/3, 19.0F/3)};
                weapons.add(new Weapon("mini-boi-mini-conquer-weapon") {
                    {
                        shootSound = Sounds.largeCannon;
                        layerOffset = 0.1F;
                        reload = 100.0F;
                        shootY = 32.5F/3;
                        shake = 5.0F/3;
                        recoil = 5.0F/3;
                        rotate = true;
                        rotateSpeed = 0.6F;
                        mirror = false;
                        x = 0.0F;
                        y = -2.0F/3;
                        shadow = 50.0F/3;
                        heatColor = Color.valueOf("f9350f");
                        shootWarmupSpeed = 0.06F;
                        cooldownTime = 110.0F;
                        heatColor = Color.valueOf("f9350f");
                        minWarmup = 0.9F;
                        parts.addAll(new DrawPart[]{new RegionPart("-glow") {
                            {
                                color = Color.red;
                                blending = Blending.additive;
                                outline = mirror = false;
                            }
                        }, new RegionPart("-sides") {
                            {
                                progress = PartProgress.warmup;
                                mirror = true;
                                under = true;
                                moveX = 0.75F/3;
                                moveY = 0.75F/3;
                                moveRot = 82.0F;
                                x = 9.25F/3;
                                y = 2.0F/3;
                            }
                        }, new RegionPart("-sinks") {
                            {
                                progress = PartProgress.warmup;
                                mirror = true;
                                under = true;
                                heatColor = new Color(1.0F, 0.1F, 0.1F);
                                moveX = 4.25F/3;
                                moveY = -3.75F/3;
                                x = 8.0F/3;
                                y = -8.5F/3;
                            }
                        }, new RegionPart("-sinks-heat") {
                            {
                                blending = Blending.additive;
                                progress = PartProgress.warmup;
                                mirror = true;
                                outline = false;
                                colorTo = new Color(1.0F, 0.0F, 0.0F, 0.5F);
                                color = colorTo.cpy().a(0.0F);
                                moveX = 4.25F/3;
                                moveY = -3.75F/3;
                                x = 8.0F/3;
                                y = -8.5F/3;
                            }
                        }});

                        for(int i = 1; i <= 3; ++i) {
                            int finalI = i;
                            parts.add(new RegionPart("-blade") {
                                {
                                    progress = PartProgress.warmup.delay((float)(3 - finalI) * 0.3F).blend(PartProgress.reload, 0.3F);
                                    heatProgress = PartProgress.heat.add(0.3F).min(PartProgress.warmup);
                                    heatColor = new Color(1.0F, 0.1F, 0.1F);
                                    mirror = true;
                                    under = true;
                                    moveRot = -40.0F * (float) finalI;
                                    moveX = 1F;
                                    layerOffset = -0.002F;
                                    x = 2.75F/3;
                                }
                            });
                        }

                        bullet = new BasicBulletType(8.0F, 360.0F/3) {
                            {
                                sprite = "missile-large";
                                width = 12.0F/3;
                                height = 20.0F/3;
                                lifetime = 35.0F/3;
                                hitSize = 6.0F/3;
                                smokeEffect = MBPFx.shootSmokeMiniTitan;
                                pierceCap = 3;
                                pierce = true;
                                pierceBuilding = true;
                                hitColor = backColor = trailColor = Color.valueOf("feb380");
                                frontColor = Color.white;
                                trailWidth = 4.0F/3;
                                trailLength = 9/3;
                                hitEffect = despawnEffect = MBPFx.tinyExplosion;
                                shootEffect = new ExplosionEffect() {
                                    {
                                        lifetime = 40.0f/3;
                                        waveStroke = 4.0F/3;
                                        waveColor = sparkColor = trailColor;
                                        waveRad = 15.0F/3;
                                        smokeSize = 5.0F/3;
                                        smokes = 8;
                                        smokeSizeBase = 0.0F;
                                        smokeColor = trailColor;
                                        sparks = 8;
                                        sparkRad = 40.0F/3;
                                        sparkLen = 4.0F/3;
                                        sparkStroke = 3.0F/3;
                                    }
                                };
                                int count = 6;

                                for(int j = 0; j < count; ++j) {
                                    final int s = j;

                                    for(final int i : Mathf.signs) {
                                        final float fin = 0.05F + (float)(j + 1) / (float)count;
                                        float spd = speed;
                                        final float life = lifetime / Mathf.lerp(fin, 1.0F, 0.5F);
                                        spawnBullets.add(new BasicBulletType(spd * fin, 60.0F/3) {
                                            {
                                                drag = 0.002F;
                                                width = 12.0F/3;
                                                height = 11.0F/3;
                                                lifetime = life + 5.0F;
                                                weaveRandom = false;
                                                hitSize = 5.0F/3;
                                                pierceCap = 2;
                                                pierce = true;
                                                pierceBuilding = true;
                                                hitColor = backColor = trailColor = Color.valueOf("feb380");
                                                frontColor = Color.white;
                                                trailWidth = 2.5F/3;
                                                trailLength = 7/3;
                                                weaveScale = (2.0F + (float)s / 2.0F) / 1.2F;
                                                weaveMag = (float)i * (3.0F - fin * 2.0F);
                                                splashDamage = 65.0F/3;
                                                splashDamageRadius = 30.0F/3;
                                                despawnEffect = new ExplosionEffect() {
                                                    {
                                                        lifetime = 50.0F/3;
                                                        waveStroke = 4.0F/3;
                                                        waveColor = sparkColor = trailColor;
                                                        waveRad = 30.0F/3;
                                                        smokeSize = 7.0F/3;
                                                        smokes = 6;
                                                        smokeSizeBase = 0.0F;
                                                        smokeColor = trailColor;
                                                        sparks = 5;
                                                        sparkRad = 30.0F/3;
                                                        sparkLen = 3.0F/3;
                                                        sparkStroke = 1.5F/3;
                                                    }
                                                };
                                            }
                                        });
                                    }
                                }

                            }
                        };
                    }
                });
                parts.add(new RegionPart("-glow") {
                    {
                        color = Color.red;
                        blending = Blending.additive;
                        layer = -1.0F;
                        outline = false;
                    }
                });
            }
        };
        miniCollaris = new ErekirUnitType("mini-collaris") {
            {
                localizedName = "Baby Collaris";
                drag = 0.1F;
                speed = 0.8f;
                hitSize = 44.0F/3;
                health = 18000.0F/3;
                armor = 9.0F/3;
                rotateSpeed = 1.6F;
                lockLegBase = true;
                legContinuousMove = true;
                legStraightness = 0.6F;
                baseLegStraightness = 0.5F;
                legCount = 8;
                legLength = 10f;
                legForwardScl = 2.5F;
                legMoveSpace = 1.05F;
                rippleScale = 1.2F;
                stepShake = 0.5F/3;
                legGroupSize = 2;
                legExtension = -2.0f;
                legBaseOffset = 19.0F/2.75f;
                legStraightLength = 0.9F;
                legMaxLength = 1.2F;
                ammoType = new PowerAmmoType(2000.0F/3);
                constructor = LegsUnit::create;
                legSplashDamage = 32.0F/3;
                legSplashRange = 32.0F/3;
                drownTimeMultiplier = 2.0F;
                hovering = true;
                shadowElevation = 0.4F/3;
                groundLayer = 75.0F;
                targetAir = false;
                alwaysShootWhenMoving = true;
                weapons.add(new Weapon("mini-boi-mini-collaris-weapon") {
                    {
                        shootSound = Sounds.pulseBlast;
                        mirror = true;
                        rotationLimit = 30.0F;
                        rotateSpeed = 0.4F;
                        rotate = true;
                        x = 12.0F/3;
                        y = -7.0F/3;
                        shootY = 16.0F/3;
                        recoil = 4.0F/3;
                        reload = 130.0F;
                        cooldownTime = reload * 1.2F;
                        shake = 7.0F/3;
                        layerOffset = 0.02F;
                        shadow = 10.0F/3;
                        shootStatus = StatusEffects.slow;
                        shootStatusDuration = reload + 1.0F;
                        shoot.shots = 1;
                        heatColor = Color.red;

                        for(int i = 0; i < 5; ++i) {
                            int finalI = i;
                            parts.add(new RegionPart("-blade") {
                                {
                                    under = true;
                                    layerOffset = -0.001F;
                                    heatColor = Pal.techBlue;
                                    heatProgress = PartProgress.heat.add(0.2F).min(PartProgress.warmup);
                                    progress = PartProgress.warmup.blend(PartProgress.reload, 0.1F);
                                    x = 3.375F/3;
                                    y = 2.5F - (float) finalI /5;
                                    moveY = 1.0F/3 - (float) finalI;
                                    moveX = (float) finalI /5;
                                    moveRot = -45.0F - (float) finalI * 17.0F;
                                    moves.add(new DrawPart.PartMove(PartProgress.reload.inv().mul(1.8F).inv().curve((float) finalI / 5.0F, 0.2F), 0.0F, 0.0F, 36.0F));
                                }
                            });
                        }

                        bullet = new ArtilleryBulletType(5.5F/3, 86) {
                            {
                                collidesTiles = collides = true;
                                lifetime = 40.0F;
                                shootEffect = MBPFx.shootMiniColor;
                                smokeEffect = MBPFx.shootSmokeSquareMini;
                                frontColor = Color.white;
                                trailEffect = new MultiEffect(new Effect[]{MBPFx.miniArtilleryTrail, MBPFx.miniArtilleryTrailSmoke});
                                hitSound = Sounds.none;
                                width = 18.0F/3;
                                height = 24.0F/3;
                                lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                                lightRadius = 40.0F/3;
                                lightOpacity = 0.7F/3;
                                trailWidth = 4.5F/3;
                                trailLength = 19/3;
                                trailChance = -1.0F;
                                despawnEffect = Fx.none;
                                despawnSound = Sounds.dullExplosion;
                                hitEffect = despawnEffect = new ExplosionEffect() {
                                    {
                                        lifetime = 34.0F/3;
                                        waveStroke = 4.0F/3;
                                        waveColor = sparkColor = trailColor;
                                        waveRad = 25.0F/3;
                                        smokeSize = 0.0F;
                                        smokeSizeBase = 0.0F;
                                        sparks = 10;
                                        sparkRad = 25.0F/3;
                                        sparkLen = 8.0F/3;
                                        sparkStroke = 3.0F/3;
                                    }
                                };
                                splashDamage = 85.0F/3;
                                splashDamageRadius = 20.0F/3;
                                fragBullets = 15;
                                fragVelocityMin = 0.5F/3;
                                fragRandomSpread = 130.0F;
                                fragLifeMin = 0.3F/3;
                                despawnShake = 5.0F/3;
                                fragBullet = new BasicBulletType(5.5F/3, 16) {
                                    {
                                        pierceCap = 2;
                                        pierceBuilding = true;
                                        homingPower = 0.09F;
                                        homingRange = 150.0F/3;
                                        lifetime = 25.0F;
                                        shootEffect = MBPFx.shootMiniColor;
                                        smokeEffect = MBPFx.shootSmokeSquareMini;
                                        frontColor = Color.white;
                                        hitSound = Sounds.none;
                                        width = 12.0F/3;
                                        height = 20.0F/3;
                                        lightColor = trailColor = hitColor = backColor = Pal.techBlue;
                                        lightRadius = 40.0F/3;
                                        lightOpacity = 0.7F;
                                        trailWidth = 2.2F/3;
                                        trailLength = 7/3;
                                        trailChance = -1.0F;
                                        collidesAir = false;
                                        despawnEffect = Fx.none;
                                        splashDamage = 46.0F/3;
                                        splashDamageRadius = 30.0F/3;
                                        hitEffect = despawnEffect = new MultiEffect(new Effect[]{new ExplosionEffect() {
                                            {
                                                lifetime = 30.0F/3;
                                                waveStroke = 2.0F/3;
                                                waveColor = sparkColor = trailColor;
                                                waveRad = 5.0F/3;
                                                smokeSize = 0.0F;
                                                smokeSizeBase = 0.0F;
                                                sparks = 5/3;
                                                sparkRad = 20.0F/3;
                                                sparkLen = 6.0F/3;
                                                sparkStroke = 2.0F/3;
                                            }
                                        }, MBPFx.miniBlastExplosion});
                                    }
                                };
                            }
                        };
                    }
                });
            }
        };

        miniDisrupt = new ErekirUnitType("mini-disrupt") {
            {
                localizedName = "Baby Disrupt";
                aiController = FlyingFollowAI::new;
                constructor = PayloadUnit::create;
                envDisabled = 0;
                lowAltitude = false;
                flying = true;
                drag = 0.07F;
                speed = 1.0F;
                rotateSpeed = 2.0F;
                accel = 0.1F;
                health = 12000.0F/3;
                armor = 9.0F/3;
                hitSize = 46.0F/3;
                payloadCapacity = Mathf.sqr(2.0F) * 64.0F;
                targetAir = false;
                engineSize = 6.0F/3;
                engineOffset = 25.25F/3;
                final float orbRad = 5.0F/3;
                final float partRad = 3.0F/3;
                final int parts = 10;
                abilities.add(new SuppressionFieldAbility() {
                    {
                        orbRadius = orbRad;
                        particleSize = partRad;
                        y = 10.0F/3;
                        particles = parts;
                    }
                });

                for(final int i : Mathf.signs) {
                    abilities.add(new SuppressionFieldAbility() {
                        {
                            orbRadius = orbRad;
                            particleSize = partRad;
                            y = -8.0F/3.25f;
                            x = 15 * (float)i / 4.0F;
                            particles = parts;
                            display = active = false;
                        }
                    });
                }

                weapons.add(new Weapon("mini-boi-mini-disrupt-weapon") {
                    {
                        shootSound = Sounds.missileLarge;
                        x = 19.5F/2.75f;
                        y = -2.5F/2.75f;
                        mirror = true;
                        rotate = true;
                        rotateSpeed = 0.4F;
                        reload = 70.0F;
                        layerOffset = -20.0F;
                        recoil = 1.0F/3;
                        rotationLimit = 22.0F;
                        minWarmup = 0.95F;
                        shootWarmupSpeed = 0.1F;
                        shootY = 2.0F/3;
                        shootCone = 40.0F;
                        shoot.shots = 3;
                        shoot.shotDelay = 5.0F;
                        inaccuracy = 28.0F;
                        parts.add(new RegionPart("-blade") {
                            {
                                heatProgress = PartProgress.warmup;
                                progress = PartProgress.warmup.blend(PartProgress.reload, 0.15F);
                                heatColor = Color.valueOf("9c50ff");
                                x = 1.25F/3;
                                y = 0.0F;
                                moveRot = -33.0F;
                                moveY = -1.0F/3;
                                moveX = -1.0F/3;
                                under = true;
                                mirror = true;
                            }
                        });
                        bullet = new BulletType() {
                            {
                                shootEffect = Fx.sparkShoot;
                                smokeEffect = MBPFx.shootSmokeMiniTitan;
                                hitColor = Pal.suppress;
                                shake = 1.0F/3;
                                speed = 0.0F;
                                keepVelocity = false;
                                collidesAir = false;
                                spawnUnit = new MissileUnitType("mini-disrupt-missile") {
                                    {
                                        targetAir = false;
                                        speed = 4.6F/3;
                                        maxRange = 5.0F/3;
                                        outlineRadius = 1;
                                        outlineColor = Pal.darkOutline;
                                        health = 70.0F/3;
                                        homingDelay = 10.0F/3;
                                        lowAltitude = true;
                                        engineSize = 3.0F/3;
                                        engineColor = trailColor = Pal.sapBulletBack;
                                        engineLayer = 110.0F;
                                        deathExplosionEffect = Fx.none;
                                        loopSoundVolume = 0.1F;
                                        parts.add(new ShapePart() {
                                            {
                                                layer = 110.0F;
                                                circle = true;
                                                y = -0.25F/3;
                                                radius = 1.5f/3F;
                                                color = Pal.suppress;
                                                colorTo = Color.white;
                                                progress = PartProgress.life.curve(Interp.pow5In);
                                            }
                                        });
                                        parts.add(new RegionPart("-fin") {
                                            {
                                                mirror = true;
                                                progress = PartProgress.life.mul(3.0F).curve(Interp.pow5In);
                                                moveRot = 32.0F;
                                                rotation = -6.0F;
                                                moveY = 1.5F/3;
                                                x = 0.75F/3;
                                                y = -1.5F/3;
                                            }
                                        });
                                        weapons.add(new Weapon() {
                                            {
                                                shootCone = 360.0F;
                                                mirror = false;
                                                reload = 1.0F;
                                                shootOnDeath = true;
                                                bullet = new ExplosionBulletType(140.0F/3, 25.0F/3) {
                                                    {
                                                        collidesAir = false;
                                                        suppressionRange = 140.0F/3;
                                                        shootEffect = new ExplosionEffect() {
                                                            {
                                                                lifetime = 50.0F/3;
                                                                waveStroke = 5.0F/3;
                                                                waveLife = 8.0F/3;
                                                                waveColor = Color.white;
                                                                sparkColor = smokeColor = Pal.suppress;
                                                                waveRad = 40.0F/3;
                                                                smokeSize = 4.0F/3;
                                                                smokes = 7;
                                                                smokeSizeBase = 0.0F/3;
                                                                sparks = 10;
                                                                sparkRad = 40.0F/3;
                                                                sparkLen = 6.0F/3;
                                                                sparkStroke = 2.0F/3;
                                                            }
                                                        };
                                                    }
                                                };
                                            }
                                        });
                                    }
                                };
                            }
                        };
                    }
                });
                setEnginesMirror(new UnitType.UnitEngine[]{new UnitType.UnitEngine(23.75F/3, -14.0F/3, 5.0F/3, 330.0F), new UnitType.UnitEngine(22.25F/3, -23.75F/3, 4.0F/3, 315.0F)});
            }
        };
        miniRenale = new NeoplasmUnitType("mini-renale") {
            {
                localizedName = "Baby Renale";
                health = 175;
                armor = 1.0F;
                hitSize = 9.0F/3;
                omniMovement = false;
                rotateSpeed = 2.5F;
                drownTimeMultiplier = 2.0F;
                segments = 3;
                drawBody = false;
                crushDamage = 0.5F/3;
                outlineRadius = 1;
                aiController = HugAI::new;
                constructor = CrawlUnit::create;
                targetAir = false;
                segmentScl = 3.0F;
                segmentPhase = 5.0F;
                segmentMag = 0.5F;
                speed = 1.2F;
            }
        };
        miniLatum = new NeoplasmUnitType("mini-latum") {
            {
                localizedName = "Baby Latum";
                health = 6600;
                armor = 12.0F/3;
                hitSize = 48.0F/3;
                omniMovement = false;
                rotateSpeed = 1.7F;
                drownTimeMultiplier = 4.0F;
                segments = 4;
                drawBody = false;
                crushDamage = 2.0F/3;
                aiController = HugAI::new;
                constructor = CrawlUnit::create;
                targetAir = false;
                segmentScl = 4.0F;
                segmentPhase = 5.0F;
                speed = 1.0F;
                abilities.add(new SpawnDeathAbility(miniRenale, 5, 11.0F/3));
            }
        };
    }
}        