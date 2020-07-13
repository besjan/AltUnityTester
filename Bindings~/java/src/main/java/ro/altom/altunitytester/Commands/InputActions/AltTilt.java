package ro.altom.altunitytester.Commands.InputActions;

import ro.altom.altunitytester.AltBaseSettings;
import ro.altom.altunitytester.Commands.AltBaseCommand;

/**
 * Simulates device rotation action in your game.
 */
public class AltTilt extends AltBaseCommand {
    private AltTiltParameters altTiltParameters;

    public AltTilt(AltBaseSettings altBaseSettings, AltTiltParameters altTiltParameters) {
        super(altBaseSettings);
        this.altTiltParameters = altTiltParameters;
    }

    public void Execute() {
        String accelerationString = vectorToJsonString(altTiltParameters.getX(), altTiltParameters.getY(),
                altTiltParameters.getZ());
        send(CreateCommand("tilt", accelerationString, String.valueOf(altTiltParameters.getDuration())));
        String data = recvall();
        if (data.equals("OK")) {
            return;
        }
        handleErrors(data);
    }
}