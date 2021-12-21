using System;
using Altom.AltUnityDriver.Logging;
using NLog;
namespace Altom.AltUnityDriver.Notifications
{
    public class BaseNotificationCallBacks : INotificationCallbacks
    {
        private static readonly NLog.Logger logger = DriverLogManager.Instance.GetCurrentClassLogger();
        public void SceneLoadedCallback(AltUnityLoadSceneNotificationResultParams altUnityLoadSceneNotificationResultParams)
        {
            logger.Log(LogLevel.Info, String.Format("Scene {0} was loaded {1}", altUnityLoadSceneNotificationResultParams.sceneName, altUnityLoadSceneNotificationResultParams.loadSceneMode.ToString()));
        }
        public void SceneUnloadedCallback(string sceneName)
        {
            logger.Log(LogLevel.Info, String.Format("Scene {0} was unloaded", sceneName));
        }
        public void ApplicationPausedCallback(bool applicationPaused)
        {
            logger.Log(LogLevel.Info, String.Format("Application paused: {0}", applicationPaused));
        }
    }
}