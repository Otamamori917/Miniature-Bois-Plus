package MiniatureBP.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.LaserBulletType;
import mindustry.entities.bullet.ShrapnelBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.ammo.PowerAmmoType;

public class MBPMinis {
    public static UnitType
    //Serpulo
    miniReign,miniCorvus,miniToxopid,miniAntumbra,miniOct,miniOmura,miniNavanax,
    //Erekir
    miniConquer,miniCollaris,miniDisrupt,
    //Erekir Misc
    miniLatum
            ;
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
                    damage = 560f / 3f;
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
            health = 22000 / 3f;
            armor = 13f / 3f;
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
                            damage = 110f / 3f;
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

                bullet = new ArtilleryBulletType(1, 50 / 3f){{
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
    }
}        