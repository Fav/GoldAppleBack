using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CreaterXMLAndEntityForIbatis
{
    internal class CreateXML : Creater
    {
        public override void Run(CInputInfo info)
        {
            GetInfo(info);
            string template = "";
            if (language != "JAVA")
            {
                template = "CXMLTemplate.txt";
            }
            else
            {
                template = "JXMLTemplate.txt";
            }
            GeneralClass gc = new GeneralClass();
            string content = gc.ReadTemplate(template);
            IDictionary<string,string> list = gc.GetField(sqlPath);

            if (list != null && list.Count > 0)
            {
                content = content.
                          Replace("<%actionName%>", GetActionName(list)).
                          Replace("<%tableCode%>", GetTableCode(list)).
                          Replace("<%tableDescripe%>", gc.GetDescripe(sqlPath)).
                          Replace("<%packageName%>", packageName).
                          Replace("<%className%>", GetTableCode(list)+"Class").
                          Replace("<%resultMap%>", CreateResultMap(list, language)).
                          Replace("<%allColumn%>",CreateAllColumn(list)).
                          Replace("<%create%>", CreateCreateCode(list)).
                          Replace("<%update%>", CreateUpdate(list, language)).
                          Replace("<%primarykey%>", CreatePrimarykey(list)).
                          Replace("<%dynamicWhere%>",CreateDynamicWhere(list)).
                          Replace("<%dynamicScope%>",CreateDynamicScope(list));
                byte[] by = Encoding.Default.GetBytes(content);
                GeneralClass.WriteToFile(savePath + "\\beanmapper\\" + GetTableCode(list) + ".xml", by);
            }
        }

        /// <summary>
        /// 替换<%actionName%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string GetActionName(IDictionary<string, string> list)
        {
            return GeneralClass.GetActionName(list);
        }

        /// <summary>
        /// 替换<%resultMap%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateResultMap(IDictionary<string, string> list, string language)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    if (language == "JAVA")
                    {
                        retStr += "\r\n" +
                                  "           <id property=\"" + item.Key + "\" column=\"" + item.Key + "\" />";
                    }
                    else
                    {
                        retStr += "\r\n" +
                                  "           <id property=\"_" + item.Key + "\" column=\"" + item.Key + "\" />";
                    }
                }
            }
            return retStr;
        }

        /// <summary>
        /// 替换<%tableCode%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string GetTableCode(IDictionary<string, string> list)
        {
            return GeneralClass.GetTableCode(list);
        }

        
       /// <summary>
        /// 替换<%allColumn%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateAllColumn(IDictionary<string, string> list)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    retStr += item.Key + ",";
                }
            }
            return retStr.TrimEnd(',');
        }

        /// <summary>
        /// 替换<%create%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateCreateCode(IDictionary<string, string> list)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    retStr += "#{" + item.Key + "},";
                }
            }
            return retStr.TrimEnd(',');
        }

        /// <summary>
        /// 替换<%update%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateUpdate(IDictionary<string, string> list, string language)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    if (language == "JAVA")
                    {
                        retStr +=string.Format("\r\n         <if test=\"{0} != null\">{0} = #{{{0}}}, </if>", item.Key);
                    }
                    else
                    {
                        retStr += "\r\n"+
                                  "         <isNotNull prepend=\",\" property=\"_" + item.Key + "\"> " +
                                  "" + item.Key + " = #_" + item.Key + "#</isNotNull>";
                    }
                }
            }
            return retStr;
        }

        /// <summary>
        /// 替换<%primarykey%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreatePrimarykey(IDictionary<string, string> list)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    retStr = item.Key + " = #{" + item.Key + "}";
                    break;
                }
            }
            return retStr;
        }

        /// <summary>
        /// 替换<%dynamicWhere%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateDynamicWhere(IDictionary<string, string> list)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    retStr +=string.Format("\r\n         <if test=\"{0} != null\">and {0} like '%'||#{{{0}}}||'%'</if>", item.Key);
                }
            }
            return retStr;
        }

        /// <summary>
        /// 替换<%dynamicScope%>
        /// </summary>
        /// <param name="list"></param>
        /// <returns></returns>
        private string CreateDynamicScope(IDictionary<string, string> list)
        {
            string retStr = "";
            foreach (KeyValuePair<string, string> item in list)
            {
                if (item.Key.Length > 7)
                {
                    retStr += string.Format("\r\n         <if test=\"{0} != null\">and {0} = #{{{0}}} </if>", item.Key);
                }
            }
            return retStr;
        }
       
    }
}
