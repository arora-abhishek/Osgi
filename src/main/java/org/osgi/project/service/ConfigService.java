package org.osgi.project.service;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "ConfigService", description = "Class Configuration")
public @interface ConfigService {


    @AttributeDefinition(
            name = "NoOfStudents", description = "Number of sttudents allowed in class",
            type = AttributeType.INTEGER)
    int getNos();

    @AttributeDefinition(name = "ReqMarks", description = "Marks req to pass",
            type = AttributeType.INTEGER)
    int getReqMarks();

}
