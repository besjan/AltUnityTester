﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Assets.AltUnityTester.AltUnityServer.Commands
{
    class FindObjectsByName :FindObjectsOldWay
    {
        string methodParameters;

        public FindObjectsByName(string methodParameters)
        {
            this.methodParameters = methodParameters;
        }

        public override string Execute()
        {
            var pieces = methodParameters.Split(new string[] { AltUnityRunner._altUnityRunner.requestSeparatorString }, System.StringSplitOptions.None);
            string objectName = pieces[0];
            UnityEngine.Debug.Log("find multiple objects by name " + objectName);
            string cameraName = pieces[1];
            bool enabled = System.Convert.ToBoolean(pieces[2]);

            UnityEngine.Camera camera = null;
            if (cameraName != null)
            {
                camera = UnityEngine.Camera.allCameras.ToList().Find(c => c.name.Equals(cameraName));
            }
            string response = AltUnityRunner._altUnityRunner.errorNotFoundMessage;
            System.Collections.Generic.List<AltUnityObject> foundObjects = new System.Collections.Generic.List<AltUnityObject>();
            foreach (UnityEngine.GameObject testableObject in FindObjectsInScene(objectName, enabled))
            {
                foundObjects.Add(AltUnityRunner._altUnityRunner.GameObjectToAltUnityObject(testableObject, camera));
            }

            response = Newtonsoft.Json.JsonConvert.SerializeObject(foundObjects);

            return response;
                
        }
    }
}
