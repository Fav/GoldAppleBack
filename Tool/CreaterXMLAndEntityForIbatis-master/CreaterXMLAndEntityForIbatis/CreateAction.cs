using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CreaterXMLAndEntityForIbatis
{
    public class CreateAction : Creater
    {
        public override void OutJFile(IDictionary<string, string> dic, byte[] by)
        {
            GeneralClass.WriteToFile(savePath + "\\action\\" + GeneralClass.GetActionName(dic) + "Action.java", by);
        }

        public override string GetJTemplate()
        {
            return "JActionTemplate.txt";

            List<string> lst = new List<string> { "ab", "bb", "cb" };
            //在里面查找第一个包含"a"的元素,以下两种方法效果相同
            //方法1
            string str = lst.Find(item => item.Contains("a"));

            //方法2
            string str1 = SearchStr(lst,"a");

        }

        private string SearchStr(List<string> lst, string p)
        {
            foreach (var item in lst)
            {
                if (item.Contains("a"))
                {
                    return item;
                }
            }
            return null;
        }

    }
}