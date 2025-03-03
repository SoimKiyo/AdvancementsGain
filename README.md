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
6. Use `/advancementsgainreload` to reload the configuration.

---

## **⚙️ Configuration**
The `config.yml` file lets you define **custom rewards** for each achievement.

### **Example Configuration**
\`\`\`yaml
rewards:
  achievement_craft_diamond_sword:
    xp: 500
    money: 200
    items:
      - "DIAMOND_SWORD:1"
    effects:
      - "STRENGTH:60:1"
    commands:
      - "say {player} has forged a mighty sword!"
\`\`\`

- `id` → The id of one of the achievement in AdvancementsCore (eg. achievement_craft_diamond_sword)
- `xp` → Amount of experience to give.  
- `money` → Amount of currency (requires Vault).  
- `items` → Items to give (`MATERIAL:AMOUNT`).  
- `effects` → Potion effects (`EFFECT:DURATION:AMPLIFIER`).  
- `commands` → Console commands executed (`{player}` replaces the player’s name).  

---

## **📌 Commands & Permissions**
### **Commands**
| Command | Description | Permission |
|---------|-------------|------------|
| `/advancementsgainreload` | Reloads the plugin configuration | `advancementsgain.admin` |

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
