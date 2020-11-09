package ro.altom.altunitytester.Commands;

import ro.altom.altunitytester.AltBaseSettings;

public class GetServerVersionCommand extends AltBaseCommand {
    public GetServerVersionCommand(AltBaseSettings altBaseSettings) {
        super(altBaseSettings);
    }

    public String Execute() {
        send(CreateCommand("getServerVersion"));
        String serverVersion = recvall();
        handleErrors(serverVersion);
        return serverVersion;
    }
}
