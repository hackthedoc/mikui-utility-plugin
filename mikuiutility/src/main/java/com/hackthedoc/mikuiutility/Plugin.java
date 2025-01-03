package com.hackthedoc.mikuiutility;

import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.mikuiutility.commands.QuestrecordCommand;
import com.hackthedoc.mikuiutility.utils.MessageUtils;
import com.hackthedoc.mikuiutility.utils.QuestRecordFileUtils;

public class Plugin extends JavaPlugin {
  private static Plugin instance;

  public void onEnable() {
    instance = this;

    QuestRecordFileUtils.initFile();
    getCommand("questrecord").setExecutor(new QuestrecordCommand());

    MessageUtils.log("template enabled");
  }

  public void onDisable() {
    MessageUtils.log("template disabled");
  }

  public static Plugin getInstance() {
    return instance;
  }
}
