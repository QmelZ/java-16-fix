package qmelz.java16;

import arc.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.mod.*;

public class Fix extends Mod{

    @Override
    public void loadContent(){
        try{
            Seq<String> whitelist = Reflect.get(Vars.mods.getScripts().getClass(), "whitelist");
            whitelist.add("jdk.proxy2");
        }catch(Throwable c){
            Log.err(c);
            Events.on(EventType.ClientLoadEvent.class, event -> {
                Vars.mods.setEnabled(Vars.mods.locateMod(" java-16-fix"), false);
                Vars.ui.showErrorMessage("an error occured, please report it on github.\nthe game will now exit to disable java 16 fixer");
                if(Core.scene.getDialog() != null) Core.scene.getDialog().hidden(Core.app::exit);
            });
        }
    }
}
