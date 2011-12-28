package jp.dip.sys1.market.statistics.report;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import jp.dip.sys1.market.statistics.data.Sales;
import jp.dip.sys1.market.statistics.data.Settings;

/**
 * 
 * @author sys1yagi
 *
 */
public class HTMLReporter implements Reporter {
    @Override
    public void report(Settings settings, List<Sales> sales) throws IOException {
        File outputDir = new File(settings.getOutputDirectory());
        outputDir.mkdirs();
        StringBuilder sb = new StringBuilder();
        Iterator<Sales> itr = sales.iterator();
        while(itr.hasNext()){
            sb.append(itr.next().toJSON());
            if(itr.hasNext()){
                sb.append(",");
            }
        }
        
        //velocity
        Properties prop = new Properties();
        prop.setProperty("resource.loader", "file");
        prop.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        prop.setProperty("file.resource.loader.path", settings.getTemplatesDirectory());
        prop.setProperty("input.encoding", "UTF-8");
        VelocityEngine engine = new VelocityEngine();
        engine.init(prop);
        
        VelocityContext context = new VelocityContext();
        context.put("sales", sb.toString());
        context.put("title", settings.getTitle());
        Template template = engine.getTemplate("HTMLReport.vm");
        File report = new File(outputDir, "sales-statistics.html");
        FileWriter fw = null;
        try{
            fw = new FileWriter(report);
            template.merge(context, fw);
        }finally{
            if(fw != null){
                try{
                    fw.close();
                }catch(Exception e){}
            }
        }
        //js copy
        Process p =Runtime.getRuntime().exec("cp -r " + settings.getTemplatesDirectory() + "/js " + outputDir.getAbsolutePath() );
        try{
            p.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
