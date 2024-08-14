package com.wimbli.WorldBorder.cmd;

import com.wimbli.WorldBorder.Config;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;


public class CmdShape extends WBCmd {
    public CmdShape() {
        name = permission = "shape";
        minParams = maxParams = 1;

        addCmdExample(nameEmphasized() + "<round|square> - set the default border shape.");
        addCmdExample(nameEmphasized() + "<elliptic|rectangular> - same as above.");
        helpText = "Default value: square/rectangular. The default border shape will be used on all worlds which don't " +
                "have an individual shape set using the " + commandEmphasized("wshape") + C_DESC + "command. Elliptic " +
                "and round work the same, as rectangular and square do. The difference is down to whether the X and Z " +
                "radius are the same.";
    }

    @Override
    public void cmdStatus(CommandSender sender) {
        sender.sendMessage(C_HEAD + "The default border shape for all worlds is currently set to \"" + Config.ShapeName() + "\".");
    }

    @Override
    public void execute(CommandSender sender, Player player, List<String> params, String worldName) {
        String shape = params.get(0).toLowerCase();
        if (shape.equals("rectangular") || shape.equals("square"))
            Config.setShape(false);
        else if (shape.equals("elliptic") || shape.equals("round"))
            Config.setShape(true);
        else {
            sendErrorAndHelp(sender, "You must specify one of the 4 valid shape names below.");
            return;
        }

        if (player != null)
            cmdStatus(sender);
    }
}
