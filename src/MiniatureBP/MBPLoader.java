package MiniatureBP;

import arc.Core;
import arc.util.Log;
import MiniatureBP.content.*;
//import MiniatureBP.content.blocks.*;
import mindustry.mod.Mod;
import mindustry.type.UnitType;

import static mindustry.Vars.mods;

public class MBPLoader extends Mod{

    public UnitType mounta;

    public MBPLoader(){
        Log.info("Loaded constructor.");
    }

    @Override
    public void loadContent(){
        Log.info("Loading MBP content");
        MBPMinis.load();
        MBPVariants.load();
        if(mods.locateMod("aj") != null){
            MBPModdedMinis.loadAxthrix();
        }
        if(mods.locateMod("project-viscott") != null){
            MBPModdedMinis.loadViscott();
        }
        //MBPBlocks.load();
        //MBPCrafters.load();
        Log.info("Miniature Boi's Plus Has Loaded. :)");
    }
}