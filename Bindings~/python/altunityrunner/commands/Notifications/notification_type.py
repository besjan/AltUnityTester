from enum import IntEnum


class NotificationType(IntEnum):
    LOADSCENE = 0
    UNLOADSCENE = 1
    APPLICATION_PAUSED = 2
