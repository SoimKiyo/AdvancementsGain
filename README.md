AdvancementsGain

AdvancementsGain is a Minecraft Spigot plugin that allows custom achievements to grant configurable rewards such as XP, economy money (Vault), items, potion effects, and more.

This plugin is designed to work with custom achievements from AdvancementsCore and will be freely available on SpigotMC. The source code and releases will be hosted on GitHub.

🔹 Features
✔️ Reward players when they complete custom achievements
✔️ Fully configurable rewards: XP, money (Vault), items, potion effects, commands
✔️ Supports multiple rewards per achievement
✔️ Works with AdvancementsCore to trigger custom achievements
✔️ Vault is optional (soft dependency) – works even without an economy plugin
✔️ Uses a lightweight and optimized event system
✔️ Open-source and free!

📜 Installation
Requirements
Minecraft 1.21+ (Supports Paper & Spigot)
Java 17+
AdvancementsCore (Required)
Vault (Optional for economy rewards)
How to Install
Download AdvancementsGain.jar from the Releases page.
Place it in the plugins/ folder of your Minecraft server.
(Required) Install AdvancementsCore if not already installed.
(Optional) Install Vault and an economy plugin (like EssentialsX) if you want money rewards.
Start your server and modify config.yml to configure rewards.
Use /advancementsgainreload to reload the configuration.
⚙️ Configuration
The config.yml file lets you define custom rewards for each achievement.

Example Configuration
yaml
Copier
Modifier
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
xp → Amount of experience to give.
money → Amount of currency (requires Vault).
items → Items to give (MATERIAL:AMOUNT).
effects → Potion effects (EFFECT:DURATION:AMPLIFIER).
commands → Console commands executed ({player} replaces the player’s name).
📌 Commands & Permissions
Commands
Command	Description	Permission
/advancementsgainreload	Reloads the plugin configuration	advancementsgain.admin
Permissions
Permission	Description
advancementsgain.admin	Allows use of admin commands
📥 Download
You can download the latest version from:
🔹 SpigotMC Page
🔹 GitHub Releases

👨‍💻 Developers
This plugin is open-source, and contributions are welcome!
📂 View the source code and contribute on GitHub:
👉 GitHub Repository

To build the project, clone it and use Maven:

bash
Copier
Modifier
git clone https://github.com/yourusername/AdvancementsGain.git
cd AdvancementsGain
mvn clean package
The compiled plugin will be located in target/AdvancementsGain.jar.

📢 Support & Contact
If you encounter issues, feel free to:
📌 Open an issue on GitHub Issues
📌 Ask for help on the SpigotMC Discussion page

For direct support, contact me on Discord: YourDiscord#1234

📜 License
This project is licensed under the MIT License.
You are free to use, modify, and distribute it with attribution.

📄 Read the full license here.

⭐ Support the Project
If you like AdvancementsGain, please consider:
✅ Leaving a ⭐ on GitHub
✅ Leaving a review on SpigotMC
✅ Sharing with other server owners

Thank you for using AdvancementsGain! 🚀
