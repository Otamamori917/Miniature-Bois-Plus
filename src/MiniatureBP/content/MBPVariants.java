package MiniatureBP.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
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
import mindustry.type.unit.ErekirUnitType;

public class MBPVariants {
    public static UnitType
    //Serpulo
    tepidReign,
    erekirCorvus,compositeCorvus,
    neoPlastedToxopid
    //Erekir
            ;
    public static void load(){
        compositeCorvus = new UnitType("composite-corvus"){{
            localizedName = "[white]Composite[] Corvus";
            hitSize = 29f;
            health = 18000f;
            armor = 12f;
            stepShake = 1.5f;
            rotateSpeed = 1.5f;
            drownTimeMultiplier = 6f;

            legCount = 4;
            legLength = 14f;
            legBaseOffset = 11f;
            legMoveSpace = 1.5f;
            legForwardScl = 0.58f;
            hovering = true;
            shadowElevation = 0.2f;
            ammoType = new PowerAmmoType(4000);
            groundLayer = Layer.legUnit;
            constructor = LegsUnit::create;

            speed = 0.3f;

            drawShields = false;

            float swingTime = 18;
            parts.addAll(
                    new RegionPart("-crest") {{
                        progress = p -> Mathf.cos(Time.time / swingTime) / 2 + 0.2f;
                        mirror = false;
                        moveY = 2.2f;
                        moves.add(new PartMove(PartProgress.charge.inv(), 0f, 1f, 0f));
                        moves.add(new PartMove(PartProgress.recoil.inv(), 0f, -1f, 0f));
                    }},
                    new RegionPart("-guard") {{
                        progress = p -> Mathf.sin(Time.time / swingTime) / 2 + 0.4f;
                        mirror = true;
                        moveY = -0.5f;
                        moves.add(new PartMove(PartProgress.charge.inv(), -0.2f, 0.2f, 0f));
                        moves.add(new PartMove(PartProgress.recoil.inv(), 0.2f, -0.2f, 0f));
                    }},
                    new RegionPart("-plad") {{
                        progress = p -> Mathf.sin(Time.time / swingTime) / 2 + 0.6f;
                        mirror = true;
                        moveY = -1;
                        moveX = -1;
                        moves.add(new PartMove(PartProgress.charge.inv(), 0.5f, 0.5f, 0f));
                        moves.add(new PartMove(PartProgress.recoil.inv(), -0.5f, -0.5f, 0f));
                    }},
                    new RegionPart("-plate") {{
                        progress = p -> Mathf.sin(Time.time / swingTime) / 2 + 0.8f;
                        mirror = true;
                        moveY = -0.2f;
                        moves.add(new PartMove(PartProgress.charge.inv(), 0.1f, -0.4f, 8f));
                        moves.add(new PartMove(PartProgress.recoil.inv(), -0.1f, 0.4f, -8f));
                    }},
                    new RegionPart("-front") {{
                        progress = p -> Mathf.sin(Time.time / swingTime) / 2 + 1f;
                        mirror = true;
                        moveY = -0.5f;
                        moveX = -0.5f;
                        moves.add(new PartMove(PartProgress.charge.inv(), -1f, 0f, -2f));
                        moves.add(new PartMove(PartProgress.recoil.inv(), 1f, 0f, 3f));
                    }}
                    /*new RegionPart("-arm") {{
                        progress = PartProgress.smoothReload;
                        moveY = -2;
                        moveX = -6;
                        moveRot = 8;
                        mirror = true;
                    }}*/
            );

            weapons.add(new Weapon("corvus-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                soundPitchMin = 1f;
                top = false;
                mirror = false;
                shake = 18f;
                shootY = 5f;
                x = y = 0;
                reload = 450f;
                recoil = 0f;

                cooldownTime = 450f;

                shootStatusDuration = 60f * 2f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new LaserBulletType(){{
                    length = 560f;
                    damage = 560f;
                    width = 80f;

                    lifetime = 65f;

                    lightningType = new LaserBulletType(){{
                        length = 56f;
                        width = 16f;
                        lifetime = 35f;
                        colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                        healPercent = 2f;

                        lightningSpacing = 35f;
                        lightningLength = 5;
                        lightningDelay = 1.1f;
                        lightningLengthRand = 15;
                        lightningDamage = 20;
                        lightningAngleRand = 40f;
                        largeHit = true;
                        lightColor = lightningColor = Pal.heal;
                    }};

                    lightningSpacing = 32f;
                    lightningDelay = 1.1f;
                    lightningDamage = 20;
                    lightningAngleRand = 0f;
                    largeHit = true;
                    lightColor = lightningColor = Pal.heal;

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 30f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Pal.heal.cpy().a(0.4f), Pal.heal, Color.white};
                }};
            }});
        }};
        erekirCorvus = new ErekirUnitType("erekir-corvus"){{
            localizedName = "Erekir Corvus";
            hitSize = 29f;
            health = 16000f;
            armor = 14f;
            legContinuousMove = true;
            legGroupSize = 3;
            legStraightness = 0.2f;
            baseLegStraightness = 0.4f;
            legMaxLength = 1.6f;
            researchCostMultiplier = 0f;

            rotateSpeed = 1.8f;

            legCount = 6;
            legLength = 20f;
            legForwardScl = 0.45f;
            legMoveSpace = 1.4f;
            rippleScale = 2f;
            stepShake = 0.5f;
            legExtension = -2f;
            legBaseOffset = 2f;

            legSplashDamage = 32;
            legSplashRange = 30;
            drownTimeMultiplier = 2f;
            ammoType = new PowerAmmoType(6000);
            groundLayer = Layer.legUnit;
            constructor = LegsUnit::create;

            speed = 0.4f;

            drawShields = false;

            for(int j = 0; j < 2; j++){
                int i = j;
                parts.add(new RegionPart("-spine"){{
                    layerOffset = -0.01f;
                    heatLayerOffset = 0.005f;
                    x = 0f;
                    y = -6;
                    moveX = 22f + i * 2.8f;
                    moveY = 22f + -18f * i;
                    moveRot = 50f - i * 34f;
                    mirror = true;
                    progress = PartProgress.warmup.delay(i * 0.2f);
                    heatProgress = PartProgress.heat;

                    moves.add(new PartMove(PartProgress.charge.inv(), -1f, -1f, -8f));
                    moves.add(new PartMove(PartProgress.recoil.inv(), 1.4f, 1.4f, 10f));

                    heatColor = Color.valueOf("98ffa980");
                }},
                new RegionPart("-glow"){{
                    color = Color.valueOf("98ffa980");
                    blending = Blending.additive;
                    outline = mirror = false;
                }});
            }

            weapons.add(new Weapon("mini-boi-erekir-corvus-weapon"){{
                shootSound = Sounds.laserblast;
                chargeSound = Sounds.lasercharge;
                heatColor = Color.valueOf("98ffa980");
                minWarmup = 0.9f;
                soundPitchMin = 1f;
                top = false;
                mirror = false;
                shake = 18f;
                shootY = 5f;
                x = y = 0;
                reload = 450f;
                recoil = 0f;

                cooldownTime = 450f;

                shootStatusDuration = 60f * 2f;
                shootStatus = StatusEffects.unmoving;
                shoot.firstShotDelay = Fx.greenLaserCharge.lifetime;
                parentizeEffects = true;

                bullet = new LaserBulletType(){{
                    length = 560f;
                    damage = 260f;
                    width = 80f;

                    lifetime = 65f;

                    lightningType = new EmpBulletType(){{
                        lightOpacity = 0.7f;
                        unitDamageScl = 0.8f;
                        healPercent = 4f;
                        timeIncrease = 3f;
                        timeDuration = 60f * 20f;
                        powerDamageScl = 1.5f;
                        hitEffect = Fx.none;
                        damage = 1;
                        hitColor = lightColor = Color.valueOf("98ffa980");
                        lightRadius = 7f;
                        clipSize = 25f;
                        shootEffect = Fx.hitEmpSpark;
                        smokeEffect = Fx.shootBigSmoke2;
                        lifetime = 20f;
                        sprite = "circle-bullet";
                        backColor = Color.valueOf("98ffa980");
                        frontColor = Color.white;
                        width = height = 8f;
                        shrinkY = 0f;
                        speed = 0.5f;
                        trailRotation = false;
                        status = StatusEffects.electrified;
                    }};

                    lightningSpacing = 18f;
                    lightningDelay = 0.6f;
                    lightningAngleRand = 0f;
                    largeHit = true;
                    lightColor = lightningColor = Color.valueOf("98ffa980");

                    chargeEffect = Fx.greenLaserCharge;

                    healPercent = 10f;
                    collidesTeam = true;

                    sideAngle = 15f;
                    sideWidth = 0f;
                    sideLength = 0f;
                    colors = new Color[]{Color.valueOf("98ffa980").cpy().a(0.4f), Color.valueOf("98ffa980"), Color.white};
                }};
            }});
        }};
    }
}        