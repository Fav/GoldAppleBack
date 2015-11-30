using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CreaterXMLAndEntityForIbatis
{
    public class CreateControl:Creater
    {
        public override void OutJFile(IDictionary<string, string> dic, byte[] by)
        {
            GeneralClass.WriteToFile(savePath + "\\controller\\" + GeneralClass.GetActionName(dic) + "Controller.java", by);
        }

        public override string GetJTemplate()
        {
            return "JControlTemplate.txt";
        }
    }
}
