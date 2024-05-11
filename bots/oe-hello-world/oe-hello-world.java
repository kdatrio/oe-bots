import dev.robocode.tankroyale.botapi.*;

// ------------------------------------------------------------------
// OE-Hello-World
// ------------------------------------------------------------------
// The first bot created by Keith D'Atrio
// For the Zoom internal Robocode Battle Tank Royale
// Overengineered Hello World Tank Bot
// Foundation from the 'My First Bot' tutorial
// ------------------------------------------------------------------

import dev.robocode.tankroyale.botapi.*;
import dev.robocode.tankroyale.botapi.events.*;

public class oe-hello-worldBot extends Bot {

    // The main method starts our bot
    public static void main(String[] args) {
        new oe-hello-worldBot().start();
    }

    // Constructor, which loads the bot config file
    oe-hello-worldBot() {
        super(BotInfo.fromFile("oe-hello-world.json"));
    }

    // Called when a new round is started -> initialize and do some movement
    @Override
    public void run() {
        // Repeat while the bot is running
        while (isRunning()) {
            forward(150);
            turnGunRight(360);
            back(150);
            turnGunRight(360);
        }
    }

    // We saw another bot -> fire!
    @Override
    public void onScannedBot(ScannedBotEvent e) {
        fire(1);
    }

    // We were hit by a bullet -> turn perpendicular to the bullet
    @Override
    public void onHitByBullet(HitByBulletEvent e) {
        // Calculate the bearing to the direction of the bullet
        double bearing = calcBearing(e.getBullet().getDirection());

        // Turn 90 degrees to the bullet direction based on the bearing
        turnLeft(90 - bearing);
    }
}