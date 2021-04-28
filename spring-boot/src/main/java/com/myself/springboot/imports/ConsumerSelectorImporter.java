package com.myself.springboot.imports;

import com.myself.logger.LoggerUtil;
import com.myself.springboot.anno.RegisterIn;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述: ConsumerSelectorImporter
 *
 * @author linqin.zxl
 * @date 2021/4/27
 */
public class ConsumerSelectorImporter implements ImportSelector {
    private static final String SCAN_PACKAGE = "com/myself/springboot/bean/*.class";
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        List<String> imports= new ArrayList<>();
        try {
            PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = pathMatchingResourcePatternResolver.getResources(PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + SCAN_PACKAGE);
            MetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
            for (Resource resource : resources) {
                MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(resource);
                if (metadataReader.getAnnotationMetadata().isAnnotated(RegisterIn.class.getName())) {
                    imports.add( metadataReader.getClassMetadata().getClassName());
                }
            }
            return imports.toArray(new String[imports.size()]);
        }catch (Exception ex){
            LoggerUtil.error("register consumer bean error:"+ex.getMessage());
        }
        return new String[0];
    }
}
