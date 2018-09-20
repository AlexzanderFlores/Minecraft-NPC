package npc;

import java.lang.reflect.Field;
import java.util.Map;

import org.bukkit.entity.EntityType;

import net.minecraft.server.v1_8_R3.EntityBat;
import net.minecraft.server.v1_8_R3.EntityBlaze;
import net.minecraft.server.v1_8_R3.EntityCaveSpider;
import net.minecraft.server.v1_8_R3.EntityChicken;
import net.minecraft.server.v1_8_R3.EntityCow;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.EntityEnderman;
import net.minecraft.server.v1_8_R3.EntityGhast;
import net.minecraft.server.v1_8_R3.EntityHorse;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityIronGolem;
import net.minecraft.server.v1_8_R3.EntityMagmaCube;
import net.minecraft.server.v1_8_R3.EntityMushroomCow;
import net.minecraft.server.v1_8_R3.EntityOcelot;
import net.minecraft.server.v1_8_R3.EntityPig;
import net.minecraft.server.v1_8_R3.EntityPigZombie;
import net.minecraft.server.v1_8_R3.EntitySheep;
import net.minecraft.server.v1_8_R3.EntitySilverfish;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.EntitySlime;
import net.minecraft.server.v1_8_R3.EntitySnowman;
import net.minecraft.server.v1_8_R3.EntitySpider;
import net.minecraft.server.v1_8_R3.EntitySquid;
import net.minecraft.server.v1_8_R3.EntityTypes;
import net.minecraft.server.v1_8_R3.EntityVillager;
import net.minecraft.server.v1_8_R3.EntityWitch;
import net.minecraft.server.v1_8_R3.EntityWolf;
import net.minecraft.server.v1_8_R3.EntityZombie;
import npc.entities.BatNPC;
import npc.entities.BlazeNPC;
import npc.entities.CaveSpiderNPC;
import npc.entities.ChickenNPC;
import npc.entities.CowNPC;
import npc.entities.CreeperNPC;
import npc.entities.EndermanNPC;
import npc.entities.GhastNPC;
import npc.entities.HorseNPC;
import npc.entities.IronGolemNPC;
import npc.entities.MagmaCubeNPC;
import npc.entities.MushroomCowNPC;
import npc.entities.OcelotNPC;
import npc.entities.PigNPC;
import npc.entities.PigZombieNPC;
import npc.entities.SheepNPC;
import npc.entities.SilverfishNPC;
import npc.entities.SkeletonNPC;
import npc.entities.SlimeNPC;
import npc.entities.SnowmanNPC;
import npc.entities.SpiderNPC;
import npc.entities.SquidNPC;
import npc.entities.VillagerNPC;
import npc.entities.WitchNPC;
import npc.entities.WolfNPC;
import npc.entities.ZombieNPC;

@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
public class NPCRegistrationHandler {
    public enum NPCs {
        BAT(EntityBat.class, BatNPC.class),
        BLAZE(EntityBlaze.class, BlazeNPC.class),
        CAVE_SPIDER(EntityCaveSpider.class, CaveSpiderNPC.class),
        CHICKEN(EntityChicken.class, ChickenNPC.class),
        COW(EntityCow.class, CowNPC.class),
        CREEPER(EntityCreeper.class, CreeperNPC.class),
        ENDERMAN(EntityEnderman.class, EndermanNPC.class),
        GHAST(EntityGhast.class, GhastNPC.class),
        HORSE(EntityHorse.class, HorseNPC.class),
        IRON_GOLEM(EntityIronGolem.class, IronGolemNPC.class),
        MAGMA_CUBE(EntityMagmaCube.class, MagmaCubeNPC.class),
        MUSHROOM_COW(EntityMushroomCow.class, MushroomCowNPC.class),
        OCELOT(EntityOcelot.class, OcelotNPC.class),
        PIG(EntityPig.class, PigNPC.class),
        PIG_ZOMBIE(EntityPigZombie.class, PigZombieNPC.class),
        SHEEP(EntitySheep.class, SheepNPC.class),
        SILVERFISH(EntitySilverfish.class, SilverfishNPC.class),
        SKELETON(EntitySkeleton.class, SkeletonNPC.class),
        SLIME(EntitySlime.class, SlimeNPC.class),
        SNOWMAN(EntitySnowman.class, SnowmanNPC.class),
        SPIDER(EntitySpider.class, SpiderNPC.class),
        SQUID(EntitySquid.class, SquidNPC.class),
        VILLAGER(EntityVillager.class, VillagerNPC.class),
        WITCH(EntityWitch.class, WitchNPC.class),
        WOLF(EntityWolf.class, WolfNPC.class),
        ZOMBIE(EntityZombie.class, ZombieNPC.class);

        private Class<? extends EntityInsentient> defaultClass = null;
        private Class<? extends EntityInsentient> customClass = null;

        private NPCs(Class<? extends EntityInsentient> defaultClass, Class<? extends EntityInsentient> customClass) {
            this.defaultClass = defaultClass;
            this.customClass = customClass;
        }

        private static Object getPrivateStatic(Class clazz, String f) throws Exception {
            Field field = clazz.getDeclaredField(f);
            field.setAccessible(true);
            return field.get(null);
        }

        public void register() {
            try {
                ((Map) getPrivateStatic(EntityTypes.class, "c")).put(toString(), customClass);
                ((Map) getPrivateStatic(EntityTypes.class, "d")).put(customClass, toString());
                int typeId = Integer.valueOf(EntityType.valueOf(toString()).getTypeId());
                ((Map) getPrivateStatic(EntityTypes.class, "e")).put(typeId, customClass);
                ((Map) getPrivateStatic(EntityTypes.class, "f")).put(customClass, typeId);
                ((Map) getPrivateStatic(EntityTypes.class, "g")).put(toString(), typeId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void unregister() {
            try {
                ((Map) getPrivateStatic(EntityTypes.class, "c")).put(toString(), defaultClass);
                ((Map) getPrivateStatic(EntityTypes.class, "d")).put(defaultClass, toString());
                int typeId = Integer.valueOf(EntityType.valueOf(toString()).getTypeId());
                ((Map) getPrivateStatic(EntityTypes.class, "e")).put(typeId, defaultClass);
                ((Map) getPrivateStatic(EntityTypes.class, "f")).put(defaultClass, typeId);
                ((Map) getPrivateStatic(EntityTypes.class, "g")).put(toString(), typeId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
