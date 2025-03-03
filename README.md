# **AdvancementsGain**
![SpigotMC](https://img.shields.io/badge/SpigotMC-Available-green) ![Java](https://img.shields.io/badge/Java-17-blue)

**AdvancementsGain** is a **Minecraft Spigot plugin** that allows **custom achievements** to grant configurable **rewards** such as XP, economy money (Vault), items, potion effects, and more.  
  
This plugin is designed to work **with custom achievements** from *AdvancementsCore* and will be **freely available on SpigotMC**. The **source code and releases** will be hosted on **GitHub**.

---

## **🔹 Features**
✔️ Reward players when they complete **custom achievements**  
✔️ Fully configurable rewards: **XP, money (Vault), items, potion effects, commands**  
✔️ Supports **multiple rewards per achievement**  
✔️ **Works with AdvancementsCore** to trigger custom achievements  
✔️ **Vault is optional** (soft dependency) – works even without an economy plugin  
✔️ Uses a **lightweight and optimized** event system  
✔️ **Open-source** and free!  

---

## **📜 Installation**
### **Requirements**
- **Minecraft 1.17+ to 1.21** (Supports Paper & Spigot)  
- **Java 17+**  
- **AdvancementsCore** (Required)  
- **Vault** (Optional for economy rewards)  

### **How to Install**
1. Download **AdvancementsGain.jar** from the [Releases](https://github.com/SoimKiyo/AdvancementsGain/releases) page.  
2. Place it in the `plugins/` folder of your Minecraft server.  
3. **(Required)** Install **AdvancementsCore** if not already installed (Buy it on [BuiltByBit](https://builtbybit.com/resources/advancementcore.61398/) or [Polymart](https://polymart.org/resource/advancementscore.7324).  
4. **(Optional)** Install **Vault** and an economy plugin (like EssentialsX) if you want money rewards.  
5. Start your server and modify `config.yml` to configure rewards.  
6. Use `/advancementsgain reload` to reload the configuration.

---

## **⚙️ Configuration**
The `config.yml` file lets you define **custom rewards** for each achievement.

### **Example Configuration**
```
# ==============================
#  AdvancementsGain - Config
# ==============================
#
# ➤ Each achievement is defined under `rewards:`, with a unique ID (e.g., "achievement_1").
# ➤ `mode:` determines who receives the reward:
#     - "team"   → The entire team gets the reward.
#     - "player" → Only the player who completed the achievement gets the reward.
# ➤ Available reward types:
#     - `xp:` Amount of experience points to grant.
#     - `money:` Amount of money to grant (requires Vault).
#     - `items:` List of items in format `ITEM:quantity:meta1:meta2`
#     - `effects:` List of effects in format `EFFECT:duration:amplifier`
#     - `commands:` List of commands executed (`{player}` is replaced with the player's name).
#
# ➤ General Rewards: These rewards are **always** given regardless of the achievement.
# ==============================

messages:
  xp: "§aYou have received {amount} XP!"
  money: "§aYou have received {amount} coins!"
  item: "§aYou have received {amount}x {item}!"
  effect: "§aYou have received the effect: {effect}!"
  command: "§aCommand executed successfully!"
  no_permission: "§cYou do not have permission to use this command."
  reload_success: "§aConfiguration and messages successfully reloaded!"
  usage: "§cUsage: /advancementsgain reload"

general_rewards:
  xp: 50
  money: 20
  items: ["IRON_INGOT:2", "GOLD_NUGGET:5"]
  effects: ["LUCK:120:1"]
  commands: ["say {player} received a general reward!"]

rewards:
  achievement_break_diamond_ore:
    mode: "player"
    xp: 200
    money: 100
    items: ["DIAMOND:5", "IRON_PICKAXE:1:EFFICIENCY_3:UNBREAKING_2"]
    effects: ["HASTE:120:2"]
    commands: ["say {player} has mined their first diamond ore!"]

  achievement_full_netherite_armor:
    mode: "player"
    xp: 500
    money: 300
    items: ["NETHERITE_INGOT:2", "TOTEM_OF_UNDYING:1"]
    effects: ["RESISTANCE:300:2", "STRENGTH:300:2"]
    commands: ["say {player} is now a true Netherite warrior!"]

```

## **📌 Commands & Permissions**
### **Commands**
| Command | Description | Permission |
|---------|-------------|------------|
| `/advancementsgain reload` | Reloads the plugin configuration | `advancementsgain.admin` |

---

## **👨‍💻 Developers**
This plugin is **open-source**, and contributions are welcome!  
📂 View the **source code** and contribute on **GitHub**

To build the project, clone it and use **Maven**:
```
git clone https://github.com/SoimKiyo/AdvancementsGain.git
cd AdvancementsGain
mvn clean package
```
The compiled plugin will be located in `target/AdvancementsGain.jar`.

---

## **📢 Support & Contact**
If you encounter issues, feel free to:  
📌 Open an **issue** on **[GitHub Issues](https://github.com/SoimKiyo/AdvancementsGain/issues)**  
📌 Ask for help on the **SpigotMC Discussion** page  

For direct support, join the discord server : **[Join US](https://discord.gg/Q42XFEyUH5)**.

---
  
## **⭐ Support the Project**
If you like **AdvancementsGain**, please consider:  
✅ **Leaving a ⭐ on GitHub**  
✅ **Leaving a review on SpigotMC**  
✅ **Sharing with other server owners**  

Thank !
