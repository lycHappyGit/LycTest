package freemark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * FreeMarker工具，用于生成邮件内容
 * 
 * @author Haijian
 * @date 2015-9-11
 */
public class FreeMarkerUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(FreeMarkerUtil.class);
	private static Configuration conf = new Configuration();
	private static Map<String, Template> templateCache = new HashMap<String, Template>();

	static {
		try {
			URL url = FreeMarkerUtil.class.getClassLoader().getResource("mail");
			File dir = new File(url.getPath());
			conf.setClassicCompatible(true);
			conf.setDefaultEncoding("UTF-8");
			conf.setDirectoryForTemplateLoading(dir);
		} catch (Exception e) {
			LOGGER.error("FreeMarkerUtil配置出错......", e);
		}
	}

	/**
	 * 根据模板和传入值生成String
	 * 
	 * @param dataModel
	 *            传入值
	 * @param templateName
	 *            模板文件名
	 * @return String
	 */
	public static String generateString(Object dataModel,
			String templateName) {
		StringWriter sw = new StringWriter();
		try {
			Template template = null;
			if (templateCache.containsKey(templateName)) {
				LOGGER.debug("从缓存中获取模板信息");
				template = templateCache.get(templateName);
			} else {
				template = conf.getTemplate(templateName);
				templateCache.put(templateName, template);
			}
			template.process(dataModel, sw);
		} catch (Exception e) {
			LOGGER.error("根据模板和传入值生成String失败", e);
			return null;
		}
		//LOGGER.debug(sw.toString());
		return sw.toString();
	}

}
