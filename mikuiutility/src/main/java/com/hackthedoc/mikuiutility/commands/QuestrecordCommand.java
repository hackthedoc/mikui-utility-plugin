package com.hackthedoc.mikuiutility.commands;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.hackthedoc.mikuiutility.utils.MessageUtils;
import com.hackthedoc.mikuiutility.utils.QuestRecordFileUtils;

public class QuestrecordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1)
            return false;
        
        try {
            int number = Integer.parseInt(args[0]);
            QuestRecordFileUtils.logNumber(number);
            MessageUtils.sendSuccess(sender, "Number "+args[0]+" has been logged!");
        } catch (NumberFormatException e) {
            MessageUtils.sendError(sender, "Error: '"+args[0]+"' is not a number.");
        } catch (IOException e) {
            MessageUtils.sendError(sender, "Error: Could not write to the log file.");
        }

        return true;
    }
}
