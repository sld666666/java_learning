package anotation.UserCase.scanner;

import anotation.UserCase.type.IDescription;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by diwu.sld on 2016/5/19.
 */
public class BeanScanner {
    static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

    private Environment environment =  new StandardEnvironment();

    private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

    private MetadataReaderFactory metadataReaderFactory =
            new CachingMetadataReaderFactory(this.resourcePatternResolver);


    public List<String> scanner(String basePackage, Class anotationClass){
        String anotationName = anotationClass.getName();
        List<String> rtnClassName = new ArrayList<String>();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                resolveBasePackage(basePackage) + "/" + DEFAULT_RESOURCE_PATTERN;
        try {
            Resource[] resources = this.resourcePatternResolver.getResources(packageSearchPath);
            for (Resource resource : resources) {
                MetadataReader metadataReader = this.metadataReaderFactory.getMetadataReader(resource);
                if(isCandidateComponent(metadataReader, anotationName)){
                    rtnClassName.add(metadataReader.getClassMetadata().getClassName());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rtnClassName;
    }

    protected String resolveBasePackage(String basePackage) {
        return ClassUtils.convertClassNameToResourcePath(this.environment.resolveRequiredPlaceholders(basePackage));
    }

    protected boolean isCandidateComponent(MetadataReader metadataReader, String anotationName) throws IOException {
        boolean rtn = false;
        AnnotationMetadata annotationMeta = metadataReader.getAnnotationMetadata();
        if(annotationMeta != null && metadataReader != null){
            Set<String> anotations =  annotationMeta.getAnnotationTypes();
            rtn = anotations.contains(anotationName);
        }
        return rtn;
    }

    public static void main(String [] args){
        BeanScanner scanner = new BeanScanner();
        List<String> rtnClassName = scanner.scanner("anotation.UserCase.type", IDescription.class);
    }
}
