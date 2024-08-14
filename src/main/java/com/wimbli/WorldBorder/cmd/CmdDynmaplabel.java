package com.wimbli.WorldBorder.cmd;

import com.wimbli.WorldBorder.Config;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;


public class CmdDynmaplabel extends WBCmd {
    public CmdDynmaplabel() {
        name = permission = "dynmaplabel";
        minParams = 1;

        addCmdExample(nameEmphasized() + "<text> - DynMap border layer labels will show this.");
        helpText = "Default value: \"WorldBorder.\". If you are running the DynMap plugin and the " +
                commandEmphasized("dynmap") + C_DESC + "command setting is enabled, the border layer shown in DynMap will " +
                "be labelled with this text.";
    }

    @Override
    public void cmdStatus(CommandSender sender) {
        sender.sendMessage(C_HEAD + "DynMap border layer label is set to: " + C_ERR + Config.DynmapLayerLabel());
    }

    @Override
    public void execute(CommandSender sender, Player player, List<String> params, String worldName) {
        StringBuilder message = new StringBuilder();
        boolean first = true;
        for (String param : params) {
            if (!first)
                message.append(" ");
            message.append(param);
            first = false;
        }

        Config.setDynmapLayerLabel(message.toString());

        if (player != null)
            cmdStatus(sender);
    }
}
