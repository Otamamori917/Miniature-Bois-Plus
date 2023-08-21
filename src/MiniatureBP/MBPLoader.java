package MiniatureBP;

import arc.util.Log;
import MiniatureBP.content.*;
//import MiniatureBP.content.blocks.*;
import mindustry.mod.Mod;
public class MBPLoader extends Mod{

    public MBPLoader(){
        Log.info("Loaded constructor.");
    }

    @Override
    public void loadContent(){
        Log.info("Loading MBP content");
        MBPMinis.load();
        MBPVariants.load();
        //MBPBlocks.load();
        //MBPCrafters.load();
        Log.info("Miniature Boi's Plus Has Loaded. :)");
    }
}