package ro.altom.altunitytester.Commands.FindObject;

import ro.altom.altunitytester.AltBaseSettings;
import ro.altom.altunitytester.AltUnityObject;

/**
 * Returns information about every object loaded in the currently loaded scenes.
 */
public class AltGetAllElements extends AltBaseFindObject {
    /**
     * @param altGetAllElementsParameters the properties parameter for finding the
     *                                    objects in a scene.
     */
    private AltGetAllElementsParameters altGetAllElementsParameters;

    public AltGetAllElements(AltBaseSettings altBaseSettings, AltGetAllElementsParameters altGetAllElementsParameters) {
        super(altBaseSettings);
        this.altGetAllElementsParameters = altGetAllElementsParameters;
    }

    public AltUnityObject[] Execute() {
        String cameraPath = SetPath(altGetAllElementsParameters.getCameraBy(),
                altGetAllElementsParameters.getCameraPath());
        SendCommand("findObjects", "//*", altGetAllElementsParameters.getCameraBy().toString(), cameraPath,
                String.valueOf(altGetAllElementsParameters.isEnabled()));
        return ReceiveListOfAltUnityObjects();
    }
}
